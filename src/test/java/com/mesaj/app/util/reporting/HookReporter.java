package com.mesaj.app.util.reporting;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.UUID;

public class HookReporter {

    private static final String ELASTIC_SEARCH_URL = "http://localhost:9200/automation/suite";
    //private static final UUID corrId = UUID.randomUUID();

    private static final String corrId = "12b27564-42c7-4824-ad90-8fba4bde2222";

    @After
    public void reportFinalStatus(Scenario scenario) {

        ScenarioStatus scenarioStatus = new ScenarioStatus();
        scenarioStatus.setStatus(scenario.getStatus().name());
        scenarioStatus.setId(scenario.getId());
        scenarioStatus.setName(scenario.getName());
        //scenarioStatus.setExecutionId(corrId.toString());
        scenarioStatus.setExecutionId(corrId);
        //add environment
        //host
        //user

        RestAssured
                .given()
                .body(scenarioStatus)
                .contentType(ContentType.JSON)
                .when().post(ELASTIC_SEARCH_URL);
    }
}
