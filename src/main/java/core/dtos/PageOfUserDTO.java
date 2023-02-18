package core.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({"number", "size", "total_pages", "total_elements",
        "first", "number_of_elements", "last", "content"})
public class PageOfUserDTO extends PageEssence {
    private List<UserDTO> content;

    public PageOfUserDTO(Integer number, Integer size, Integer totalPages,
                         Integer totalElements, boolean first, Integer numberOfElement,
                         boolean last, List<UserDTO> content) {
        super(number, size, totalPages, totalElements, first, numberOfElement, last);
        this.content = content;
    }

    public void validate() {

    }

    public List<UserDTO> getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageOfUserDTO that = (PageOfUserDTO) o;
        return super.equals(o)
                && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content);
    }
}
