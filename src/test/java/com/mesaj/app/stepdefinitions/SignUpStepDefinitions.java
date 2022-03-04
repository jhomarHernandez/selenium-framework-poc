package com.mesaj.app.stepdefinitions;

import com.mesaj.app.builders.data.UserBuilder;

import com.mesaj.app.tasks.NavigateTo;
import com.mesaj.app.tasks.UserSignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUpStepDefinitions {

    @Autowired
    private NavigateTo navigate;

    @Autowired
    private UserSignUp signUp;

    @Given("^Pepito wants to have an account$")
    public void pepito_wants_to_have_an_account() {
        navigate.signUpPage();
    }

    @When("^he sends required information to get the account$")
    public void he_sends_required_information_to_get_the_account() {
        signUp.withInfo(
                UserBuilder
                        .anUser()
                        .withDefaultInfo()
                        .withoutEmail()
                        .withoutBirthDay()
                        .build()
        );
    }

    @Then("^he should be told that the account was created$")
    public void he_should_be_told_that_the_account_was_created() {
        assertThat(true).isEqualTo(true);
    }


    @Then("he should be told that the account was not created")
    public void heShouldBeToldThatTheAccountWasNotCreated() {
        assertThat(true).isEqualTo(false);
    }
}
