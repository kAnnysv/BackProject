package HW4;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class MyTest extends AbstractTest {



    @Test
    void postCuisinePositiveTest() {
        PostResponse response = given().spec(requestSpecification)
                .when()
                .formParam("title","Nigerian Snail Stew")
                .post(getBaseUrl()+"recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(PostResponse.class);
        assertThat(response.getCuisine(), containsString("Italian"));



    }
    @Test
    void postCuisinePositiveTest2() {
        PostResponse response = given().spec(requestSpecification)
                .when()
                .formParam("title", "Berry Banana Breakfast Smoothie")
                .post(getBaseUrl() + "recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(PostResponse.class);
        assertThat(response.getCuisine(), containsString("Italian"));

    }

    @Test
    void postCuisinePositiveTest3() {
        PostResponse response = given().spec(requestSpecification)
                .when()
                .formParam("title", "Lamb and Fresh Goat Cheese Roulade")
                .post(getBaseUrl() + "recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(PostResponse.class);
        assertThat(response.getCuisine(), containsString("German"));

    }

    @Test
    void postCuisinePositiveTest4() {
        PostResponse response = given().spec(requestSpecification)
                .when()
                .formParam("title", "LXocai Irish Cream with Xocai Healthy Dark Chocolate Nuggets")
                .post(getBaseUrl() + "recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(PostResponse.class);
        assertThat(response.getCuisine(), containsString("Irish"));

    }

    @Test
    void postCuisinePositiveTest5() {
        PostResponse response = given().spec(requestSpecification)
                .when()
                .formParam("title", "African Chicken Peanut Stew")
                .post(getBaseUrl() + "recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(PostResponse.class);
        assertThat(response.getCuisine(), containsString("African"));

    }

    @Test

    void getRecipePositiveTest1() {
        Example results = given().spec(requestSpecification)
                .when()
                .formParam("minAlcohol",40)
                .get(getBaseUrl() + "recipes/complexSearch?minAlcohol=40")
                .then()
                .extract()
                .response()
                .body()
                .as(Example.class);
        assertThat(results.getNumber().toString(), containsString("10"));


    }

    @Test

    void getRecipePositiveTest2() {
        Example example = given().spec(requestSpecification)
                .when()
                .formParam("minAlcohol",40)
                .get(getBaseUrl() + "recipes/complexSearch?minAlcohol=40")
                .then()
                .extract()
                .response()
                .body()
                .as(Example.class);
        assertThat(example.getResults().get(0).getNutrition().getNutrients().get(0).getName(), containsString("Alcohol"));
        assertThat(example.getNumber().toString(), containsString("10"));



    }

    @Test

    void getRecipePositiveTest3() {
        Example example = given().spec(requestSpecification)
                .when()
                .formParam("sort","protein")
                .formParam("number",100)
                .get(getBaseUrl() + "recipes/complexSearch?sort=protein&number=100")
                .then()
                .extract()
                .response()
                .body()
                .as(Example.class);
        assertThat(example.getResults().get(0).getImageType(), containsString("jpg"));
        assertThat(example.getResults().get(0).getNutrition().getNutrients().get(0).getName(), containsString("Protein"));
        assertThat(example.getNumber().toString(), containsString("100"));



    }
    @Test

    void getRecipePositiveTest4() {
        Example example = given().spec(requestSpecification)
                .when()
                .formParam("minCaffeine",10)
                .formParam("number",50)
                .get(getBaseUrl() + "recipes/complexSearch?minCaffeine=10")
                .then()
                .extract()
                .response()
                .body()
                .as(Example.class);
        assertThat(example.getResults().get(0).getImageType(), containsString("jpg"));
        assertThat(example.getResults().get(0).getNutrition().getNutrients().get(0).getName(), containsString("Caffeine"));
        assertThat(example.getNumber().toString(), containsString("50"));



    }

    @Test

    void getRecipePositiveTest5() {
        Example example = given().spec(requestSpecification)
                .when()
                .formParam("maxCalories",600)
                .formParam("cuisine", "German")
                .formParam("number",5)
                .get(getBaseUrl() + "recipes/complexSearch?maxCalories=600&cuisine=German")
                .then()
                .extract()
                .response()
                .body()
                .as(Example.class);
        assertThat(example.getResults().get(0).getImageType(), containsString("jpg"));
        assertThat(example.getResults().get(0).getNutrition().getNutrients().get(0).getName(), containsString("Calories"));
        assertThat(example.getNumber().toString(), containsString("5"));



    }









}
