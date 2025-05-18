package com.example.teamcity.api.spec;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


//Построения (настройки) HTTP-запроса перед его выполнением.

public class Specifications {

    private static Specifications spec;

    private Specifications() {

    }

    public static Specifications getSpec() {
        if (spec == null) {
            spec = new Specifications();
        }
        return spec;
    }

    private RequestSpecBuilder reqSpecBuilder() {
        var requestBuild = new RequestSpecBuilder();
        requestBuild.addFilter(new RequestLoggingFilter());
        requestBuild.addFilter(new ResponseLoggingFilter());
        return requestBuild;
    }

    public RequestSpecification unauthSpec() {
        var requestBuilder = reqSpecBuilder();
        requestBuilder.setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON);
        return requestBuilder.build();
    }

    public RequestSpecification authSpec() {
        var requestBuilder = reqSpecBuilder();

        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("admin");

        requestBuilder.setBaseUri("http://192.168.31.92:8111")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setAuth(authScheme)
                .build();
        return requestBuilder.build();
    }
}
