package com.solvd.qa.carina.demo.posts;

import com.solvd.qa.carina.demo.api.*;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APIPostTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "duy")
    public void testGetPosts() {
        //preparing call request
        GetPostMethod getPostMethods = new GetPostMethod();

        //making call to endpoint
        getPostMethods.callAPIExpectSuccess();

        //validate response
        getPostMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPostMethods.validateResponseAgainstSchema("api/posts/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "duy")
    public void testCreatePost() throws Exception {

        //preparing call request
        PostPostMethod api = new PostPostMethod();
        api.setProperties("api/posts/post.properties");

        //making call to endpoint
        api.callAPIExpectSuccess();

        //validate response
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "duy")
    public void testCreatePostMissingSomeFields() throws Exception {
        //preparing call request
        PostPostMethod api = new PostPostMethod();
        api.setProperties("api/posts/post.properties");

        //remove field
        api.getProperties().remove("title");

        //making call to endpoint
        api.callAPIExpectSuccess();

        //validate response
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "duy")
    public void testPatchPost() {
        //preparing call POST request
        PostPostMethod api = new PostPostMethod();
        api.setProperties("api/posts/post.properties");

        //making call to endpoint
        Response response = api.callAPIExpectSuccess();
        String title = response.jsonPath().getString("0.title");

        //preparing call Patch request
        PatchPostMethod updateApi = new PatchPostMethod();


    }

}
