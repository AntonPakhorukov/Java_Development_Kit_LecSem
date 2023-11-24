package Lecture;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Обход элементов коллекции
        Collection<Integer> collection = List.of(1, 2, 3, 4, 5);
        /**
         * Iterator
         */
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        /**
         * Foreach
         */
        for (Integer item : collection) {
            System.out.print(item + " ");
        }
        System.out.println();
        /**
         * Stream API
         */
        collection.stream().forEach(value -> System.out.print(value + " "));
        System.out.println();
        collection.stream().forEach(System.out::print);
        System.out.println();
        /**
         * Map
         */
        Map<String, Integer> map = Map.of("Hello", 1, "World", 2);
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        for (String str : map.keySet()) {
            System.out.println(str + ": " + map.get(str));
        }
        System.out.println();
        map.forEach((K, V) -> System.out.println(K + ": " + V));
    }
}
