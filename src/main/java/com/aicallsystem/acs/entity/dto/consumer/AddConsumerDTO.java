package com.aicallsystem.acs.entity.dto.consumer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *      添加客户信息DTO
 * </p>
 * @author ispong
 * @since 5/4/2019
 * @version 1.0.0
 */
@Data
public class AddConsumerDTO {

    @ApiModelProperty(value = "客户姓名")
    private String name;

    @ApiModelProperty(value = "客户公司")
    private String company;

    @ApiModelProperty(value = "客户电话 ")
    private String phone;

    @ApiModelProperty(value = "客户性别")
    private String sex;

    @ApiModelProperty(value = "客户意向等级")
    private String rankString;

    @ApiModelProperty(value = "批次号")
    private String batch;

    @ApiModelProperty(value = "备注")
    private String remark;
}
