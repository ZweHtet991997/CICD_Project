package com.yomabank.employeeapiservices.utils;

public class ResponseMessageUtils {
    public static final String Success = "Success";
    public static final String BadRequest = "Bad Request";
    public static final String Conflict = "Conflict";
    public static final String InternalServerError = "Internal Server Error";
    public static final String Created = "Created";
    public static final String Updated = "Updated";
    public static final String Deleted = "Deleted";

    public static String EmailDuplicate(String email) {
        return String.format("This Email %s is already created in the system", email);
    }

    public static String EmpCodeDuplicate(String empCode) {
        return String.format("Employee Code %s is already created in the system", empCode);
    }
}
