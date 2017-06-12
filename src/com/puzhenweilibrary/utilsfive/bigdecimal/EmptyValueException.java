package com.puzhenweilibrary.utilsfive.bigdecimal;

/**
 * Runtime exception for empty value Created by Joielechong on 1/3/16.
 */
public class EmptyValueException extends RuntimeException {
    private static final long serialVersionUID = 7743477701336896342L;
    
    public EmptyValueException(String aMessage) {
        super(aMessage);
    }
}
