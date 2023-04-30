package GeneticTree;

import java.io.Serializable;

public class Human implements Serializable {
    // Имя человека
    private String name;

    // Получить имя
    public String getName() {
        return name;
    }

    // Иницилизация поля нэим(это констроктур)
    public Human(String name) {
        this.name = name;

    }

}
