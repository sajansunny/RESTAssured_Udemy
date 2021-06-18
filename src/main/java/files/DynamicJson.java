package files;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class DynamicJson {
    @Test
    public void addBook(){
        RestAssured.baseURI = "http://216.10.245.166";
        given().header("Content-Type","application/json").body(Payload.AddBook())
                .when().post("Library/Addbook.php")
    }
}
