package com.mesaj.app.util.reporting;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JReporter implements ConcurrentEventListener {

    private static final String ELASTIC_SEARCH_URL = "http://localhost:9200/automation/suite";

    private static final String executionId = "12b27564-42c7";

    private void onTestCaseFinished(final TestCaseFinished event) {

        ScenarioExecutionInfo scenarioExecutionInfo = new ScenarioExecutionInfo();
        scenarioExecutionInfo.setExecutionId(executionId);
        scenarioExecutionInfo.setId(event.getTestCase().getId().toString());
        scenarioExecutionInfo.setName(event.getTestCase().getName());
        scenarioExecutionInfo.setStatus(event.getResult().getStatus().toString());

        RestAssured
                .given()
                .body(scenarioExecutionInfo)
                .contentType(ContentType.JSON)
                .when()
                .post(ELASTIC_SEARCH_URL);
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
    }
}


