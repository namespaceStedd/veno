package namespace.stedd.data.sys;

import namespace.stedd.data.Converter;

/**
 * Перечисление системных свойств для удобства.
 * @author Namespace Stedd
 */
public enum SystemProperty {
    FileEncoding("file.encoding"),
    FileSeparator("file.separator"),
    JavaClassPath("java.class.path"),
    JavaClassVersion("java.class.version"),
    JavaHome("java.home"),
    JavaIoTmpdir("java.io.tmpdir"),
    JavaLibraryPath("java.library.path"),
    JavaRuntimeName("java.runtime.name"),
    JavaRuntimeVersion("java.runtime.version"),
    JavaSpecificationName("java.specification.name"),
    JavaSpecificationVendor("java.specification.vendor"),
    JavaSpecificationVersion("java.specification.version"),
    JavaVendor("java.vendor"),
    JavaVendorUrl("java.vendor.url"),
    JavaVendorUrlBug("java.vendor.url.bug"),
    JavaVersion("java.version"),
    JavaVersionDate("java.version.date"),
    JavaVmCompressedOopsMode("java.vm.compressedOopsMode"),
    JavaVmInfo("java.vm.info"),
    JavaVmName("java.vm.name"),
    JavaVmSpecificationName("java.vm.specification.name"),
    JavaVmSpecificationVendor("java.vm.specification.vendor"),
    JavaVmSpecificationVersion("java.vm.specification.version"),
    JavaVmVendor("java.vm.vendor"),
    JavaVmVersion("java.vm.version"),
    JdkDebug("jdk.debug"),
    LineSeparator("line.separator"),
    NativeEncoding("native.encoding"),
    OsArch("os.arch"),
    OsName("os.name"),
    OsVersion("os.version"),
    PathSeparator("path.separator"),
    StderrEncoding("stderr.encoding"),
    StdoutEncoding("stdout.encoding"),
    SunArchDataModel("sun.arch.data.model"),
    SunBootLibraryPath("sun.boot.library.path"),
    SunCpuEndian("sun.cpu.endian"),
    SunCpuIsalist("sun.cpu.isalist"),
    SunIoUnicodeEncoding("sun.io.unicode.encoding"),
    SunJavaCommand("sun.java.command"),
    SunJavaLauncher("sun.java.launcher"),
    SunJnuEncoding("sun.jnu.encoding"),
    SunManagementCompiler("sun.management.compiler"),
    SunOsPatchLevel("sun.os.patch.level"),
    SunStderrEncoding("sun.stderr.encoding"),
    SunStdoutEncoding("sun.stdout.encoding"),
    UserCountry("user.country"),
    UserDir("user.dir"),
    UserHome("user.home"),
    UserLanguage("user.language"),
    UserName("user.name"),
    UserScript("user.script"),
    UserVariant("user.variant"),
    ;

    private final String key;   // Ключ системного свойства

    /**
     * Создание системного свойства.
     * @author Namespace Stedd
     * @param key ключ системного свойства
     */
    SystemProperty(String key) {
        this.key = key;
    }

    /**
     * Получение ключа системного свойства.
     * @author Namespace Stedd
     * @return ключ системного свойства
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Получение значения системного свойства.
     * @author Namespace Stedd
     * @return значение системного свойства
     */
    public String getValue() {
        return this.getValue(null);
    }

    /**
     * Получение значения системного свойства.
     * @author Namespace Stedd
     * @param ifNull значение при отсутствии системного свойства
     * @return значение системного свойства
     */
    public String getValue(String ifNull) {
        return Converter.parseString(System.getProperty(this.key), ifNull);
    }

}
