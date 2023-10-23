package OnlineLibraryManagementSystem;

import java.util.Scanner;

public class LibraryManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        try {
            while (true) {
                System.out.println("\nLibrary Management System Menu:");
                System.out.println("1. Add Student");
                System.out.println("2. Add Teacher");
                System.out.println("3. Add Book");
                System.out.println("4. Borrow Book");
                System.out.println("5. Return Book");
                System.out.println("6. Display Available Books");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        // Adding student
                        System.out.print("Enter student name: ");
                        String studentName = scanner.nextLine();
                        System.out.print("Enter student ID: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Enter student grade level: ");
                        int studentGradeLevel = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        Student student = new Student(studentName, studentId, studentGradeLevel);
                        library.addStudent(student);
                        break;
                    case 2:
                        // Adding teacher
                        System.out.print("Enter teacher name: ");
                        String teacherName = scanner.nextLine();
                        System.out.print("Enter teacher ID: ");
                        String teacherId = scanner.nextLine();
                        System.out.print("Enter teacher subject: ");
                        String teacherSubject = scanner.nextLine();
                        Teacher teacher = new Teacher(teacherName, teacherId, teacherSubject);
                        library.addTeacher(teacher); // Use addTeacher method for adding a teacher
                        break;
                    case 3:
                        // Adding book
                        System.out.print("Enter book title: ");
                        String bookTitle = scanner.nextLine();
                        System.out.print("Enter book author: ");
                        String bookAuthor = scanner.nextLine();
                        System.out.print("Enter book ISBN: ");
                        String bookISBN = scanner.nextLine();
                        Book book = new Book(bookTitle, bookAuthor, bookISBN, true);
                        library.addBook(book);
                        break;
                    case 4:
                        // Borrowing book
                        System.out.print("Enter user ID: ");
                        String borrowUserId = scanner.nextLine();
                        System.out.print("Enter book ISBN to borrow: ");
                        String borrowISBN = scanner.nextLine();
                        library.borrowBook(borrowUserId, borrowISBN);
                        break;
                    case 5:
                        // Returning book
                        System.out.print("Enter user ID: ");
                        String returnUserId = scanner.nextLine();
                        System.out.print("Enter book ISBN to return: ");
                        String returnISBN = scanner.nextLine();
                        library.returnBook(returnUserId, returnISBN);
                        break;
                    case 6:
                        // Display available books
                        library.displayAvailableBooks();
                        break;
                    case 7:
                        // Exit the program
                        System.out.println("Exiting Library Management System. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}








