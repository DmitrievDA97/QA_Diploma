package ru.netology.data;

import com.github.javafaker.Faker;

import lombok.Data;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class DataHelper {

    @Value

    public static class CardInfo {
        private String number;
        private String month;
        private String year;
        private String holder;
        private String code;
    }


    public static String getMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }
    public static String getYear() {
        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }
    public static String getLastYear() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }
    public static String getLastMonth() {
        return LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
    }
    public static String getThisYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static Faker faker = new Faker();
    public static String getName() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static CardInfo getCardWithMoney() {
        return new CardInfo("4444444444444441", getMonth(), getYear(), getName(), "777");
    }

    public static CardInfo getCardNoMoney() {
        return new CardInfo("4444444444444442", getMonth(), getYear(), getName(), "777");
    }

    public static CardInfo getCardWithLastMonth() {
        return new CardInfo("4444444444444441", getLastMonth(), getThisYear(), getName(), "777");
    }

    public static CardInfo getCardWithLastYear() {
        return new CardInfo("4444444444444441", getMonth(), getLastYear(), getName(), "777");
    }


}
