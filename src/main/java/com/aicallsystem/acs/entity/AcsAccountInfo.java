package com.aicallsystem.acs.entity;

import com.aicallsystem.acs.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户账号表
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="AcsAccountInfo对象", description="用户账号表")
public class AcsAccountInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private String userUuid;

    @ApiModelProperty(value = "用户账号")
    private String account;

    @ApiModelProperty(value = "账号密码")
    private String password;

    @ApiModelProperty(value = "账号状态")
    private Integer state;


}
