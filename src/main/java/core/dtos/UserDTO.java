package core.dtos;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import core.dtos.enums.UserRole;
import core.dtos.enums.UserStatus;

import java.util.Objects;

public class UserDTO {
    @JsonUnwrapped
    private BaseEssence essence;
    private String mail;
    private String fio;
    private UserRole role;
    private UserStatus status;

    public UserDTO(){
    }
    public UserDTO(BaseEssence essence, String mail, String fio, UserRole role, UserStatus status) {
        this.essence = essence;
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
    }

    public BaseEssence getEssence() {
        return essence;
    }

    public void setEssence(BaseEssence essence) {
        this.essence = essence;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO user = (UserDTO) o;
        return Objects.equals(essence, user.essence) && Objects.equals(mail, user.mail) && Objects.equals(fio, user.fio) && role == user.role && status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(essence, mail, fio, role, status);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "essence=" + essence +
                ", mail='" + mail + '\'' +
                ", fio='" + fio + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
