package restAPI.stepdefinitions;

import gherkin.deps.com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;

public class RestApiSteps {
    @Given("I create clickup folder")  //it's able to find a JAVA method which is linked
    public void createFolder(){ //function that return nth, basic method
        System.out.println("We create a ClickUP folder");
  //      JsonObject obj = new JsonObject();


    }
}

@When("I create clickup folder")
public void clickUpCall(){
    JSONObject obj = new JSONObject();
    obj.put("name", "Name of my Folder");
    Response resp = createFolder(obj);
}