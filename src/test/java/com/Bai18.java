package com;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai18 extends BasicTest{

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
    public void loginTestBai18() {
        // Launch website
        Launchwebsite();

        // Homework 18
        // Case Login
        Login();
        // Way 1
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        // Switch focus to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        // Launch URL in the new tab
        driver.get("https://bantheme.xyz/hathanhauto/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://bantheme.xyz/hathanhauto/");

    }
    
}
