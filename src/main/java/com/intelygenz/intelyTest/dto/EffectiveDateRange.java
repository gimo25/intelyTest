package com.intelygenz.intelyTest.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.intelygenz.intelyTest.util.LocalDateTimeDeserializer;
import com.intelygenz.intelyTest.util.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO clas representing a date range start/end.
 *
 * @author Giordano Bortolini
 */
@Data
@AllArgsConstructor
public class EffectiveDateRange {

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime start;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime end;
}
