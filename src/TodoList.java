import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    // List to store task descriptions
    private final ArrayList<String> tasks = new ArrayList<>();

    // Method to add a new task to the list
    public void addTask(String taskDescription) {
        tasks.add(taskDescription);
    }

    // Method to remove a task by index
    public void removeTask(int index) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove, please create at least one task.");
        } else if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task successfully removed!");
        } else {
            System.out.println("Invalid number! Please try again.");
        }
    }

    // Method to edit a task description
    public void editTask(int index, String newDescription) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to edit, please create at least one task.");
            return;
        } else if ((index < 1 || index > tasks.size())) {
            System.out.println("Invalid number! Please try again.");
            return;
        }
        tasks.set(index - 1, newDescription);
        System.out.println("Task successfully edited!");
    }

    // Method to delete all tasks
    public void deleteAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete, the task list is empty.");
        } else {
            tasks.clear();
            System.out.println("All tasks were successfully deleted!");
        }
    }

    // Method to display all tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display, please create at least one task.");
        } else {
            System.out.println("TODO List:");
            System.out.println();
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
                printBorder(tasks.get(i).length());
            }
        }
    }

    // Method to print a border
    private void printBorder(int length) {
        StringBuilder border = new StringBuilder();
        for (int i = -3; i < length; i++) {
            border.append("-");
        }
        System.out.println(border);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Display tasks");
            System.out.println("4. Edit task");
            System.out.println("5. Delete all tasks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue;
            }
            if (!input.matches("\\d+")) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue;
            }
            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskDescription = scanner.nextLine();
                    if (!taskDescription.isEmpty()) {
                        todoList.addTask(taskDescription);
                        System.out.println("Task added successfully!");
                        System.out.println();
                    } else {
                        System.out.println("Task description cannot be empty! Please try again.");
                    }
                    break;
                case 2:
                    if (todoList.tasks.isEmpty()) {
                        System.out.println("No tasks to remove, please create at least one task.");
                    } else {
                        System.out.print("Enter number of task to remove: ");
                        String indexToRemoveInput = scanner.nextLine();
                        if (indexToRemoveInput.matches("\\d+")) {
                            int indexToRemove = Integer.parseInt(indexToRemoveInput);
                            if (indexToRemove < 1 || indexToRemove > todoList.tasks.size()) {
                                System.out.println("No such task exists.");
                                System.out.println();
                            } else {
                                todoList.removeTask(indexToRemove - 1);
                            }
                        } else {
                            System.out.println("Invalid input! Please enter a valid number.");
                        }
                    }
                    break;
                case 3:
                    todoList.displayTasks();
                    break;
                case 4:
                    if (todoList.tasks.isEmpty()) {
                        System.out.println("No tasks to edit, please create at least one task.");
                    } else {
                        System.out.print("Enter number of task to edit: ");
                        String editIndexInput = scanner.nextLine();
                        if (editIndexInput.trim().isEmpty()) {
                            System.out.println("Input cannot be EMPTY, please enter a valid number input.");
                            System.out.println();
                            break;
                        }
                        try {
                            int indexToEdit = Integer.parseInt(editIndexInput);
                            if (indexToEdit < 1 || indexToEdit > todoList.tasks.size()) {
                                System.out.println("No such task exists.");
                                System.out.println();
                            } else {
                                System.out.print("Enter the new description: ");
                                String newDescription = scanner.nextLine();
                                todoList.editTask(indexToEdit, newDescription);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                            System.out.println();
                        }
                    }
                    break;
                case 5:
                    todoList.deleteAllTasks();
                    break;
                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}