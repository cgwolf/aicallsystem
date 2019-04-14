package com.aicallsystem.acs.service;

import com.aicallsystem.acs.entity.AcsPermissionInfo;
import com.aicallsystem.acs.entity.dto.permission.GetPermissionDTO;
import com.aicallsystem.acs.entity.dto.user.MarkUserDto;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
public interface IAcsPermissionInfoService extends IService<AcsPermissionInfo> {

    GetPermissionDTO getPermission(MarkUserDto markUserDto);
}
