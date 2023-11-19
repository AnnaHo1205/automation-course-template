package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai16 extends BasicTest {

    public void ClickRegisterBtn() {
        WebElement registerBtn = driver.findElement(By.xpath("//*[@name='register']"));
        registerBtn.click();
        Utils.hardWait();
    }

    public void ClickLoginBtn() {
        WebElement loginBtn = driver.findElement(By.xpath("//*[@name='login']"));
        loginBtn.click();
        Utils.hardWait();
    }

    public void verifyTextRegisterAndEmailInvalid() {
        WebElement message = driver.findElement(By.xpath("//*[text()=' Vui lòng cung cấp địa chỉ email hợp lệ.\t\t']"));
        String actual = message.getText().trim();
        String expected = "Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.";
        Assert.assertEquals(expected, actual);
        Utils.hardWait();
        //*[contains(text(),'Vui lòng cung cấp địa chỉ email hợp lệ.')]
        //Assert.assertTrue(errorMessage.contains("Vui lòng cung cấp địa chỉ email hợp lệ"));

    }

    public void InputText(By element, String text) {
        WebElement emailEle1 = driver.findElement(element);
        emailEle1.sendKeys(text);
    }

    public void Launchwebsite() {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(enabled = true)
    public void loginTestBai16() {
        // Launch website
        Launchwebsite();
        // Homework 16
        // Case register
        ClickRegisterBtn();
        verifyTextRegisterAndEmailInvalid();

        // Case emailInvalid
        By emailEle1 = By.id("reg_email");
        String email = "123@456";
        InputText(emailEle1, email);
        ClickRegisterBtn();
        // Verify emailInvalid
        verifyTextRegisterAndEmailInvalid();
        Utils.hardWait();

        // Case emailValid
        WebElement emailEle2 = driver.findElement(By.id("reg_email"));
        emailEle2.clear();
        emailEle2.sendKeys("qwerty@gmail.com");
        ClickRegisterBtn();
        // Verify emailValid
        WebElement messageEmailValid = driver
                .findElement(By.xpath("//*[text()=' Vui lòng nhập mật khẩu tài khoản.\t\t']"));
        String actualEmailValid = messageEmailValid.getText().trim();
        String expectedEmailValid = "Lỗi: Vui lòng nhập mật khẩu tài khoản.";
        Assert.assertEquals(expectedEmailValid, actualEmailValid);

    }
    
}
