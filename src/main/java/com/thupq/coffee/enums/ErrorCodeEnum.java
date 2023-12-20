package com.thupq.coffee.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    SUCCESS("200", "Successful"),
    SUCCESS_STATUS_CORE("00", "Successful"),
    // #################### Mã thông báo cho http status 4xx khai báo ở đây ############################################
    DATA_INVALID("PRO_400", "Dữ liệu input không đúng "),
    CUSTOMER_REWARD_IMPORT_FILE_EXCEED_MAX_FILE_SIZE("PRO_001",
            "Dung lượng file vượt quá dung lượng được cấu hình"),
    CUSTOMER_REWARD_IMPORT_FILE_PROCESS_IMPORT_ERROR("PRO_002", "Có lỗi xảy ra trong quá trình import file"),
    CUSTOMER_REWARD_IMPORT_FILE_EMPTY_FILE("PRO_003", "File tải lên trống"),
    CUSTOMER_REWARD_IMPORT_FILE_INVALID_FORMAT("PRO_004",
            "File tải lên lỗi do dữ liệu không hợp lệ"),
    IMPORT_FILE_CUSTOMER_REWARD_ERROR("PRO_005",
            "File tải lên không đúng định dạng excel"),
    ERROR_SAVE_CUSTOMER_REWARD_IMPORT_FILE("PRO_006",
            "Có lỗi xảy ra khi lưu CUSTOMER_REWARD_IMPORT_FILE"),
    ERROR_SAVE_CUSTOMER_REWARD("PRO_007",
            "Có lỗi xảy ra khi lưu CUSTOMER_REWARD_IMPORT_FILE"),
    ERROR_UPLOAD_FILE_TO_MINIO("PRO_008",
            "Có lỗi xảy ra khi upload file lên cloud"),
    DATE_SEARCH_INTERVAL_TOO_LARGE("PRO_009",
            "Khoảng thời gian tìm kiếm quá lớn"),
    DATE_SEARCH_PARAMETER_INVALID("PRO_010", "Tham số tìm kiếm theo khoảng thời gian không hợp lệ"),
    DATE_FORMAT_INVALID("PRO_011", "Thời gian không đúng định dạng"),

    PROMOTION_NOT_EXIST("PRO_012", "Không tồn tại chương trình khuyến mãi"),
    PROMOTION_NOT_AVAIlABLE("PRO_013", "Chương trình khuyến mãi không khả dụng"),
    PROMOTION_EXPIRE_DATE("PRO_014", "Chương trình khuyến mãi đã hết hạn"),

    PROMOTION_NOT_APPLY_FOR_USER("PRO_015", "Người dùng không nằm trong danh sách được khuyến mãi"),

    PROMOTION_USER_WARRING("PRO_016", "User chưa login, hoặc có lỗi liên quan đến token người dùng"),

    EXPORT_EXCEL_DATA_FAILED_CODE("PRO_017", "Có lỗi xảy ra khi xuất file excel"),
    CUSTOMER_REWARD_IMPORT_FILE_PROMOTION_CODE_INVALID_FORMAT("PRO_018",
            "File tải lên lỗi do tên CTKM không hợp lệ"),
    CUSTOMER_REWARD_IMPORT_FILE_AMOUNT_OF_TRANSACTION_INVALID_FORMAT("PRO_019",
            "File tải lên lỗi do không đúng định dạng trường số tiền giao dịch "),
    CUSTOMER_REWARD_IMPORT_FILE_CURRENT_VALUE_RECEIVE_INVALID_FORMAT("PRO_019",
            "File tải lên lỗi do không đúng định dạng trường số tiền hưởng khuyến mại "),
    ERROR_CUSTOMER_PROMOTION_IS_EXITS("PRO_020", "Vui lòng kiểm tra dữ liệu import, yêu cầu:\n" +
            "Dữ liệu không trùng, đúng thông tin và đủ thông tin bắt buộc"),
    PROMOTION_CUSTOMER_NOT_FOUND("PRO_021", "Không tìm thấy khách hàng"),

    PROMOTION_CUSTOMER_RECEIVED("PRO_022", "Khách hàng đã nhận thưởng"),
    ERROR_CUSTOMER_REWARD_IMPORT_FILE_DATA_INVALID("PRO_023", "Vui lòng kiểm tra dữ liệu import, yêu cầu:\n" +
            "Dữ liệu phải đúng định dạng trong file mẫu!"),

    PROMOTION_REWARD_WRONG("PRO_024", "Phần thưởng cho ctkm không đúng. vui lòng kiểm tra lại setting hệ thống"),
    CUSTOMER_REWARD_IMPORT_FILE_CUSTOMER_MOBILE_IS_NULL("PRO_025", "Số điện thoại không được để trống"),
    CUSTOMER_REWARD_IMPORT_FILE_CUSTOMER_NAME_IS_NULL("PRO_026", "Tên khách hàng không được để trống"),
    CUSTOMER_REWARD_IMPORT_FILE_AMOUNT_OF_TRANSACTION_INVALID("PRO_027", "Số tiền giao dịch không đúng định dạng"),
    CUSTOMER_REWARD_IMPORT_FILE_CURRENT_VALUE_RECEIVE_INVALID("PRO_028",
            "Số tiền hưởng khuyến mại không đúng định dạng"),
    CUSTOMER_REWARD_IMPORT_FILE_NOT_FOUND_PROMOTION_CODE("PRO_029", "Không tìm thấy CTKM tương ứng với code: "),
    CUSTOMER_REWARD_IMPORT_FILE_NOT_FOUND_PROMOTION_REWARD("PRO_030", "Không tìm thấy PROMOTION_REWARD tương ứng với promotion_id: "),
    CUSTOMER_REWARD_IMPORT_FILE_IS_NOT_EXITS("PRO_031", "Không tìm thấy CUSTOMER_REWARD_IMPORT_FILE tương ứng với id truyền vào "),
    PROMOTION_INVALID_JOIN_PROMOTION_STATUS("PRO_025", "Trạng thái phải đang là chờ duyệt"),
    PROMOTION_OUT_OF_BUDGET_PROMOTION("PRO_026", "Ngân sách chương trình đã hết"),
    PROMOTION_INACTIVE_STATUS("PRO_027", "Chương trình đang không hoạt động"),
    PROMOTION_ADVANCE_PAYMENT_INVALID_DELETE("PRO_028", "Xóa không thành công. Trạng thái của bản ghi không phải là tạo mới."),
    EXPIRED_CAMPAIGN_DATETIME("PRO_029", "Chiến dịch đã hết hạn"),
    INVALID_CAMPAIGN_STATUS("PRO_030", "Trạng thái chiến dịch không hợp lệ"),
    INVALID_RECEIVE_REWARD_DATE("PRO_031", "Ngày nhận thưởng không hợp lệ"),
    PROMOTION_STATUS_CAN_NOT_ADVANCE("PRO_032", "Trạng thái của promotion không thể tạm ứng."),
    PROMOTION_LINMT_ADVANCE("PRO_033", "Hạn mức tạm ứng không đủ."),
    PROMOTION_AMOUNT_ADVANCE_INVALID("PRO_034", "Số tiền hoàn ứng không thỏa mãn điều kiện."),
    PROMOTION__ADVANCE_PAYMENT_NOT_EXIST("PRO_035", "Tạm ứng không tồn tại."),
    PROMOTION__ADVANCE_PAYMENT_EXIST_OTHER_REQUEST("PRO_036", "Có một tạm ứng ở trạng thái tạo mới hoặc chờ duyệt."),
    CUSTOMER_REWARD_IMPORT_FILE_CUSTOMER_MOBILE_INVALID("PRO_037", "Số điện thoại không đúng định dạng"),
    //    CUSTOMER_REWARD_IMPORT_FILE_ETC_ACC_NO_IS_NULL("PRO_038", "Mã TKGT không được để trống"),
//    CUSTOMER_REWARD_IMPORT_FILE_ETC_ACC_NO_INVALID("PRO_039", "Mã TKGT không đúng định dạng"),
    CUSTOMER_REWARD_IMPORT_FILE_REWARD_TYPE_IS_NULL("PRO_040", "Loại trả thưởng không được để trống"),
    CUSTOMER_REWARD_IMPORT_FILE_VOUCHER_CODE_IS_NULL("PRO_041", "Mã trả thưởng không được để trống"),
    CUSTOMER_REWARD_IMPORT_FILE_CAMPAIGN_CODE_IS_NULL("PRO_042", "Mã chiến dịch không được để trống"),
    CUSTOMER_REWARD_IMPORT_FILE_PROMOTION_START_DATE_IS_NULL("PRO_043", "Ngày nhận KM không không được để trống"),
    CUSTOMER_REWARD_IMPORT_FILE_PROMOTION_START_DATE_INVALID("PRO_044", "Ngày nhận KM không đúng định dạng"),
    CUSTOMER_REWARD_IMPORT_FILE_CURRENT_VALUE_RECEIVE_IS_NULL("PRO_045", "Số tiền hưởng khuyến mại không được để trống"),
    CUSTOMER_REWARD_IMPORT_FILE_PROMOTION_CODE_IS_NULL("PRO_046", "Mã CTKM không được để trống"),
    PROMOTION_ADVANCE_PAYMENT_NOT_EXIST("PRO_047", "Tạm ứng không tồn tại."),
    PROMOTION_ADVANCE_PAYMENT_EXIST_OTHER_REQUEST("PRO_048", "Có một tạm ứng ở trạng thái tạo mới hoặc chờ duyệt."),
    PROMOTION_CALL_ACCOUNTING_GET_OTHER_ERROR("PRO_049", "Lỗi bất thường khi gửi thông tin sang kế toán."
            + " Vui lòng kiểm tra kĩ trạng thái trên hệ thống promotion và hệ thống kế toán có thể thao tác đã thực hiện thành công."),

    PROMOTION_ADVANCE_PAYMENT_EXIST_OTHER_REQUEST_HOAN_UNG("PRO_056", "Có một hoàn ứng ở trạng thái tạo mới hoặc chờ duyệt."),
    PROMOTION_STATUS_CAN_NOT_REIMBURSEMENT("PRO_057", "Trạng thái của promotion không thể hoàn ứng."),
    RECORD_NOT_FOUND("PRO_058", "Bản ghi không tồn tại"),
    FILE_TYPE_UPLOAD_NOT_SUPPORT("PRO_059", "File tải lên không được hỗ trợ"),
    ENCODE_BASE64_STRING_ERROR("PRO_060", "Có lỗi trong quá trình mã hóa file"),

    // #################### Mã thông báo cho http status 5xx khai báo ở đây ############################################
    DOCUMENT_FILE_PROCESS_IMPORT_ERROR("PRO_036", "Có lỗi xảy ra trong quá trình import file"),
    PROMOTION_STATUS_IS_INVALID("PRO_051", "Status không hợp lệ"),
    PROMOTION_CODE_WAS_EXISTED("PRO_052", "Mã khuyến mại đã tồn tại"),
    EXISTED_CAMPAIGN_CODE("PRO_053", "Mã chiến dịch đã tồn tại"),
    EXPIRED_CASHBACK_CODE("PRO_054", "Mã trả thưởng đã hết hiệu lực"),
    PROMOTION_CREATE_MASTER_ACCOUNT_FAIL("PRO_055", "Có lỗi xảy ra khi gọi tạo tài khoản promotion"),
    XAPI_KEY_INVALID("000001", "Xapikey không chính xác"),

    UNKNOWN_ERROR("999999", "Hệ thống đang bảo trì, vui lòng liên hệ chăm sóc khách hàng để được tư vấn"),

    INTERNAL_SERVER_ERROR("500", "Hệ thống đang bảo trì, vui lòng liên hệ chăm sóc khách hàng để được tư vấn");

    private String code;
    private String message;
}
