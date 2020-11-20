package utils;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HttpMethods {

    private HttpMethods() {
        throw new IllegalStateException("Utility class");
    }

    public static Response postRequest(String endPoint, Map<String, ?> headers, Object content) {
        RequestSpecification request = prepareRequest()
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(content);

        return request
                .when()
                .post(endPoint);
    }

    public static Response getRequest(String endPoint, Map<String, ?> headers) {
        RequestSpecification request = prepareRequest()
                .headers(headers);

        return request
                .when()
                .get(endPoint);
    }

    public static Response deleteRequest(String endPoint, Map<String, ?> headers) {
        RequestSpecification request = prepareRequest()
                .headers(headers);

        return request
                .when()
                .delete(endPoint);
    }

    private static RequestSpecification prepareRequest() {
        return given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());
    }
}
