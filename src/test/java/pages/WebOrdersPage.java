package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class WebOrdersPage {
    public WebOrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#ctl00_menu>li>a")
    public List<WebElement> webOrderMenuItems;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllButton;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr//td[1]")
    public List <WebElement> allCheckBoxes;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement familyAlbum;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    public WebElement amexButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumberBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expirationBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(linkText = "View all orders")
    public WebElement viewOrdersLink;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td")
    public List<WebElement> allMyInfoRow;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement emptyOrderMessage;






}
