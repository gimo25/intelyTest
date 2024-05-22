package com.intelygenz.intelyTest.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Custom Serializer for LocalDateTime serialization, that way we can control the format we need.
 *
 * @author Giordano Bortolini
 */
public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

  protected LocalDateTimeSerializer() {
    this(null);
  }
  protected LocalDateTimeSerializer(Class<LocalDateTime> type) {
    super(type);
  }

  @Override
  public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator,
      SerializerProvider serializerProvider) throws IOException {

    jsonGenerator.writeString(LocalDateTimeDeserializer.DATE_TIME_FORMATTER.format(localDateTime));
  }
}
