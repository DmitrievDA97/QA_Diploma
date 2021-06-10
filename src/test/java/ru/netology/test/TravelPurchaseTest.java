package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchasePage;
import ru.netology.page.TravelPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DBHelper.*;

class TravelPurchaseTest {
    private TravelPage travelPage;

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
        travelPage = new TravelPage();
    }

    @Test
    void purchaseWithCardSufficientBalance() {
        val card = DataHelper.getCardWithMoney();
        travelPage.purchaseByCard();
        val purchasePage = new PurchasePage();
        purchasePage.travelPurchase(card.getNumber(), card.getMonth(), card.getYear(), card.getHolder(), card.getCode());
        purchasePage.successfully();
        assertEquals("APPROVED", getStatusPurchase());
    }

    @Test
    void purchaseWithCardNoSufficientBalance() {
        val card = DataHelper.getCardNoMoney();
        travelPage.purchaseByCard();
        val purchasePage = new PurchasePage();
        purchasePage.travelPurchase(card.getNumber(), card.getMonth(), card.getYear(), card.getHolder(), card.getCode());
        purchasePage.error();
        assertEquals("DECLINED", getStatusPurchase());
    }

    @Test
    void sendInvalidCardNumber() {
        val card = DataHelper.getCardWithMoney();
        travelPage.purchaseByCard();
        val purchasePage = new PurchasePage();
        purchasePage.travelPurchase("444444444444441", card.getMonth(), card.getYear(), card.getHolder(), card.getCode());
        purchasePage.errorCardNumber();
    }
    @Test
    void sendLastMonth() {
        val card = DataHelper.getCardWithLastMonth();
        travelPage.purchaseByCard();
        val purchasePage = new PurchasePage();
        purchasePage.travelPurchase(card.getNumber(), card.getMonth(), card.getYear(), card.getHolder(), card.getCode());
        purchasePage.lastMonth();
    }


    @Test
    void sendInvalidMonth() {
        val card = DataHelper.getCardWithMoney();
        travelPage.purchaseByCard();
        val purchasePage = new PurchasePage();
        purchasePage.travelPurchase(card.getNumber(), "13", card.getYear(), card.getHolder(), card.getCode());
        purchasePage.invalidMonth();
    }

    @Test
    void sendLastYear() {
        val card = DataHelper.getCardWithLastYear();
        travelPage.purchaseByCard();
        val purchasePage = new PurchasePage();
        purchasePage.travelPurchase(card.getNumber(), card.getMonth(), card.getYear(), card.getHolder(), card.getCode());
        purchasePage.lastYear();
    }
    @Test
    void sendInvalidHolder() {
        val card = DataHelper.getCardWithMoney();
        travelPage.purchaseByCard();
        val purchasePage = new PurchasePage();
        purchasePage.travelPurchase(card.getNumber(), card.getMonth(), card.getYear(), "х23оат№", card.getCode());
        purchasePage.invalidHolder();
    }
    @Test
    void sendInvalidCode() {
        val card = DataHelper.getCardWithMoney();
        travelPage.purchaseByCard();
        val purchasePage = new PurchasePage();
        purchasePage.travelPurchase(card.getNumber(), card.getMonth(), card.getYear(), card.getHolder(), "77");
        purchasePage.invalidCode();
    }
    @Test
    void sendEmptyForm() {
        travelPage.purchaseByCard();
        val purchasePage = new PurchasePage();
        purchasePage.emptyFields();
    }
}
