package Test2;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ToDoPage;

import static org.testng.Assert.*;


public class Test2 extends BaseTests {

    @Test
    public void removingToDoTest(){

        ToDoPage todoPage = homePage.clickVanillaJS();
        //ToDoPage todoPage = homePage.clickTypescript();
        //ToDoPage todoPage = homePage.clickEmberJS();
        String firstTodo = "“Automation is fun!”";
        String secondTodo = "“Automation is fun2!”";
        String thirdTodo = "“Automation is fun3!”";
        todoPage.writeToDoText(firstTodo + Keys.ENTER);
        todoPage.writeToDoText(secondTodo + Keys.ENTER);
        todoPage.writeToDoText(thirdTodo + Keys.ENTER);
        int indexOfTodoToDelete = 1;
        todoPage.removeTodo(indexOfTodoToDelete);
        assertEquals(todoPage.getSizeOfToDoList(),2,"There is not exactly two todo's on this page");
        assertFalse(todoPage.readToDoList().contains(secondTodo),"the todo text is still there");


    }

}