package com.thupq.coffee.exceptions;

import com.thupq.coffee.enums.ErrorCodeEnum;
import com.thupq.coffee.models.response.BaseResponse;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Author HungVM
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomizeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String code;
    private String message;
    private BaseResponse data;
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    /**
     * CustomizeException
     * @param code String
     * @param message String
     * @param error String
     * @param httpStatus HttpStatus
     */
    public CustomizeException(String code, String message, String error, HttpStatus httpStatus) {
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    /**
     * CustomizeException
     * @param code String
     * @param message String
     * @param httpStatus HttpStatus
     */
    public CustomizeException(String code, String message, HttpStatus httpStatus) {
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    /**
     * CustomizeException(String code, String message, Object data)
     * @param code String
     * @param message String
     * @param data Object
     */
    public CustomizeException(String code, String message, BaseResponse data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    /**
     * CustomizeException
     * @param code String
     * @param message String
     * @param httpStatus HttpStatus
     * @param data Object
     */
    public CustomizeException(String code, String message, HttpStatus httpStatus, BaseResponse data) {
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
        this.data = data;
    }
    /**
     * CustomizeException(String code, String message)
     * @param code String
     * @param message String
     */
    public CustomizeException(String code, String message) {
        this.message = message;
        this.code = code;
    }

    /**
     * CustomizeException(String code, String message)
     * @param message String
     */
    public CustomizeException(String message) {
        this.message = message;
        this.code = "ERR_400";
    }

    /**
     * CustomizeException exception
     * @param errorCodeEnum mã code
     */
    public CustomizeException(ErrorCodeEnum errorCodeEnum) {
        this.message = errorCodeEnum.getMessage();
        this.code = errorCodeEnum.getCode();
    }

    /**
     * CustomizeException exception
     * @param errorCodeEnum mã code
     * @param httpStatus status http
     */
    public CustomizeException(ErrorCodeEnum errorCodeEnum, HttpStatus httpStatus) {
        this.message = errorCodeEnum.getMessage();
        this.code = errorCodeEnum.getCode();
        this.httpStatus = httpStatus;
    }

    /**
     * CustomizeException(ErrorCode errorCode, Object data)
     * @param errorCodeEnum ErrorCode
     * @param data Object
     */
    public CustomizeException(ErrorCodeEnum errorCodeEnum, BaseResponse data) {
        this.message = errorCodeEnum.getMessage();
        this.code = errorCodeEnum.getCode();
        this.data = data;
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
