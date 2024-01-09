package com.thupq.coffee.controllers;

import com.thupq.coffee.dto.request.appram.ApCreateRequest;
import com.thupq.coffee.dto.request.appram.ApUpdateRequest;
import com.thupq.coffee.dto.request.appram.IdApParamRequest;
import com.thupq.coffee.dto.request.appram.SearchApParamRequest;
import com.thupq.coffee.dto.response.ResultResponse;
import com.thupq.coffee.service.ApParamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller lấy ra ap param
 */
@RequestMapping("/i/ap_param")
@Slf4j
@RestController
@RequiredArgsConstructor
public class ApParamController {

    private final ApParamService apParamService;

    /**
     * Load ap param by group
     *
     * @param groupCode String
     * @param parType   String
     * @return ResponseEntity<Object>
     */
    @RequestMapping(value = "/load-param-by-group", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
            MediaType.ALL_VALUE})
    public ResultResponse<Object> loadParamByGroup(@RequestParam("group-code") String groupCode,
                                                   @RequestParam(value = "par-type", required = false) String parType) {
        return ResultResponse.success(apParamService.loadParamByGroup(groupCode, parType));
    }

    /**
     * API tìm kiếm cấu hình trong bảng ap_param theo: parGroup, parType, parName
     *
     * @param searchApParamRequest
     * @param pageable
     * @return apParamResult
     */
    @PostMapping("/search")
    public ResultResponse<?> search(@RequestBody SearchApParamRequest searchApParamRequest, Pageable pageable) {
        return ResultResponse.success(apParamService.searchApParam(searchApParamRequest, pageable));
    }

    /**
     * tạo thông tin ap_param
     *
     * @param apRequest
     * @return
     */
    @PostMapping("/create")
    public ResultResponse<Object> createApParam(@Valid @RequestBody ApCreateRequest apRequest) throws NoSuchFieldException, IllegalAccessException {
        return ResultResponse.success(apParamService.create(apRequest));
    }

    /**
     * Chi tiết ap_param
     *
     * @param idApParamRequest
     * @return
     */
    @PostMapping("/detail")
    public ResultResponse<Object> detail(@Valid @RequestBody IdApParamRequest idApParamRequest) {
        return ResultResponse.success(apParamService.getDetail(idApParamRequest));
    }

    /**
     * update thông tin ap_param
     *
     * @param id
     * @param apUpdateRequest
     * @return
     */
    @PutMapping("/update/{id}")
    public ResultResponse<Object> update(@PathVariable("id") Long id,
                                         @Valid @RequestBody ApUpdateRequest apUpdateRequest) throws NoSuchFieldException, IllegalAccessException {
        return ResultResponse.success(apParamService.update(id, apUpdateRequest));
    }

    /**
     * Xóa ap_param theo id
     *
     * @param idApParamRequest
     * @return
     */
    @DeleteMapping("/delete")
    public ResultResponse<Object> delete(@Valid @RequestBody IdApParamRequest idApParamRequest) throws NoSuchFieldException, IllegalAccessException {
        return ResultResponse.success(apParamService.delete(idApParamRequest));
    }

}

