package com.chungchun.website.likes.exception;

public class LikeAlreadyExistsException extends RuntimeException {
    public LikeAlreadyExistsException(String message) {
            super(message);
        }
    }
