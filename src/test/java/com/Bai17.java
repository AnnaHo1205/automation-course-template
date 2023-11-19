package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai17 extends BasicTest{

    public void ClickLoginBtn() {
        WebElement loginBtn = driver.findElement(By.xpath("//*[@name='login']"));
        loginBtn.click();
        Utils.hardWait();
    }


    public void InputText(By element, String text) {
        WebElement emailEle1 = driver.findElement(element);
        emailEle1.sendKeys(text);
    }

    public void Login() {
        By userNameEle = By.xpath("//*[@name='username']");
        String username = "huou@gmail.com";
        InputText(userNameEle, username);
        By passEle = By.xpath("//*[@name='password']");
        String pass = "Huou123@123";
        InputText(passEle, pass);
        ClickLoginBtn();

    }

    public void Launchwebsite() {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(enabled = true)
    public void loginTestBai17() {
        // Launch website
        Launchwebsite();
        Login();
        WebElement exitElement = driver.findElement(By.xpath("//*[text()='Thoát']"));
        Actions action = new Actions(driver);
        action.moveToElement(exitElement).click(exitElement).build().perform();
        Utils.hardWait();
        // click browser back button
        driver.navigate().back();
        Utils.hardWait();
        WebElement verifyHeader = driver.findElement(By.xpath("//h1[contains(text(),'Tài khoản')]"));
        Assert.assertTrue(verifyHeader.isDisplayed());

    }
    
}
