package core.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@JsonPropertyOrder({"dt_create", "dt_update"})
public abstract class BaseEssence {
    @JsonIgnore
    protected UUID uuid;
    @JsonProperty("dt_create")
    protected Date dtCreate;
    @JsonProperty("dt_update")
    protected Date dtUpdate;

    public BaseEssence() {
    }

    public BaseEssence(UUID uuid, Date dt_create, Date dt_update) {
        this.uuid = uuid;
        this.dtCreate = dt_create;
        this.dtUpdate = dt_update;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Long getDtCreate() {
        return dtCreate.getTime();
    }

    public Long getDtUpdate() {
        return dtUpdate.getTime();
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setDtCreate(Date dtCreate) {
        this.dtCreate = dtCreate;
    }

    public void setDtUpdate(Date dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEssence that = (BaseEssence) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(dtCreate, that.dtCreate) && Objects.equals(dtUpdate, that.dtUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, dtCreate, dtUpdate);
    }

    @Override
    public String toString() {
        return "BaseEssence{" +
                "uuid=" + uuid +
                ", dt_create=" + dtCreate +
                ", dt_update=" + dtUpdate +
                '}';
    }
}
