package com.yomabank.employeeapiservices.enums;

public enum ResponseStatus {
    SUCCESS,               // Operation was successful
    ALREADY_EXISTS,        // Resource already exists, cannot create
    FAILED_TO_CREATE,      // Failed to create the resource
    BAD_REQUEST,           // Bad Request
    NOT_FOUND,             // Resource not found
    FAILED_TO_UPDATE,      // Failed to update the resource
    FAILED_TO_DELETE,      // Failed to delete the resource
    UNAUTHORIZED,          // Unauthorized operation
    VALIDATION_ERROR,      // Input validation failed
    ERROR                  // Internal server error
}
