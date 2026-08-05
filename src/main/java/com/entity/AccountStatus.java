package com.entity;

public enum AccountStatus {
    ACTIVE(10, "Активен"),
    BLOCKED(20, "Заблокирован"),
    CLOSED(30, "Закрыт");

    private final Integer code;
    private final String description;

    AccountStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static AccountStatus fromCode(int code) {
        for (AccountStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Неизвестный код статуса: " + code);
    }

    public static AccountStatus fromName(String name) {
        try {
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Неизвестное имя статуса: " + name);
        }
    }
}