package OnlineLibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Book> availableBooks;

    public Library() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.availableBooks = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public void borrowBook(String studentId, String bookISBN) throws LibraryException {
        Student student = findStudentById(studentId);
        Book book = findBookByISBN(bookISBN);

        if (student != null && book != null && book.isAvailable()) {
            student.borrowBook(book);
            book.setAvailable(false);
            System.out.println("Book borrowed successfully.");
        } else {
            throw new LibraryException("Book not available or student not found.");
        }
    }

    public void returnBook(String studentId, String bookISBN) throws LibraryException {
        Student student = findStudentById(studentId);
        Book book = findBookByISBN(bookISBN);

        if (student != null && book != null && !book.isAvailable()) {
            if (student.hasBorrowedBook(book)) {
                student.returnBook(book);
                book.setAvailable(true);
                System.out.println("Book returned successfully.");
            } else {
                throw new LibraryException("Student hasn't borrowed this book.");
            }
        } else {
            throw new LibraryException("Invalid book return request.");
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }

    private Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    private Book findBookByISBN(String bookISBN) {
        for (Book book : availableBooks) {
            if (book.getISBN().equals(bookISBN)) {
                return book;
            }
        }
        return null;
    }
}






