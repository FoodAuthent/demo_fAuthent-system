package org.foodauthent.common.exception;

/**
 * Summarizes auto-generated exceptions that can occur in the the fa-system.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public final class FAExceptions {

    /**
    * Exception thrown when a job could not be initialized.
    */
    public static class InitJobException extends Exception {
        public InitJobException(String message) {
            super(message);
        }
        
        public InitJobException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    
}
