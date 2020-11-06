
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class lambdaUserRegistrationTest {
    public static final String NAME_PATTERN = "^[A-Z]{1}[a-z]{2}[a-z]*$";
    public static final String NUMBER_PATTERN = "^(\\d{2})\\-([6-9]{1}\\d{9})$";
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,}$";
    UserValidation Validator;


    @Before
    public void setUp() throws Exception {
        Validator = new UserValidation();
    }

    @Test
    public void givenFirstName_WhenWithProperFirstName_ShouldReturnTrue() throws UserRegistrationException {
        boolean result= Validator.lambdaValidation("Rohit",NAME_PATTERN);
        Assert.assertTrue(result);
    }
    @Test
    public void givenFirstName_WhenLessThanMiniMumLength_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("Ro", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Minimum length should be three characters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenFirstName_WhenWithSplCharacter_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("Rohit@", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name should not contain special characters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccured::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenFirstName_WhenWithNum_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("Rohit12", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name should not contain numeric");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccured::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenFirstName_WhenFirstLetterWithOutUpperCase_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("rohit", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name starts with Uppercase");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenFirstName_WhenWithNullValue_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name should not be empty");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }

    @Test
    public void givenLastName_WhenWithProperLastName_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.lambdaValidation("Bhat",NAME_PATTERN);
        Assert.assertTrue(result);
    }
    @Test
    public void givenLastName_WhenLessThanMinimumLength_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("Ro", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Minimum length should be three characters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenLastName_WhenWithSplCharacter_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("Rohit@", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name should not contains special characters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenLastName_WhenWithNum_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("Rohit1", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name should not contain numeric");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenLastName_WhenFirstLetterWithOutUpperCase_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("bhat", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name starts with uppercase");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccured::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenLastName_WhenWithNullValue_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("", NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Name should not be empty");
        }catch (UserRegistrationException userRegistrationException) {
            System.out.println("ExceptionOccurred::" + userRegistrationException.getMessage());
        }
    }

    @Test
    public void givenNumber_WhenWithProperNumber_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.lambdaValidation("91-8712443377",NUMBER_PATTERN);
        Assert.assertTrue(result);
    }
    @Test
    public void givenNumber_WhenLessThanMinimumLength_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("91-871244337", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Mobilenumber should contain ten numerics");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_WithOutCountryCode_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("8712443377", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Please enter your countrycode");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_WhenWithLetter_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("91-871244337j", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Mobilenumber should not contain letters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_WithAnyOtherSplCharacter_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("91_9812443377", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Mobilenumber should not contain special characters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_CountryCodeWithOutDash_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("918712443377", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("There must be a - between countrycode and mobilenumber");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_WhenWithNullValue_ShouldReturnFalse()  {
        try {
            boolean result = Validator.lambdaValidation("",NAME_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Mobilenumber should not be empty");
        } catch (UserRegistrationException userRegistrationException) {
            System.out.println("ExceptionOccurred:" + userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_WhenWithNumberStartingLessThan6_SholdReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("91-5712443377", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Please enter your valid mobilenumber");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenNumber_WhenWithCountryCodeFollowedBy2Dash_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("91--8712443377", NUMBER_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("There must be one - between countrycode and mobilenumber");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }

    @Test
    public void givenPassword_WithProperPassword_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.lambdaValidation("shAnu12@",PASSWORD_PATTERN);
        Assert.assertTrue(result);
    }
    @Test
    public void givenPassword_WhenStratingWithNumbers_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.lambdaValidation("12Shanu@",PASSWORD_PATTERN);
        Assert.assertTrue(result);
    }
    @Test
    public void givenPassword_WhenStartingWithSplCharacter_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.lambdaValidation("@12Shanu",PASSWORD_PATTERN);
        Assert.assertTrue(result);
    }

    @Test
    public void givenPassword_WhenStartingWithLowerCase_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.lambdaValidation("shAnu12@",PASSWORD_PATTERN);
        Assert.assertTrue(result);
    }

    @Test
    public void givenPassword_WhenLessThanMinimumLength_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("Shan2@", PASSWORD_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Password must contain atleast eight characters");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenPassword_WithOutNumber_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("Rohit@", PASSWORD_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Password must contain atleast one numeric");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenPassword_WithOutUpperCase_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("shanu12@", PASSWORD_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Password must contain atleast one uppercase");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenPassword_WithOutSplCharacter_ShouldReturnFalse() throws UserRegistrationException {
        try {
            boolean result = Validator.lambdaValidation("Shanu123", PASSWORD_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Password must conatin atleast one special cahracter");
        }catch (UserRegistrationException userRegistrationException){
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
    @Test
    public void givenPassword_WhenWithNullValue_ShouldReturnFalse() {
        try {
            boolean result = Validator.lambdaValidation("",PASSWORD_PATTERN);
            Assert.assertFalse(result);
            throw new UserRegistrationException("Password should not be empty");
        } catch (UserRegistrationException userRegistrationException) {
            System.out.println("ExceptionOccurred::"+userRegistrationException.getMessage());
        }
    }
}