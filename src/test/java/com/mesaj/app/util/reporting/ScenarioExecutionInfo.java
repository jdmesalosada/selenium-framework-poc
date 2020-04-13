package com.mesaj.app.util.reporting;

import lombok.Data;

@Data
public class ScenarioExecutionInfo {

    private String status;
    private String id;
    private String name;
    private String executionId;
}
