package utils;

public class ErrorHandler {
    public static void handleError(Exception e) {
        System.err.println("[ERROR] " + e.getMessage());
    }
}
