
import java.util.*;

// Class representing a student
class Student {
  private int rollNumber;
  private String name;
  private String gender;

  public Student(int rollNumber, String name, String gender) {
    this.rollNumber = rollNumber;
    this.name = name;
    this.gender = gender;
  }

  public int getRollNumber() {
    return rollNumber;
  }

  public String getName() {
    return name;
  }

  public String getGender() {
    return gender;
  }

  @Override
  public String toString() {
    return "Student{" +
        "rollNumber=" + rollNumber +
        ", name='" + name + '\'' +
        ", gender='" + gender + '\'' +
        '}';
  }
}

// Main class for performing different operations on collections
public class Q1 {
  public static void main(String[] args) {
    System.out.println("\nAssignment-08");
    System.out.println("22610018 -> Vighnesh Potdar\n");

    // Create objects of class Student
    Student student1 = new Student(101, "Alice", "Female");
    Student student2 = new Student(102, "Bob", "Male");
    Student student3 = new Student(103, "Charlie", "Male");

    // a. ArrayList
    List<Student> arrayList = new ArrayList<>();
    arrayList.add(student1);
    arrayList.add(student2);
    arrayList.add(student3);
    System.out.println("a. ArrayList: " + arrayList);

    // b. LinkedList
    List<Student> linkedList = new LinkedList<>();
    linkedList.add(student1);
    linkedList.add(student2);
    linkedList.add(student3);
    System.out.println("b. LinkedList: " + linkedList);

    // c. ArrayDeque
    Deque<Student> arrayDeque = new ArrayDeque<>();
    arrayDeque.add(student1);
    arrayDeque.add(student2);
    arrayDeque.add(student3);
    System.out.println("c. ArrayDeque: " + arrayDeque);

    // d. PriorityQueue
    Queue<Student> priorityQueue = new PriorityQueue<>(Comparator.comparing(Student::getRollNumber));
    priorityQueue.add(student2);
    priorityQueue.add(student1);
    priorityQueue.add(student3);
    System.out.println("d. PriorityQueue: " + priorityQueue);

    // e. HashSet
    Set<Student> hashSet = new HashSet<>();
    hashSet.add(student1);
    hashSet.add(student2);
    hashSet.add(student3);
    System.out.println("e. HashSet: " + hashSet);

    // f. TreeSet
    Set<Student> treeSet = new TreeSet<>(Comparator.comparing(Student::getName));
    treeSet.add(student2);
    treeSet.add(student1);
    treeSet.add(student3);
    System.out.println("f. TreeSet: " + treeSet);

    // g. HashMap
    Map<Integer, Student> hashMap = new HashMap<>();
    hashMap.put(student1.getRollNumber(), student1);
    hashMap.put(student2.getRollNumber(), student2);
    hashMap.put(student3.getRollNumber(), student3);
    System.out.println("g. HashMap: " + hashMap);

    // h. LinkedHashMap
    Map<Integer, Student> linkedHashMap = new LinkedHashMap<>();
    linkedHashMap.put(student1.getRollNumber(), student1);
    linkedHashMap.put(student2.getRollNumber(), student2);
    linkedHashMap.put(student3.getRollNumber(), student3);
    System.out.println("h. LinkedHashMap: " + linkedHashMap);
  }
}
