import java.util.Scanner;

public class UserRegistrationMain{
 Scanner scanner = new Scanner(System.in);
    public static final String NAME_PATTERN = "^[A-Z]{1}[a-z]{2}[a-z]*$";
    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9+_-]+(?:\\.[a-zA-Z0-9_-]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z]{2,}){1,2}$";
    public static final String NUMBER_PATTERN = "^(\\d{2})\\-([6-9]{1}\\d{9})$";
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,}$";

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
	System.out.println("Enter your email");
        String email = scanner.next();
        checkPattern(email, EMAIL_PATTERN);
	System.out.println("enter your mobilenumber with countrycode followed by -");
        String mobileNumber = scanner.next();
        checkPattern(mobileNumber, NUMBER_PATTERN);
	System.out.println("Enter your password\n"
                + "password should contain combination of uppercase,lowercase,number,special character and minimum 8 characters");
        String password = scanner.next();
        checkPattern(password, PASSWORD_PATTERN);
	}

 public static void main(String[] args) {
	UserRegistrationMain user = new UserRegistrationMain();
        user.userInput();
    }
}
