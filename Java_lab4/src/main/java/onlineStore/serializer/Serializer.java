package onlineStore.serializer;

import java.io.File;
import java.io.IOException;

public interface Serializer<T> {
    // Метод для серіалізації об'єкта у форматі String
    String serialize(T object) throws IOException;

    // Метод для десеріалізації об'єкта з рядка
    T deserialize(String data, Class<T> clazz) throws IOException;

    // Метод для запису об'єкта в файл
    void writeToFile(T object, File file) throws IOException;

    // Метод для зчитування об'єкта з файлу
    T readFromFile(File file, Class<T> clazz) throws IOException;
}
