import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File binaryFile = new File("TaskList.dat");
        Task[] taskList = new Task[10];
        Scanner keyboard = new Scanner(System.in);
        String name, dueDate, deadline;
        int priority;
        int count = 0;

        if (binaryFile.exists() && binaryFile.length() > 0) {
            try {
                // Creating ObjectInputStream to read binaryFile
                ObjectInputStream Reader = new ObjectInputStream(new FileInputStream(binaryFile));
                // Taking Tasks from binaryFile and putting it into an array
                taskList = (Task[]) Reader.readObject();
                // Add count using for each loop
                for (Task t : taskList) {
                    if (t != null){
                        count++;
                        System.out.println(t);
                    } else {
                        break;
                    }
                }
                // Close reader
                Reader.close();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }

        if (taskList[0] == null) {
            System.out.println("[None, please enter new Tasks]");
        }

        do {
            System.out.print("\nPlease enter task name (or \"quit\" to exit): ");
            name = keyboard.nextLine();
            // if user inputs quit, break immediately
            if (name.equals("quit")) {break;}
            System.out.print("Please enter due date (in form MM/DD/YYYY): ");
            dueDate = keyboard.nextLine();
            System.out.print("Please enter deadline: ");
            deadline = keyboard.nextLine();
            System.out.print("Please enter priority: ");
            priority = keyboard.nextInt();
            keyboard.nextLine();

            if (count > 10) {
                System.err.println("You already have 10 tasks.");
                break;
            } else {
                taskList[count++] = new Task(name, dueDate, deadline, priority);
                System.out.println("[Task added]");
            }
        } while (taskList[9] == null);

        try {
            ObjectOutputStream Writer = new ObjectOutputStream(new FileOutputStream(binaryFile));
            Writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}