package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gb.utils.CurrencyEnumList;

@SpringBootApplication
public class CommonApiUserAccountApplication {
    public static void main(String[] args) {
        System.out.println(CurrencyEnumList.RUB.value);
        SpringApplication.run(CommonApiUserAccountApplication.class, args);
    }

}
