package com.thupq.coffee.service.impl;

import com.thupq.coffee.dto.request.appram.ApCreateRequest;
import com.thupq.coffee.dto.request.appram.ApUpdateRequest;
import com.thupq.coffee.dto.request.appram.IdApParamRequest;
import com.thupq.coffee.dto.request.appram.SearchApParamRequest;
import com.thupq.coffee.dto.response.PageResponse;
import com.thupq.coffee.dto.response.ResultResponse;
import com.thupq.coffee.dto.response.apparam.ApParamResponse;
import com.thupq.coffee.entity.ApParam;
import com.thupq.coffee.enums.ErrorCodeEnum;
import com.thupq.coffee.exceptions.CustomizeException;
import com.thupq.coffee.repository.ApParamRepoCustom;
import com.thupq.coffee.repository.ApParamRepository;
import com.thupq.coffee.service.ApParamService;
import com.thupq.coffee.service.mapper.ApParamMapper;
import com.thupq.coffee.utils.ObjectUtil;
import com.thupq.coffee.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApParamServiceImpl implements ApParamService {

    private final ApParamRepository apParamRepository;

    private final ApParamRepoCustom apParamRepoCustom;

    private final ApParamMapper apParamMapper;

    /**
     * Load ap param by group
     *
     * @param groupCode String
     * @param parType   String
     * @return ds ApParam
     */
    public List<ApParam> loadParamByGroup(String groupCode, String parType) {

        if (!StringUtil.isNullOrEmpty(parType)) {
            return this.apParamRepository
                    .findByParGroupAndParType(Optional.ofNullable(groupCode).orElse("").trim().toUpperCase(), parType);
        }

        List<ApParam> apParamList = this.apParamRepository
                .findByParGroup(Optional.ofNullable(groupCode).orElse("").trim().toUpperCase());

        return apParamList;
    }

    @Override
    public ResultResponse<List<ApParam>> searchApParam(SearchApParamRequest searchApParamRequest, Pageable pageable) {
        PageResponse<ApParam> result = apParamRepoCustom.searchApParam(searchApParamRequest, pageable);
        List<ApParam> apParams = result.getContent().stream().map(
                content -> ApParam.builder()
                        .id(content.id)
                        .parGroup(content.getParGroup())
                        .parType(content.getParType())
                        .parName(content.getParName())
                        .parValue(content.getParValue())
                        .description(content.getDescription())
                        .applicationName(content.getApplicationName())
                        .isModify(content.getIsModify())
                        .build()
        ).collect(Collectors.toList());
        return ResultResponse.success(apParams, result.getSize());
    }

    @Override
    @Transactional
    public ApParam create(ApCreateRequest apRequest) throws IllegalAccessException, NoSuchFieldException {
        validApCreateRequest(apRequest);
        ApParam apParam = apParamMapper.toEntityApParam(apRequest);
        ApParam newApParam = apParamRepository.save(apParam);
        return newApParam;
    }

    @Override
    @Transactional
    public ApParam update(Long id, ApUpdateRequest apUpdateRequest) throws IllegalAccessException, NoSuchFieldException {
        validApCreateRequest(apUpdateRequest);
        ApParam apParam = apParamRepository.findById(id)
                .orElseThrow(() -> new CustomizeException(ErrorCodeEnum.AP_PARAM_ID_NOT_EXIST.getCode(),
                        ErrorCodeEnum.AP_PARAM_ID_NOT_EXIST.getMessage(), HttpStatus.BAD_REQUEST));
        ApParam newApParam = apParamRepository.save(apParam);
        return newApParam;
    }

    @Override
    public ApParamResponse getDetail(IdApParamRequest idApParamRequest) {
        ApParam apParam = apParamRepository.findById(Long.valueOf(idApParamRequest.getIdApParam()))
                .orElseThrow(() -> new CustomizeException(ErrorCodeEnum.AP_PARAM_ID_NOT_EXIST.getCode(),
                        ErrorCodeEnum.AP_PARAM_ID_NOT_EXIST.getMessage(), HttpStatus.BAD_REQUEST));

        ApParamResponse response = ApParamResponse.createResponse(apParam);
        return response;
    }

    @Override
    @Transactional
    public ApParam delete(IdApParamRequest idApParamRequest) throws NoSuchFieldException, IllegalAccessException {
        ApParam apParam = apParamRepository.findById(Long.valueOf(idApParamRequest.getIdApParam()))
                .orElseThrow(() -> new CustomizeException(ErrorCodeEnum.AP_PARAM_ID_NOT_EXIST.getCode(),
                        ErrorCodeEnum.AP_PARAM_ID_NOT_EXIST.getMessage(), HttpStatus.BAD_REQUEST));
        apParamRepository.deleteById(Long.valueOf(idApParamRequest.getIdApParam()));
        return apParam;
    }

    @Override
    public List<String> loadValueToSearch(String value) {
        return null;
    }

    /**
     * validate dữ liệu đầu vào : trimspace, check trống
     *
     * @param apRequest ApCreateRequest
     */
    private void validApCreateRequest(ApCreateRequest apRequest) {
        ObjectUtil.trimStringValues(apRequest);

        ObjectUtil.validateAndThrowIfInvalid(apRequest.getParGroup(), ErrorCodeEnum.AP_PARAM_PAR_GROUP_INVALID.getCode(),
                ErrorCodeEnum.AP_PARAM_PAR_GROUP_INVALID.getMessage());

        ObjectUtil.validateAndThrowIfInvalid(apRequest.getParType(), ErrorCodeEnum.AP_PARAM_PAR_TYPE_INVALID.getCode(),
                ErrorCodeEnum.AP_PARAM_PAR_TYPE_INVALID.getMessage());

        ObjectUtil.validateAndThrowIfInvalid(apRequest.getParName(), ErrorCodeEnum.AP_PARAM_PAR_NAME_INVALID.getCode(),
                ErrorCodeEnum.AP_PARAM_PAR_NAME_INVALID.getMessage());

        ObjectUtil.validateAndThrowIfInvalid(apRequest.getParValue(), ErrorCodeEnum.AP_PARAM_PAR_VALUE_INVALID.getCode(),
                ErrorCodeEnum.AP_PARAM_PAR_VALUE_INVALID.getMessage());

        ObjectUtil.validateAndThrowIfInvalid(apRequest.getApplicationName(), ErrorCodeEnum.APP_NAME_IS_NULL.getCode(),
                ErrorCodeEnum.APP_NAME_IS_NULL.getMessage());
    }

    /**
     * validate dữ liệu đầu vào : trimspace, check trống
     *
     * @param request ApUpdateRequest
     */
    private void validApCreateRequest(ApUpdateRequest request) {
        ObjectUtil.trimStringValues(request);

        ObjectUtil.validateAndThrowIfInvalid(request.getApplicationName(), ErrorCodeEnum.APP_NAME_IS_NULL.getCode(),
                ErrorCodeEnum.APP_NAME_IS_NULL.getMessage());
    }
}

