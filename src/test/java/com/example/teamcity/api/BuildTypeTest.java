package com.example.teamcity.api;

import com.example.teamcity.api.enums.Endpoint;
import com.example.teamcity.api.generators.DataGenerator;
import com.example.teamcity.api.models.User;
import com.example.teamcity.api.requests.checked.CheckedBase;
import com.example.teamcity.api.spec.Specifications;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

@Test(groups = {"Regression"})
public class BuildTypeTest extends BaseApiTest {

    @Test(description = "User should be able to create build type", groups = {"Positive", "CRUD"})
    public void checkUserCanCreateBuildType() {
        step("Create user", () -> {
            User user = DataGenerator.generate(User.class);
            var requester = new CheckedBase<User>(Specifications.superUserAuthSpec(), Endpoint.USERS);
            requester.create(user);
        });
    }

    @Test(description = "User should not be able to create two build types with the same id", groups = {"Negative", "CRUD"})
    public void checkUserCanNotCreateTwoBuildTypesWithTheSameId() {
        step("Create user");
        User user = User.builder()
                .username("admin")
                .password("admin")
                .build();

        var token = RestAssured
                .given()
                .spec(Specifications.authSpec(user))
                .get("/authenticationTest.html?csrf")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();

        System.out.println(token);
    }

    @Test(description = "Project admin should be able to create build type", groups = {"Positive", "Roles"})
    public void checkProjectAdminShouldBeAbleCreateBuildType() {
        step("Create user");
        step("Create project");
        step("Grant user project_admin role in project");
        step("Create build type");
        step("Build type was created successfully");

        User user = User.builder()
                .username("admin")
                .password("admin")
                .build();

        var token = RestAssured
                .given()
                .spec(Specifications.authSpec(user))
                .get("/authenticationTest.html?csrf")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();

        System.out.println(token);
    }

    @Test(description = "Project admin should be able to create build type", groups = {"Negative", "Roles"})
    public void checkProjectAdminShouldNotBeAbleCreateBuildTypeForNotTheirProject() {
        step("Create user1");
        step("Create project1");
        step("Grand user project_admin1 role in project1");

        step("Create user2");
        step("Create project2");
        step("Grand user project_admin1 role in project1");

        step("Create build type for project1 by user2");
        step("Access denied");

        User user = User.builder()
                .username("admin")
                .password("admin")
                .build();

        var token = RestAssured
                .given()
                .spec(Specifications.authSpec(user))
                .get("/authenticationTest.html?csrf")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();

        System.out.println(token);
    }
}
