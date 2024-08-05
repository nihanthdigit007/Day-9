import java.util.HashSet;
import java.util.Set;

class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class UserService {
    private final Set<String> registeredUsers = new HashSet<>();

    public void registerUser(String username) throws UserAlreadyExistsException {
        if (registeredUsers.contains(username)) {
            throw new UserAlreadyExistsException("User '" + username + "' already exists.");
        }
        registeredUsers.add(username);
        System.out.println("User '" + username + "' registered successfully.");
    }

    public void checkUserExistence(String username) throws UserNotFoundException {
        if (!registeredUsers.contains(username)) {
            throw new UserNotFoundException("User '" + username + "' not found.");
        }
        System.out.println("User '" + username + "' exists.");
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        try {
            userService.registerUser("alice");
            userService.registerUser("bob");
            userService.checkUserExistence("alice");
            userService.checkUserExistence("charlie"); // This user doesn't exist
        } catch (UserAlreadyExistsException | UserNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
