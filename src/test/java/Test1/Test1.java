package Test1;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ToDoPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test1 extends BaseTests {

    @Test
    public void createToDoTest(){

        //ToDoPage todoPage = homePage.clickVanillaJS();
        //ToDoPage todoPage = homePage.clickTypescript();
        ToDoPage todoPage = homePage.clickEmberJS();
        String firstTodo = "“Automation is fun!”";
        todoPage.writeToDoText("“Automation is fun!”" + Keys.ENTER);
        assertEquals(todoPage.getSizeOfToDoList(),1,"There is not exactly one todo on this page");
        assertTrue(todoPage.readToDoList().contains(firstTodo),"the todo text is wrong");


    }

}
