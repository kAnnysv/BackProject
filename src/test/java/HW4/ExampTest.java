package HW4;

import org.junit.jupiter.api.Test;

import static HW4.AbstractTest.requestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ExampTest extends AbstractTest{

    @Test

    void getRecipePositiveTest2() {
        Nutrient nutrient = given().spec(requestSpecification)
                .when()
                .formParam("minAlcohol",40)
                .get(getBaseUrl() + "recipes/complexSearch?minAlcohol=40")
                .then()
                .extract()
                .response()
                .body()
                .as(Nutrient.class);
        assertThat(nutrient.getName(), containsString("Alcohol"));


    }




}
