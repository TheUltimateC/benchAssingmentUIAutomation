package Test3;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ToDoPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test3 extends BaseTests {

    @Test
    public void createToDoTest(){

        //ToDoPage todoPage = homePage.clickVanillaJS();
        //ToDoPage todoPage = homePage.clickTypescript();
        ToDoPage todoPage = homePage.clickEmberJS();
        String firstTodo = "“Automation is fun!”";
        String secondTodo = "“Automation is fun2!”";
        String thirdTodo = "“Automation is fun3!”";
        todoPage.writeToDoText(firstTodo + Keys.ENTER);
        todoPage.writeToDoText(secondTodo + Keys.ENTER);
        todoPage.writeToDoText(thirdTodo + Keys.ENTER);
        int indexOfCompletedTodo =  2;
        todoPage.completeTodo(indexOfCompletedTodo);
        todoPage.toggleCompleted();

        assertEquals(todoPage.getSizeOfToDoList(),1,"There is not exactly one todo completed");
        assertTrue(todoPage.readToDoList().contains(thirdTodo),"the todo text is wrong");


    }

}