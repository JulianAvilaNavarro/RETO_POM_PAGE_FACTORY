package co.com.sofka.page.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonActionOnpages extends BaseSikulix{

    private WebDriver driver;
    private final WebDriverWait explicitWait;


    public CommonActionOnpages(WebDriver driver) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver,120);
    }

    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearText(By locator){driver.findElement(locator).clear();}

    protected void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void pathFile(By locator, String path){
        driver.findElement(locator).sendKeys(path);
    }

    // Usado PAGE FACTORY mediante polimorfismo de sobrecarga
    protected void typeInto(WebElement webElement, String value){
        webElement.sendKeys(value);
    }

    protected void clearText(WebElement webElement){
        webElement.clear();
    }

    protected void click(WebElement webElement){
        webElement.click();
    }

    protected void pathFile(WebElement webElement, String path){
        webElement.sendKeys(path);
    }

    protected void pressEnter(WebElement webElement) {
        webElement.sendKeys(Keys.ENTER);
    }

    protected void clickWait(WebElement webElement){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webElement.click();

    }

    public void scrollTo(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected  String getText (WebElement webElement){

        return webElement.getText();
    }

    protected void implicitWaitTime(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds , TimeUnit.SECONDS);}

    protected void waitForElementToBeInvisible(By locator) {
        var element = driver.findElement(locator);
        this.explicitWait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitToBeClickable(WebElement locator){
        this.explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
    }


}
