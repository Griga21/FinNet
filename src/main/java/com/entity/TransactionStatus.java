package com.entity;

public enum TransactionStatus {
    PENDING(10, "Ожидает обработки"),      // Ожидает обработки
    PROCESSING(20, "В процессе выполнения"),   // В процессе выполнения
    COMPLETED(30, "Успешно завершена"),    // Успешно завершена
    FAILED(40, "Ошибка при выполнении"),       // Ошибка при выполнении
    CANCELLED(50, "Отменена"),    // Отменена (пользователем или системой)
    REVERSED(60, "Откат"),     // Откат (возврат средств после COMPLETED)
    DECLINED(70, "Отклонена"),     // Отклонена (например, недостаточно средств)
    EXPIRED(80, "Истекло время ожидания");
    private final int code;
    private final String description;

    TransactionStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }
    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TransactionStatus fromCode(int code) {
        for (TransactionStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Неизвестный код статуса: " + code);
    }

    public static TransactionStatus fromName(String name) {
        try {
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Неизвестное имя статуса: " + name);
        }
    }
}
