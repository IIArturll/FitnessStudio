package fitness.core.user.dtos;

import fitness.core.exceptions.MultipleErrorResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

public class UserLoginDTO {
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",
            message = "illegal format of email,correct example: email@mail.ru , google@gmail.com")
    public String mail;
    @NotNull
    @NotBlank
    public String password;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String mail, String password) throws MultipleErrorResponse {
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
}
