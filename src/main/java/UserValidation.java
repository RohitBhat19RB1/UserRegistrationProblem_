
@FunctionalInterface
interface user{
    boolean userValidate(String input,String Pattern);
}
public class UserValidation  {

    public boolean lambdaValidation(String name,String pattern) throws UserRegistrationException {
        user validate = (input, Pattern) -> input.matches(pattern);
        return validate.userValidate(name, pattern);
    }
}
