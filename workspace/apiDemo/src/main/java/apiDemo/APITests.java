package apiDemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APITests extends BaseTest {

    @Test
    public void testGetUserDetails() {
        setUpAPI();

        // Send GET request to the API
        Response response = RestAssured.given()
                                      .header("Authorization", "Bearer token")
                                      .when()
                                      .get("/users/123");

        // Verify the response
        assert response.getStatusCode() == 200;
        assert response.jsonPath().getString("username").equals("testUser");
    }
}


