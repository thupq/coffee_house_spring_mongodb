package com.thupq.coffee.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * BaseResponse: các response khác extends từ class này
 */
@Data
@AllArgsConstructor
@SuperBuilder
public class BaseResponse implements Serializable {

}
