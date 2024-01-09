package com.thupq.coffee.utils;

import com.thupq.coffee.exceptions.CustomizeException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * ObjectUtil
 */
@Log4j2
public class ObjectUtil {
    /**
     * cycleEffectDate
     */
    public static List<String> auditFieldDate = Arrays.asList("cycleEffectDate");

    /**
     * trimStringValues
     *
     * @param model Object
     */
    public static void trimStringValues(Object model) {
        for (Field field : model.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(model);
                if (value != null) {
                    if (value instanceof String) {
                        String strValue = (String) value;
                        field.set(model, strValue.trim());
                    }
                }
            } catch (IllegalAccessException e) {
                log.error("error: " + e);
            }
        }
    }

    /**
     * check Long
     *
     * @param str String
     * @return check
     */
    public static boolean isNumbericLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * check Double
     *
     * @param str String
     * @return check
     */
    public static boolean isNumbericDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Ham check map is null or empty
     *
     * @param map Map
     * @param <K> Key
     * @param <V> Object
     * @return boolean
     */
    public static <K, V> boolean isMapEmptyOrNull(Map<K, V> map) {
        return map == null || map.isEmpty();
    }

    /**
     * hàm check trống|null và trả ra ngoại lệ
     *
     * @param value
     * @param errorCode
     * @param errorMessage
     */
    public static void validateAndThrowIfInvalid(String value, String errorCode, String errorMessage) {
        if (StringUtils.isEmpty(value)) {
            throw new CustomizeException(errorCode, errorMessage, HttpStatus.BAD_REQUEST);
        }
    }
}
