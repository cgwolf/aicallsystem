package com.aicallsystem.acs.entity.dto.account;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserInfoDTO {

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "用户性别")
    private String sex;

    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @ApiModelProperty(value = "其他手机号")
    private String otherPhone;

    @ApiModelProperty(value = "用户公司")
    private String company;
}
