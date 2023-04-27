package GeneticTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Saver {
    // Создаем метод для записи
    public static void save(String fileName, Serializable data)
     throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(data);
        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();
    }

    // Создаем метод для чтения
    public static Object read(String fileName)
     throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object result = objectInputStream.readObject();
        objectInputStream.close();
        return result;
    }
}
