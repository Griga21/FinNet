package com.entity;

public enum TransactionType {
    ENROLLMENT(10, "Зачисление"),
    WITHDRAWAL(20, "Списание");

    private final int code;
    private final String description;

    TransactionType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TransactionType fromCode(int code) {
        for (TransactionType status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Неизвестный код статуса: " + code);
    }

    public static TransactionType fromName(String name) {
        try {
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Неизвестное имя статуса: " + name);
        }
    }
}
