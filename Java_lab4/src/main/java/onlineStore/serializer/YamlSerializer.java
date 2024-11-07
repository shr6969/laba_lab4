package onlineStore.serializer;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class YamlSerializer<T> {

    private final YAMLMapper yamlMapper;

    public YamlSerializer() {
        yamlMapper = new YAMLMapper();
        yamlMapper.registerModule(new JavaTimeModule()); // Register JSR310 module
    }

    public String serialize(T object) throws IOException {
        return yamlMapper.writeValueAsString(object);
    }

    public void writeToFile(T object, File file) throws IOException {
        yamlMapper.writeValue(file, object);
    }

    public T readFromFile(File file, Class<T> clazz) throws IOException {
        return yamlMapper.readValue(file, clazz);
    }
}
