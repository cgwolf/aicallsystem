package com.aicallsystem.acs.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 *   返回对象
 * </p>
 * @author ispong
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
public class ResultBean<T> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("返回状态  ture为成功/false为失败")
    private boolean status;

    @ApiModelProperty("包含成功或失败信息")
    private String description;

    @ApiModelProperty("返回数据对象")
    private T data;

}
