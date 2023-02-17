package core.dtos;

import java.util.Objects;

public class UserLoginDTO {
    public String mail;
    public String password;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLoginDTO userLogin = (UserLoginDTO) o;
        return Objects.equals(mail, userLogin.mail)
                && Objects.equals(password, userLogin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, password);
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
