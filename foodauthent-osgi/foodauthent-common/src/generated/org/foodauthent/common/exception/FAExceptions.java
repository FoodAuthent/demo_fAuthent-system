package org.foodauthent.common.exception;

/**
 * Summarizes auto-generated exceptions that can occur in the the fa-system.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public final class FAExceptions {

    /**
    * Unspecified exception.
    */
    public static class FAException extends Exception {
        public FAException(String message) {
            super(message);
        }
        
        public FAException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    /**
    * Invalid input was provided.
    */
    public static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
        
        public InvalidInputException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
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
    
    /**
    * Invalid data was uploaded.
    */
    public static class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
        
        public InvalidDataException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    /**
    * Invalid input was provided, entity already exists.
    */
    public static class EntityAlreadyExistsResponse extends Exception {
        public EntityAlreadyExistsResponse(String message) {
            super(message);
        }
        
        public EntityAlreadyExistsResponse(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    /**
    * Response thrown when an entity could not be found.
    */
    public static class EntityNotFoundResponse extends Exception {
        public EntityNotFoundResponse(String message) {
            super(message);
        }
        
        public EntityNotFoundResponse(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    /**
    * Access to resource is not allowed.
    */
    public static class ForbiddenAccessResponse extends Exception {
        public ForbiddenAccessResponse(String message) {
            super(message);
        }
        
        public ForbiddenAccessResponse(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    /**
    * Requested operation is not supported.
    */
    public static class InvalidOperationResponse extends Exception {
        public InvalidOperationResponse(String message) {
            super(message);
        }
        
        public InvalidOperationResponse(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    /**
    * Unauthorized access.
    */
    public static class UnauthorizedResponse extends Exception {
        public UnauthorizedResponse(String message) {
            super(message);
        }
        
        public UnauthorizedResponse(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    
}
