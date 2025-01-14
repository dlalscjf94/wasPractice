package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class RequestLine {

    private final String method; //GET
    private final String urlPath;
    private String queryString;

    private  static  final Logger logger = LoggerFactory.getLogger(RequestLine.class);

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;
    }

    public RequestLine(String requestLine) {
        // GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];
        logger.info("method check :: {}", method);
        for (int i = 0; i < tokens.length; i++) {
            logger.debug("splited token check :: {}", tokens[i]);
        }
        // 1 위치 /calculate?operand1=11&operator=*&operand2=55
        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        if (urlPathTokens.length == 2) {
            this.queryString = urlPathTokens[0];
        }
    }
    // 객체끼리 비교할 때 equals and hashCode 필요
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }
}
