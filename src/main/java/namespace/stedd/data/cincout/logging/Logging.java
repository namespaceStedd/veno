package namespace.stedd.data.cincout.logging;

import namespace.stedd.data.Converter;
import namespace.stedd.data.type.ExoString;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.logging.log4j.core.appender.rolling.*;
import org.apache.logging.log4j.core.appender.rolling.action.*;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.spi.ExtendedLogger;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Ядро ведения Журнала.
 * @author Namespace Stedd
 */
public class Logging {

    /**
     * Получение Журнала по умолчанию.
     * @author Namespace Stedd
     * @param callingClass название класса Журнала
     * @return Журнал
     */
    public static ExtendedLogger getDefault(Class<?> callingClass) {
        return getDefault("app", "logs/", callingClass);
    }

    /**
     * Получение Журнала по умолчанию.
     * @author Namespace Stedd
     * @param fileName название файла Журнала
     * @param callingClass название класса Журнала
     * @return Журнал
     */
    public static ExtendedLogger getDefault(String fileName, Class<?> callingClass) {
        return getDefault(fileName, "logs/", callingClass);
    }

    /**
     * Получение Журнала по умолчанию.
     * @author Namespace Stedd
     * @param fileName название файла Журнала
     * @param rootDirectory корневая папка Журнала
     * @param callingClass название класса Журнала
     * @return Журнал
     */
    public static ExtendedLogger getDefault(String fileName, String rootDirectory, Class<?> callingClass) {
        return Builder.create(fileName, rootDirectory, callingClass)
                .addPattern("%d{DEFAULT}{GMT+0} %p %c{1.} [%t] %m%n")
                .setLevel(Level.INFO)
                .archiveTo(rootDirectory + "app/%d{yyyy-MM}/%d{dd}/", fileName + "_%d{yyyy-MM-dd_HH-mm-ss}{GMT}.log.gz")
                .withTimeBasedPolicy(1, TimeUnit.DAYS)
                .withSizeBasedPolicy(100, InformationUnit.MegaByte)
                .deletePolicy("*.log.gz", TimeUnit.DAYS.toMillis(91))
                .build();
    }

    /**
     * Получение нового Конструктора Журнала.
     * @author Namespace Stedd
     * @param fileName название файла Журнала
     * @param rootDirectory название корневой папки Архива
     * @param callingClass название класса Журнала
     * @return новый Конструктор Журнала
     */
    public static Builder newBuilder(String fileName, String rootDirectory, Class<?> callingClass) {
        return Builder.create(fileName, rootDirectory, callingClass);
    }

    /**
     * Конструктор Журнала.
     * @author Namespace Stedd
     */
    public static class Builder {

        // Обязательные параметры
        private String loggerName;   // Название Журнала
        private final String fileName;   // Название файла Журнала
        private final String rootDirectory;   // Название корневой папки Архива

        // Определение контекста Журнала и его настроек
        private final LoggerContext context;   // Контекст Журнала
        private final Configuration configuration;   // Настройка Журнала

        // Настройки Журнала
        private Level loggerLevel;   // Уровень Журналирования

        // Необязательные настройки
        private String pattern;   // Шаблонная строка
        private TriggeringPolicy archivePolicy;   // Политика Архивирования
        private final List<TriggeringPolicy> archivePolicies;   // Политики Архивирования

        // Запись Архива
        private String archiveDirectory;   // Название корневой папки Архива
        private String archiveFileName;   // Название файла Архива
        private Action deleteAction;   // Настройка удаления

        /**
         * Создание Конструктора Журнала.
         * @param fileName название файла Журнала
         * @param rootDirectory корневая папка Журнала
         * @param callingClass название класса Журнала
         */
        public Builder(String fileName, String rootDirectory, Class<?> callingClass) {
            this.loggerName = callingClass.getName();
            this.fileName = fileName;
            this.rootDirectory = rootDirectory;
            this.context = (LoggerContext) LogManager.getContext();
            this.configuration = this.context.getConfiguration();
            this.loggerLevel = Level.INFO;
            this.archivePolicies = new ArrayList<>();
        }

        /**
         * Создание Конструктора Журнала.
         * @param fileName название файла Журнала
         * @param rootDirectory корневая папка Журнала
         * @param callingClass название класса Журнала
         * @return первоначальный Конструктор Журнала
         */
        public static Builder create(String fileName, String rootDirectory, Class<?> callingClass) {
            return new Builder(fileName, rootDirectory, callingClass);
        }

        /**
         * Применение названия Журнала.
         * @author Namespace Stedd
         * @param loggerName название Журнала
         * @return Конструктор Журнала с нововведением
         */
        public Builder setLoggerName(String loggerName) {
            this.loggerName = loggerName;
            return this;
        }

        /**
         * Применение уровня Журналирования.
         * @author Namespace Stedd
         * @param loggerLevel уровень Журналирования
         * @return Конструктор Журнала с нововведением
         */
        public Builder setLevel(Level loggerLevel) {
            this.loggerLevel = loggerLevel;
            return this;
        }

        /**
         * Добавление Шаблонной строки.
         * @author Namespace Stedd
         * @param pattern Шаблонная строка
         * @return Конструктор Журнала с нововведением
         */
        public Builder addPattern(String pattern) {
            this.pattern = pattern;
            return this;
        }

        /**
         * Добавление Архивирования.
         * @author Namespace Stedd
         * @param archiveDirectory название корневой папки Архива
         * @param archiveFileName название файла Архива
         * @return Конструктор Журнала с нововведением
         */
        public Builder archiveTo(String archiveDirectory, String archiveFileName) {
            // Определение Корня
            this.archiveDirectory = archiveDirectory;

            // Определение названия файла Архива
            this.archiveFileName = archiveFileName;

            // Возврат каретки
            return this;
        }

        /**
         * Добавление Временной политики Архивирования.
         * TODO: Warning для предупреждения об использовании только одной политики
         * @author Namespace Stedd
         * @param times количество Времени
         * @param unit единица измерения Времени
         * @return Конструктор Журнала с нововведением
         */
        public Builder withTimeBasedPolicy(long times, TimeUnit unit) {
            // Полиция указывается в Секундах!!!
            TriggeringPolicy timeBasedPolicy = TimeBasedTriggeringPolicy.newBuilder()
                    .withInterval((int) unit.toSeconds(times))
                    // .withModulate(true)
                    .withModulate(false)
                    .build();
            System.out.println(timeBasedPolicy);
            this.archivePolicies.add(timeBasedPolicy);
            this.archivePolicy = timeBasedPolicy;
            return this;
        }

        /**
         * Добавление Временной политики Архивирования.
         * TODO: Warning для предупреждения об использовании только одной политики
         * @author Namespace Stedd
         * @param size количество Информации
         * @param unit единица измерения Информации
         * @return Конструктор Журнала с нововведением
         */
        public Builder withSizeBasedPolicy(int size, InformationUnit unit) {
            // Политики Самокрутки
            TriggeringPolicy sizeBasedPolicy = SizeBasedTriggeringPolicy.createPolicy(size + unit.getUnit());
            System.out.println(sizeBasedPolicy);
            this.archivePolicies.add(sizeBasedPolicy);
            this.archivePolicy = sizeBasedPolicy;
            return this;
        }

        /**
         * Добавление политики Удаления Архива.
         * @author Namespace Stedd
         * @param namePattern шаблон файла Архива
         * @param milliseconds количество прошедшего времени в миллисекундах
         * @return Конструктор Журнала с нововведением
         */
        public Builder deletePolicy(String namePattern, long milliseconds) {
            this.deleteAction = DeleteAction.createDeleteAction(
                    this.rootDirectory,
                    false,
                    Integer.MAX_VALUE,
                    false,
                    null,
                    new PathCondition[] {
                            IfFileName.createNameCondition(namePattern, namePattern),
                            IfLastModified.newBuilder().setAge(java.time.Duration.ofMillis(milliseconds)).build()
                    },
                    null,
                    this.configuration
            );
            return this;
        }

        /**
         * Сборка Конструктора.
         * @author Namespace Stedd
         * @return Ядро введения Журнала
         */
        public <B extends RollingFileAppender.Builder<B>> ExtendedLogger build() {
            // Определение Шаблона сообщения
            this.pattern = ExoString.notNullStatus(this.pattern) ? this.pattern : "%m%n";
            PatternLayout layout = PatternLayout.newBuilder()
                    .withPattern(this.pattern)
                    .withCharset(Charset.defaultCharset())
                    .build();

            // Определение структуры добавления Журнальных строк
            // noinspection unchecked
            RollingFileAppender.Builder<B> appender = (B) RollingFileAppender.newBuilder()
                    .setName(this.loggerName)
                    .withFileName(this.rootDirectory + this.fileName + ".log")
                    .setLayout(layout);

            // Настройка ведения Журнала
            LoggerConfig loggerConfiguration = LoggerConfig.newBuilder()
                    .withLoggerName(this.loggerName)
                    .withLevel(this.loggerLevel)
                    .withConfig(this.configuration)
                    .build();

            // Совмещение политик Архивирования
            // Добавление политики Ведения Архива
            // TODO: Поправить
            if (this.archivePolicy != null) {
                appender.withPolicy(this.archivePolicy);
            }
            else if (!this.archivePolicies.isEmpty()) {
                TriggeringPolicy[] archivePolicies = Converter.toArray(this.archivePolicies, TriggeringPolicy.class);
                CompositeTriggeringPolicy composite = CompositeTriggeringPolicy.createPolicy(archivePolicies);
                System.out.println(composite);
                appender.withPolicy(composite);
            }

            // Определение Архивирования
            if (this.archiveFileName != null) {
                this.archiveDirectory = ExoString.notNullStatus(this.archiveDirectory) ? this.archiveDirectory : "";
                appender.withFilePattern(this.rootDirectory + this.archiveDirectory + this.archiveFileName);

                // Добавление политики Очистки Архива
                if (this.deleteAction != null) {
                    RolloverStrategy strategy = DefaultRolloverStrategy.newBuilder()
                            .withCustomActions(new Action[] { this.deleteAction })
                            .build();
                    appender.withStrategy(strategy);
                }
            }

            // Финальные штрихи
            RollingFileAppender fileAppender = appender.build();
            fileAppender.start();
            loggerConfiguration.addAppender(fileAppender, null, null);
            this.configuration.addAppender(fileAppender);
            this.configuration.addLogger(this.loggerName, loggerConfiguration);
            this.context.updateLoggers(this.configuration);

            // Возврат каретки
            return LogManager.getContext().getLogger(this.loggerName);
        }

    }

}
