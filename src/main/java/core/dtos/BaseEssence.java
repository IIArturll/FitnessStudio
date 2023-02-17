package core.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class BaseEssence {
    private UUID uuid;
    @JsonProperty("dt_create")
    private Date dtCreate;
    @JsonProperty("dt_update")
    private Date dtUpdate;

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

    public Date getDtCreate() {
        return dtCreate;
    }

    public Date getDtUpdate() {
        return dtUpdate;
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
