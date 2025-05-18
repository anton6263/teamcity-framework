package com.example.teamcity.api;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class BuildConfigurationTest extends BaseApiTest {

    @Test
    public void buildConfigurationTest() {
        var token = RestAssured.given().auth()
                .basic("admin", "admin")
                .when()
                .get("http://192.168.31.92:8111/authenticationTest.html?csrf")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .asString();

        System.out.println(token);
    }
}
