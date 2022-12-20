package com.gb.financial.assistant.lib.data.account;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Currency {
    RUB("Российские рубли"),
    USD("Доллары США"),
    EUR("Евро");

    public final String humanReadable;
}
