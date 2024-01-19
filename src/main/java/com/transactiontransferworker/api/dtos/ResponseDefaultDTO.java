package com.transactiontransferworker.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ResponseDefaultDTO<T> {

    private final String message;

    private final String code;

    private final T data;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private final LocalDateTime timestamp;

    public ResponseDefaultDTO(String message, String code, T data, LocalDateTime timestamp) {
        this.message = message;
        this.code = code;
        this.data = data;
        this.timestamp = timestamp;
    }

    public static <T> ResponseDefaultDTO<T> success(String message, String code, T data) {
        return new ResponseDefaultDTO<>(message, code, data, LocalDateTime.now());
    }

    public static <T> ResponseDefaultDTO<T> error(String message, String code, T data) {
        return new ResponseDefaultDTO<>(message, code, data, LocalDateTime.now());
    }
}
