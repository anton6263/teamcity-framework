package com.example.teamcity.api.models;

import lombok.Builder;

@Builder
public class Project extends BaseModel {
    private String id;
    private String name;
    @Builder.Default
    private String locator = "_Root";

}
