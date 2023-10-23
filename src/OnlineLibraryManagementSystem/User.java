package OnlineLibraryManagementSystem;

public class User {
    private String name;
    private String id;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public static User createUser(String userType, String name, String id) throws UserException {
        if (userType.equalsIgnoreCase("student")) {
            return new Student(name, id);
        } else if (userType.equalsIgnoreCase("teacher")) {
            return new Teacher(name, id);
        } else {
            throw new UserException("Invalid user type.");
        }
    }
}


