package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;



import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class TravelPage {


    private SelenideElement heading = $(byText("Путешествие дня"));
    private SelenideElement purchase = $(byText("Купить"));
    private SelenideElement credit = $(byText("Купить в кредит"));


    public TravelPage() { heading.shouldBe(Condition.visible);
    }
    public PurchasePage purchaseByCard() {
        purchase.click();
        return new PurchasePage();
    }

    public CreditPurchasePage purchaseOnCredit() {
        credit.click();
        return new CreditPurchasePage();
    }






}
