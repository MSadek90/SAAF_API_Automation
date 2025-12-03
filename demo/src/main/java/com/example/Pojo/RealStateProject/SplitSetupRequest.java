package com.example.Pojo.RealStateProject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SplitSetupRequest {

    @JsonProperty("split_type")
    private int split_type;

    @JsonProperty("number_of_units")
    private int number_of_units;

    @JsonProperty("project_id")
    private int project_id;

    public int getProjectId() {
        return project_id;
    }

    public void setProjectId(int projectId) {
        this.project_id = projectId;
    }

    public int getSplitType() {
        return split_type;
    }

    public void setSplitType(int splitType) {
        this.split_type = splitType;
    }

    public int getNumberOfUnits() {
        return number_of_units;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.number_of_units = numberOfUnits;
    }
}
