import java.util.ArrayList;
import java.util.List;

public class Main {
    private static class GBox<T>{
        private T value;
        public GBox(T value) {
            this.value = value;
        }
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
    }
    private static class KVBox<K, V>{
        private K key;
        private V value;
        public KVBox(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
    }
    private static class GBoxN<T extends Number> {
        private T value;
        public GBoxN(T value) {
            this.value = value;
        }
        public T getValue() {
            return value;
        }
    }
//    class Hymn{}
//    interface Dog{}
//    interface Cat{}
//    private static class Animal<T extends Hymn & Dog & Cat>{
//        private List<T> animal;
//
//        public Animal() {
//            this.animal = new ArrayList<>();
//        }
//        @Override
//        public String toString() {
//            return animal.getClass().getSimpleName().toString();
//        }
//    }
    public static void main(String[] args) {
        GBox<Integer> box1 = new GBox<>(20);
        GBox<String> box2 = new GBox<>("Hello");
        System.out.println("Box1 = " + box1.value + "\nBox2 = " + box2.value);

        KVBox<Integer, String> box3 = new KVBox<>(1, "world");
        System.out.println("Key = " + box3.getKey() + " and Value = " + box3.getValue());

        KVBox<GBox, KVBox> box4 = new KVBox<>(box2, box3);
        System.out.println(box2.getValue() + " " + box3.getValue());

        GBox box5 = new GBox("RAW TYPE"); // Сырой тип

        GBoxN<Integer> boxN = new GBoxN<>(25);
//        GBoxN<String> boxN1 = new GBoxN<String>(""); // сработает ограничение, только число
        GBoxN<Float> boxN2 = new GBoxN<>(25.5f);
        System.out.println(boxN.getValue() + boxN2.getValue());

    }
}
