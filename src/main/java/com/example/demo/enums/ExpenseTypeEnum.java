package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum ExpenseTypeEnum {
    BILL(1L),
    SUBSCRIPTION(4L),
    CONSUMPTION(7L),
    CONSUMPTION_CREDIT(5L);

    private final Long value;

    ExpenseTypeEnum(Long value) {
        this.value = value;
    }

    public static ExpenseTypeEnum fromValue(Long value) {
        for (ExpenseTypeEnum type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + value);
    }
}
