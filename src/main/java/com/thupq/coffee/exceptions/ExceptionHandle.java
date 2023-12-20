package com.thupq.coffee.exceptions;

import com.thupq.coffee.enums.ErrorCodeEnum;
import com.thupq.coffee.models.response.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author HungVM
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomizeException.class)
    protected ResponseEntity<?> handleCustomizeException(CustomizeException ex) {
        log.debug("hanle error {}", ex);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        if (ex != null && ex.getHttpStatus() != null) {
            httpStatus = ex.getHttpStatus();
        }
        ResultResponse result = ResultResponse.error400(ex.getCode(), ex.getMessage(), ex.getData());
        return ResponseEntity.status(httpStatus).body(result);
    }

    /**
     * handle exception cho trường hợp file import vượt quá kích thước được cấu hình
     *
     * @param ex Exception
     * @return
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    protected ResponseEntity<?> handleSizeLimitExceededException(Exception ex) {
        log.debug("hanle error {}", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultResponse.error400(
                ErrorCodeEnum.CUSTOMER_REWARD_IMPORT_FILE_EXCEED_MAX_FILE_SIZE.getCode(),
                ErrorCodeEnum.CUSTOMER_REWARD_IMPORT_FILE_EXCEED_MAX_FILE_SIZE.getMessage()));
    }

    /**
     * handle exception cho trường hợp DataIntegrityViolation
     *
     * @param ex Exception
     * @return
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<?> handleDataIntegrityViolationException(Exception ex) {
        log.debug("hanle error {}", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResultResponse.error400(
                ErrorCodeEnum.ERROR_CUSTOMER_PROMOTION_IS_EXITS.getCode(),
                ErrorCodeEnum.ERROR_CUSTOMER_PROMOTION_IS_EXITS.getMessage()));
    }

    /**
     * Handle exception sql
     * @param ex
     * @return
     */
    @ExceptionHandler(SQLSyntaxErrorException.class)
    public ResponseEntity<?> handleSQLSyntaxErrorException(Exception ex) {
        log.error("Handle error SQLSyntaxErrorException {}", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResultResponse.error500());
    }
    /**
     * xử lý exception lỗi bất định khi hệ thống chạy gây lỗi.
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleError(Exception ex) {
        log.error("Handle error Exception {}", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResultResponse.error500());
    }

    /**
     * handle
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Handle exception MethodArgumentNotValidException : ", ex);
        String errorMessage = getErrorMessage(ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ResultResponse.error400(ErrorCodeEnum.DATA_INVALID.getCode(), errorMessage));
    }

    private String getErrorMessage(MethodArgumentNotValidException ex) {
        List<String> errors = getErrors(ex);
        return getMessage(errors);
    }

    private String getMessage(List<String> errors) {
        if (errors == null) {
            return StringUtils.EMPTY;
        }

        int errorSize = errors.size();
        if (errorSize <= 0) {
            return StringUtils.EMPTY;
        }
        String messageError = errors.get(errorSize - 1);

        return messageError;
    }

    private List<String> getErrors(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<String> errors = new ArrayList<String>(fieldErrors.size() + globalErrors.size());

        for (FieldError fieldError : fieldErrors) {
            String error = fieldError.getDefaultMessage();
            errors.add(error);
        }

        for (ObjectError objectError : globalErrors) {
            String error = objectError.getDefaultMessage();
            errors.add(error);
        }

        return errors;
    }
}
