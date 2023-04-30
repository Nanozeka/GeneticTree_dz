package GeneticTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class Tree implements Serializable, Iterable<Human> {

    // Реализуем обход коллекции по итератору
    public class TreeIterator implements Iterator<Human> {

        int cursor;
        Human[] humans;

        public TreeIterator(Human[] humans) {
            this.humans = humans;
        }

        int lastReturned = -1;

        public boolean hasNext() {
            return cursor != persons.size();
        }

        public Human next() {
            return getNextElement();
        }

        private Human getNextElement() {
            int current = cursor;
            // exist(current);

            cursor = current + 1;
            lastReturned = current;
            return humans[lastReturned];

        }
    }

    // констроктур класса дерево
    public Tree() {

        // Иницилизация список родственных связей
        this.children = new TreeMap<String, ArrayList<Human>>();

        // Иницилизация список всех людей
        this.persons = new TreeMap<String, Human>();
    }
       // Перегрузка метода.Преведение к итератору
    @Override
    public Iterator<Human> iterator() {
        Human[] humans = new Human[persons.size()];
        persons.values().toArray(humans);

        return new TreeIterator(humans);
    }

    // объявляем что они члены класса
    private TreeMap<String, ArrayList<Human>> children;

    public TreeMap<String, ArrayList<Human>> getChildren() {
        return children;
    }

    private TreeMap<String, Human> persons;

    // метод по добавлянию людей в дерево
    public void addChild(Human child, Human mather, Human father) {
        persons.put(child.getName(), child);
        persons.put(mather.getName(), mather);
        persons.put(father.getName(), father);

        // Иницилизирууем список детей матерей отцов Если список пустой то создаем новый
        // список
        if (children.get(mather.getName()) == null)
            children.put(mather.getName(), new ArrayList<Human>());
        if (children.get(father.getName()) == null)
            children.put(father.getName(), new ArrayList<Human>());

        // добавляем детей в список матери или отца
        children.get(mather.getName()).add(child);
        children.get(father.getName()).add(child);
    }

    // метод по поиску людей
    public Human search(String name) {
        return persons.get(name);

    }

}
