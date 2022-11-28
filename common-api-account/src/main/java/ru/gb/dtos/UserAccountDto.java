package ru.gb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDto {

    private Long id;
    private Long userId;
    private String name;
    private String currency;


}
