package com.gb.financial.assistant.lib.data.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private long id;
    private long userId;
    private String name;
    private Currency currency;
}
