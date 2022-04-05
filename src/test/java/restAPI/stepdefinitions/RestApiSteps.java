package restAPI.stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;
import restAPI.domain.Folder;
import restAPI.helpers.TestCaseContext;
import restAPI.domain.List;
import restAPI.domain.Task;


import static restAPI.clients.RestApiClients.*;



public class RestApiSteps {

    @When("I create clickup folder")
    public void clickUpCall() {
        JSONObject obj = new JSONObject();
        obj.put("name", "My Created Folder");
        Response resp = createfolder(obj);
        Folder defaultFolder = resp.as(Folder.class);
        // We create a new folder, and then we say that this folder will take a response and covert this response from text to be using the Folder class
        System.out.println("The folder id is: " + defaultFolder.getId());
        System.out.println("The folder name is: " + defaultFolder.getName());

        TestCaseContext.setFolder(defaultFolder);
        Scenario scenario = TestCaseContext.getScenario();
        scenario.log("We are creating a Folder with name: " + defaultFolder.getName());

        Assertions.assertThat(defaultFolder.getName())
                .as("We check if the FOLDER name is correct!")
                .isEqualTo(TestCaseContext.getFolder().getName()); // or we can have: .isEqualTo("My Created Folder");
        TestCaseContext.setFolder(defaultFolder);

    }

    @Then("I create a list in the folder")
    public void addNewList() {
        JSONObject objL = new JSONObject(); // creates an empty json object
        objL.put("name", "My Created List");  // on that object we put key and value.  onjL.put("description","Smt on desc")
        objL.put("content", "New list content");
        Response resp = createList(objL);  // name from cucumber step
        List defaultList = resp.as(List.class);
        System.out.println("The list id is: " + defaultList.getIdL());
        System.out.println("The list name is: " + defaultList.getNameL());
        Scenario scenario = TestCaseContext.getScenario();
        scenario.log("We are creating a List with name: " + defaultList.getNameL());

        TestCaseContext.setList(defaultList);
    }

    @And("I check if List name is correct and added to correct folder")
    public void iCheckIsListNameIsCorrect() {
        JSONObject objLid = new JSONObject();
        Response resp = getListInfo(objLid);
        List defaultList = resp.as(List.class);

        Assertions.assertThat(defaultList.getNameL())
                .as("We check if the List name is correct!")
                .isEqualTo(TestCaseContext.getList().getNameL());   //.isEqualTo("My Created List");

        Assertions.assertThat(defaultList.getFolderId())
                .as("We check if the new List is on the correct Folder - comparing with Folder's ID!")
                .isEqualTo(TestCaseContext.getList().getFolderId());

        Scenario scenario = TestCaseContext.getScenario();
        scenario.log("We are checking if List with name: " + defaultList.getNameL() + "and is created on the right Folder");

    }


    @Then("In the List I create one Task with automatically generated and unique name")
    public void createTaskOnListWithName() {

        Faker faker = new Faker();  // Creating a Random name for Task. And - yes - it's person's full name :))
        String randomName = faker.name().name();

        JSONObject objT = new JSONObject();
        objT.put("name", randomName);  // Or can simply add Task name by adding "My new Task name"
        objT.put("description", "New Task Description");
        Response resp = createTaskOnList(objT); //convert from the text to the object
        Task defaultTask = resp.as(Task.class);
        TestCaseContext.setTask(defaultTask);
        Scenario scenario = TestCaseContext.getScenario();
        scenario.log("We are creating a Task with random name: " + randomName);
    }

    @And("I check if Task name is correct")
    public void iCheckIfTaskNameIsCorrect() {

        JSONObject objTid = new JSONObject();
        Response resp = getTaskInfo(objTid);
        Task defaultTask = resp.as(Task.class);

        Assertions.assertThat(defaultTask.getNameT())
                .as("We check if the Task name is correct!")
                .isEqualTo(TestCaseContext.getTask().getNameT());
        Scenario scenario = TestCaseContext.getScenario();
        scenario.log("We are checking if Task is created with name: " + defaultTask.getNameT());
    }

    @Then("I remove the task")
    public void RemoveTheTask() {
        deleteTask();
    }

}

     /**JSONObject objTdel = new JSONObject();
        Response resp = deleteTask(objTdel);//objTdel);
        Task defaultTask = resp.as(Task.class); // response save as a class
        TestCaseContext.setTask(defaultTask);*/

/**  @Given("I create clickup folder")  //it's able to find a JAVA method which is linked
     public void createFolder(){ //function that return nth, basic method
        System.out.println("We create a ClickUP folder");
        JsonObject obj = new JsonObject();*/
