/**
 * Customized Linked List implementation based on CLRS's algorithms
 * @param <T>
 */
public class MyLinkedList<T> {

    Node<T> head;

    public MyLinkedList() {
        head = null;
    }

    public T listSearch(String name) {
        Node<T> x = this.head;
        while (x != null && !x.entry.toString().equals(name))
            x = x.next;
        if (x == null) return null;
        return x.entry;
    }

    public Node<T> searchNode(String name) {
        Node<T> x = this.head;
        while (x != null && !x.entry.toString().equals(name))
            x = x.next;
        if (x == null) return null;
        return x;
    }

    public void listInsert(T entry) {
        Node<T> x = new Node<>(entry);
        x.next = this.head;
        if (this.head != null) this.head.prev = x;
        this.head = x;
        x.prev = null;
    }

    public void listDelete(String name) {
        Node<T> x = searchNode(name);
        if (x.prev != null)
            x.prev.next = x.next;
        else this.head = x.next;
        if (x.next != null)
            x.next.prev = x.prev;
    }

    public boolean isContain(String name) {
        if (listSearch(name) == null) return false;
        else return true;
    }

    public String toString() {
        return toString(head);
    }

    private String toString(Node<T> node) {
        if (node == null) {
            return "";
        } else {
            return node.getString() + "\n" + toString(node.next);
        }
    }

    /**
     * Inner class for Node: an element of Linked List
     * @param <T>
     */
    static public class Node<T> {
        public Node<T> next, prev;
        public T entry;

        Node(T entry) { this.entry = entry; }

        public String getString() {
            return entry.toString();
        }
    }
}
