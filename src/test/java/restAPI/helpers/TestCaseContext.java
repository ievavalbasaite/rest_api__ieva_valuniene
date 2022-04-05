package restAPI.helpers;

import io.cucumber.java.Scenario;
import restAPI.domain.Folder;
import restAPI.domain.List;
import restAPI.domain.Task;

/**To save the information about the Folder, List, Task. Like our LOCAL DATABASE
 * To save the information about the Folder, List, Task. Like our LOCAL DATABASE.
 * During the scenario we save all the information to testFolder (testList, testTask etc),
 * we use that info for our steps, and after scenario method - init() - helps to clear the data.
 * So if new scenario is provided besides the old one, we will use the same methods with variables,
 * and new data will be saved for that particular scenario. After it, deleted again.
 */
public class TestCaseContext {


    private static Folder testFolder;
    private static List testList; //variable where we send info of List
    private static Task testTask;
    private static Scenario scenario;
   // private static String randomName;



    public static void setFolder(Folder testFolder){
        TestCaseContext.testFolder = testFolder;
    }
    public static Folder getFolder () {
        return testFolder;
    }


    public static void setList(List testList){
        TestCaseContext.testList = testList;
    }

    public static List getList(){
        return testList;
    }

    public static void setTask(Task testTask){  //update the task
        TestCaseContext.testTask = testTask;
    }

    public static Task getTask(){
        return testTask;
    }

    public static void setScenario(Scenario scenario){
        TestCaseContext.scenario = scenario;
    }

    public static Scenario getScenario(){
        return scenario;
    }

    // to delete the data
    public static void init() { //initilize
        testFolder = null;
        testList = null;
        testTask = null;
    }



/**
    public static void setString(String randomName){  //update the task
        TestCaseContext.randomName = randomName;
    }

    public static String getString(){
        return randomName;
    }*/

    }
