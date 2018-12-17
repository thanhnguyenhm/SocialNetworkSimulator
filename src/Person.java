/**
 * Person class for an user account
 * Each user account has a name and a list of their friends
 * @author thanhnguyen
 */
public class Person {
    // Declare instance fields
    private String name;
    private MyLinkedList<Person> friendList;

    /**
     * Constructor
     * @param name: a name of user account
     * When an account is added, friendList will be generated with null
     */
    public Person(String name) {
        this.name = name;
        friendList = new MyLinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyLinkedList<Person> getFriendList() {
        return friendList;
    }

    public void setFriendList(MyLinkedList<Person> friendList) {
        this.friendList = friendList;
    }

    public String toString() {
        return name;
    }
}
