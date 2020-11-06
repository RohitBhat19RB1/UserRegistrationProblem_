import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserValidationTest1 {
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
        Assert.assertTrue("Happy Test Case",result);
    }

    @Test
    public void givenFirstName_WhenLessThanMiniMumLength_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("Ro", NAME_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenFirstName_WhenWithSplCharacter_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("Rohit@", NAME_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenFirstName_WhenWithNum_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("Rohit12", NAME_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenFirstName_WhenFirstLetterWithOutUpperCase_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("rohit", NAME_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenFirstName_WhenWithNullValue_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("", NAME_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }

    @Test
    public void givenLastName_WhenWithProperLastName_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.validation("Bhat",NAME_PATTERN);
        Assert.assertTrue("Happy Test Case",result);
    }
    @Test
    public void givenLastName_WhenLessThanMinimumLength_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("Bh", NAME_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenLastName_WhenWithSplCharacter_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("Bhat@", NAME_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenLastName_WhenWithNum_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("Bhat1", NAME_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
               }
    @Test
    public void givenLastName_WhenFirstLetterWithOutUpperCase_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("bhat", NAME_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenLastName_WhenWithNullValue_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("", NAME_PATTERN);
            Assert.assertFalse("Happy Test Case",result);
    }

    @Test
    public void givenNumber_WhenWithProperNumber_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.validation("91-8712443377",NUMBER_PATTERN);
        Assert.assertTrue("Happy Test Case",result);
    }
    @Test
    public void givenNumber_WhenLessThanMinimumLength_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("91-871244337", NUMBER_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenNumber_WithOutCountryCode_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("8712443377", NUMBER_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenNumber_WhenWithLetter_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("91-871244337j", NUMBER_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenNumber_WithAnyOtherSplCharacter_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("91_9812443377", NUMBER_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenNumber_CountryCodeWithOutDash_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("918712443377", NUMBER_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenNumber_WhenWithNullValue_ShouldReturnFalse()  {
            boolean result = Validator.validation("",NAME_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenNumber_WhenWithNumberStartingLessThan6_SholdReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("91-5712443377", NUMBER_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenNumber_WhenWithCountryCodeFollowedBy2Dash_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("91--8712443377", NUMBER_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }

    @Test
    public void givenPassword_WithProperPassword_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.validation("shAnu12@",PASSWORD_PATTERN);
        Assert.assertTrue("Happy Test Case",result);
    }
    @Test
    public void givenPassword_WhenStratingWithNumbers_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.validation("12Shanu@",PASSWORD_PATTERN);
        Assert.assertTrue("Happy Test Case",result);
    }
    @Test
    public void givenPassword_WhenStartingWithSplCharacter_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.validation("@12Shanu",PASSWORD_PATTERN);
        Assert.assertTrue("Happy Test Case",result);
    }

    @Test
    public void givenPassword_WhenStartingWithLowerCase_ShouldReturnTrue() throws UserRegistrationException {
        boolean result=Validator.validation("shAnu12@",PASSWORD_PATTERN);
        Assert.assertTrue("Happy Test Case",result);
    }

    @Test
    public void givenPassword_WhenLessThanMinimumLength_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("Shan2@", PASSWORD_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenPassword_WithOutNumber_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("Rohit@", PASSWORD_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenPassword_WithOutUpperCase_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("shanu12@", PASSWORD_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
    }
    @Test
    public void givenPassword_WithOutSplCharacter_ShouldReturnFalse() throws UserRegistrationException {
            boolean result = Validator.validation("Shanu123", PASSWORD_PATTERN);
            Assert.assertFalse("Sad Test Case",result);
           }
    @Test
    public void givenPassword_WhenWithNullValue_ShouldReturnFalse() {
        boolean result = Validator.validation("", PASSWORD_PATTERN);
        Assert.assertFalse("Sad Test Case",result);
    }

}
