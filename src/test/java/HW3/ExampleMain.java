package HW3;

import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ExampleMain {

    private final String apiKey = "029d45d3b98d47569a8a4885cbac8f82";
    private final String URL = "https://api.spoonacular.com";


    @Test
    void getRequestCuisinePositiveTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        JsonPath response = given()

                .queryParam("apiKey", apiKey)
                .queryParam("cuisine", "Indian")
                .when()
                .get("recipes/complexSearch?cuisine=Indian")
                .body()
                .jsonPath();
        assertThat(response.get("number"), equalTo(10));

    }

    @Test
    void getRequestMinAlcoholPositiveTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("minAlcohol", 40)
                .when()
                .get("recipes/complexSearch?minAlcohol=40")
                .then().log().all()
                .body("results", notNullValue())
                .time(Matchers.lessThan(2000l));


    }

    @Test
    void getRequestTablewarePositiveTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        JsonPath response = given()

                .queryParam("apiKey", apiKey)
                .queryParam("titleMatch", "Crock Pot")
                .when()
                .get("recipes/complexSearch?titleMatch=Crock Pot")
                .body()
                .jsonPath();
        assertThat(response.get("number"), equalTo(10));


    }


    @Test
    void getRecipeCaffeineRequestPositiveTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("maxCaffeine", "20")
                .when()
                .get("recipes/complexSearch?maxCaffeine=20")
                .body()
                .jsonPath();
        assertThat(response.get("results[0].imageType"), equalTo("jpg"));
    }

    @Test
    void getRecipeVitaminCRequestPositiveTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("minVitaminC", "50")
                .queryParam("diet", "vegetarian")
                .when()
                .get("recipes/complexSearch?minVitaminC=50&diet=vegetarian")
                .body()
                .jsonPath();
        assertThat(response.get("results[0].nutrition.nutrients[0].name"), equalTo("Vitamin C"));
    }

    @Test
    void postCuisineRecipesPositiveTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        given()
                .queryParam("apiKey", apiKey)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("title", "Nigerian Snail Stew")
                .when()
                .post("recipes/cuisine")
                .then().log().all()
                .time(Matchers.lessThan(1000l))
                .body("cuisine", equalTo("Mediterranean"));


    }

    @Test
    void postCuisine2RecipesPositiveTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        given()
                .queryParam("apiKey", apiKey)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("title", "Berry Banana Breakfast Smoothie")
                .when()
                .post("recipes/cuisine")
                .then().log().all()
                .time(Matchers.lessThan(1000l))
                .body("cuisine", equalTo("Mediterranean"));


    }

    @Test
    void postCuisine3RecipesPositiveTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        given()
                .queryParam("apiKey", apiKey)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("title", "Lamb and Fresh Goat Cheese Roulade")
                .when()
                .post("recipes/cuisine")
                .then().log().all()
                .time(Matchers.lessThan(1000l))
                .body("cuisine", equalTo("European"));


    }

    @Test
    void postCuisine4RecipesPositiveTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        given()
                .queryParam("apiKey", apiKey)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("title", "Xocai Irish Cream with Xocai Healthy Dark Chocolate Nuggets")
                .when()
                .post("recipes/cuisine")
                .then().log().all()
                .time(Matchers.lessThan(1000l))
                .body("cuisine", equalTo("European"));


    }

    @Test
    void postCuisine5RecipesPositiveTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        given()
                .queryParam("apiKey", apiKey)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("title", "African Chicken Peanut Stew")
                .when()
                .post("recipes/cuisine")
                .then().log().all()
                .time(Matchers.lessThan(1000l))
                .body("cuisine", equalTo("African"));


    }

    @Test
    void addPlanPositiveTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        String id = given()
                .queryParam("apiKey", apiKey)
                .queryParam("hash", "a3da66460bfb7e62ea1c96cfa0b7a634a346ccbf")
                .body("{\n"
                        + " \"date\": 1644881179,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"1 banana\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .when()
                .post("mealplanner/geekbrains/items")
                .then()
                .log().all()
                .body("id", notNullValue())
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("apiKey", apiKey)
                .queryParam("hash", "a3da66460bfb7e62ea1c96cfa0b7a634a346ccbf")
                .delete("mealplanner/geekbrains/items" + id);



    }


}