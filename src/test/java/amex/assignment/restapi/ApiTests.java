package amex.assignment.restapi;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiTests {

    @LocalServerPort
    private int port;

    // Tests for status code, response body and content type
    @Test
    void post() throws IOException{
        String jsonBodyOrange = generateStringFromResource("src/main/resources/json/TC1.json");

        given().
                port(port).
                contentType("application/json").
                body(jsonBodyOrange).
        when().
                post("/orders").
        then().
                statusCode(200).
                contentType("application/json").
                body("orderTotal",equalTo(1.8F));

        String jsonBodyApple = generateStringFromResource("src/main/resources/json/TC2.json");

        given().
                port(port).
                contentType("application/json").
                body(jsonBodyApple).
                when().
                post("/orders").
                then().
                statusCode(200).
                contentType("application/json").
                body("orderTotal",equalTo(0.75F));
    }

    @Test
    void getOrders() {
        given().
                port(port).
        when().
                get("/orders").
        then().
                statusCode(200).
                body("orderList[0].itemList[0].quantity", equalTo(5)).
                body("orderList[1].itemList[1].quantity",equalTo(3));
    }

    @Test
    void getOrder() {
        given().
                port(port).
        when().
                get("/orders/0/order").
        then().
                statusCode(200).
                body("itemArr[0].quantity", equalTo(5));

        given().
                port(port).
        when().
                get("/orders/1/order").
        then().
                statusCode(200).
        body("itemArr[1].quantity", equalTo(3));

    }

    public String generateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

}
