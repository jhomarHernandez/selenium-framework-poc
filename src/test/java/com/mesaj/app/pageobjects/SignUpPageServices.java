package com.mesaj.app.pageobjects;

import com.mesaj.app.enums.Gender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class SignUpPageServices {

    @Autowired
    private SignUpPageObject signUpPageObject;

    @Autowired
    private WebDriver driver;

    @Autowired
    WebDriverWait wait;

    public void go(String url){
        this.driver.get(url);
    }

    public void writeFirstName(String firstName){
        this.wait.until(ExpectedConditions.visibilityOf(this.signUpPageObject.getFirstNameTextBox()));
        this.signUpPageObject.getFirstNameTextBox().sendKeys(firstName);
    }

    public void writeLastName(String firstName){
        this.signUpPageObject.getLastNameTextBox().sendKeys(firstName);
    }

    public void writeEmail(String email){
        this.signUpPageObject.getEmailTextBox().sendKeys(email);
    }

    private void selectMale(){
        this.signUpPageObject.getMaleCheckBox().click();
    }

    private void selectFemale(){
        this.signUpPageObject.getFemaleCheckBox().click();
    }

    public void selectCountry(String country){
        new Select(this.signUpPageObject.getCountrySelect()).selectByValue(country);
    }

    public void selectBirthDay(String day){
        new Select(this.signUpPageObject.getDayBirthDay()).selectByValue(day);
    }

    public void selectBirthMonth(String month){
        new Select(this.signUpPageObject.getMonthBirthDay()).selectByValue(month);
    }

    public void selectBirthYear(String year){
        new Select(this.signUpPageObject.getYearBirthDay()).selectByValue(year);
    }

    public void writePhone(String phone){
        this.signUpPageObject.getPhoneTextBox().sendKeys(phone);
    }

    public void writePassword(String password){
        this.signUpPageObject.getPassword().sendKeys(password);
    }

    public void writeConfirmPassword(String password){
        this.signUpPageObject.getConfirmPassword().sendKeys(password);
    }

    public void clickOnSubmit(){
        this.signUpPageObject.getSubmit().click();
    }

    public void selectGender(Gender gender){
        if(gender == Gender.female) {
            this.selectFemale();
        }else {
            this.selectMale();
        }
    }
}
