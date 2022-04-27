package org.acme;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProductsResourceTest {

    @Test
    public void testList() {
        given()
                .when().get("/q/health/ready")
                .then()
                .statusCode(200);
    }

}