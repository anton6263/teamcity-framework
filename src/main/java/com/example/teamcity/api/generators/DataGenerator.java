package com.example.teamcity.api.generators;

import com.example.teamcity.api.models.BaseModel;
import com.example.teamcity.api.utils.RandomData;

import java.lang.reflect.InvocationTargetException;

public class DataGenerator {

    public static <T extends BaseModel> T generate(Class<T> generatorClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var instance = generatorClass.getDeclaredConstructor().newInstance();
        for (var field : generatorClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (String.class.equals(field.getType())) {
                field.set(instance, RandomData.getString());
            }
            field.setAccessible(false);
        }
        return instance;
    }
}
