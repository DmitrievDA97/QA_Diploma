package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PurchasePage {
    private SelenideElement heading = $(byText("Оплата по карте"));
    private SelenideElement number = $(".input [placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $(".input [placeholder='08']");
    private SelenideElement year = $(".input [placeholder='22']");
    private SelenideElement code = $(".input [placeholder='999']");
    private SelenideElement proceed = $(byText("Продолжить"));
    private SelenideElement successfullyPurchase = $(withText("Успешно"));
    private SelenideElement errorPurchase = $(withText("Ошибка"));
    private SelenideElement fieldNumber = $$(".input__top").find(text("Номер карты")).parent();
    private SelenideElement fieldMonth = $$(".input__top").find(text("Месяц")).parent();
    private SelenideElement fieldYear = $$(".input__top").find(text("Год")).parent();
    private SelenideElement fieldHolder = $$(".input__top").find(text("Владелец")).parent();
    private SelenideElement fieldCode = $$(".input__top").find(text("CVC/CVV")).parent();
    private SelenideElement holder = fieldHolder.$(".input__control");




    public PurchasePage() {
        heading.shouldBe(Condition.visible);
    }

    public TravelPage travelPurchase(String numberCard, String monthCard, String yearCard, String holderCard, String codeCard) {
        number.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        number.setValue(numberCard);
        month.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        month.setValue(monthCard);
        year.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        year.setValue(yearCard);
        holder.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        holder.setValue(holderCard);
        code.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        code.setValue(codeCard);
        proceed.click();

        return new TravelPage();
    }

    public SelenideElement successfully() {
        return successfullyPurchase.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    public SelenideElement error() {
        return errorPurchase.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }


    public void errorCardNumber() {
        fieldNumber.$(byText("Неверный формат")).shouldBe(Condition.visible);
    }
    public void lastMonth() {
        fieldMonth.$(byText("Истёк срок действия карты")).shouldBe(Condition.visible);
    }
    public void invalidMonth() {
        fieldMonth.$(byText("Неверно указан срок действия карты")).shouldBe(Condition.visible);
    }
    public void lastYear() {
        fieldYear.$(byText("Истёк срок действия карты")).shouldBe(Condition.visible);
    }
    public void invalidHolder() {
        fieldHolder.$(byText("Неверный формат")).shouldBe(Condition.visible);
    }
    public void invalidCode() {
        fieldCode.$(byText("Неверный формат")).shouldBe(Condition.visible);
    }
    public void emptyFields() {
        proceed.click();
        fieldNumber.$(byText("Поле обязательно для заполнения")).shouldBe(Condition.visible);
        fieldMonth.$(byText("Поле обязательно для заполнения")).shouldBe(Condition.visible);
        fieldYear.$(byText("Поле обязательно для заполнения")).shouldBe(Condition.visible);
        fieldHolder.$(byText("Поле обязательно для заполнения")).shouldBe(Condition.visible);
        fieldCode.$(byText("Поле обязательно для заполнения")).shouldBe(Condition.visible);
    }
}
