package UI;

import Controller.Controller;
import Model.Log;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * UI provides a menu-driven interface for interacting with Controller.
 */
public class UI {
    private final Controller controller;
    private final Scanner scanner;

    public UI(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Main menu for console application
     *
     * @throws IOException when results cannot be inserted in file
     */
    public void menu() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("1. Lesen");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    printAllLogs();
                    break;
//                case "2":
//                    printLogs(controller.getLogsSortedByX());
//                    break;
//                case "3":
//                    printLogsByX();
//                    System.out.println("Done");
//                    break;
                case "4":
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Handles option to display logs whose names start with a specific letter
     */
//    private void handleLogsByLetter() {
//        System.out.print("Enter a capital letter: ");
//        String letter = scanner.nextLine();
//        controller.getLogsByLetter(letter).forEach(System.out::println);
//    }

    /**
     * Prints a list of logs
     *
     * @param logs list of logs
     */
//    private void printLogs(List<Log> logs) {
//        if (logs.isEmpty()) {
//            System.out.println("No logs found.");
//        } else {
//            for(Log log : logs) {
//                System.out.println(log.getDatum() + ": " + log.getMitgliedsname() + " - " + log.getEreignis());
//            }
//        }
//    }

    /**
     * Prints Logs to file
     *
     * @throws IOException when logs cannot be printed to file
     */
//    private void printLogsByX() throws IOException {
//        writeToFile(controller.getLogsByX(), "ergebnis.txt");
//    }
    private void printAllLogs() throws IOException {
        for (Log log : controller.getAllLogs()) {
            System.out.println(log);
            {
            }
        }
    }
}