package com.mesaj.app.tasks;

import com.mesaj.app.enums.Gender;
import com.mesaj.app.models.User;
import com.mesaj.app.pageobjects.SignUpPageServices;
import com.mesaj.app.util.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class UserSignUp {

    @Autowired
    private SignUpPageServices signUp;

    public void withInfo(User user){

        signUp.writeFirstName(user.getFirstName());
        signUp.writeLastName(user.getLastName());
        signUp.writeEmail(user.getEmail());
        signUp.selectGender(user.getGender());
        signUp.selectCountry(user.getCountry());
        signUp.selectBirthDay(user.getBirthDay());
        signUp.selectBirthMonth(user.getBirthMonth());
        signUp.selectBirthYear(user.getBirthYear());
        signUp.writePhone(RandomNumberGenerator.get());
        signUp.writePassword(user.getPassword());
        signUp.writeConfirmPassword(user.getPasswordConfirmation());
        //signUp.clickOnSubmit();
    }
}
