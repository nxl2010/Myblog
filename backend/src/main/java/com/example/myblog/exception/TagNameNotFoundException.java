package com.example.myblog.exception;

public class TagNameNotFoundException extends RuntimeException {
    public TagNameNotFoundException(String tagName) {
        super("TagName not found: " + tagName);
    }
}
