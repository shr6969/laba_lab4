package onlineStore.serializer;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class XmlSerializer<T> {

    private final XmlMapper xmlMapper;

    public XmlSerializer() {
        xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule()); // Register JSR310 module
    }

    public String serialize(T object) throws IOException {
        return xmlMapper.writeValueAsString(object);
    }

    public void writeToFile(T object, File file) throws IOException {
        xmlMapper.writeValue(file, object);
    }

    public T readFromFile(File file, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(file, clazz);
    }
}
