package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @Size(min=5, max=15, message="Username must be between 5 and 15 characters.")
    private String username;
    @Email(message="Please enter a valid email.")
    private String email;
    @Min(value=6, message="Password must be at least 6 characters long.")
    private String password;

    @Min(value=6, message="Password must be at least 6 characters long.")
    @NotNull(message = "Passwords do not match.")
    private String verify;

    public User() {}

    public User(String username, String email, String password, String verify) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
        checkPassword();
    }

    private void checkPassword() {
        if (password != null && verify != null && !password.equals(verify)) {
            setVerify(null);
        }
    }
}
