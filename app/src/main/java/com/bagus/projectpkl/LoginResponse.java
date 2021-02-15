package com.bagus.projectpkl;

public class LoginResponse {
    private boolean error;
    private String message;
    private UserModel data;

    public LoginResponse(boolean error, String message, UserModel data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public UserModel getData() {
        return data;
    }
}
