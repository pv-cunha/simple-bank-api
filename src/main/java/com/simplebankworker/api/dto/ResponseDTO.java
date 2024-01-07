package com.simplebankworker.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ResponseDTO<T> {

    private final String message;

    private final String code;

    private final T data;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private final LocalDateTime timestamp;

    public ResponseDTO(String message, String code, T data, LocalDateTime timestamp) {
        this.message = message;
        this.code = code;
        this.data = data;
        this.timestamp = timestamp;
    }

    public static <T> ResponseDTO<T> success(String message, String code, T data) {
        return new ResponseDTO<>(message, code, data, LocalDateTime.now());
    }

    public static <T> ResponseDTO<T> error(String message, String code, T data) {
        return new ResponseDTO<>(message, code, data, LocalDateTime.now());
    }
}
