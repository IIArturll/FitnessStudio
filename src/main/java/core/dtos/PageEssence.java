package core.dtos;

import java.util.Objects;

public class PageEssence {
    private Integer number;
    private Integer size;
    private Integer totalPages;
    private Integer totalElements;
    private boolean first;
    private Integer numberOfElement;
    private boolean last;

    public PageEssence() {
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
