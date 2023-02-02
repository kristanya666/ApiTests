package tests;

import data.ApiDataHelper;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class APItests {

    RequestSpecification requestSpec = ApiDataHelper.getRequestSpec();
    String path = "booking/";

    @Test
    public void checkStatusCodeOfBooking() {
        var requestBody = ApiDataHelper.getRequestBody(
                "first.last@gmail.com",
                "89969490412",
                1,
                "Kris",
                "Roll",
                false,
                ApiDataHelper.getDate("2023-05-09", "2023-05-10"));

        given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post(path)
                .then()
                .statusCode(201);
    }
}
