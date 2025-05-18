package com.example.teamcity.api.models;

import lombok.Builder;

@Builder
public class Project {
    private String id;
    private String name;
    @Builder.Default
    private String locator = "_Root";

}
