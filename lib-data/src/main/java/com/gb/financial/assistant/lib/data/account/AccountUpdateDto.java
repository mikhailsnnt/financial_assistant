package com.gb.financial.assistant.lib.data.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountUpdateDto {
    private String name;
    private String currencyCode;
}
