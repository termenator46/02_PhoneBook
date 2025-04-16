package phoneBook.model;

public class User {
     private  String email;
    private  String password;
    private  String connfirmPassword;
    private  String FirstName;
    private String lastName;

    public String getConnfirmPassword() {
        return connfirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User setEmail(String email) {
        this.email = email;
        return  this;
    }

    public User setPassword(String password) {
        this.password = password;
        return  this;
    }
}
