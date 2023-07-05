package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility
{
    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException
    {
        String name = "option";
        // Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));
        // Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        clickOnElement(By.xpath("//a[text()='Register']"));
        Thread.sleep(1000);
        //selectMyAccountOptions("Register");
        sendTextToElements(By.xpath("//input[@id='input-firstname']"),"john");
        sendTextToElements(By.xpath("//input[@id='input-lastname']"),"david");
        sendTextToElements(By.xpath("//input[@id='input-email']"),"johndavid123@gmail.com");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        clickOnElement(By.xpath("//input[@name='agree']"));
        clickOnElement(By.xpath("//input[@value='Continue']"));
        Thread.sleep(1000);
        // Verify the message “Your Account Has Been Created!”
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        Assert.assertEquals(expectedMessage,actualMessage);
        //Click on Continue Button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(1000);
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOnElement(By.xpath("//a[contains(text(),'Logout')]"));
        // Verify the text “Account Logout”
        String expectedText = "Account Logout";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(1000);
        //Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException
    {
        // Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        clickOnElement(By.xpath("//a[contains(text(),'Login')]"));
        Thread.sleep(1000);
        // Enter Email address
        sendTextToElements(By.xpath("//input[@id='input-email']"), "xyz@gmail.com");
        //Enter Password
        sendTextToElements(By.xpath("//input[@id='input-password']"), "chintz111");
        //Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        Thread.sleep(1000);
        //Verify text “My Account”
        String expectedText = "My Account";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]"));
        // Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(1000);
        // Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]"));
        //Verify the text “Account Logout”
        String expectText = "Account Logout";
        String actuallyText = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals(expectedText,actuallyText);
        // Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @After
    public void tearDown()
    {
        //Close the Browser
        driver.quit();
    }
}
