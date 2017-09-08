package com.huizhi.common.result;

/**
 * 返回工厂类
 */
public class ResultDtoFactory {

    private static final int SUCCESS_COMMON_CODE = 0;
    private static final String SUCCESS_COMMON_MESSAGE = "success";
    
    private ResultDtoFactory() {
    }

    public static ResultDto toSuccess(){
        ResultDto dto = new ResultDto();
        dto.setCode(SUCCESS_COMMON_CODE);
        dto.setMessage(SUCCESS_COMMON_MESSAGE);
        return dto;
    }

    public static ResultDto toSuccess(String message) {
        ResultDto dto = new ResultDto();
        dto.setCode(SUCCESS_COMMON_CODE);
        dto.setMessage(message);
        return dto;
    }

    public static ResultDto toSuccessData(Object data) {
        ResultDto dto = new ResultDto();
        dto.setCode(SUCCESS_COMMON_CODE);
        dto.setMessage(SUCCESS_COMMON_MESSAGE);
        dto.setData(data);
        return dto;
    }

    public static ResultDto toSuccess(String message, Object data) {
        ResultDto dto = new ResultDto();
        dto.setCode(SUCCESS_COMMON_CODE);
        dto.setData(data);
        dto.setMessage(message);
        return dto;
    }

    /**
     * 失败统一定义在 ResultEnum 中
     * @see ResultEnum
     * @param resultEnum
     * @return
     */
    public static ResultDto toError(ResultEnum resultEnum) {
        ResultDto dto = new ResultDto();
        dto.setCode(resultEnum.getCode());
        dto.setMessage(resultEnum.getMessage());
        return dto;
    }

    public static ResultDto toError(int code, String message) {
        ResultDto dto = new ResultDto();
        dto.setCode(code);
        dto.setMessage(message);
        return dto;
    }
}
