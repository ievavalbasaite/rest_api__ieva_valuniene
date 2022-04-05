package restAPI.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import restAPI.helpers.TestCaseContext;

import static restAPI.clients.RestApiClients.deleteFolder;


public class Hooks {

    @Before
    public void beforeEveryScenario(Scenario scenario) {
          //    TestCaseContext.init(); // will clean all the data before the scenario
        TestCaseContext.setScenario(scenario);
        System.out.println("OUR SCENARIO IS BEGINNING THE WORK!");
    }

    @After
    public void afterEveryScenario() {

        deleteFolder();
        System.out.println("After our steps of scenario are completed, we delete our firstly created Folder.");
        TestCaseContext.init(); // clear all data that we have saved
        System.out.println("OUR SCENARIO IS FINISHING THE WORK!");
    }
}

//    clickUpCall ("Default Folder");
//   deleteTask();