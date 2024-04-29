import java.util.Scanner;

// Assignment No. 7

public class ThreadAssignment {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.println("\nAssignment No. 7 Menu:");
      System.out.println("1. Can we call the run() method instead of start()?");
      System.out.println("2. Explain the use of the keyword 'synchronized'.");
      System.out.println("3. Display thread information.");
      System.out.println("4. Create threads using Thread class and Runnable interface.");
      System.out.println("5. Demonstrate thread communication and synchronization.");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          canCallRunMethod();
          break;
        case 2:
          explainSynchronizedKeyword();
          break;
        case 3:
          displayThreadInformation();
          break;
        case 4:
          createThreads();
          break;
        case 5:
          threadCommunication();
          break;
        case 6:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid choice. Please enter a valid option.");
      }
    } while (choice != 6);
    scanner.close();
  }

  // 1. Can we call the run() method instead of start()?
  private static void canCallRunMethod() {
    System.out
        .println("Yes, we can call the run() method directly, but it will run in the context of the current thread, "
            + "just like any other method call. It won't create a new thread of execution.");
  }

  // 2. Explain the use of the keyword 'synchronized'.
  private static void explainSynchronizedKeyword() {
    System.out.println(
        "The 'synchronized' keyword in Java is used to control access to critical sections of code by multiple threads. "
            + "It ensures that only one thread can execute a synchronized block of code at a time, preventing concurrent "
            + "access to shared resources and thus avoiding race conditions and data inconsistency issues.");
  }

  // 3. Display thread information.
  private static void displayThreadInformation() {
    Thread currentThread = Thread.currentThread();
    System.out.println("Thread Information:");
    System.out.println("Name: " + currentThread.getName());
    System.out.println("ID: " + currentThread.getId());
    System.out.println("Priority: " + currentThread.getPriority());
    System.out.println("State: " + currentThread.getState());
    System.out.println("Is Alive: " + currentThread.isAlive());
  }

  // 4. Create threads using Thread class and Runnable interface.
  private static void createThreads() {
    Thread threadUsingThreadClass = new MyThread();
    threadUsingThreadClass.start();

    Thread threadUsingRunnableInterface = new Thread(new MyRunnable());
    threadUsingRunnableInterface.start();
  }

  static class MyThread extends Thread {
    public void run() {
      System.out.println("Thread using Thread class");
    }
  }

  static class MyRunnable implements Runnable {
    public void run() {
      System.out.println("Thread using Runnable interface");
    }
  }

  // 5. Demonstrate thread communication and synchronization.
  private static void threadCommunication() {
    SharedResource resource = new SharedResource();
    Producer producer = new Producer(resource);
    Consumer consumer = new Consumer(resource);

    Thread producerThread = new Thread(producer);
    Thread consumerThread = new Thread(consumer);

    producerThread.start();
    consumerThread.start();
  }

  static class SharedResource {
    private int value;
    private boolean valueSet;

    synchronized int getValue() {
      while (!valueSet) {
        try {
          wait();
        } catch (InterruptedException e) {
          System.out.println("InterruptedException caught");
        }
      }
      System.out.println("Got: " + value);
      valueSet = false;
      notify();
      return value;
    }

    synchronized void setValue(int value) {
      while (valueSet) {
        try {
          wait();
        } catch (InterruptedException e) {
          System.out.println("InterruptedException caught");
        }
      }
      this.value = value;
      valueSet = true;
      System.out.println("Put: " + value);
      notify();
    }
  }

  static class Producer implements Runnable {
    private final SharedResource resource;

    Producer(SharedResource resource) {
      this.resource = resource;
    }

    public void run() {
      int i = 0;
      while (true) {
        resource.setValue(i++);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.out.println("Producer interrupted");
        }
      }
    }
  }

  static class Consumer implements Runnable {
    private final SharedResource resource;

    Consumer(SharedResource resource) {
      this.resource = resource;
    }

    public void run() {
      while (true) {
        resource.getValue();
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.out.println("Consumer interrupted");
        }
      }
    }
  }
}
