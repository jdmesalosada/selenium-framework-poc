package com.mesaj.app.util.reporting;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class HookReporter {

    private static final String ELASTIC_SEARCH_URL = "http://localhost:9200/app/suite";

    @After
    public void reportFinalStatus(Scenario scenario) {

        ScenarioStatus scenarioStatus = new ScenarioStatus();
        scenarioStatus.setStatus(scenario.getStatus().name());
        scenarioStatus.setId(scenario.getId());
        scenarioStatus.setName(scenario.getName());

        RestAssured
                .given()
                .body(scenarioStatus)
                .contentType(ContentType.JSON)
                .when().post(ELASTIC_SEARCH_URL);
    }
}
