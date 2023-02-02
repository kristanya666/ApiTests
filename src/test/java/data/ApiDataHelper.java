package data;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class ApiDataHelper {
    public static String getRequestBody(String email, String phone, int id, String firstname, String lastname, boolean deposit, JSONObject bookingdates) {
        JSONObject requestBody = new JSONObject()
                .put("email", email)
                .put("phone", phone)
                .put("roomid", id)
                .put("firstname", firstname)
                .put("lastname", lastname)
                .put("depositpaid", deposit)
                .put("bookingdates", bookingdates);
        return requestBody.toString();
    }

    public static JSONObject getDate(String dateIn, String dateOut) {
        JSONObject requestBodyDate = new JSONObject()
                .put("checkin", dateIn)
                .put("checkout", dateOut);
        return requestBodyDate;
    }

    public static RequestSpecification getRequestSpec() {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://automationintesting.online/")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        return requestSpec;
    }
}

