package com.example.teamcity.api.requests.unchecked;

import com.example.teamcity.api.enums.Endpoint;
import com.example.teamcity.api.models.BaseModel;
import com.example.teamcity.api.requests.CrudInterface;
import com.example.teamcity.api.requests.Request;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Класс, в котором просто отправляем запрос и не проверяем его ответ
 */
public class UncheckedBase extends Request implements CrudInterface {

    public UncheckedBase(RequestSpecification spec, Endpoint endpoint) {
        super(spec, endpoint);
    }

    @Override
    public Response create(BaseModel baseModel) {
        return RestAssured.given()
                .spec(spec)
                .body(baseModel)
                .post(endpoint.getUrl());
    }

    @Override
    public Response read(String id) {
        return RestAssured.given()
                .spec(spec)
                .get(endpoint.getUrl() + "/id:" + id);
    }

    @Override
    public Response update(String id, BaseModel baseModel) {
        return RestAssured.given()
                .body(baseModel)
                .spec(spec)
                .put(endpoint.getUrl() + "/id:" + id);
    }

    @Override
    public Response delete(String id) {
        return RestAssured.given()
                .spec(spec)
                .get(endpoint.getUrl() + "/id:" + id);
    }
}
