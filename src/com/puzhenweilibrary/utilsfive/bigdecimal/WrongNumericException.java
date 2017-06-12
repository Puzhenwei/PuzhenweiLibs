package com.puzhenweilibrary.utilsfive.bigdecimal;

/**
 * Thrown when a string is not a valid numeric value. Created by Joielechong 1/2/2016
 */
public final class WrongNumericException extends RuntimeException {
    private static final long serialVersionUID = -4729990385411148256L;

    WrongNumericException(String aMessage) {
        super(aMessage);
    }
}
