package expl;

import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        
        // Account Login
        System.out.println("Welcome to Login!");
        
  // Create a new object to read input from the console
        Scanner scanner = new Scanner(System.in);
        
       // Ask the user for their desired username
        String username;
        while (true) {
            System.out.println("Enter username");
            username = scanner.nextLine();
              // Check if the username meets our requirements
            if (username.length() <= 5 && username.contains("_")) {
                System.out.println("Username successfully captured.");
                break;  // Exit the loop if the username is valid
            } else {
                // If the username is not valid, ask the user to try again
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }

        // Ask the user to create a password
        String password;
        while (true) {
            System.out.println("Enter password");
            password = scanner.nextLine();
             // Check if the password meets our requirements
            if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()].*")) {
                System.out.println("Password successfully captured.");
                break; // Exit the loop if the password is valid
            } else {
                // If the password is not valid, ask the user to try again
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            }
        }
 // Ask the user for their first and last name
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();

       

        // Confirm the user's Login
        System.out.println("Login successful. Welcome " + firstName + " " + lastName + "!");
    }
}
