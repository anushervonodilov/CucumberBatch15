package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AddEmployee extends CommonMethods {


    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        doClick(driver.findElement(By.xpath("//b[text()='PIM']")));

    }
    @When("user click on Add employee button")
    public void user_click_on_add_employee_button() {
        doClick(driver.findElement(By.xpath("//a[text()='Add Employee']")));


    }
    @When("user enters firstname and middle and lastname")
    public void user_enters_firstname_and_middle_and_lastname() {

        //driver.findElement(By.id("firstName")).sendKeys(ConfigReader.getPropertyValue("firstname"));
        WebElement firstnameTextBox=driver.findElement(By.id("firstName"));
        sendText(firstnameTextBox,ConfigReader.getPropertyValue("firstname"));

        //driver.findElement(By.id("middleName")).sendKeys(ConfigReader.getPropertyValue("middlename"));
        WebElement middlenameTextBox=driver.findElement(By.id("middleName"));
        sendText(middlenameTextBox,ConfigReader.getPropertyValue("middlename"));

        //driver.findElement(By.id("lastName")).sendKeys(ConfigReader.getPropertyValue("lastname"));
        WebElement lastnameTextBox=driver.findElement(By.id("lastName"));
        sendText(lastnameTextBox,ConfigReader.getPropertyValue("lastname"));


    }
    @When("user click on save button")
    public void user_click_on_save_button() {
        WebElement saveBtn=driver.findElement(By.id("btnSave"));
        doClick(saveBtn);


    }

}