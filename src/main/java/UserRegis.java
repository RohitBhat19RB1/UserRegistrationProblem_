public class UserRegis {
    public Boolean ValidEmail(String emails) {
        return (emails.matches("^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*[@][0-9A-Za-z]+([.][a-zA-Z]{2,4})*$"));

    }

    public boolean validation(String input, String Pattern) {
        Boolean result = input.matches(Pattern);
        return result;
    }

    }
