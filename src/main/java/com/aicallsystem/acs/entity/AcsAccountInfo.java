package com.aicallsystem.acs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *      用户验证对象
 * </p>
 * @author ispong
 * @since 4/3/2019
 * @version 1.0.0
 */
@Data
@ApiModel(value="AcsContactInfo对象", description="联系我们信息")
public class AcsAccountInfo {

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String password;
}
