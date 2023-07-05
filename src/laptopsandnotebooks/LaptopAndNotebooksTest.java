package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopAndNotebooksTest extends Utility
{
    String baseUrl="http://tutorialsninja.com/demo/index.php";
    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        //Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        // Select Sort By "Price (High > Low)"
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        String expectedMessage="Price (High > Low)";
        String actualMessage =getTextFromElement(By.xpath("//option[text()='Price (High > Low)']"));
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        // Select Sort By "Price (High > Low)"
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        //click on macBook
        clickOnElement(By.xpath("//a[text()='MacBook']"));
        // verify the Macbook Text
        String expectedMessage="MacBook";
        String actualMessage;
        actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        Assert.assertEquals(expectedMessage,actualMessage);
        //click on the Add to card
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedText1 = ("Success: You have added MacBook to your shopping cart!" + "×");
        String actualText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(expectedText1,expectedText1);
        //Click on "shopping cart"display into successMessage
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //Verify the text "Shopping Cart"
        String exps="Shopping Cart  (0.00kg)";
        String acts = getTextFromElement(By.xpath("//h1[contains(text(),'(0.00kg)')]"));
        Assert.assertEquals(exps,acts);
        //Verify the product name "MacBook"
        String exptMacBook= "MacBook";
        String actMacBook = getTextFromElement(By.xpath("(//a[contains(text(),'MacBook')])[2]"));
        Assert.assertEquals(exptMacBook,actMacBook);
        //Change quantity"2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        Thread.sleep(1000);
        sendTextToElements(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");
        //Click On "Update Tab"
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        //Verify the Message "Success: You have modified your shopping cart!”
        String expectedMessage_1 = ("Success: You have modified your shopping cart!" +"×");
        String actualMessage_1 = getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        Assert.assertEquals(expectedMessage_1,actualMessage_1);
        //Verify the total £737.45
        String expectedTotal="£1500";
        String actualTotal=getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        Assert.assertEquals(expectedTotal,actualTotal);
        //Click on "Checkout" Button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        // Verify the text “Checkout”
        String expectedText4 = "Checkout";
        String actualText4 = getTextFromElement(By.xpath("//h1[text()='Checkout']"));
        Assert.assertEquals(expectedText4,actualText4);
        //Verify the text New Customer
        String expectedText5 = "New Customer";
        String actualText5 = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        Assert.assertEquals(expectedText5,actualText5);
        // Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//label[normalize-space()='Register Account']"));
        //Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //Fill the mandatory fields
        sendTextToElements(By.xpath("//input[@id='input-payment-firstname']"), "john");
        sendTextToElements(By.xpath("//input[@id='input-payment-lastname']"), "david");
        sendTextToElements(By.xpath("//input[@id='input-payment-email']"), "jason");
        sendTextToElements(By.xpath("//input[@id='input-payment-telephone']"), "07700017017");
        sendTextToElements(By.xpath("//input[@id='input-payment-password']"),"johndavid@123");
        sendTextToElements(By.xpath("//input[@id='input-payment-confirm']"),"johndavid@123");
        sendTextToElements(By.xpath("//input[@id='input-payment-address-1']"), "111,harrow road");
        sendTextToElements(By.xpath("//input[@id='input-payment-city']"), "London");
        sendTextToElements(By.xpath("//input[@id='input-payment-postcode']"), "HA3 8RP");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "London");
        clickOnElement(By.xpath("//input[@name='agree']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='button-register']"));
        sendTextToElements(By.xpath("//textarea[@name='comment']"),"Order should be delivered on time");
        clickOnElement(By.xpath("//input[@name='agree']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //Verify the message “Warning: Payment method required!”
        String expectedMessage7 = ("Warning: Payment method required!" +"×");
        String actualMessage7 = getTextFromElement(By.xpath("//div[text()='Warning: Payment method required!']"));
        Assert.assertEquals(expectedMessage7,actualMessage7);

    }
    @After
    public void tearDown()
    {
        //Close the Browser
        driver.quit();
    }

}
