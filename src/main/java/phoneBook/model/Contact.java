package phoneBook.model;

public class Contact {

    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String desc;
    private String Password;
    private String Confirmpassword;

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setPassword(String password) {
        this.Password = password;
        return this;
    }

    public Contact setConfirmpassword(String confirmpassword) {
        this.Confirmpassword = confirmpassword;
        return this;
    }

    public Contact setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;

    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}