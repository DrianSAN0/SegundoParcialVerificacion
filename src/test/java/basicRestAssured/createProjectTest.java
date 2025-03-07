package basicRestAssured;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class createProjectTest {


    /**
     * given()-> configuracion
     * headers /params/auth/body/logs
     * when()--> request
     * method(GET/PATH/DELETE/POST u otro)/url
     *then()--response
     * code response/mensaje response / headers response
     * body response
     * verification
     * extraer datos***
     *
     */
    @Test
    @DisplayName("Verify Create Project by API - Todo.ly")
    public void verifyCreateProject(){
        given()
                .auth()
                .preemptive()
                .basic("api2024@2024.com","12345")
                .body("{\n" +
                        "   \"Content\":\"AdrianSanchez\",\n" +
                        "   \"Icon\":6\n" +
                        "}")
                .log().all()
                .when()
                .post("https://todo.ly/api/projects.json")
                .then()
                .log().all();
    }


    @Test
    @DisplayName("Verify Create Project by API - Todo.ly StringBody")
    public void verifyCreateProjectStringBody(){
        given()
                .auth()
                .preemptive()
                .basic("api2024@2024.com","12345")
                .body("{\n" +
                        "   \"Content\":\"AdrianSanchez\",\n" +
                        "   \"Icon\":6\n" +
                        "}")
                .log().all()
                .when()
                .post("https://todo.ly/api/projects.json")
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify Create Project by API - Todo.ly JSONObject")
    public void verifyCreateProjectJSONObject(){
        JSONObject body = new JSONObject();
        body.put("Content","RESTJsonBody");
        body.put("Icon", 7);
        given()
                .auth()
                .preemptive()
                .basic("api2024@2024.com","12345")
                .body(body.toString())
                .log().all()
        .when()
                .post("https://todo.ly/api/projects.json")
        .then()
                .log().all();
    }
    @Test
    @DisplayName("Verify Create Project by API - Todo.ly ExternalFile")
    public void verifyCreateProjectExternalFile(){
        String fileBodyPath =new File("").getAbsolutePath()+"/src/test/resources/CreateProjectBody.json";
        JSONObject body = new JSONObject();
        body.put("Content","RESTJsonBody");
        body.put("Icon", 7);
        given()
                .auth()
                .preemptive()
                .basic("api2024@2024.com","12345")
                .body(new File(fileBodyPath))
                .log().all()
        .when()
                .post("https://todo.ly/api/projects.json")
        .then()
                .log().all();
    }

}
