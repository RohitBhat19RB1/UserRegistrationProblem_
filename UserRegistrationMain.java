import java.util.Scanner;

public class UserRegistrationMain{
 Scanner scanner = new Scanner(System.in);
    public static final String NAME_PATTERN = "^[A-Z]{1}[a-z]{2}[a-z]*$";

 public void checkPattern(String matchstring, String pattern) {
        if (matchstring.matches(pattern)) {
            System.out.println("valid");
        } else {
            System.out.println("Invalid");
        }
    }

public void userInput() {
        System.out.println("Enter your firstname starts with uppercase and minimum three characters");
        String firstname = scanner.next();
	checkPattern(firstname, NAME_PATTERN);
	System.out.println("Enter your lastname starts with uppercase and minimum three characters");
        String lastname = scanner.next();
        checkPattern(lastname, NAME_PATTERN);
	}

 public static void main(String[] args) {
	UserRegistrationMain user = new UserRegistrationMain();
        user.userInput();
    }
}
