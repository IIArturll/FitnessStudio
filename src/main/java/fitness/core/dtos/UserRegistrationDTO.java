package core.dtos;

import core.exceptions.MultipleErrorResponse;
import core.validators.FIOValidator;
import core.validators.MailValidator;
import core.validators.PasswordValidator;

import java.util.Objects;

public class UserRegistrationDTO {
    private String mail;
    private String fio;
    private String password;

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String mail, String fio, String password) throws MultipleErrorResponse {
        this.mail = mail;
        this.fio = fio;
        this.password = password;
        validate();
    }

    public String getMail() {
        return mail;
    }

    public String getFio() {
        return fio;
    }

    public String getPassword() {
        return password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void validate() throws MultipleErrorResponse {
        MultipleErrorResponse errorResponse = new MultipleErrorResponse("invalid fields");
        MailValidator.validate(errorResponse, this.mail);
        FIOValidator.validate(errorResponse, this.fio);
        PasswordValidator.validate(errorResponse, this.password);
        if (!errorResponse.getErrors().isEmpty()) {
            throw errorResponse;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRegistrationDTO that = (UserRegistrationDTO) o;
        return Objects.equals(mail, that.mail)
                && Objects.equals(fio, that.fio)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, fio, password);
    }

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "mail='" + mail + '\'' +
                ", fio='" + fio + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
