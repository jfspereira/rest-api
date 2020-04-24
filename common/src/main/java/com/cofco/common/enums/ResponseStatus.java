package com.cofco.common.enums;

import java.util.Optional;

public enum ResponseStatus {


    /**
     * 200 OK, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.2.1">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_OK(200, "OK"),
    /**
     * 201 Created, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.2.2">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_CREATED(201, "Created"),
    /**
     * 202 Accepted, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.2.3">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_ACCEPTED(202, "Accepted"),
    /**
     * 204 No Content, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.2.5">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_NO_CONTENT(204, "No Content"),
    /**
     * 205 Reset Content, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.2.6">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_RESET_CONTENT(205, "Reset Content"),
    /**
     * 206 Reset Content, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.2.7">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_PARTIAL_CONTENT(206, "Partial Content"),
    /**
     * 301 Moved Permanently, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.3.2">HTTP/1.1 documentation</a>}.
     */
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    /**
     * 302 Found, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.3.3">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_FOUND(302, "Found"),
    /**
     * 303 See Other, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.3.4">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_SEE_OTHER(303, "See Other"),
    /**
     * 304 Not Modified, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.3.5">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_NOT_MODIFIED(304, "Not Modified"),
    /**
     * 305 Use Proxy, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.3.6">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_USE_PROXY(305, "Use Proxy"),
    /**
     * 307 Temporary Redirect, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.3.8">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    /**
     * 400 Bad Request, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.1">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_BAD_REQUEST(400, "Bad Request"),
    /**
     * 401 Unauthorized, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.2">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_UNAUTHORIZED(401, "Unauthorized"),
    /**
     * 402 Payment Required, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.3">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_PAYMENT_REQUIRED(402, "Payment Required"),
    /**
     * 403 Forbidden, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.4">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_FORBIDDEN(403, "Forbidden"),
    /**
     * 404 Not Found, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.5">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_NOT_FOUND(404, "Not Found"),
    /**
     * 405 Method Not Allowed, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.6">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    /**
     * 406 Not Acceptable, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.7">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_NOT_ACCEPTABLE(406, "Not Acceptable"),
    /**
     * 407 Proxy Authentication Required, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.8">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
    /**
     * 408 Request Timeout, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.9">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_REQUEST_TIMEOUT(408, "Request Timeout"),
    /**
     * 409 Conflict, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.10">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_CONFLICT(409, "Conflict"),
    /**
     * 410 Gone, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.11">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_GONE(410, "Gone"),
    /**
     * 411 Length Required, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.12">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_LENGTH_REQUIRED(411, "Length Required"),
    /**
     * 412 Precondition Failed, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.13">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_PRECONDITION_FAILED(412, "Precondition Failed"),
    /**
     * 413 Request Entity Too Large, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.14">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large"),
    /**
     * 414 Request-URI Too Long, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.15">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_REQUEST_URI_TOO_LONG(414, "Request-URI Too Long"),
    /**
     * 415 Unsupported Media Type, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.16">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    /**
     * 416 Requested Range Not Satisfiable, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.17">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
    /**
     * 417 Expectation Failed, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.18">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_EXPECTATION_FAILED(417, "Expectation Failed"),
    /**
     * 500 Internal Server Error, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.5.1">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    /**
     * 501 Not Implemented, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.5.2">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_NOT_IMPLEMENTED(501, "Not Implemented"),
    /**
     * 502 Bad Gateway, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.5.3">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_BAD_GATEWAY(502, "Bad Gateway"),
    /**
     * 503 Service Unavailable, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.5.4">HTTP/1.1 documentation</a>}.
     */
    K_HTTP_CODE_SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    /**
     * 504 Gateway Timeout, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.5.5">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    /**
     * 505 HTTP Version Not Supported, see {@link <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.5.6">HTTP/1.1 documentation</a>}.
     *
     * @since 2.0
     */
    K_HTTP_CODE_HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported"),

    K_HTTP_CODE_UNPROCESSABLE_ENTITY(422, "Unprocessable entity"),

    /**
     * Custom Error codes.
     */

    K_SQL_CODE_NULL_VALUE(400, "Could not execute statement. Cannot insert the value NULL"),

    K_SQL_CODE_UNIQUE_VIOLATION(409, "Could not execute statement. Violation of UNIQUE KEY constraint"),

    K_GENERIC_ERROR(500, "An error occurred");

    private final int code;
    private final String reasonPhrase;

    ResponseStatus(final int statusCode, final String reasonPhrase) {
        this.code = statusCode;
        this.reasonPhrase = reasonPhrase;
    }

    /**
     * Convert a numerical status code into the corresponding Status.
     *
     * @param statusCode the numerical status code.
     * @return the matching Status or null is no matching Status is defined.
     */
    public static Optional<ResponseStatus> fromStatusCode(final int statusCode) {
        Optional<ResponseStatus> result = Optional.empty();
        for (final ResponseStatus s : ResponseStatus.values()) {
            if (s.code == statusCode) {
                result = Optional.of(s);
                break;
            }
        }
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
}


