package GeneticTree;

import java.io.Serializable;

public class Human implements Serializable {
    // Характеристика экземпляра класса
    private String name;

    // метод для обращения к имени
    public String getName() {
        return name;
    }

    // Иницилизация поля нэим(это констроктур)
    public Human(String name) {
        this.name = name;

    }

}
