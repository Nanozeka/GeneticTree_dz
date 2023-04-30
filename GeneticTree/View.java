package GeneticTree;

import java.io.IOException;
import java.util.ArrayList;
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
        System.out.println("6. Вывести отсортированный список членов семьи: ");
        System.out.println("7. Найти члена семьи: ");

    }

    // Создаем дерево
    public void createNewTree() {
        tree = new Tree();
        System.out.println(" Дерево успешно создано");
    }

    // Сохраняем дерево
    public void saveTree() throws IOException {
        if (!checkTree())
            return;
        System.out.println("Введите имя файла для сохранения: ");
        var scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Saver.save(name, tree);
        System.out.println(" Дерево успешно сохранено");

    }

    // Загружаем дерево
    public void loadTree() throws ClassNotFoundException, IOException {
        System.out.println("Введите имя файла для загрузки: ");
        var scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        tree = (Tree) Saver.read(name);
        System.out.println(" Дерево успешно загружено");

    }

    // Добавляем члена семьи
    public void addHuman() {
        if (!checkTree())
            return;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Введите имя отца: ");
        String fatherName = scanner.nextLine();
        Human father = tree.search(fatherName) != null ? tree.search(fatherName) : new Human(fatherName);

        System.out.println(" Введите имя матери: ");
        String matherName = scanner.nextLine();
        Human mather = tree.search(matherName) != null ? tree.search(matherName) : new Human(matherName);

        System.out.println(" Введите имя ребенка: ");
        String humanName = scanner.nextLine();
        Human human = new Human(humanName);
        tree.addChild(human, mather, father);
        System.out.println("Ребенок успешно добавлен");

    }

    boolean checkTree() {
        if (tree == null) {
            System.out.println("Дерево не инициализировано. Создайте или загрузите дерево.");
            return false;
        }
        return true;
    }

    // Выводим список членов семьи
    public void printTree() {

        if (!checkTree())
            return;
        System.out.printf("Генелогическое дерево: \n");

        // К найденому родителю подставляем найденого ребенка
        // путем перебора цикла(сначала ищем родителя а потом по найдемоу родителю
        // детей)
        for (String parent : tree.getChildren().keySet()) {
            System.out.printf("Родитель %s\nДети:\n", parent);

            ArrayList<Human> childs = tree.getChildren().get(parent);
            for (Human child : childs) {
                System.out.printf("Ребенок %s\n", child.getName());
            }
            System.out.printf("\n");
        }
        // for (var human : tree)
        // System.out.println(human.getName());
    }

    public void printHuman() {

        if (!checkTree())
            return;
        System.out.printf("Отсортированное генелогическое дерево: \n");

        for (var human : tree)
            System.out.println(human.getName());
    }

    // Находим члена семьи
    public void searchHuman() {
        if (!checkTree())
            return;
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        {
            // Делаем поиск по имени в дереве
            var human = tree.search(name);

            // Если имя совпадает с введеным то выводим найден
            if (human != null)
                System.out.println(String.format("%s найден", name));

            // если нет то не найден
            else
                System.out.println(String.format("%s не найден", name));
        }

    }

    public void processUserCommand() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                printUserCommands();

                int num = scanner.nextInt();

                switch (num) {
                    case 1:
                        createNewTree();
                        break;

                    case 2:
                        saveTree();
                        break;

                    case 3:
                        loadTree();
                        break;

                    case 4:
                        addHuman();
                        break;

                    case 5:
                        printTree();
                        break;

                    case 6:
                        printHuman();
                        break;

                    case 7:
                        searchHuman();
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
