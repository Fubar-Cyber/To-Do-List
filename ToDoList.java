/*
 * File: ToDoList.java
 * Version: 1.0.0
 * Date: 05/21/2023
 * Author: Jensy Fernandez
 * Class: CEN-4025C
 * Professor: Mary Walauskis Valencia College
 * Description: A simple to-do-item application in Java that allows users to add, delete, and view to-do items.
 */

package cen.module2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a to-do list with basic operations such as adding, deleting, and displaying to-do items.
 */
public class ToDoList {
    private ArrayList<String> items;

    /**
     * Constructor: Initializes the ToDoList object with an empty ArrayList.
     */
    public ToDoList() {
        items = new ArrayList<>();
    }

    /**
     * Adds a to-do item to the list.
     *
     * @param item The to-do item to be added.
     */
    public void addItem(String item) {
        items.add(item);
    }

    /**
     * Deletes a to-do item from the list based on its index number.
     * You may only delete by inputting index number from view list
     *
     * @param index The index of the item to be deleted.
     */
    public void deleteItem(int index) {
        items.remove(index);
    }

    /**
     * Displays the to-do items in the list.
     * If the list is empty, it prints a message indicating that the list is empty.
     * If the list is not empty, it displays each item with its corresponding index number.
     */
    public void displayList() {
        if (items.isEmpty()) {
            System.out.println("Your To-Do list is empty! Go relax and have fun!!! ");
        } else {
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }
    }

    /**
     * The entry point of the program.
     * It creates an instance of ToDoList, prompts the user for commands, and performs the corresponding actions.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What would you like to do? (add, delete, view, quit):"); 
            String command = scanner.nextLine().toLowerCase(); // Convert input to lowercase

            if (command.equalsIgnoreCase("add")) {
                System.out.println("Enter an item to add:");
                String item = scanner.nextLine();
                todoList.addItem(item);
            } else if (command.equalsIgnoreCase("delete")) {
                System.out.println("Enter the index number of the item to delete:");
                int index = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                todoList.deleteItem(index - 1);
            } else if (command.equalsIgnoreCase("view")) {
                System.out.println("The items on your To Do List are:\n");
                todoList.displayList();
            } else if (command.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye! Have a great day!");
                break;
            } else {
                System.out.println("Invalid command!");
            }
        }

        scanner.close();
    }
}