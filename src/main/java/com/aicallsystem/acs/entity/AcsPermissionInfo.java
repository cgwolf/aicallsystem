package com.aicallsystem.acs.entity;

import com.aicallsystem.acs.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="AcsPermissionInfo对象", description="权限表")
public class AcsPermissionInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "权限代码")
    private String code;

    @ApiModelProperty(value = "父级权限代码")
    private String pcode;

    @ApiModelProperty(value = "权限等级")
    private Integer level;

    @ApiModelProperty(value = "权限排序")
    private Integer index;

    @ApiModelProperty(value = "是否有子级权限")
    private Integer isOpen;

    @ApiModelProperty(value = "权限状态")
    private Integer state;


}
