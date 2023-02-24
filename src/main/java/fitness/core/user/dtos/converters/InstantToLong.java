package fitness.core.user.dtos.serializers;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.Instant;

public class InstantToLong extends StdConverter<Instant, Long> {

    @Override
    public Long convert(Instant value) {
        return value.toEpochMilli();
    }
}
