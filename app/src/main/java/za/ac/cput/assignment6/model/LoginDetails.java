package za.ac.cput.assignment6.model;

/**
 * Created by sanXion on 2016/09/02.
 */
public class LoginDetails {
    private String email;
    private String password;

    public LoginDetails()
    {

    }

    public LoginDetails(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
