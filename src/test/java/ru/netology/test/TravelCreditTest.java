package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.CreditPurchasePage;
import ru.netology.page.TravelPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DBHelper.*;


public class TravelCreditTest {
    private TravelPage travelPage;

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
        travelPage = new TravelPage();
    }
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure",new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void creditWithCardSufficientBalance() {
        val card = DataHelper.getCardWithMoney();
        travelPage.purchaseOnCredit();
        val creditPage = new CreditPurchasePage();
        creditPage.travelPurchase(card.getNumber(), card.getMonth(), card.getYear(), card.getHolder(), card.getCode());
        creditPage.successfully();
        assertEquals("APPROVED", getStatusCredit());
    }

    @Test
    void creditWithCardNoSufficientBalance() {
        val card = DataHelper.getCardNoMoney();
        travelPage.purchaseOnCredit();
        val creditPage = new CreditPurchasePage();
        creditPage.travelPurchase(card.getNumber(), card.getMonth(), card.getYear(), card.getHolder(), card.getCode());
        creditPage.error();
        assertEquals("DECLINED", getStatusCredit());
    }

    @Test
    void sendInvalidCardNumber() {
        val card = DataHelper.getCardWithMoney();
        travelPage.purchaseOnCredit();
        val creditPage = new CreditPurchasePage();
        creditPage.travelPurchase("444444444444441", card.getMonth(), card.getYear(), card.getHolder(), card.getCode());
        creditPage.errorCardNumber();
    }
    @Test
    void sendLastMonth() {
        val card = DataHelper.getCardWithLastMonth();
        travelPage.purchaseOnCredit();
        val creditPage = new CreditPurchasePage();
        creditPage.travelPurchase(card.getNumber(), card.getMonth(), card.getYear(), card.getHolder(), card.getCode());
        creditPage.lastMonth();
    }


    @Test
    void sendInvalidMonth() {
        val card = DataHelper.getCardWithMoney();
        travelPage.purchaseOnCredit();
        val creditPage = new CreditPurchasePage();
        creditPage.travelPurchase(card.getNumber(), "13", card.getYear(), card.getHolder(), card.getCode());
        creditPage.invalidMonth();
    }

    @Test
    void sendLastYear() {
        val card = DataHelper.getCardWithLastYear();
        travelPage.purchaseOnCredit();
        val creditPage = new CreditPurchasePage();
        creditPage.travelPurchase(card.getNumber(), card.getMonth(), card.getYear(), card.getHolder(), card.getCode());
        creditPage.lastYear();
    }
    @Test
    void sendInvalidHolder() {
        val card = DataHelper.getCardWithMoney();
        travelPage.purchaseOnCredit();
        val creditPage = new CreditPurchasePage();
        creditPage.travelPurchase(card.getNumber(), card.getMonth(), card.getYear(), "??23?????????", card.getCode());
        creditPage.invalidHolder();
    }
    @Test
    void sendInvalidCode() {
        val card = DataHelper.getCardWithMoney();
        travelPage.purchaseOnCredit();
        val creditPage = new CreditPurchasePage();
        creditPage.travelPurchase(card.getNumber(), card.getMonth(), card.getYear(), card.getHolder(), "77");
        creditPage.invalidCode();
    }
    @Test
    void sendEmptyForm() {
        travelPage.purchaseOnCredit();
        val creditPage = new CreditPurchasePage();
        creditPage.emptyFields();
    }
}

