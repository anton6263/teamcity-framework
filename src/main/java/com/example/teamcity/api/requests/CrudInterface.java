package com.example.teamcity.api.requests;

import com.example.teamcity.api.models.BaseModel;

public interface CrudInterface {

    Object create(BaseModel baseModel);
    Object read(String id);
    Object update(String id, BaseModel baseModel);
    Object delete(String id);
}
