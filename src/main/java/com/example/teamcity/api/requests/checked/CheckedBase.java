package com.example.teamcity.api.requests.checked;

import com.example.teamcity.api.enums.Endpoint;
import com.example.teamcity.api.models.BaseModel;
import com.example.teamcity.api.requests.CrudInterface;
import com.example.teamcity.api.requests.Request;
import com.example.teamcity.api.requests.unchecked.UncheckedBase;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

@SuppressWarnings("unchecked")
public final class CheckedBase<T extends BaseModel> extends Request implements CrudInterface {

    private final UncheckedBase uncheckedBase;

    public CheckedBase(RequestSpecification spec, Endpoint endpoint) {
        super(spec, endpoint);
        this.uncheckedBase = new UncheckedBase(spec, endpoint);
    }

    @Override
    public T create(BaseModel baseModel) {
        return (T) uncheckedBase.create(baseModel)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(endpoint.getModel());
    }

    @Override
    public T read(String id) {
        return (T) uncheckedBase.read(id)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(endpoint.getModel());
    }

    @Override
    public T update(String id, BaseModel baseModel) {
        return (T) uncheckedBase.update(id, baseModel)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(endpoint.getModel());
    }

    @Override
    public T delete(String id) {
        return (T) uncheckedBase.delete(id)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }
}
