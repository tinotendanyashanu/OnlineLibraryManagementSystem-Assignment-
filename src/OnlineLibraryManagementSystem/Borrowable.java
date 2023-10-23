package OnlineLibraryManagementSystem;

interface Borrowable {
    void borrowBook(Book book) throws LibraryException;
    void returnBook(Book book) throws LibraryException;
}