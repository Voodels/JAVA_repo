import java.util.*;

class Book {
  private String isbn;
  private String name;
  private double price;

  public Book(String isbn, String name, double price) {
    this.isbn = isbn;
    this.name = name;
    this.price = price;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Book{" +
        "isbn='" + isbn + '\'' +
        ", name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}

public class Q2 {
  public static void main(String[] args) {
    // Create objects of class Book
    Book book1 = new Book("978-0134685991", "Effective Java", 39.99);
    Book book2 = new Book("978-0201633610", "Design Patterns", 47.99);
    Book book3 = new Book("978-0321356680", "Clean Code", 35.99);

    // a. ArrayList
    List<Book> arrayList = new ArrayList<>();
    arrayList.add(book1);
    arrayList.add(book2);
    arrayList.add(book3);
    System.out.println("ArrayList:");
    printBooks(arrayList);

    // b. LinkedList
    List<Book> linkedList = new LinkedList<>();
    linkedList.add(book1);
    linkedList.add(book2);
    linkedList.add(book3);
    System.out.println("\nLinkedList:");
    printBooks(linkedList);

    // c. ArrayDeque
    Deque<Book> arrayDeque = new ArrayDeque<>();
    arrayDeque.add(book1);
    arrayDeque.add(book2);
    arrayDeque.add(book3);
    System.out.println("\nArrayDeque:");
    printBooks(arrayDeque);

    // d. PriorityQueue
    Queue<Book> priorityQueue = new PriorityQueue<>(Comparator.comparing(Book::getPrice));
    priorityQueue.add(book2);
    priorityQueue.add(book1);
    priorityQueue.add(book3);
    System.out.println("\nPriorityQueue:");
    printBooks(priorityQueue);

    // e. HashSet
    Set<Book> hashSet = new HashSet<>();
    hashSet.add(book1);
    hashSet.add(book2);
    hashSet.add(book3);
    System.out.println("\nHashSet:");
    printBooks(hashSet);

    // f. TreeSet
    Set<Book> treeSet = new TreeSet<>(Comparator.comparing(Book::getName));
    treeSet.add(book2);
    treeSet.add(book1);
    treeSet.add(book3);
    System.out.println("\nTreeSet:");
    printBooks(treeSet);

    // g. HashMap
    Map<String, Book> hashMap = new HashMap<>();
    hashMap.put(book1.getIsbn(), book1);
    hashMap.put(book2.getIsbn(), book2);
    hashMap.put(book3.getIsbn(), book3);
    System.out.println("\nHashMap:");
    printBooks(hashMap.values());

    // h. LinkedHashMap
    Map<String, Book> linkedHashMap = new LinkedHashMap<>();
    linkedHashMap.put(book1.getIsbn(), book1);
    linkedHashMap.put(book2.getIsbn(), book2);
    linkedHashMap.put(book3.getIsbn(), book3);
    System.out.println("\nLinkedHashMap:");
    printBooks(linkedHashMap.values());
  }

  // Method to print books in a collection
  private static void printBooks(Collection<Book> books) {
    for (Book book : books) {
      System.out.println(book);
    }
  }
}
