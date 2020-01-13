package ch.hesge.eshop.services;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidatorService {

    public Boolean isValidName(String name) {
        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    //https://stackoverflow.com/questions/9315647/regex-credit-card-number-tests
    public Boolean isValidNumberCard(String numberCard) {
        if (numberCard == null || numberCard.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$");
        Matcher matcher = pattern.matcher(numberCard);
        return matcher.find();
    }


    //https://stackoverflow.com/questions/5342375/regex-email-validation
    public Boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
        /*try
        {
            MailAddress m = new MailAddress(emailaddress);

            return true;
        }
        catch (Attribute.FormatException)
        {
            return false;
        }*/
    }

}
