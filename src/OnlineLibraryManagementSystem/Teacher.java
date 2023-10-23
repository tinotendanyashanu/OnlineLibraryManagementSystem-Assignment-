package OnlineLibraryManagementSystem;

public class Teacher extends User {
    private String subject;

    // Constructor for creating a Teacher object with name, id, and subject
    public Teacher(String name, String id, String subject) {
        super(name, id);
        this.subject = subject;
    }

    // Constructor for creating a Teacher object with only name and id
    public Teacher(String name, String id) {
        super(name, id);
        this.subject = "Unknown"; // Default subject
    }

    // Additional methods specific to teachers
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void gradePapers() {
        System.out.println("Teacher " + getName() + " is grading papers.");
    }

    @Override
    public String toString() {
        return "Teacher: " + getName() + "\nID: " + getId() + "\nSubject: " + subject;
    }
}
