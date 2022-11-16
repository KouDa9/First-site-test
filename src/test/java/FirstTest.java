import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.*;
import static io.netty.handler.codec.rtsp.RtspHeaders.Values.URL;
import org.openqa.selenium.edge.EdgeDriver;
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
    private final SelenideElement btnOpenContribution = $(By.xpath("//a[@id='btn-show-rates']"));
    private final SelenideElement btnDemoDeposit2 = $(By.xpath("//a[@data-ga-dimension13='Демо депозит №2']"));
    private final SelenideElement amountInput = $(By.xpath("//input[@name='amount']"));
    private final SelenideElement submitBtn = $(By.xpath("//button[@id='submit-button']"));
    private final SelenideElement newDepositConditionCheckBoxInput = $(By.xpath("//input[@name='condition.newDepositConditions']"));
    private final SelenideElement minDaysTwoYearInput = $(By.xpath("//input[@value='733']"));
    private final SelenideElement prolongationCheckBoxInput = $(By.xpath("//input[@name='prolongation']"));
    private final SelenideElement reopenDepositsBtn = $(By.xpath("//a[@href='/deposits/10056/reopen/form']"));
    private final SelenideElement conditionDepositReopenCheckBoxInput = $(By.xpath("//input[@name='condition.deposit.reopen.conditions']"));
    private final SelenideElement messageSpan = $(By.xpath("//span[@class='icon-email']"));
    private final SelenideElement newMessagetBtn = $(By.xpath("//a[@id='new-message-btn']"));
    private final SelenideElement topicNameSelect = $(By.xpath("//select[@name='message.topicName']"));
    private final SelenideElement BUGtopicNameOption = $(By.xpath("//option[@value='BUG']"));
    private final SelenideElement messageTextarea = $(By.xpath("//Textarea[@name='message.text']"));
    private final SelenideElement sendBtn = $(By.xpath("//button[@id='send-button']"));
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
        step4();
        step5();
        step6();
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
    @Step("4. Open deposit")
    public void step4(){
        depositsIndexBut.should(Condition.visible).click();
        btnOpenContribution.should(Condition.visible).click();
        minDaysTwoYearInput.should(Condition.visible).click();
        btnDemoDeposit2.should(Condition.visible).click();
        amountInput.should(Condition.visible).val("110000");
        sleep(1000);
        prolongationCheckBoxInput.should(Condition.visible).click();
        submitBtn.should(Condition.visible).click();
        newDepositConditionCheckBoxInput.should(Condition.visible).click();
    }
    @Step("5. Reissuring deposit")
    public void step5() {
        depositsIndexBut.should(Condition.visible).click();
        reopenDepositsBtn.should(Condition.visible).click();
        conditionDepositReopenCheckBoxInput.should(Condition.visible).click();
        sleep(1000);
        submitBtn.should(Condition.visible).click();
    }
    @Step("6. Send error message")
    public void step6() {
        messageSpan.should(Condition.visible).click();
        newMessagetBtn.should(Condition.visible).click();
        topicNameSelect.should(Condition.visible).click();
        BUGtopicNameOption.should(Condition.visible).click();
        messageTextarea.should(Condition.visible).val("Your site is in a very raw state");
        sendBtn.should(Condition.visible).click();
    }
    @AfterEach
    public void after() {}
}
