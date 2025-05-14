import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // == Register ==
                System.out.println("== Register a New User ==");

                System.out.println("Enter first name: ");
                String firstName = scanner.nextLine();

                System.out.println("Enter last name: ");
                String lastName = scanner.nextLine();

                System.out.println("Enter username (must include '_' and be no more than 5 characters long): ");
                String username = scanner.nextLine();

                System.out.println("Enter password (must have 1 uppercase, 1 digit, 1 special char, and be >= 8 char): ");
                String password = scanner.nextLine();

                System.out.println("Enter cell number (+27XXXXXXXXX): ");
                String cellNumber = scanner.nextLine();

                Login login = new Login(firstName, lastName, username, password,cellNumber);
                String registrationResult = login.registerUser();
                System.out.println(registrationResult);

                if (!registrationResult.equals("User has been registered successfully.")) {
                    System.out.println("Username or password-incorrect. Exiting...");
                    return;
                }

                System.out.println("Welcome to Quickchat!");
            }
        }
    }
}