package com.puzhenweilibrary.utilsfive.extensions;

/**
 * Created by <a href="https://about.me/janrabe">Jan Rabe</a>.
 */

public class ThrowableExtensions {
    
    /**
     * Rethrow an {@link Throwable} preserving the stack trace but making it unchecked.
     *
     * @param ex to be rethrown and unchecked.
     */
    public static void rethrowUnchecked(final Throwable ex) {
        try {
            ThrowableExtensions.rethrow(ex);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void rethrow(final Throwable t)
        throws T {
        throw (T)t;
    }
}
