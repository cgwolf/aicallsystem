package com.aicallsystem.acs.entity.dto.contact;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *      添加联系信息VO
 * </p>
 * @author ispong
 * @since 4/7/2019
 * @version 1.0.0
 */
@Data
@ApiModel(description="添加联系方式对象")
public class AddContactDTO {

    @ApiModelProperty(value = "客户姓名")
    private String name;

    @ApiModelProperty(value = "客户电话")
    private String phone;

    @ApiModelProperty(value = "客户邮箱")
    private String email;

    @ApiModelProperty(value = "备注")
    private String remark;
}
