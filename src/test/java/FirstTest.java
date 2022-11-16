import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {
    WebDriver driver;
    private static final String baseUrl = "https://idemo.bspb.ru/";
    private final SelenideElement loginInput = $(By.xpath("//input[@name='username']"));
    private final SelenideElement passwordInput = $(By.xpath("//input[@name='password']"));
    private final SelenideElement loginBtn = $(By.xpath("//button[@id='login-button']"));
    private final SelenideElement codeInput = $(By.xpath("//input[@id='otp-code']"));
    private final SelenideElement codeBtn = $(By.xpath("//button[@id='login-otp-button']"));
    private final SelenideElement bankOverviewBut = $(By.xpath("//a[@id='bank-overview']"));
    private final SelenideElement accountsIndexBut = $(By.xpath("//a[@id='accounts-index']"));
    private final SelenideElement paymentsFormBut = $(By.xpath("//a[@id='payments-form']"));
    private final SelenideElement cardsOverviewIndexBut = $(By.xpath("//a[@id='cards-overview-index']"));
    private final SelenideElement depositsIndexBut = $(By.xpath("//a[@id='deposits-index']"));
    private final SelenideElement loansIndexBut = $(By.xpath("//a[@id='loans-index']"));
    private final SelenideElement externaltraderoomIndexBut = $(By.xpath("//a[@id='externaltraderoom-index']"));
    private final SelenideElement insuranceTraveBut = $(By.xpath("//a[@id='insurance-travel']"));

    @BeforeAll
    static void beforeConfig() {
        WebDriverManager.edgedriver().setup();
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
    public void before() {
        open(baseUrl);
    }
    @Test
    public void test() {
        step1();
        step2();
        step3();
    }
    @Step("1. Authorization")
    public void step1(){
        loginInput.should(Condition.visible).val("demo");
        passwordInput.should(Condition.visible).val("demo");
        loginBtn.should(Condition.visible).click();
    }
    @Step("2. Confirmation code")
    public void step2(){
        codeInput.should(Condition.visible).val("0000");
        codeBtn.should(Condition.visible).click();
    }
    @Step("3. Checking values in main menu")
    public void step3(){
        bankOverviewBut.should(Condition.text("Обзор")).click();
        accountsIndexBut.should(Condition.text("Счета")).click();
        paymentsFormBut.should(Condition.text("Платежи и Переводы")).click();
        cardsOverviewIndexBut.should(Condition.text("Карты")).click();
        depositsIndexBut.should(Condition.text("Вклады")).click();
        loansIndexBut.should(Condition.text("Кредиты")).click();
        externaltraderoomIndexBut.should(Condition.text("Валюта")).click();
        insuranceTraveBut.should(Condition.text("Страхование")).click();
    }
    @AfterEach
    public void after() {}
}
