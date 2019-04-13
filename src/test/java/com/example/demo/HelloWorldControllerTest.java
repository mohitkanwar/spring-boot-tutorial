package com.example.demo;


import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloWorldControllerTest {

    @Value("${server.port}")
    int port;

    @Before
    public void setBaseUri () {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost"; // replace as appropriate
    }

    @Test
    public void simpleHelloWorldTest() {
        get("/api/tdd/helloworld").then().assertThat().body("data", equalTo("Hello World!"));
    }

    @Test
    public void parameterizedHelloParam() {
        String name = "someRandomName";
        get("/api/tdd/helloworld?name="+name).then().assertThat().body("data", equalTo("Hello "+name+"!"));
    }

    @Test
    public void pathParamHelloWorldEnglishLocale() {

        get("/api/tdd/en_US/helloworld").then().assertThat().body("data", equalTo("Hello World!"));
    }

    @Test
    public void pathParamHelloWorldHindiLocale() {

        get("/api/tdd/hi_IN/helloworld").then().assertThat().body("data", equalTo("नमस्ते दुनिया!"));
    }

}
