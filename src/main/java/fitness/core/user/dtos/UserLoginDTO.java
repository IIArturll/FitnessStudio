package fitness.core.user.dtos;

import fitness.core.exceptions.MultipleErrorResponse;
import fitness.core.validators.MailValidator;
import fitness.core.validators.PasswordValidator;

import java.util.Objects;

public class UserLoginDTO {
    public String mail;
    public String password;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String mail, String password) throws MultipleErrorResponse {
        this.mail = mail;
        this.password = password;
        validate();
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

    public void validate() throws MultipleErrorResponse {
        MultipleErrorResponse errorResponse = new MultipleErrorResponse("invalid fields");
        MailValidator.validate(errorResponse, this.mail);
        PasswordValidator.validate(errorResponse, this.password);
        if (!errorResponse.getErrors().isEmpty()) {
            throw errorResponse;
        }
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
