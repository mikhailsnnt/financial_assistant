package ru.gb.utils;

public enum CurrencyEnumList {

    RUB("Российские рубли"),
    USD("Доллары США"),
    EUR("Евро");

    public final String value;

    CurrencyEnumList(String value) {
        this.value = value;
    }


}
