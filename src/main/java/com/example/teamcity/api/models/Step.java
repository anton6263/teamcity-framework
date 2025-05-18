package com.example.teamcity.api.models;

import lombok.Builder;

@Builder
public class Step {
    private String id;
    private String name;
    @Builder.Default
    private String type = "simpleRunner";
}
