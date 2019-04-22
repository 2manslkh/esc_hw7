package com.example.lib_hw7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.NoSuchElementException;

public class LoginBotWithInvalidValidUser{
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String[] a = {"log!n1","ais98u29h((","*8sh82kk,","LOOOOOOOOGGGGG IN","GO GO IN"};
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        WebElement username = driver.findElement(By.name("identifier"));
        WebElement nextButton = driver.findElement(By.id("identifierNext"));

        for (int i = 0; i < a.length; i++) {
            // Run the fuzz.exe program.
            // fuzz.exe is modified simple-fuzzer.c with a constant output of 32 fuzz chars.
            username.sendKeys(a[i]);
            nextButton.click();
            username.clear();
            Thread.sleep(500);
        }

        username.sendKeys("lim.keng.hin@gmail.com");
        nextButton.click();
        Thread.sleep(1000);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
            WebElement password = driver.findElement(By.name("password"));
            WebElement pwButton = driver.findElement(By.id("passwordNext"));
            password.sendKeys("********");
            pwButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("no password field/button?");
        }
    }
}
