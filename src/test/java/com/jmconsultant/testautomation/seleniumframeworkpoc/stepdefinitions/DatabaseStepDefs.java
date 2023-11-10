package com.jmconsultant.testautomation.seleniumframeworkpoc.stepdefinitions;

/*import com.mesaj.app.database.User;
import com.mesaj.app.database.UserRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@ScenarioScope
public class DatabaseStepDefs {

    @Autowired
    UserRepository userRepository;

    User user = new User();

    @Given("Pepito already registered an user")
    public void pepito_already_registered_an_user() {
        user.setEmail("anonimo@gmail.com");
        user.setName("anonimo");
        userRepository.save(user);
    }

    @When("he asks for the user")
    public void he_asks_for_the_user() {
        Optional<User> user1 = userRepository.findById(user.getId());
        System.out.println(user1.get().getEmail());
    }

    @Then("he should get a registered user")
    public void he_should_get_a_registered_user() {

    }
}
*/

