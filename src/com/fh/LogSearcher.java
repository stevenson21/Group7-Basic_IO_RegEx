package com.fh;
import java.io.*;
import java.nio.file.*;
import java.util.regex.*;
import java.util.*;

public class LogSearcher {
    private String logDirectory;
    private Metadata metadata;

    public LogSearcher(String logDirectory, Metadata metadata) {
        this.logDirectory = logDirectory;
        this.metadata = metadata;
    }

    // Method to search log files by date using a regular expression
    public List<String> searchByDate(String date) {
        List<String> matchedFiles = new ArrayList<>();
        String regex = ".*" + date + ".*\\.log$";
        Pattern pattern = Pattern.compile(regex);

        // Get the user's home directory and the log path
        String homeDirectory = System.getProperty("user.home");
        Path logDirPath = Paths.get(homeDirectory, "Documents", logDirectory);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(logDirPath, "*.log")) {
            for (Path entry : stream) {
                Matcher matcher = pattern.matcher(entry.getFileName().toString());
                if (matcher.matches()) {
                    matchedFiles.add(entry.toString());
                }
            }
            metadata.logSearch(date, "searched by date");

            // If no files matched, print "not found"
            if (matchedFiles.isEmpty()) {
                System.out.println("No log files found for the date: " + date);
            } else {
                // Print the found files
                System.out.println("Files found:");
                matchedFiles.forEach(System.out::println);
            }

        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }

        return matchedFiles;
    }

    // Method to search log files by equipment name using a regular expression
    public List<String> searchByEquipment(String equipmentName) {
        List<String> matchedFiles = new ArrayList<>();
        String regex = ".*" + equipmentName + ".*\\.log$";
        Pattern pattern = Pattern.compile(regex);

        // Get the user's home directory and the log path
        String homeDirectory = System.getProperty("user.home");
        Path logDirPath = Paths.get(homeDirectory, "Documents", logDirectory);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(logDirPath, "*.log")) {
            for (Path entry : stream) {
                Matcher matcher = pattern.matcher(entry.getFileName().toString());
                if (matcher.matches()) {
                    matchedFiles.add(entry.toString());
                }
            }
            metadata.logSearch(equipmentName, "searched by equipment");

            // If no files matched, print "not found"
            if (matchedFiles.isEmpty()) {
                System.out.println("No log files found for equipment: " + equipmentName);
            } else {
                // Print the found files
                System.out.println("Files found:");
                matchedFiles.forEach(System.out::println);
            }

        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }

        return matchedFiles;
    }

    // Method to open and display the contents of a log file
    public void openLogFile(String fileName) {
        // Get the user's home directory and the log file path
        String homeDirectory = System.getProperty("user.home");
        Path logFilePath = Paths.get(homeDirectory, "Documents", logDirectory, fileName);

        // Check if the file exists
        if (Files.exists(logFilePath)) {
            try {
                // Read and print the contents of the log file
                List<String> lines = Files.readAllLines(logFilePath);
                System.out.println("\nContents of " + fileName + ":");
                for (String line : lines) {
                    System.out.println(line);
                }
                // Log the file opening operation
                metadata.logOperation(fileName, "Log file opened");
            } catch (IOException e) {
                // Error handling for issues during file read
                System.err.println("Error opening log file: " + e.getMessage());
            }
        } else {
            // If the file does not exist, print a clear message
            System.err.println("Log file does not exist: " + fileName);
        }
    }

}
