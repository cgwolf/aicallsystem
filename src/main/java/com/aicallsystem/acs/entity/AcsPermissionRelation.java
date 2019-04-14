package com.aicallsystem.acs.entity;

import com.aicallsystem.acs.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限关联表
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="AcsPermissionRelation对象", description="权限关联表")
public class AcsPermissionRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色类型")
    private String roleType;

    @ApiModelProperty(value = "权限id")
    private Integer permissionId;


}
