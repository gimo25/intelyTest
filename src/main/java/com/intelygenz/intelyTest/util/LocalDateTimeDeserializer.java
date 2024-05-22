package com.intelygenz.intelyTest.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Custom deserializer for LocalDateTime used in DTOs.
 *
 * @author Giordano Bortolini
 */
public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

  public static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

  protected LocalDateTimeDeserializer() {
    this(null);
  }
  protected LocalDateTimeDeserializer(Class<LocalDateTime> type) {
    super(type);
  }

  @Override
  public LocalDateTime deserialize(JsonParser jsonParser,
      DeserializationContext deserializationContext) throws IOException {
    return LocalDateTime.parse(jsonParser.getText(), DATE_TIME_FORMATTER);
  }
}
