package com.payload;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.pojo.Pojo_PostRequest;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DifferentPayloadPost {


//    @Test(priority = 1)
//    public void payloadpost()
//    {
//        String coursearr[] ={"Python","Java"};
//        JSONObject data = new JSONObject();
//        data.put("Name","Max");
//        data.put("Education","MBA");
//        data.put("courses",coursearr);
//        given().contentType("application/json")
//                .body(data.toString()).when().post("http://localhost:3000/students").then().statusCode(201).body("Name",equalTo("Max")).log().all();
//
//
//    }

//    @Test(priority = 1)
//    public void payloadPojodata()
//    {
//        String[] coursearr= {"Data science, ML, AI"};
//        Pojo_PostRequest data = new Pojo_PostRequest();
//        data.setName("Iron-Man");
//        data.setLocation("USA- Marvel");
//        data.setCoursearr(coursearr);
//        given().contentType("application/json")
//                .body(data).when().post("http://localhost:3000/students").then().statusCode(201).body("name",equalTo("Iron-Man")).log().all();
//
//    }


    @Test(priority = 1)
    public void payloadExternaljsondata() throws FileNotFoundException {
        System.out.println("Payload External JSON");
       File fl= new File(".\\body.json");
        FileInputStream fis = new FileInputStream(fl);
        JSONTokener jt= new JSONTokener(fis);
        JSONObject data = new JSONObject(jt);
        given().contentType("application/json")
                .body(data.toString()).when().post("http://localhost:3000/students").then().statusCode(201).body("name",equalTo("Dexter")).log().all();

    }




    @Test
    public void payloadpostusingjsonObj()
    {
        System.out.println("Data using hash map");
        String coursearr[] ={"Python","Java"};
        HashMap data1 = new HashMap();
        data1.put("name", "scott");
        data1.put("location","USA");
        data1.put("phone","123456");
        data1.put("Courses",coursearr);
        given().contentType("application/json")
                .body(data1).when().post("http://localhost:3000/students").then().statusCode(201).body("name",equalTo("scott")).log().all();


    }
}
