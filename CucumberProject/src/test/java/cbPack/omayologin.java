 

package cbPack;

 

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

 

public class omayologin {

           

            WebDriver driver;

           

            @Given("^I navigate to omayo website$")

            public void I_navigate_to_omayo_website()  {

               

                        System.setProperty("webdriver.chrome.driver", "chromedriver//chromedriver.exe");
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                    
                        driver.get("http://omayo.blogspot.com");                    

            }

 

            @When("^I enter Username is \"([^\"]*)\" and Password is \"([^\"]*)\" into the fields$")

            public void I_enter_Username_and_Password(String username, String password)  {

                        driver.findElement(By.name("userid")).sendKeys(username);
                        driver.findElement(By.name("pswrd")).sendKeys(password);


            }

 

            @And("^I click on Login button$")

            public void I_click_on_Login_button() throws InterruptedException  {
           

                        driver.findElement(By.cssSelector("input[type='button'][value='Login']")).click();
                        Thread.sleep(3000);

            }

 

 

            @Then("^User should login based on expected \"([^\"]*)\" status$")

            public void User_should_login_based_on_expected_status(String expectedStatus)  {

             

                        String ExpectedLoginStatus = expectedStatus;
                        String actualLoginStatus = null;

                         try{
                                   Alert alert = driver.switchTo().alert();
                                   String AlertName = alert.getText();

                                    if(AlertName.equals("Error Password or Username")) {
                                          actualLoginStatus ="failure";
                                }

                                               
                        }catch(Exception e){
                        	
                                  actualLoginStatus = "success";
                                  
                        }

       
                        if(actualLoginStatus.equals(ExpectedLoginStatus)) {

                      //test case will pass

                        }else {
                               Assert.fail("Omayo Login test has failed");

                        }
                             driver.quit();

            }

 

           

 

 

}