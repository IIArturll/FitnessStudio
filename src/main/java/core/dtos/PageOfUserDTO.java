package core.dtos;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.List;
import java.util.Objects;

public class PageOfUserDTO {
    @JsonUnwrapped
    private PageEssence pageDTO;
    private List<UserDTO> users;

    public PageOfUserDTO() {
    }

    public PageOfUserDTO(PageEssence pageDTO, List<UserDTO> users) {
        this.pageDTO = pageDTO;
        this.users = users;
    }

    public PageEssence getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageEssence pageDTO) {
        this.pageDTO = pageDTO;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageOfUserDTO that = (PageOfUserDTO) o;
        return Objects.equals(pageDTO, that.pageDTO) && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageDTO, users);
    }

    @Override
    public String toString() {
        return "PageOfUserDTO{" +
                "pageDTO=" + pageDTO +
                ", users=" + users +
                '}';
    }
}
