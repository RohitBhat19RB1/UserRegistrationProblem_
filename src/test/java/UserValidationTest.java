
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserValidationTest {
    public static final String NAME_PATTERN = "^[A-Z]{1}[a-z]{2}[a-z]*$";
    public static final String NUMBER_PATTERN = "^(\\d{2})\\-([6-9]{1}\\d{9})$";
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,}$";
    UserRegis Validator;
    UserRegistrationException exception;

    @Before
    public void setUp() throws Exception {
        Validator = new UserRegis();
    }

    @Test
    public void givenFirstName_WhenWithProperFirstName_ShouldReturnTrue() throws UserRegistrationException {
        boolean result= Validator.validation("Rohit",NAME_PATTERN);
        Assert.assertTrue(result);
    }
    @Test
    public void givenFirstName_WhenLessThanMiniMumLength_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("Ro", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Minimum length should be three characters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenFirstName_WhenWithSplCharacter_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("Rohit@", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name should not contain special characters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenFirstName_WhenWithNum_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("Rohit12", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name should not contain numeric");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccured::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenFirstName_WhenFirstLetterWithOutUpperCase_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("rohit", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name starts with Uppercase");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenFirstName_WhenWithNullValue_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name should not be empty");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }

    @Test
    public void givenLastName_WhenWithProperLastName_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.validation("Bhat",NAME_PATTERN);
        Assert.assertTrue(result);
    }
    @Test
    public void givenLastName_WhenLessThanMinimumLength_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("Bh", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Minimum length should be three characters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenLastName_WhenWithSplCharacter_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("Bhat@", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name should not contains special characters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenLastName_WhenWithNum_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("Bhat1", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name should not contain numeric");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenLastName_WhenFirstLetterWithOutUpperCase_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("bhat", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name starts with uppercase");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccured::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenLastName_WhenWithNullValue_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name should not be empty");
        }catch (UserRegistrationException userRegistrationException) {
            System.out.println("ExceptionOccurred::" + userRegistrationException.getMessage());
        }
    }

    @Test
    public void givenNumber_WhenWithProperNumber_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.validation("91-8712443377",NUMBER_PATTERN);
        Assert.assertTrue(result);
    }
    @Test
    public void givenNumber_WhenLessThanMinimumLength_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("91-871244337", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Mobilenumber should contain ten numerics");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_WithOutCountryCode_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("8712443377", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Please enter your countrycode");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_WhenWithLetter_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("91-871244337j", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Mobilenumber should not contain letters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_WithAnyOtherSplCharacter_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("91_9812443377", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Mobilenumber should not contain special characters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_CountryCodeWithOutDash_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("918712443377", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("There must be a - between countrycode and mobilenumber");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_WhenWithNullValue_ShouldReturnFalse()  {
        try {
            boolean result = Validator.validation("",NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Mobilenumber should not be empty");
        } catch (UserRegistrationException userRegistrationException) {
            System.out.println("ExceptionOccurred:" + userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_WhenWithNumberStartingLessThan6_SholdReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("91-5712443377", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Please enter your valid mobilenumber");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_WhenWithCountryCodeFollowedBy2Dash_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("91--8712443377", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("There must be one - between countrycode and mobilenumber");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }

    @Test
    public void givenPassword_WithProperPassword_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.validation("shAnu12@",PASSWORD_PATTERN);
        Assert.assertTrue(result);
    }
    @Test
    public void givenPassword_WhenStratingWithNumbers_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.validation("12Shanu@",PASSWORD_PATTERN);
        Assert.assertTrue(result);
    }
    @Test
    public void givenPassword_WhenStartingWithSplCharacter_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.validation("@12Shanu",PASSWORD_PATTERN);
        Assert.assertTrue(result);
    }

    @Test
    public void givenPassword_WhenStartingWithLowerCase_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.validation("shAnu12@",PASSWORD_PATTERN);
        Assert.assertTrue(result);
    }

    @Test
    public void givenPassword_WhenLessThanMinimumLength_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("Shan2@", PASSWORD_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Password must contain atleast eight characters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenPassword_WithOutNumber_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("Rohit@", PASSWORD_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Password must contain atleast one numeric");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenPassword_WithOutUpperCase_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("shanu12@", PASSWORD_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Password must contain atleast one uppercase");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenPassword_WithOutSplCharacter_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.validation("Shanu123", PASSWORD_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Password must conatin atleast one special cahracter");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenPassword_WhenWithNullValue_ShouldReturnFalse() {
        try {
            boolean result = Validator.validation("",PASSWORD_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Password should not be empty");
        } catch (UserRegistrationException userRegistrationException) {
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
}
