package com.mesaj.app.util.reporting;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class HookReporter {

    private static final String ELASTIC_SEARCH_URL = "http://localhost:9200/automation/suite";

    private static final String executionId = "12b27564-42c7-4824-ad90-8fba4bde2222";

    @After
    public void reportFinalScenarioStatus(Scenario scenario) {

        ScenarioExecutionInfo scenarioExecutionInfo = new ScenarioExecutionInfo();
        scenarioExecutionInfo.setExecutionId(executionId);
        scenarioExecutionInfo.setId(scenario.getId());
        scenarioExecutionInfo.setName(scenario.getName());
        scenarioExecutionInfo.setStatus(scenario.getStatus().toString());

        RestAssured
                .given()
                .body(scenarioExecutionInfo)
                .contentType(ContentType.JSON)
                .when()
                .post(ELASTIC_SEARCH_URL);
    }
}
