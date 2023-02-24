package fitness.core.user.dtos.serializers;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.Instant;

public class LongToInstant extends StdConverter<Long, Instant> {
    @Override
    public Instant convert(Long value) {
        return Instant.ofEpochMilli(value);
    }
}
