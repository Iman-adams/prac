import java.util.*;

public class QuickChat {
    static Scanner scanner = new Scanner(System.in);
    static int messageCounter = 1;
    static Random random = new Random();

    static class Message {
        String id;
        String sender;
        String receiver;
        String text;
        String hash;

        Message(String id, String sender, String receiver, String text, String hash) {
            this.id = id;
            this.sender = sender;
            this.receiver = receiver;
            this.text = text;
            this.hash = hash;
        }

        public String toJSON() {
            return String.format("{\"id\": \"%s\", \"sender\": \"%s\", \"receiver\": \"%s\", \"text\": \"%s\", \"hash\": \"%s\"}",
                    id, sender, receiver, text, hash);
        }
    }

    static ArrayList<Message> sentMessages = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Please log in to continue:");
        System.out.print("Username: ");
        scanner.nextLine(); // Not validating login for simplicity

        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to QuickChat.");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    sendMessages();
                    break;
                case 2:
                    System.out.println("Coming Soon.");
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void sendMessages() {
        System.out.print("How many messages do you want to send? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            String id = String.format("%010d", random.nextInt(1_000_000_000));
            System.out.print("Enter your name: ");
            String sender = scanner.nextLine();

            String receiver;
            while (true) {
                System.out.print("Enter recipient (max 10 digits, no +): ");
                receiver = scanner.nextLine();
                if (receiver.matches("\\d{1,10}")) break;
                System.out.println("Invalid recipient number.");
            }

            String text;
            while (true) {
                System.out.print("Enter message: ");
                text = scanner.nextLine();
                if (text.length() > 250) {
                    System.out.println("Please enter a message of less than 50 characters.");
                } else {
                    System.out.println("Message sent");
                    break;
                }
            }

            String[] words = text.trim().split("\\s+");
            String first = words.length > 0 ? words[0] : "EMPTY";
            String last = words.length > 1 ? words[words.length - 1] : first;
            String hash = String.format("%s:%02d:%s%s", id.substring(0, 2), messageCounter, first.toUpperCase(), last.toUpperCase());

            Message msg = new Message(id, sender, receiver, text, hash);

            System.out.println("\nChoose an option:");
            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message to send later");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    sentMessages.add(msg);
                    System.out.println("Message sent and saved.");
                    break;
                case 2:
                    System.out.println("Message disregarded.");
                    break;
                case 3:
                    System.out.println("Message saved for later.");
                    // For simplicity, just printing the message
                    System.out.println(msg.toJSON());
                    break;
                default:
                    System.out.println("Invalid choice. Message skipped.");
            }

            messageCounter++;
        }
    }
}
