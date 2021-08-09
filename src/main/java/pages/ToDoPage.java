package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoPage {
    private WebDriver driver;
    private By toDoList = By.className("todo-list");
    private By toDoTextInput = By.cssSelector("input[placeholder='What needs to be done?']");
    private By li = By.cssSelector("li");
    private By deleteX = By.className("destroy");
    private By completeCheckbox = By.cssSelector("input[type='checkbox']");
    private By completed = By.linkText("Completed");
    private By all = By.linkText("All");
    private By active = By.linkText("Active");
    private By todoText = By.tagName("label");
    private By todoEdit = By.className("edit");
    private By itemsLeft = By.tagName("span");


    public ToDoPage(WebDriver driver){

        this.driver = driver;
    }

    public void writeToDoText(String text){
        driver.findElement(toDoTextInput).sendKeys(text);
    }

    public boolean isToDoListPresent(){
        return driver.findElements(toDoList).size()>0;
    }

    public List<WebElement> getToDoList(){

        List<WebElement> toDos = new ArrayList<>();
        if(isToDoListPresent()){
            var listOfToDo = driver.findElement(toDoList);
            toDos = listOfToDo.findElements(li);
        }
        return toDos;
    }

    public List<String> readToDoList(){
        return getToDoList().stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public int getSizeOfToDoList(){
        return getToDoList().size();
    }

    public void removeTodo(int index){

        Actions actions = new Actions(driver);
        var todo = getToDoList().get(index);
        actions.moveToElement(todo).perform();
        var xToDelete = todo.findElement(deleteX);
        actions.moveToElement(xToDelete).click().perform();
    }

    public void completeTodo(int index){
        Actions actions = new Actions(driver);
        var todo = getToDoList().get(index);
        actions.moveToElement(todo).perform();
        var checkbox = todo.findElement(completeCheckbox);
        actions.moveToElement(checkbox).click().perform();
    }

    public void toggleCompleted(){
        driver.findElement(completed).click();
    }

    public void toggleAll(){
        driver.findElement(all).click();
    }

    public void toggleActive(){
        driver.findElement(active).click();
    }

    public void editTodo(int index){
        Actions actions = new Actions(driver);
        var todo = getToDoList().get(index);
        actions.moveToElement(todo).perform();
        var labelText = todo.findElement(todoText);
        actions.moveToElement(labelText).doubleClick().perform();
        var editField = todo.findElement(todoEdit);
        editField.sendKeys(Keys.chord(Keys.CONTROL,"a"),"I used to be something else",Keys.ENTER);


    }

    public String getItemsLeft(){
        var spanItemsLeft = driver.findElement(By.tagName("footer")).findElement(itemsLeft);
        return spanItemsLeft.getText();
    }
}