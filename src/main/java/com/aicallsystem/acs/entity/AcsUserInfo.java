package com.aicallsystem.acs.entity;

import com.aicallsystem.acs.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="AcsUserInfo对象", description="用户表")
public class AcsUserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "用户uuid")
    private String userUuid;

    @ApiModelProperty(value = "角色类型")
    private String roleType;

}
