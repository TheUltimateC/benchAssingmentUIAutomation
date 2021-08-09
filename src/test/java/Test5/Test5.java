package Test5;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ToDoPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test5 extends BaseTests {

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
        todoPage.toggleCompleted();
        assertEquals(todoPage.getSizeOfToDoList(),0,"There are todo's on completed while there shouldn't be");
        assertEquals(todoPage.getItemsLeft(),"3 items left", "there isn't the right amount of items left");
        todoPage.toggleAll();
        todoPage.completeTodo(2);
        todoPage.completeTodo(1);
        todoPage.toggleCompleted();
        assertEquals(todoPage.getSizeOfToDoList(),2,"There are todo's on completed while there shouldn't be");

        assertTrue(todoPage.readToDoList().contains("“Automation is fun3!”"), "the third todo has not been been found in the completed list");
        assertTrue(todoPage.readToDoList().contains("“Automation is fun2!”"), "the second todo has not been been found in the completed list");





    }

}