package com.fh;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Setting up the log directory and creating necessary objects
        String logDirectory = "logs";
        Metadata metadata = new Metadata();
        LogManager logManager = new LogManager(logDirectory);
        EnergyDataExchange energyDataExchange = new EnergyDataExchange(logDirectory, metadata);
        LogSearcher logSearcher = new LogSearcher(logDirectory, metadata);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Energy Management System ---\n1. Create Log File\n2. Delete Log File\n3. Move Log File\n" +
                    "4. Archive Old Logs\n5. Log Energy Data\n6. Retrieve Energy Data\n7. Search Log Files by Date\n" +
                    "8. Search Log Files by Equipment Name\n9. Open Log File\n0. Exit\nChoose an option: ");
//            System.out.println("1. Create Log File");
//            System.out.println("2. Delete Log File");
//            System.out.println("3. Move Log File");
//            System.out.println("4. Archive Old Logs");
//            System.out.println("5. Log Energy Data");
//            System.out.println("6. Retrieve Energy Data");
//            System.out.println("7. Search Log Files by Date");
//            System.out.println("8. Search Log Files by Equipment Name");
//            System.out.println("9. Open Log File");
//            System.out.println("10. Exit");
//            System.out.print("Choose an option: ");


            // Take the user input as a String
            String input = scanner.nextLine();

            try {

                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1: //Create log files
                        System.out.print("Enter log file name: ");
                        String createFileName = scanner.nextLine();
                        logManager.createLogFile(createFileName);
                        break;

                    case 2: //Delete log file
                        System.out.print("Enter log file name to delete: ");
                        String deleteFileName = scanner.nextLine();
                        logManager.deleteLogFile(deleteFileName);
                        break;

                    case 3://Move log file
                        System.out.print("Enter log file name to move: ");
                        String moveFileName = scanner.nextLine();
                        System.out.print("Enter new directory to move the file: ");
                        String newDirectory = scanner.nextLine();
                        logManager.moveLogFile(moveFileName, newDirectory);
                        break;

                    case 4: //Archive old logs files
                        System.out.print("Enter the number of days to archive logs older than: ");
                        int days = scanner.nextInt();
                        logManager.archiveOldLogs(days);
                        break;

                    case 5: //Log energy data for eg solar and wind stations
                        System.out.print("Enter equipment name to log energy data for: ");
                        String equipmentName = scanner.nextLine();
                        System.out.print("Enter energy data: ");
                        String energyData = scanner.nextLine();
                        energyDataExchange.logEnergyData(equipmentName, energyData);
                        break;

                    case 6: //Retrieve and display energy data
                        System.out.print("Enter equipment name to retrieve energy data: ");
                        String retrieveEquipment = scanner.nextLine();
                        List<String> data = energyDataExchange.retrieveEnergyData(retrieveEquipment);
                        System.out.println("Energy data for " + retrieveEquipment + ":");
                        data.forEach(System.out::println);
                        break;

                    case 7: // Search for log files by date (e.g., today's date)
                        System.out.print("Enter date to search logs (format: YYYY-MM-DD): ");
                        String searchDate = scanner.nextLine();

                        // Search for log files by date using LogSearcher
                        List<String> dateResults = logSearcher.searchByDate(searchDate);

                        break;

                    case 8: // Search for log files by equipment name (e.g., "solar")
                        System.out.print("Enter equipment name to search logs: ");
                        String searchEquipment = scanner.nextLine();

                        // Search for log files by equipment name using LogSearcher
                        List<String> equipmentResults = logSearcher.searchByEquipment(searchEquipment);

                        break;

                    case 9: //Open and display a specific log file (e.g., the solar station's log)
                        System.out.print("Enter the log file name to open (including extension, e.g., log_2024-10-09.log): ");
                        String openFileName = scanner.nextLine();
                        logSearcher.openLogFile(openFileName);
                        break;

                    case 0: // exit
                        running = false;
                        System.out.println("Exiting the system. Goodbye!");
                        break;

                    default: // invalid
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                // Handle the case where input is not a number and not "X"
                System.out.println("Invalid input. Please enter a number or '0' to exit.");
            }
        }

        scanner.close();
    }
}
