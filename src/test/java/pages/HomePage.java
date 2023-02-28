package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='menu-item-40']")
    public WebElement shopButon;
    //@FindBy(xpath = "//*[.='Shop']") public WebElement shopButon;
    @FindBy(xpath = "//*[.='Home']")
    public WebElement homeButon;

    @FindBy(xpath = "(//*[@class='n2-ow'])[2]")
    public WebElement sagTus;

    @FindBy(xpath = "//*[@data-id='36']")
    public WebElement kayanResim1;

    @FindBy(xpath = "//*[@data-id='34']")
    public WebElement kayanResim2;

    @FindBy(xpath = "//*[@data-id='35']")
    public WebElement kayanResim3;

    @FindBy(xpath = "//*[@class='woocommerce-LoopProduct-link']")
    public List<WebElement> tumNewArrivals;
    @FindBy(xpath = "//*[@class='cartcontents']")
    public WebElement urunSepeti;

    @FindBy(xpath = "//*[@title='Mastering JavaScript']")
    public WebElement gelenUcuncuResim;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sepeteEkle;
    @FindBy(xpath = "//*[@class='button wc-forward']")
    public WebElement sepetiGöster;
    @FindBy(xpath = "//*[@class='attachment-shop_single size-shop_single wp-post-image']")
    public WebElement eklenenSiparis;

    @FindBy(xpath = "//*[.='Reviews (0)']")
    public WebElement reviewsButon;
    @FindBy(xpath = "//*[.='Description']")
    public WebElement descrıptıonButon;
    @FindBy(xpath = "//*[@id='tab-description']")
    public WebElement urunDescrıptıon;
    @FindBy(xpath = "//*[@id='reply-title']")
    public WebElement urunİncelemesi;
    @FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[1]")
    public WebElement urunFiyati;
    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']")
    public WebElement urunCıkıs;
    @FindBy(xpath = "//*[@data-product_id='165']")
    public WebElement kitapEkle;
    @FindBy(xpath = "//input[@type='number']")
    public WebElement kitapSayisi;
    @FindBy(xpath = "//*[@id='coupon_code']")
    public WebElement kuponKodu;
    @FindBy(xpath = "(//*[@class='button'])[1]")
    public WebElement kuponOnay;
    @FindBy(xpath = "//*[@class='woocommerce-message']")
    public WebElement kuponBasarıMesajı;
    @FindBy(xpath = "//*[@data-title='Coupon: krishnasakinala']")
    public WebElement kuponİndirimi;

    @FindBy(xpath = "//*[@class='woocommerce-error']")
    public WebElement kuponError;

    @FindBy(xpath = "( //*[.=' 350.00'])[1]")
    public WebElement tekUrunFiyat;

    @FindBy(xpath = "(//*[.='×'])[1]")
    public WebElement kitabıKaldir;
    @FindBy(xpath = "//*[@class='cart-empty']")
    public WebElement bosSepetMesaji;
    @FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")
    public WebElement cıkısaDogru;
    @FindBy(xpath = "//*[@step='1']")
    public WebElement yukarıYön;

    @FindBy(xpath = "//*[@name='update_cart']")
    public WebElement sepetiGüncelle;

    @FindBy(xpath = "//*[@class='input-text qty text']")
    public WebElement kitapSayisiniAzalt;

}

