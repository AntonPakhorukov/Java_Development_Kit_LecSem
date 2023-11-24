package Seminar;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /**
     * Example_01
     * Отсортировать коллекцию в алфавитном порядке.
     * Отсортировать коллекцию по количеству букв в слове.
     * Разверните коллекцию.
     */
    public static void sortByAlphabet(List<String> list){
        Collections.sort(list);
    }
    public static void sortByLength(List<String> list){
        list.sort(Comparator.comparing(String::length));
    }
    public static void reversList(List<String> list) {
        Collections.reverse(list);
    }

    /**
     * Example_02
     * Получите уникальный список Set на основании списка List.
     * Определить наименьший элемент на основании алфавитного порядка.
     * Определить наибольший элемент по кол-ву букв.
     * Удалить все элементы содержащие букву "А".
     */
    public static Set<String> convertListToSet(List<String> list){
        return new HashSet<>(list);
    }
    public static String minLengthName(Set<String> names){
        return names.stream().min(Comparator.naturalOrder()).orElse(null);
    }
    public static List<String> minAndMaxLengthNames(Set<String> names){
        List<String> result = new ArrayList<>();
        result.add(names.stream().min(Comparator.comparing(String::length)).orElse(null));
        result.add(names.stream().max(Comparator.comparing(String::length)).orElse(null));
        return result;
    }
    public static void removeNamesByChar(Set<String> names, char symbol){
        names.removeIf(name -> name.contains(String.valueOf(symbol)));
    }

    /**
     * Example_03
     * Найдите человека с самым маленьким номером телефона.
     * Найдите номер телефона человека чье имя самое большое в алфавитном порядке
     */

    public static String findByMinPhoneNmber(Map<String, String> phonebook){
        Set<Long> numbers = phonebook.keySet().stream().map(el -> Long.valueOf(el)).collect(Collectors.toSet());
        long number = numbers.stream().min(Comparator.naturalOrder()).get();
        return String.format("Наименьший номер: %s, владелец: %s", number, phonebook.get(String.valueOf(number)));
    }
    public static String findByMaxAlphabetName(Map<String, String> phonebook){
        Set<Map.Entry<String, String>> elements = phonebook.entrySet();
        Map.Entry<String, String> name = elements.stream().max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())).get();
        return String.format("Наибольшее имя в алфавитном порядке: %s, номер: %s", name.getValue(), name.getKey());
    }
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Иван", "Сергей", "Александр", "Ирина", "Светлана","Егор"));
        System.out.println(names);
        sortByAlphabet(names);
        System.out.println(names);
        sortByLength(names);
        System.out.println(names);
        reversList(names);
        System.out.println(names);
        System.out.println();

        List<String> names2 = new ArrayList<>(Arrays.asList("Иван", "Сергей", "Светлана", "Ирина", "Светлана","Егор"));
        System.out.println(names2);
        Set<String> setName = convertListToSet(names2);
        System.out.println(setName);
        System.out.println(minLengthName(setName));
        System.out.println(minAndMaxLengthNames(setName));
        removeNamesByChar(setName, 'С');
        System.out.println(setName);
        System.out.println();

        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("89014562356", "Егор");
        phoneBook.put("89134567823", "Светлана");
        phoneBook.put("89023568741", "Алексей");
        phoneBook.put("89654568956", "Алина");
        phoneBook.put("89271254565", "Кирилл");
        System.out.println(findByMaxAlphabetName(phoneBook));
        System.out.println(findByMinPhoneNmber(phoneBook));


    }
}
