package com.thupq.coffee.dto.response;

import com.thupq.coffee.enums.ErrorCodeEnum;
import lombok.*;

/**
 * Class chung cấu trúc trả ra api cho client.
 *
 * @param <T> data trả ra
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultResponse<T> {
    private String message;
    private String code;
    private T data;

    /**
     * Hàm trả ra kết quả thành công cho api, với data trả ra là rỗng.
     *
     * @param <T>
     * @return ResultResp
     */
    public static <T extends BaseResponse> ResultResponse<T> success() {
        return success(ErrorCodeEnum.SUCCESS.getCode(), ErrorCodeEnum.SUCCESS.getMessage(), null);
    }

    /**
     * Hàm trả ra kết quả thành công cho api
     *
     * @param result ResultResp
     * @param <T>    ResultResp
     * @return ResultResp
     */
    public static <T> ResultResponse<T> success(T result) {
        return success(ErrorCodeEnum.SUCCESS.getCode(), ErrorCodeEnum.SUCCESS.getMessage(), result);
    }

    /**
     * Hàm trả ra kết quả api thành công.
     *
     * @param message message
     * @param code    code
     * @param data    data
     * @param <T>     ResultResp
     * @return ResultResp
     */
    public static <T> ResultResponse<T> success(String code, String message, T data) {
        return ResultResponse.<T>builder()
                .code(code)
                .message(message)
                .data(data)
                .build();
    }

    public static <T extends BaseResponse> ResultResponse<T> error400(String code, String message) {
        return ResultResponse.error(code, message, null);
    }

    public static <T extends BaseResponse> ResultResponse<T> error400(String code, String message, T data) {
        return ResultResponse.error(code, message, data);
    }

    public static <T extends BaseResponse> ResultResponse<T> businessError(String code, String message, T data) {
        return ResultResponse.error(code, message, data);
    }

    public static <T extends BaseResponse> ResultResponse<T> error500() {
        return ResultResponse.<T>builder()
                .code(ErrorCodeEnum.UNKNOWN_ERROR.getCode())
                .message(ErrorCodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }

    private static <T extends BaseResponse> ResultResponse<T> error(String code, String message, T data) {
        return ResultResponse.<T>builder()
                .code(code)
                .message(message)
                .data(data)
                .build();
    }
}
