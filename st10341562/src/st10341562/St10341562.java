package st10341562;

import javax.swing.*;

public class St10341562 {
    private static String username;
    private static String password;
    private static boolean isLoggedIn = false;
    private static int numTasks;

    public static void main(String[] args) {

        // Registration
        register();

        // Login
        login();

        // Welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Add tasks
        addTasks();
    }

    public static void register() {
        // Account registration
        JOptionPane.showMessageDialog(null, "Welcome to Registration!");

        while (true) {
            // Prompt the user to enter a username
            username = JOptionPane.showInputDialog("Enter username");

            // Validate the username format
            if (username.length() <= 5 && username.contains("_")) {
                JOptionPane.showMessageDialog(null, "Username successfully captured.");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }

        while (true) {
            // Prompt the user to enter a password
            password = JOptionPane.showInputDialog("Enter password");

            // Validate the password format
            if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()].*")) {
                JOptionPane.showMessageDialog(null, "Password successfully captured.");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            }
        }

        // Prompt the user to enter their first and last name
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String lastName = JOptionPane.showInputDialog("Enter last name:");

        JOptionPane.showMessageDialog(null, "Registration successful. Welcome " + firstName + " " + lastName + "!");
    }

    public static void login() {
        // Account login
        JOptionPane.showMessageDialog(null, "Welcome to Login!");

        while (true) {
            // Prompt the user to enter their username and password
            String inputUsername = JOptionPane.showInputDialog("Enter username");
            String inputPassword = JOptionPane.showInputDialog("Enter password");

            // Validate the login credentials
            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                JOptionPane.showMessageDialog(null, "Login successful. Welcome!");
                isLoggedIn = true;
                numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to add?"));
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            }
        }
    }

    public static void addTasks() {
        if (!isLoggedIn) {
            JOptionPane.showMessageDialog(null, "You must login first to add tasks.");
            login();
        }

        Task[] tasks = new Task[numTasks];
        for (int i = 0; i < numTasks; i++) {
            int taskNumber = i;

            // Prompt the user to enter the task details
            String taskName = JOptionPane.showInputDialog("Enter the name of the task to be performed (Task #" + taskNumber + "):");
            String taskDescription = JOptionPane.showInputDialog("Enter a short description of the task (Task #" + taskNumber + "):\n(Not exceeding 50 characters)");

            // Validate the task description length
            while (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                taskDescription = JOptionPane.showInputDialog("Enter a short description of the task (Task #" + taskNumber + "):\n(Not exceeding 50 characters)");
            }

            String developerDetails = JOptionPane.showInputDialog("Enter the first and last name of the developer assigned to the task (Task #" + taskNumber + "):");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the estimated duration of the task in hours (Task #" + taskNumber + "):"));

            // Generate Task ID
            String taskID = createTaskID();

            // Create a new Task object and add it to the tasks array
            tasks[i] = new Task(taskID, taskName, taskNumber, taskDescription, developerDetails, taskDuration);
        }

        JOptionPane.showMessageDialog(null, "Tasks added successfully:\n" + formatTasks(tasks));
        JOptionPane.showMessageDialog(null, "Total hours of all entered tasks: " + returnTotalHours(tasks));

        // Show the main menu to the user
        showMainMenu();
    }

    public static String createTaskID() {
        int randomNumber = (int) ((int) (Math.random() * 9000000000L) + 1000000000L); // Generate a random 10-digit number
        return String.valueOf(randomNumber);
    }

    public static String formatTasks(Task[] tasks) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.length; i++) {
            Task task = tasks[i];
            sb.append("Task ID: ").append(task.getId()).append("\n");
            sb.append("Task Name: ").append(task.getName()).append("\n");
            sb.append("Task Number: ").append(task.getNumber()).append("\n");
            sb.append("Task Description: ").append(task.getDescription()).append("\n");
            sb.append("Developer Details: ").append(task.getDeveloperDetails()).append("\n");
            sb.append("Task Duration: ").append(task.getDuration()).append(" hours").append("\n\n");
        }
        return sb.toString();
    }

    public static int returnTotalHours(Task[] tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getDuration();
        }
        return totalHours;
    }

    static class Task {
        private String id;
        private String name;
        private int number;
        private String description;
        private String developerDetails;
        private int duration;

        public Task(String id, String name, int number, String description, String developerDetails, int duration) {
            this.id = id;
            this.name = name;
            this.number = number;
            this.description = description;
            this.developerDetails = developerDetails;
            this.duration = duration;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getNumber() {
            return number;
        }

        public String getDescription() {
            return description;
        }

        public String getDeveloperDetails() {
            return developerDetails;
        }

        public int getDuration() {
            return duration;
        }
    }

    public static void showMainMenu() {
        // Display the main menu options to the user
        String menuMessage = "Please choose one of the following options:\n"
                + "1) Add tasks\n"
                + "2) Show report\n"
                + "3) Quit";
        int choice = Integer.parseInt(JOptionPane.showInputDialog(menuMessage));

        // Perform the selected action
        switch (choice) {
            case 1:
                addTasks();
                break;
            case 2:
                showReport();
                break;
            case 3:
                quit();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                showMainMenu();
        }
    }

    public static void showReport() {
        // Display a message indicating that the feature is still in development
        JOptionPane.showMessageDialog(null, "Coming Soon");

        // Show the main menu again
        showMainMenu();
    }

    public static void quit() {
        // Display a farewell message
        JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban. Goodbye!");

        // Terminate the program
        System.exit(0);
    }
}
