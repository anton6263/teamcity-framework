package com.example.teamcity.api.models;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class BuildType extends BaseModel {
    private String id;
    private String name;
    private Project project;
    private Steps steps;
}
