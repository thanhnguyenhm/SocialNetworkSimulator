import java.util.ArrayList;

public class MyHashTable<T> {
    ArrayList<MyLinkedList> array; // a list of m slots, each slot has a MyLinkedList object
    private static int m; // number of slots in the hash table

    public MyHashTable() {
        array = new ArrayList<>();
        m = 10;
        for (int i = 0; i < m; i++)
            array.add(null);
    }

    public void chainedHashInsert(Person person) {
//        HashNode node = new HashNode(getHashCode(person), person);
        int key = getHashCode(person);
        array.get(key).listInsert(person);
    }

    public Person chainedHashSearch(Person person) {
        return (Person) array.get(getHashCode(person)).listSearch(person.toString());
    }

    public void chainedHashDelete(Person person) {
        array.get(getHashCode(person)).listDelete(person.getName());
    }

    /**
     * Convert String to its ascii integer
     * hash function use division method
     * @param person
     * @return hash code
     */
    private int getHashCode(Person person) {
        // convert name as String to ascii number
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < person.getName().length(); i++) {
            strBuilder.append((int) person.getName().charAt(i));
        }
        return (Integer.parseInt(strBuilder.toString()) % (m));
    }

//    /**
//     * Inner class HashNode
//     * Each HashNode has Person object as key and MyLinkedList as value
//     */
//    public class HashNode {
//        int key;
//        Person value;
//        HashNode next;
//
//        public HashNode(int key, Person value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
}
