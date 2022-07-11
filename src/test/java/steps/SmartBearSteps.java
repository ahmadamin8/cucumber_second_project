package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SmartBearPage;
import pages.WebOrdersPage;
import utilities.Driver;
import utilities.DropdownHandler;
import utilities.Waiter;

public class SmartBearSteps {

    WebDriver driver;
    SmartBearPage smartBearPage;
    WebOrdersPage webOrdersPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        smartBearPage = new SmartBearPage();
    }

    @When("user enters username as {string}")
    public void userEntersUsernameAs(String userName) {
        smartBearPage.nameInputBox.sendKeys(userName);

    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        smartBearPage.passwordInputBox.sendKeys(password);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        smartBearPage.loginButton.click();
    }

    @Then("user should see {string} Message")
    public void userShouldSeeMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, smartBearPage.errorMessage.getText());
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String newURL) {
        Assert.assertEquals(newURL, driver.getCurrentUrl());
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable dataTable) {
        for (int i = 0; i < dataTable.asList().size(); i++) {
            Assert.assertTrue(webOrdersPage.webOrderMenuItems.get(i).isDisplayed());

        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button) {
            case "Check All":
                webOrdersPage.checkAllButton.click();
                break;

            case "Uncheck All":
                webOrdersPage.uncheckAllButton.click();
                break;
        }
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (WebElement element : webOrdersPage.allCheckBoxes) {
            Assert.assertFalse(element.isSelected());

        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (WebElement element : webOrdersPage.allCheckBoxes) {
            Assert.assertFalse(element.isSelected());
        }
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String orderButton) {
        switch (orderButton){
            case "Order":
                for (int i = 0; i < webOrdersPage.webOrderMenuItems.size(); i++) {
                    webOrdersPage.webOrderMenuItems.get(i).click();

                }
        }
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String product) {
        Waiter.pause(2);
        DropdownHandler.selectOptionByValue(webOrdersPage.familyAlbum, product);
    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(Integer quantity) {
        webOrdersPage.quantityBox.sendKeys(String.valueOf(quantity));
    }
    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
        webOrdersPage.customerNameBox.sendKeys("Ahmad");
        webOrdersPage.streetBox.sendKeys("FalconRidge Dr");
        webOrdersPage.cityBox.sendKeys("Bridgeview");
        webOrdersPage.stateBox.sendKeys("IL");
        webOrdersPage.zipBox.sendKeys("60455");
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        webOrdersPage.amexButton.click();
        webOrdersPage.cardNumberBox.sendKeys("123456789");
        webOrdersPage.expirationBox.sendKeys("07/22");
        webOrdersPage.processButton.click();
    }
    @And("user clicks on {string} menu items")
    public void userClicksOnMenuItems(String viewOrdersLink) {
        webOrdersPage.viewOrdersLink.click();
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String allInfo) {
        for (int i = 1; i < webOrdersPage.allMyInfoRow.size()-1; i++) {
            Assert.assertTrue(webOrdersPage.allMyInfoRow.get(i).isDisplayed());

        }
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder(DataTable dataTable) {
        for (int i = 1; i < 12; i++) {
            Assert.assertEquals(dataTable.asList().get(i),webOrdersPage.allMyInfoRow.get(i).getText());

        }
    }


    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe(String orders) {
        Assert.assertNotNull(orders);
    }

    @And("validate user sees {string} Message")
    public void validateUserSeesMessage(String emptyOrderMessage) {
        Assert.assertEquals(emptyOrderMessage,webOrdersPage.emptyOrderMessage.getText());
    }
}


