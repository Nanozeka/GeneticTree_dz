package GeneticTree;

import java.io.IOException;
import java.util.Scanner;

public class View {

    private Tree tree;

    // Создаем навигатор для работы с деревом
    public void printUserCommands() {
       
        System.out.println("Введите код команды: ");
        System.out.println("1. Создать дерево: ");
        System.out.println("2. Сохранить дерево: ");
        System.out.println("3. Загрузить дерево: ");
        System.out.println("4. Добавить члена семьи: ");
        System.out.println("5. Вывести список членов семьи: ");
        System.out.println("6. Найти члена семьи: ");
        
    }

    //Создаем дерево
    public void createNewTree() {
        tree = new Tree();
        System.out.println(" Дерево успешно создано");
    }

    // Сохраняем дерево
    public void saveTree(Scanner scanner) throws IOException {
        System.out.println("Введите имя файла для сохранения: ");
        String name = scanner.nextLine();
        Saver.save(name, tree);
        System.out.println(" Дерево успешно сохранено");
        
    }

    // Загружаем дерево
    public void loadTree(Scanner scanner) throws ClassNotFoundException, IOException {
        System.out.println("Введите имя файла для загрузки: ");
        String name = scanner.nextLine();
        tree = (Tree)Saver.read(name);
        System.out.println(" Дерево успешно загружено");
        
    }

    // Добавляем члена семьи
    public void addHuman(Scanner scanner) {
        
        System.out.println(" Введите имя отца: ");
        String fatherName = scanner.nextLine();
        Human father = tree.search(fatherName) != null ? tree.search(fatherName) : new Human(fatherName);

        System.out.println(" Введите имя матери: ");
        String matherName = scanner.nextLine();
        Human mather = tree.search(matherName) != null ? tree.search(matherName) : new Human(matherName);

        System.out.println(" Введите имя человека: ");
        String humanName = scanner.nextLine();
        Human human = new Human(humanName);
        tree.addChild(human,mather,father);
        System.out.println("Человек успешно добавлен");
    }

    // Выводим список членов семьи
    public void printTree() {

    }

    // Находим члена семьи
    public void searchHuman(Scanner scanner) {

    }

    public void processUserCommand() {
        try {
        Scanner scanner = new Scanner(System.in);
       
        while(true)
        {
            printUserCommands();
        int num = scanner.nextInt();
        // Сделать бесконечный цикл для ввода сканера
        switch(num) {
            case 1:
                createNewTree();
                break;

                case 2:
                saveTree(scanner);
                break;

                case 3:
                loadTree(scanner);
                break;

                case 4:
                addHuman(scanner);
                break;

                case 5:
                printTree();
                break;

                case 6:
                searchHuman(scanner);
                break;
        }
    }
    } catch (ClassNotFoundException e) {
         e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Операция закончилась ошибкой");
    }
    }
    
}
