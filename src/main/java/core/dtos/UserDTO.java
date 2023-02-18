package core.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import core.dtos.enums.UserRole;
import core.dtos.enums.UserStatus;
import core.exceptions.MultipleErrorResponse;
import core.exceptions.SingleErrorResponse;
import core.validators.FIOValidator;
import core.validators.MailValidator;
import core.validators.RoleValidator;
import core.validators.StatusValidator;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@JsonPropertyOrder({"uuid",
        "dt_create",
        "dt_update",
        "mail",
        "fio",
        "role",
        "status"})
public class UserDTO extends BaseEssence {
    protected String mail;
    protected String fio;
    protected UserRole role;
    protected UserStatus status;

    public UserDTO() {
    }

    public UserDTO(String mail, String fio, UserRole role, UserStatus status) throws MultipleErrorResponse, SingleErrorResponse {
        super(UUID.randomUUID(), new Date(), new Date());
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
        validate();
    }

    public UserDTO(UUID uuid, Date dt_create, Date dt_update, String mail,
                   String fio, UserRole role, UserStatus status) throws MultipleErrorResponse{
        super(uuid, dt_create, dt_update);
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
        validate();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public void validate() throws MultipleErrorResponse {
        MultipleErrorResponse errorResponse = new MultipleErrorResponse("invalid fields");
        MailValidator.validate(errorResponse, this.mail);
        FIOValidator.validate(errorResponse, this.fio);
        RoleValidator.validate(errorResponse, this.role);
        StatusValidator.validate(errorResponse, this.status);
        if (!errorResponse.getErrors().isEmpty()) {
            throw errorResponse;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserDTO userDTO = (UserDTO) o;
        return super.equals(o)
                && Objects.equals(mail, userDTO.mail)
                && Objects.equals(fio, userDTO.fio)
                && role == userDTO.role
                && status == userDTO.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mail, fio, role, status);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "\nuuid= '" + uuid + '\'' +
                ",\ndt_create= " + getDtCreate() +
                ",\ndt_create= " + getDtUpdate() +
                ",\nmail= '" + mail + '\'' +
                ",\nfio= '" + fio + '\'' +
                ",\nrole= " + role +
                ",\nstatus=" + status +
                "\n}";
    }
}
