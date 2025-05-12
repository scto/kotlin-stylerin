package com.levelrin;

import java.io.Serial;

/**
 * The input text might have syntax errors.
 * Even worse, the parsing may fail due to a bug in the `KotlinParser.g4`.
 * We will throw this exception in such cases.
 */
public final class ParseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     *
     * @param message Error message.
     */
    public ParseException(final String message) {
        super(message);
    }

}
