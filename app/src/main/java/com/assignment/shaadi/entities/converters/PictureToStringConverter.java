package com.assignment.shaadi.entities.converters;

import com.assignment.shaadi.entities.user.Id;
import com.assignment.shaadi.entities.user.Name;
import com.assignment.shaadi.entities.user.Picture;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.objectbox.converter.PropertyConverter;

public class PictureToStringConverter implements PropertyConverter<Picture, String> {

    @Override
    public Picture convertToEntityProperty(String databaseValue) {
        Picture picture = new Gson().fromJson(databaseValue, new TypeToken<Picture>() {
        }.getType());
        return (picture == null) ? new Picture() : picture;
    }

    @Override
    public String convertToDatabaseValue(Picture picture) {
        return new Gson().toJson(picture);
    }
}

