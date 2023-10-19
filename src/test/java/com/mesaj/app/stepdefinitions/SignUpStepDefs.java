package com.mesaj.app.stepdefinitions;

import com.mesaj.app.builders.data.UserBuilder;
import com.mesaj.app.models.User;
import com.mesaj.app.questions.GetUserToSignUpBy;
import com.mesaj.app.tasks.NavigateTo;
import com.mesaj.app.tasks.UserSignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
@ScenarioScope
public class SignUpStepDefs {

    @Autowired
    private UserSignUp signUp;

    @Autowired
    private NavigateTo navigate;

    @Given("^Pepito wants to have an account$")
    public void pepito_wants_to_have_an_account() throws InterruptedException {
        navigate.signUpPage();
        Thread.sleep(4000);
    }

    @When("^he sends required information to get the account$")
    public void he_sends_required_information_to_get_the_account() {

        signUp.withInfo(
                UserBuilder
                        .anUser()
                        .but()
                        .withoutBirthDay()
                        .withoutEmail()
                        .build()
        );
    }

    @When("^he sends required information to get the account as an (.*)$")
    public void sends_required_information_as_an(String profile) throws Exception {

        User userToSignUp = GetUserToSignUpBy.profile(profile);

        signUp.withInfo(
                userToSignUp
        );
    }

    @Then("^he should be told that the account was created$")
    public void he_should_be_told_that_the_account_was_created() {
        assertThat(true).isEqualTo(true);
    }

    @Then("^he should be told that the account was not created$")
    public void he_should_be_told_that_the_account_was_not_created() {
        assertThat(true).isEqualTo(false);
    }
}
