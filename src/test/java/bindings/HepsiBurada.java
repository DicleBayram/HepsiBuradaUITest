package bindings;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import static org.junit.Assert.assertTrue;


public class HepsiBurada {

    WebDriver driver;
    public HepsiBurada(){
        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path +"/resources/chromedriver.exe");
    }

    @Given("^Hepsiburada uygulamasina giris yapilir$")
    public void open_the_Chrome_and_launch_the_application() throws Throwable
    {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hepsiburada.com/");
    }

    @When("^Search alanina '(.*)' yazilir$")
    public void set_query(String query) throws Throwable
    {
        driver.findElement(By.className("desktopOldAutosuggestTheme-input")).sendKeys(query);
    }

   @Then("^Query girilen sayfadan sonuc donmesi beklenir$")
    public void click_proceed_to_checkout() throws Throwable
    {
        String url = "ara?q=";
        Boolean isCurrentUrlCorrect = driver.getCurrentUrl().contains(url);
        assertTrue(isCurrentUrlCorrect);
    }
}