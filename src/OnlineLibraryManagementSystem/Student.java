package OnlineLibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private int gradeLevel;
    private List<Book> borrowedBooks;

    // Constructor for creating a Student object with name, id, and grade level
    public Student(String name, String id, int gradeLevel) {
        super(name, id);
        this.gradeLevel = gradeLevel;
        this.borrowedBooks = new ArrayList<>();
    }

    // Constructor for creating a Student object with only name and id
    public Student(String name, String id) {
        super(name, id);
        this.gradeLevel = 0; // Default grade level
        this.borrowedBooks = new ArrayList<>();
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(getName() + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Sorry, the book " + book.getTitle() + " is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println(getName() + " returned the book: " + book.getTitle());
        } else {
            System.out.println(getName() + " did not borrow this book.");
        }
    }

    public boolean hasBorrowedBook(Book book) {
        return borrowedBooks.contains(book);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", gradeLevel=" + gradeLevel +
                '}';
    }
}

