package namespace.stedd.data.crypto;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.X509ExtendedTrustManager;
import java.net.Socket;
import java.security.AlgorithmConstraints;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Имитационный доверенный управляющий.
 * @author Namespace Stedd
 */
public class MockTrustManager extends X509ExtendedTrustManager {

    /**
     * Создание имитационного доверенного управляющего.
     * @author Namespace Stedd
     * @return имитационный доверенный управляющий
     */
    public static MockTrustManager create() {
        return new MockTrustManager();
    }

    /**
     * Given the partial or complete certificate chain provided by the
     * peer, build and validate the certificate path based on the
     * authentication type and ssl parameters.
     * <p>
     * The authentication type is determined by the actual certificate
     * used. For instance, if RSAPublicKey is used, the authType
     * should be "RSA". Checking is case-sensitive.
     * <p>
     * If the {@code socket} parameter is an instance of
     * {@link javax.net.ssl.SSLSocket}, and the endpoint identification
     * algorithm of the {@code SSLParameters} is non-empty, to prevent
     * man-in-the-middle attacks, the address that the {@code socket}
     * connected to should be checked against the peer's identity presented
     * in the end-entity X509 certificate, as specified in the endpoint
     * identification algorithm.
     * <p>
     * If the {@code socket} parameter is an instance of
     * {@link javax.net.ssl.SSLSocket}, and the algorithm constraints of the
     * {@code SSLParameters} is non-null, for every certificate in the
     * certification path, fields such as subject public key, the signature
     * algorithm, key usage, extended key usage, etc. need to conform to the
     * algorithm constraints in place on this socket.
     *
     * @param chain the peer certificate chain
     * @param authType the key exchange algorithm used
     * @param socket the socket used for this connection. This parameter
     *        can be null, which indicates that implementations need not check
     *        the ssl parameters
     * @throws IllegalArgumentException if null or zero-length array is passed
     *        in for the {@code chain} parameter or if null or zero-length
     *        string is passed in for the {@code authType} parameter
     * @throws CertificateException if the certificate chain is not trusted
     *        by this TrustManager
     *
     * @see SSLParameters#getEndpointIdentificationAlgorithm
     * @see SSLParameters#setEndpointIdentificationAlgorithm(String)
     * @see SSLParameters#getAlgorithmConstraints
     * @see SSLParameters#setAlgorithmConstraints(AlgorithmConstraints)
     */
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType, Socket socket) throws CertificateException {

    }

    /**
     * Given the partial or complete certificate chain provided by the
     * peer, build and validate the certificate path based on the
     * authentication type and ssl parameters.
     * <p>
     * The authentication type is the key exchange algorithm portion
     * of the cipher suites represented as a String, such as "RSA",
     * "DHE_DSS". Note: for some exportable cipher suites, the key
     * exchange algorithm is determined at run time during the
     * handshake. For instance, for TLS_RSA_EXPORT_WITH_RC4_40_MD5,
     * the authType should be RSA_EXPORT when an ephemeral RSA key is
     * used for the key exchange, and RSA when the key from the server
     * certificate is used. Checking is case-sensitive.
     * <p>
     * If the {@code socket} parameter is an instance of
     * {@link javax.net.ssl.SSLSocket}, and the endpoint identification
     * algorithm of the {@code SSLParameters} is non-empty, to prevent
     * man-in-the-middle attacks, the address that the {@code socket}
     * connected to should be checked against the peer's identity presented
     * in the end-entity X509 certificate, as specified in the endpoint
     * identification algorithm.
     * <p>
     * If the {@code socket} parameter is an instance of
     * {@link javax.net.ssl.SSLSocket}, and the algorithm constraints of the
     *  {@code SSLParameters} is non-null, for every certificate in the
     * certification path, fields such as subject public key, the signature
     * algorithm, key usage, extended key usage, etc. need to conform to the
     * algorithm constraints in place on this socket.
     *
     * @param chain the peer certificate chain
     * @param authType the key exchange algorithm used
     * @param socket the socket used for this connection. This parameter
     *        can be null, which indicates that implementations need not check
     *        the ssl parameters
     * @throws IllegalArgumentException if null or zero-length array is passed
     *        in for the {@code chain} parameter or if null or zero-length
     *        string is passed in for the {@code authType} parameter
     * @throws CertificateException if the certificate chain is not trusted
     *        by this TrustManager
     *
     * @see SSLParameters#getEndpointIdentificationAlgorithm
     * @see SSLParameters#setEndpointIdentificationAlgorithm(String)
     * @see SSLParameters#getAlgorithmConstraints
     * @see SSLParameters#setAlgorithmConstraints(AlgorithmConstraints)
     */
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket) throws CertificateException {

    }

    /**
     * Given the partial or complete certificate chain provided by the
     * peer, build and validate the certificate path based on the
     * authentication type and ssl parameters.
     * <p>
     * The authentication type is determined by the actual certificate
     * used. For instance, if RSAPublicKey is used, the authType
     * should be "RSA". Checking is case-sensitive.
     * <p>
     * If the {@code engine} parameter is available, and the endpoint
     * identification algorithm of the {@code SSLParameters} is
     * non-empty, to prevent man-in-the-middle attacks, the address that
     * the {@code engine} connected to should be checked against
     * the peer's identity presented in the end-entity X509 certificate,
     * as specified in the endpoint identification algorithm.
     * <p>
     * If the {@code engine} parameter is available, and the algorithm
     * constraints of the {@code SSLParameters} is non-null, for every
     * certificate in the certification path, fields such as subject public
     * key, the signature algorithm, key usage, extended key usage, etc.
     * need to conform to the algorithm constraints in place on this engine.
     *
     * @param chain the peer certificate chain
     * @param authType the key exchange algorithm used
     * @param engine the engine used for this connection. This parameter
     *        can be null, which indicates that implementations need not check
     *        the ssl parameters
     * @throws IllegalArgumentException if null or zero-length array is passed
     *        in for the {@code chain} parameter or if null or zero-length
     *        string is passed in for the {@code authType} parameter
     * @throws CertificateException if the certificate chain is not trusted
     *        by this TrustManager
     *
     * @see SSLParameters#getEndpointIdentificationAlgorithm
     * @see SSLParameters#setEndpointIdentificationAlgorithm(String)
     * @see SSLParameters#getAlgorithmConstraints
     * @see SSLParameters#setAlgorithmConstraints(AlgorithmConstraints)
     */
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType, SSLEngine engine) throws CertificateException {

    }

    /**
     * Given the partial or complete certificate chain provided by the
     * peer, build and validate the certificate path based on the
     * authentication type and ssl parameters.
     * <p>
     * The authentication type is the key exchange algorithm portion
     * of the cipher suites represented as a String, such as "RSA",
     * "DHE_DSS". Note: for some exportable cipher suites, the key
     * exchange algorithm is determined at run time during the
     * handshake. For instance, for TLS_RSA_EXPORT_WITH_RC4_40_MD5,
     * the authType should be RSA_EXPORT when an ephemeral RSA key is
     * used for the key exchange, and RSA when the key from the server
     * certificate is used. Checking is case-sensitive.
     * <p>
     * If the {@code engine} parameter is available, and the endpoint
     * identification algorithm of the {@code SSLParameters} is
     * non-empty, to prevent man-in-the-middle attacks, the address that
     * the {@code engine} connected to should be checked against
     * the peer's identity presented in the end-entity X509 certificate,
     * as specified in the endpoint identification algorithm.
     * <p>
     * If the {@code engine} parameter is available, and the algorithm
     * constraints of the {@code SSLParameters} is non-null, for every
     * certificate in the certification path, fields such as subject public
     * key, the signature algorithm, key usage, extended key usage, etc.
     * need to conform to the algorithm constraints in place on this engine.
     *
     * @param chain the peer certificate chain
     * @param authType the key exchange algorithm used
     * @param engine the engine used for this connection. This parameter
     *        can be null, which indicates that implementations need not check
     *        the ssl parameters
     * @throws IllegalArgumentException if null or zero-length array is passed
     *        in for the {@code chain} parameter or if null or zero-length
     *        string is passed in for the {@code authType} parameter
     * @throws CertificateException if the certificate chain is not trusted
     *        by this TrustManager
     *
     * @see SSLParameters#getEndpointIdentificationAlgorithm
     * @see SSLParameters#setEndpointIdentificationAlgorithm(String)
     * @see SSLParameters#getAlgorithmConstraints
     * @see SSLParameters#setAlgorithmConstraints(AlgorithmConstraints)
     */
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine) throws CertificateException {

    }

    /**
     * Given the partial or complete certificate chain provided by the
     * peer, build a certificate path to a trusted root and return if
     * it can be validated and is trusted for client SSL
     * authentication based on the authentication type.
     * <p>
     * The authentication type is determined by the actual certificate
     * used. For instance, if RSAPublicKey is used, the authType
     * should be "RSA". Checking is case-sensitive.
     *
     * @param chain the peer certificate chain
     * @param authType the authentication type based on the client certificate
     * @throws IllegalArgumentException if null or zero-length chain
     *         is passed in for the chain parameter or if null or zero-length
     *         string is passed in for the  authType parameter
     * @throws CertificateException if the certificate chain is not trusted
     *         by this TrustManager.
     */
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

    }

    /**
     * Given the partial or complete certificate chain provided by the
     * peer, build a certificate path to a trusted root and return if
     * it can be validated and is trusted for server SSL
     * authentication based on the authentication type.
     * <p>
     * The authentication type is the key exchange algorithm portion
     * of the cipher suites represented as a String, such as "RSA",
     * "DHE_DSS". Note: for some exportable cipher suites, the key
     * exchange algorithm is determined at run time during the
     * handshake. For instance, for TLS_RSA_EXPORT_WITH_RC4_40_MD5,
     * the authType should be RSA_EXPORT when an ephemeral RSA key is
     * used for the key exchange, and RSA when the key from the server
     * certificate is used. Checking is case-sensitive.
     *
     * @param chain the peer certificate chain
     * @param authType the key exchange algorithm used
     * @throws IllegalArgumentException if null or zero-length chain
     *         is passed in for the chain parameter or if null or zero-length
     *         string is passed in for the  authType parameter
     * @throws CertificateException if the certificate chain is not trusted
     *         by this TrustManager.
     */
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

    }

    /**
     * Return an array of certificate authority certificates
     * which are trusted for authenticating peers.
     *
     * @return a non-null (possibly empty) array of acceptable
     *          CA issuer certificates.
     */
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

}
