package com.solvd.qa.carina.demo.postsBlock4;

import com.solvd.qa.carina.demo.api.*;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class APIPostTest implements IAbstractTest {

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
    public void testCreatePost() {

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
    public void testCreatePostMissingSomeFields() {
        //preparing call request
        PostPostMethod api = new PostPostMethod();
        api.setProperties("api/posts/post.properties");

        //remove field
//        api.getProperties().remove("title");
        api.getProperties().remove("body");

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
        int id = response.jsonPath().getInt("0.id");

        //preparing call Patch request
        PatchPostMethod updateApi = new PatchPostMethod();
        updateApi.replaceUrlPlaceholder("post_id", Integer.toString(id));

        //making call to endpoint
        updateApi.callAPIExpectSuccess();

        //validate response
        updateApi.validateResponse();

    }

}
