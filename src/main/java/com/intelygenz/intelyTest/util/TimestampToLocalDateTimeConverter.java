package com.intelygenz.intelyTest.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Converter to use in entities to convert LocalDateTime and sql timestamp.
 *
 * @author Giordano Bortolini
 */
@Converter
public class TimestampToLocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

  @Override
  public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
    return localDateTime == null ? null : Timestamp.valueOf(localDateTime);
  }

  @Override
  public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
    return timestamp == null ? null : timestamp.toLocalDateTime();
  }
}
