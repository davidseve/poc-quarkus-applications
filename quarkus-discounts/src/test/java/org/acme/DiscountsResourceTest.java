package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class DiscountsResourceTest {

    @Test
    public void testList() {
        given()
                .when().get("/discounts")
                .then()
                .statusCode(200)
                .body("$.size()", is(1),
                        "name", containsInAnyOrder("Apple"),
                        "price", containsInAnyOrder("2"),
                        "discount", containsInAnyOrder("5%"));
    }

}