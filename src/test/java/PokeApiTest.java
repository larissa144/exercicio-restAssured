import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.restassured.http.ContentType;


public class PokeApiTest {

    @Test
    void PokeSucessTest() {
        Response  response =
                given()
                        .when()
                        .get("https://pokeapi.co/api/v2/pokemon/charmander")
                        .then()
                        .contentType(ContentType.JSON).extract().response();
        assertEquals(response.getStatusCode(), 200);
        String PokeName = response.path("name");
        assertEquals(PokeName, "charmander");
    }

    @Test
    void PokeFailTest() {
        Response  response =
                given()
                        .when()
                        .get("https://pokeapi.co/api/v2/pokemon/larissa")
                        .then()
                        .contentType(ContentType.JSON).extract().response();
        assertEquals(response.getStatusCode(), 200);
    }
}
