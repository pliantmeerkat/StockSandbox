package com.stocktrainer.stockJb.service;

import java.io.File;
import java.io.InputStream;

import com.stocktrainer.stockJb.enums.ErrorConstants;
import com.stocktrainer.stockJb.exception.InvalidJsonException;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

abstract class Authorization {

    Authorization() {}
    static String JSON_SCHEMA_PATH = File.separator.concat("schemas").concat(File.separator);

    private static void validateJsonFromSchema(String schemaName, String inputJson) {
        String schemaPath = JSON_SCHEMA_PATH.concat(schemaName);
        InputStream inputStream = Authorization.class.getResourceAsStream(schemaPath);
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(inputJson));
    }

    static void verifyJsonFormatting(String userJson) {
        try {
            validateJsonFromSchema("user-json-schema.json", userJson);
        } catch (ValidationException e) {
            throw new InvalidJsonException(ErrorConstants.JSON_FORMATTING_BASIC.toString(), e);
        } catch (JSONException e) {
            throw new InvalidJsonException(ErrorConstants.JSON_FORMATTING_INVALID.toString(), e);
        }
    }
}
