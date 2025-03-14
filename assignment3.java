import java.util.Scanner;

class Node {
    int ticketId;
    String customerName;
    String issue;
    Node next;

    public Node(int ticketId, String customerName, String issue) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.issue = issue;
        this.next = null;
    }
}

class TicketQueue {
    private Node front, rear;

    public TicketQueue() {
        this.front = this.rear = null;
    }

    public void enqueue(int ticketId, String customerName, String issue) {
        Node newNode = new Node(ticketId, customerName, issue);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Ticket added successfully.");
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty. No tickets to serve.");
            return;
        }
        System.out.println("Serving Ticket: Ticket ID: " + front.ticketId +
                ", Customer Name: " + front.customerName +
                ", Issue: " + front.issue);
        front = front.next;
        if (front == null) rear = null;
    }

    public void peek() {
        if (front == null) {
            System.out.println("Queue is empty, no tickets to peek.");
        } else {
            System.out.println("Next Ticket to be Served: Ticket ID: " + front.ticketId +
                    ", Customer Name: " + front.customerName +
                    ", Issue: " + front.issue);
        }
    }

    public void display() {
        if (front == null) {
            System.out.println("Queue is empty. No tickets to display.");
            return;
        }
        System.out.println("All Pending Tickets: ");
        Node temp = front;
        while (temp != null) {
            System.out.println("Ticket ID: " + temp.ticketId +
                    ", Customer Name: " + temp.customerName +
                    ", Issue: " + temp.issue);
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Assignment3DataStructures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketQueue queue = new TicketQueue();

        while (true) {
            System.out.println("\n--- Customer Support Ticket System ---");
            System.out.println("1. Add a Ticket");
            System.out.println("2. Serve a Ticket");
            System.out.println("3. Peek Next Ticket");
            System.out.println("4. Display All Tickets");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int ticketId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Enter Issue Description: ");
                    String issue = scanner.nextLine();

                    queue.enqueue(ticketId, customerName, issue);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.peek();
                    break;

                case 4:
                    queue.display();
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

