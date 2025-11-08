//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    int id;
    String title;
    String status;


    Task(int task_id, String task_title, String task_status) {
        id = task_id;
        title = task_title;
        status = task_status;
    }
}

public class Main {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int nextId = 1;

    public static void main(String[] args) {
        Task task1 = new Task(1, "Homework", "Pending");
        Task task2 = new Task(2, "Churchwork", "Completed");
        tasks.add(task1);
        tasks.add(task2);

        boolean running = true;

        while (running) {
            System.out.println("\n=== Task Manager ===");
            System.out.println("1. Create task");
            System.out.println("2. List all tasks");
            System.out.println("3. Update task status");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear buffer

            switch (choice) {
                case 1:
                    createTask();
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    updateTaskStatus();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
    static void createTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        Task newTask = new Task(nextId, title, "pending");
        tasks.add(newTask);

        System.out.println("✓ Task created with ID: " + nextId);
        nextId++;
    }
    static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        System.out.println("\n--- All Tasks ---");
        for (Task task : tasks) {
            System.out.println("ID: " + task.id + " | Title: " + task.title + " | Status: " + task.status);
        }
    }
    static void updateTaskStatus() {
        System.out.print("Enter task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Task taskToUpdate = null;
        for (Task task : tasks) {
            if (task.id == id) {
                taskToUpdate = task;
                break;
            }
        }

        if (taskToUpdate == null) {
            System.out.println("Task not found.");
            return;
        }

        System.out.println("Choose new status:");
        System.out.println("1. pending");
        System.out.println("2. in progress");
        System.out.println("3. completed");
        System.out.print("Enter choice: ");

        int statusChoice = scanner.nextInt();
        scanner.nextLine();

        switch (statusChoice) {
            case 1:
                taskToUpdate.status = "pending";
                break;
            case 2:
                taskToUpdate.status = "in progress";
                break;
            case 3:
                taskToUpdate.status = "completed";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("✓ Task status updated!");
    }
    static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).id == id) {
                tasks.remove(i);
                found = true;
                System.out.println("✓ Task deleted!");
                break;
            }
        }

        if (!found) {
            System.out.println("Task not found.");
        }
    }
}
