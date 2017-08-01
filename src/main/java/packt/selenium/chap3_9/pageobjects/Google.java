package packt.selenium.chap3_9.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ripon on 11/19/2015.
 */
public class Google {
    private WebDriver driver;
    private String baseURL;

    public Google(WebDriver driver){
        this.driver = driver;
        baseURL = "https://www.bing.com/";
        driver.get(baseURL);
        System.out.println(driver.getTitle());
        if (!driver.getTitle().equals("Bing")){
            throw new WrongPageException("Incorrect page for Google Home page");
        }
    }
    public GoogleSearchPage goToSearchPage(){
        driver.findElement(By.id("sb_form_q")).sendKeys("Mastering Selenium Testing Tools");
		driver.findElement(By.id("sb_form_go")).click();  
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("sb_count")));
        return new GoogleSearchPage(driver);
    }
}