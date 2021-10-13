package ir.maktab.Exception;

import ir.maktab.enums.Gender;

public class Validation {
    public boolean validateUserInfo(String fullName, String phoneNumber, String email,
                                    String nationalId, String userName) throws InvalidPhoneNumberException, InvalidEmailException, InvalidNationalIDException, InvalidNameException {
        return validateFullName(fullName) && validatePhoneNumber(phoneNumber) && validateEmail(email) &&
                validateNationalID(nationalId, userName);
    }

    private boolean validateNationalID(String nationalId, String userName) throws InvalidNationalIDException {
        if (nationalId.matches("[0-9]+") && nationalId.length() == 10 && userName.matches("[0-9]+") && userName.length() == 10) {
            return true;
        }
        throw new InvalidNationalIDException("invalid national Id or user name");
    }

    private boolean validateEmail(String email) throws InvalidEmailException {
        if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            return true;
        }
        throw new InvalidEmailException("invalid Email!");
    }

    private boolean validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        if (phoneNumber.matches("[0-9]+") && phoneNumber.startsWith("09") && phoneNumber.length() == 11) {
            return true;
        }
        throw new InvalidPhoneNumberException("invalid phoneNumber!");
    }

    private boolean validateFullName(String fullName) throws InvalidNameException {
        if ( fullName.length()> 4  ){
            return true;
        }
        throw new InvalidNameException("invalid name!");
    }

//&& fullName.matches("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)")
}
