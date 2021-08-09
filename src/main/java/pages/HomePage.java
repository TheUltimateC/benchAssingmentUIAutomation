package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    public ToDoPage clickVanillaJS(){
        clickLink("Vanilla JS");
        return new ToDoPage(driver);
    }

    public ToDoPage clickTypescript(){
        clickLink("TypeScript\n" +
                "+ AngularJS");
        return new ToDoPage(driver);
    }

    public ToDoPage clickEmberJS(){
        clickLink("Ember.js");
        return new ToDoPage(driver);
    }


    private void clickLink(String linkText){

        driver.findElement(By.linkText(linkText)).click();
    }
}
