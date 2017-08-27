package com.adhack.adhack.services;

import com.adhack.adhack.models.MarketingCompany;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class FaceBookServiceImpl implements FaceBookService {


    private static WebDriver driver;
    private static String login = "sevostyanovg.d@gmail.com";
    private static String password = "Uthvfy1q2w3e";
    private static String title = "Ваш личный рекламный аккаунт";

    @Override
    public void start(MarketingCompany marketingCompany) throws InterruptedException {

    try {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024,1024));
        driver.get("https://business.facebook.com/");


        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("u_0_0")).click();

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("pagelet_bizbar_megamenu")));

        driver.get("https://www.facebook.com/ads/manager/");

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("_34_m")));
        driver.findElement(By.className("_34_m")).click();

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("AdsCFObjectiveSelectorItemContainer-LINK_CLICKS")));

        driver.findElement(By.id("AdsCFObjectiveSelectorItemContainer-LINK_CLICKS")).click();
        driver.findElement(By.id("AdsCFObjectiveSelectorItemContainer-LINK_CLICKS")).click();

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("textarea._2vli._2vlj._1h26._1h27")).clear();
        driver.findElement(By.cssSelector("textarea._2vli._2vlj._1h26._1h27")).sendKeys(marketingCompany.getCompanyName());
        driver.findElement(By.cssSelector("button._271k._271m._1qjd")).click();
        Thread.sleep(6000);
        List<WebElement> list = driver.findElements(By.cssSelector("li._3b66._3ujh"));


        Thread.sleep(3000);


        list.get(list.size()-1).click();
        Thread.sleep(6000);

        driver.findElement(By.cssSelector("div._5vz5._5vz6._5yk1 div._5yk2")).click();
        driver.findElement(By.cssSelector("div._5vz5._5vz6._5yk1 div._5yk2")).sendKeys(marketingCompany.getLongDescription());

        Thread.sleep(6000);

        driver.findElement(By.cssSelector("span label._55r1._58ak._3ct8 input")).sendKeys(marketingCompany.getTargetLink());
        driver.findElement(By.cssSelector("span label._55r1._58ak._3ct8 input")).sendKeys(Keys.ENTER);


        Thread.sleep(6000);


        List<WebElement> webElements = driver.findElements(By.cssSelector("button._271k._271m._1qjd"));
        webElements.get(webElements.size()-1).click();
    } catch (Exception e){
        System.err.println("WARNING!!!");
        System.err.println("WARNING!!!");
        System.err.println("WARNING!!!");
    }


    }
}
