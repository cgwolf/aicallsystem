package com.aicallsystem.acs.entity.dto.permission;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetPermissionDTO {

    @ApiModelProperty("1 代理管理/2 Ai机器人/3 加盟管理/4 广告推广")
    private List<Integer> permissions;

}
