package Test5;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ToDoPage;

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



    }

}