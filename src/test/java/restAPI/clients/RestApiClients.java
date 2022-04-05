package restAPI.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import restAPI.helpers.TestCaseContext;

import static restAPI.constants.ProjectConstants.API_KEY;
import static restAPI.constants.ProjectConstants.SPACE_ID;


public class RestApiClients { //to get a response

    public static Response createfolder(JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/space/" + SPACE_ID + "/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createList(JSONObject objL){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(objL)
                .when()
                .post("https://api.clickup.com/api/v2/folder/"+ TestCaseContext.getFolder().getId() +"/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response getListInfo(JSONObject objLid){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(objLid)
                .when()
                .get("https://api.clickup.com/api/v2/list/" + TestCaseContext.getList().getIdL())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createTaskOnList(JSONObject objT){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(objT) // in the body we send that object created on RestApSteps
                .when()
                .post("https://api.clickup.com/api/v2/list/"+TestCaseContext.getList().getIdL()+"/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response getTaskInfo(JSONObject objTid){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(objTid)
                .when()
                .get("https://api.clickup.com/api/v2/task/"+ TestCaseContext.getTask().getIdT())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }


    public static Response deleteTask(){      //JSONObject objTdel){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
               // .body()
               // .body(objTdel)
                .when()
                .delete("https://api.clickup.com/api/v2/task/"+ TestCaseContext.getTask().getIdT())  //   https://api.clickup.com/api/v2/task/task_id
                .then().log().all()
                .statusCode(204)
                .extract().response();
    }

    public static Response deleteFolder(){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                // .body()
                .when()
                .delete("https://api.clickup.com/api/v2/folder/"+ TestCaseContext.getFolder().getId())  //   https://api.clickup.com/api/v2/folder/folder_id
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

}
