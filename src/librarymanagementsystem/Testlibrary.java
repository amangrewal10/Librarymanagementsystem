//Names: Christabel Giner, Amanpreet Grewal
//Project 2
package librarymanagementsystem;

import java.util.*;
import java.io.*;

public class Testlibrary {

    static Scanner input = new Scanner(System.in);

    static ArrayList<libraryitem> library = new ArrayList<>();

    static ArrayList<String> usernames = new ArrayList<>();

    static ArrayList<String> passwords = new ArrayList<>();

    public static void main(String[] args) {

        initializeLibrary();

        readAdminFile();

        if (login()) {

            menu();

        } else {

            System.out.println("Access Denied.");

        }

    }

    public static void initializeLibrary() {

        book firstBook = new book(1001, "Java Programming", "John Smith", 2023, "", 5, 5);
        firstBook.setGenre(Genre.NON_FICTION);
        firstBook.setISBN("9781234567890");
        firstBook.setNumberCopies(5);
        library.add(firstBook);

        magazine firstMag = new magazine(2001, "Tech Monthly", "Alice Brown", 2025);
        firstMag.setIssueNumber(15);
        firstMag.setMonthlyEdition(true);
        library.add(firstMag);

    }

    public static void readAdminFile() {

        try {

            Scanner file = new Scanner(new File("admins.txt"));

            while (file.hasNextLine()) {

                String line = file.nextLine();

                String[] data = line.split(",");

                usernames.add(data[0]);

                passwords.add(data[1]);

            }

            file.close();

        }

        catch (IOException e) {

            System.out.println("Cannot read admin file.");

        }

    }

    public static boolean login() {

        System.out.print("Username: ");
        String user = input.nextLine();

        System.out.print("Password: ");
        String pass = input.nextLine();

        for (int i = 0; i < usernames.size(); i++) {

            if (user.equals(usernames.get(i)) && pass.equals(passwords.get(i))) {

                return true;

            }

        }

        return false;

    }

    public static void menu() {

        int choice;

        do {

            System.out.println("\n===== Library Menu =====");

            System.out.println("1. Insert Library Item");
            System.out.println("2. Borrow Book");
            System.out.println("3. Reserve Magazine");
            System.out.println("4. View Borrowing History");
            System.out.println("5. Check Book Availability");
            System.out.println("6. View Reservation Schedule");
            System.out.println("7. Check Magazine Availability for a Time Slot");
            System.out.println("8. Search Library Items");
            System.out.println("9. Display Library Items");
            System.out.println("10. Save Data");
            System.out.println("11. Exit");

            System.out.print("Choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

            case 1:

                insertLibraryItem();

                break;

            case 2:

                borrowBook();

                break;

            case 3:

                reserveMagazine();

                break;

            case 4:

                viewBorrowHistory();

                break;

            case 5:

                checkAvailability();

                break;

            case 6:

                reservationSchedule();

                break;

            case 7:

                checkMagazineAvailability();

                break;

            case 8:

                searchLibrary();

                break;

            case 9:

                displayLibrary();

                break;

            case 10:

                saveToFile();

                break;

            case 11:

                System.out.println("Goodbye.");

                break;

            default:

                System.out.println("Invalid choice.");

            }

        } while (choice != 11);

    }

    public static void insertLibraryItem() {
        System.out.println("1. Add Book  2. Add Magazine");
        int type = input.nextInt();
        input.nextLine();

        if (type == 1) {
            System.out.print("ID: ");
            long id = input.nextLong();
            input.nextLine();
            System.out.print("Title: ");
            String title = input.nextLine();
            System.out.print("Author: ");
            String author = input.nextLine();
            System.out.print("Year Published: ");
            int year = input.nextInt();
            input.nextLine();
            System.out.print("User ID: ");
            String userID = input.nextLine();
            System.out.print("Overdue Days: ");
            int overdueDays = input.nextInt();
            System.out.print("Loan Period: ");
            int loanPeriod = input.nextInt();
            input.nextLine();

            try {
                book newBook = new book(id, title, author, year, userID, overdueDays, loanPeriod);

                System.out.print("Genre (FICTION, NON_FICTION, MYSTERY, SCI_FI, BIOGRAPHY): ");
                String genreInput = input.nextLine();
                try {
                    newBook.setGenre(Genre.valueOf(genreInput.trim().toUpperCase()));
                } catch (IllegalArgumentException e) {
                    System.out.println("Unrecognized genre, leaving unset.");
                }

                System.out.print("ISBN (13 digits, starting with 978 or 979): ");
                newBook.setISBN(input.nextLine());

                System.out.print("Number of Copies: ");
                newBook.setNumberCopies(input.nextInt());
                input.nextLine();

                library.add(newBook);
                System.out.println("Book added.");
            } catch (IllegalArgumentException e) {
                System.out.println("Could not add book: " + e.getMessage());
            }

        } else if (type == 2) {
            System.out.print("ID: ");
            long id = input.nextLong();
            input.nextLine();
            System.out.print("Title: ");
            String title = input.nextLine();
            System.out.print("Author: ");
            String author = input.nextLine();
            System.out.print("Year Published: ");
            int year = input.nextInt();
            input.nextLine();

            magazine newMag = new magazine(id, title, author, year);

            System.out.print("Issue Number: ");
            newMag.setIssueNumber(input.nextInt());
            input.nextLine();

            System.out.print("Monthly Edition (true/false): ");
            newMag.setMonthlyEdition(input.nextBoolean());
            input.nextLine();

            library.add(newMag);
            System.out.println("Magazine added.");

        } else {
            System.out.println("Invalid type.");
        }
    }

    public static void borrowBook() {
        System.out.print("Enter Item ID of book to borrow: ");
        long id = input.nextLong();
        input.nextLine();

        for (libraryitem item : library) {
            if (item instanceof book && item.getId() == id) {
                book b = (book) item;
                if (b.getAvailableCopies() <= 0) {
                    System.out.println("No copies currently available.");
                    return;
                }
                System.out.print("Enter your User ID: ");
                String userID = input.nextLine();
                System.out.println(b.processBorrowing(userID));
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void reserveMagazine() {
        System.out.print("Enter Item ID of magazine to reserve: ");
        long id = input.nextLong();
        input.nextLine();

        for (libraryitem item : library) {
            if (item instanceof magazine && item.getId() == id) {
                magazine m = (magazine) item;
                System.out.print("Enter Time Slot (11-15): ");
                int timeSlot = input.nextInt();
                input.nextLine();
                System.out.print("Enter your User ID: ");
                String userID = input.nextLine();

                boolean success = m.reserveItem(String.valueOf(id), timeSlot, userID);
                System.out.println(
                        success ? "Reservation successful." : "Reservation failed (slot unavailable or invalid).");
                return;
            }
        }
        System.out.println("Magazine not found.");
    }

    public static void viewBorrowHistory() {
     /* 
     System.out.print("Enter Item ID of book to view history: ");
        long id = input.nextLong();
        input.nextLine();

        for (libraryitem item : library) {
            if (item instanceof book && item.getId() == id) {
                book b = (book) item;
                System.out.println("\n--- Borrowing History for \"" + b.getTitle() + "\" ---");
                if (b.getBorrowedUserIDs().isEmpty()) {
                    System.out.println("No borrowing history yet.");
                    return;
                }
                for (int i = 0; i < b.getBorrowedUserIDs().size(); i++) {
                    System.out.println(
                            "User: " + b.getBorrowedUserIDs().get(i) + " | Date: " + b.getBorrowingDates().get(i));
                }
                return;
            }
           
        
        }
        System.out.println("Book not found.");
 */
    }

    public static void checkAvailability() {
        System.out.print("Enter Item ID of book to check availability: ");
        long id = input.nextLong();
        input.nextLine();

        for (libraryitem item : library) {
            if (item instanceof book && item.getId() == id) {
                book b = (book) item;
                System.out.println(
                        "Available Copies: " + b.getAvailableCopies() + " / " + b.getNumberCopies() + " total");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void reservationSchedule() {
        System.out.print("Enter Item ID of magazine to view schedule: ");
        long id = input.nextLong();
        input.nextLine();

        for (libraryitem item : library) {
            if (item instanceof magazine && item.getId() == id) {
                magazine m = (magazine) item;
                m.checkReservationStatus(String.valueOf(id));
                return;
            }
        }
        System.out.println("Magazine not found.");
    }

    public static void checkMagazineAvailability() {
        System.out.print("Enter Item ID of magazine: ");
        long id = input.nextLong();
        input.nextLine();
        System.out.print("Enter Time Slot to check (11-15): ");
        int timeSlot = input.nextInt();
        input.nextLine();

        for (libraryitem item : library) {
            if (item instanceof magazine && item.getId() == id) {
                magazine m = (magazine) item;
                try {
                    m.validateTimeSlot(timeSlot);
                    if (m.getReservedSlots().contains(timeSlot)) {
                        System.out.println("Time slot " + timeSlot + " is already booked.");
                    } else {
                        System.out.println("Time slot " + timeSlot + " is available.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Magazine not found.");
    }

    public static void searchLibrary() {
        System.out.print("Enter keyword to search (title/author/ID): ");
        String keyword = input.nextLine().toLowerCase();

        boolean found = false;
        for (libraryitem item : library) {
            if (item.getTitle().toLowerCase().contains(keyword) || item.getAuthor().toLowerCase().contains(keyword)
                    || String.valueOf(item.getId()).equals(keyword)) {
                System.out.println(item.getItemType() + ": " + item.getTitle() + " by " + item.getAuthor() + " (ID: "
                        + item.getId() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matches found.");
        }
    }

    public static void displayLibrary() {
        System.out.println("1. Books  2. Magazines  3. All");
        int choice = input.nextInt();
        input.nextLine();

        System.out.println("\n--- Library Items ---");
        for (libraryitem item : library) {
            if (choice == 1 && item instanceof book) {
                System.out.println(item);
            } else if (choice == 2 && item instanceof magazine) {
                System.out.println(item);
            } else if (choice == 3) {
                System.out.println(item);
            }
        }
    }

    public static void saveToFile() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("library_data.txt"));
            for (libraryitem item : library) {
                writer.println(item.getItemType() + "," + item.toString());
            }
            writer.close();
            System.out.println("Library saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving library.");
        }
    }
}
