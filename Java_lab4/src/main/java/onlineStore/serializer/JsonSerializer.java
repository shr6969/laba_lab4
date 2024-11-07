package onlineStore.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class JsonSerializer<T> {

    private final ObjectMapper objectMapper;

    public JsonSerializer() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Register JSR310 module
    }

    public String serialize(T object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    public void writeToFile(T object, File file) throws IOException {
        objectMapper.writeValue(file, object);
    }

    public T readFromFile(File file, Class<T> clazz) throws IOException {
        return objectMapper.readValue(file, clazz);
    }
}
