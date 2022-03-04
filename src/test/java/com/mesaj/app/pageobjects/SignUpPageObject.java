package com.mesaj.app.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
@Getter
public class SignUpPageObject extends PageBase{

    @Autowired
    public SignUpPageObject(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")
    private WebElement firstNameTextBox;

    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")
    private WebElement lastNameTextBox;

    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")
    private WebElement addressTextArea;

    @FindBy(xpath = "//*[@id=\"eid\"]/input")
    private WebElement emailTextBox;

    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")
    private WebElement phoneTextBox;

    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")
    private WebElement maleCheckBox;

    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input")
    private WebElement femaleCheckBox;

    @FindBy(id = "country")
    private WebElement countrySelect;

    @FindBy(xpath = "//*[@id=\"yearbox\"]")
    private WebElement yearBirthDay;

    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")
    private WebElement monthBirthDay;

    @FindBy(xpath = "//*[@id=\"daybox\"]")
    private WebElement dayBirthDay;

    @FindBy(xpath = "//*[@id=\"firstpassword\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"secondpassword\"]")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"submitbtn\"]")
    private WebElement submit;
}
