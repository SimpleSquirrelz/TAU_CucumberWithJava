package steps;

import base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Steps extends BaseUtil {

    private WebDriver driver;
    private BaseUtil baseUtil;

    public Steps(BaseUtil baseUtil){
        this.baseUtil = baseUtil;
    }

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Given("I am in the login page")
    @Given("I am in the login page of Para Bank Application")
    public void openLoginPage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid {string} and {string} with {string}")
    public void enterCredentials(String username, String password, String userFullName){
        baseUtil.userFullName = userFullName;
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();
    }

    @When("I enter valid credentials")
    public void enterCredentials() {
        driver.findElement(By.name("username")).sendKeys("test123");
        driver.findElement(By.name("password")).sendKeys("test123");
        driver.findElement(By.name("username")).submit();
    }

    @When("I enter valid credentials")
    public void enterCredentials(DataTable table) {
        List<String> loginForm = table.asList();

        driver.findElement(By.name("username")).sendKeys(loginForm.get(0));
        driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
        driver.findElement(By.name("username")).submit();
    }

    @When("I enter valid {string} and {string}")
    public void enterCredentials(String username, String password){
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();
    }

    @Then("^I should be taken to the Overview page")
    public void openOverviewPage() throws InterruptedException {

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/h1")).isDisplayed();
        driver.findElement(By.linkText("Log out")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
