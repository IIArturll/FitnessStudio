package fitness.core.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonPropertyOrder({"number", "size", "total_pages", "total_elements",
        "first", "number_of_elements", "last"})
public abstract class PageEssence {
    protected Integer number;
    protected Integer size;
    @JsonProperty("total_pages")
    protected Integer totalPages;
    @JsonProperty("total_elements")
    protected Integer totalElements;
    protected boolean first;
    @JsonProperty("number_of_elements")
    protected Integer numberOfElement;
    protected boolean last;

    public PageEssence() {
    }

    public PageEssence(Integer number, Integer size, Integer totalPages,
                       Integer totalElements, boolean first,
                       Integer numberOfElement, boolean last) {
        this.number = number;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.first = first;
        this.numberOfElement = numberOfElement;
        this.last = last;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public Integer getNumberOfElement() {
        return numberOfElement;
    }

    public void setNumberOfElement(Integer numberOfElement) {
        this.numberOfElement = numberOfElement;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageEssence pageDTO = (PageEssence) o;
        return first == pageDTO.first && last == pageDTO.last && Objects.equals(number, pageDTO.number) && Objects.equals(size, pageDTO.size) && Objects.equals(totalPages, pageDTO.totalPages) && Objects.equals(totalElements, pageDTO.totalElements) && Objects.equals(numberOfElement, pageDTO.numberOfElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, size, totalPages, totalElements, first, numberOfElement, last);
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "number=" + number +
                ", size=" + size +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", first=" + first +
                ", numberOfElement=" + numberOfElement +
                ", last=" + last +
                '}';
    }
}
