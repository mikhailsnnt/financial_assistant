package com.gb.financial.assistant.lib.data.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateDto {
    @NotBlank(message = "Account name is mandatory, and cannot be empty")
    private String name;
    @NotNull(message = "Currency is not specified")
    private Currency currency;
}
