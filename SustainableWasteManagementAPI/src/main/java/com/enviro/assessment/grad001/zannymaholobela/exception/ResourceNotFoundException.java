package com.enviro.assessment.grad001.zannymaholobela.exception;
/**
 * Custom exception for resource not found errors.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {
        super(s);  //message
    }
}
