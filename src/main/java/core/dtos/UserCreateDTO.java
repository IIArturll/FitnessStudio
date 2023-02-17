package core.dtos;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.Objects;

public class UserCreateDTO {
    @JsonUnwrapped
    private UserDTO user;
    private String password;

    public UserCreateDTO(){
    }

    public UserCreateDTO(UserDTO user, String password) {
        this.user = user;
        this.password = password;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateDTO that = (UserCreateDTO) o;
        return Objects.equals(user, that.user) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

    @Override
    public String toString() {
        return "UserCreateDTO{" +
                "user=" + user +
                ", password='" + password + '\'' +
                '}';
    }
}
