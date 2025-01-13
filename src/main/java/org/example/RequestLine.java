package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestLine {

    private final String method; //GET

    private  static  final Logger logger = LoggerFactory.getLogger(RequestLine.class);
    public RequestLine(String requestLine) {

        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];
        logger.info("method check :: {}", method);
    }
}
