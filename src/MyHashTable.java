import java.util.ArrayList;
import java.util.Arrays;

public class MyHashTable<T> {
    ArrayList<MyLinkedList> array; // a list of m slots, each slot has a MyLinkedList object
    private static int m; // number of slots in the hash table

    public MyHashTable() {
        array = new ArrayList<>();
        m = 10;
        for (int i = 0; i < m; i++)
            array.add(new MyLinkedList());
    }

    public void chainedHashInsert(Person person) {
//        HashNode node = new HashNode(getHashCode(person), person);
        int key = getHashCode(person);
        array.get(key).listInsert(person);
    }

    public Person chainedHashSearch(String name) {
        return (Person) array.get(getHashCode(name)).listSearch(name);
    }

    public void chainedHashDelete(Person person) {
        array.get(getHashCode(person)).listDelete(person.getName());
    }

    public boolean isContain(String name) {
        if (chainedHashSearch(name) == null) return false;
        else return true;
    }

    /**
     * Convert String to its ascii integer
     * hash function use division method
     * @param person
     * @return hash code
     */
    private int getHashCode(Person person) {
        return getHashCode(person.getName());
    }

    private int getHashCode(String name) {
        // convert name as String to ascii number
        StringBuilder strBuilder = new StringBuilder();
        int maxChar; // only use first 5 letter for hash function
        if (name.length() > 5) maxChar = 5;
        else maxChar = name.length();

        for (int i = 0; i < maxChar; i++) {
            if (name.charAt(i) == ' ') break;
            strBuilder.append((int) name.charAt(i));
        }
        return (int)(Long.parseLong(strBuilder.toString()) % m);
    }

    public String toString() {
        String out = "";
        for (MyLinkedList elem : array) {
            out += elem.toString();
        }
        return out;
    }

    public Object[] toArray() {
        String out = "";
        for (MyLinkedList elem : array) {
            out += elem.toString();
        }
        return new ArrayList(Arrays.asList(out.split("\n"))).toArray();
    }
}
