package PageObjectModel;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txtUsername")
    public WebElement userNameTextBox;

    @FindBy(id = "txtPassword")
    public WebElement passwordTextBox;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    @FindBy(id = "welcome")
    public WebElement welcomeIcon;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutLink;

}
