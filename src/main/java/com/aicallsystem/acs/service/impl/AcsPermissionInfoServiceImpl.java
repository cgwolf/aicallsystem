package com.aicallsystem.acs.service.impl;

import com.aicallsystem.acs.entity.AcsPermissionInfo;
import com.aicallsystem.acs.entity.AcsUserInfo;
import com.aicallsystem.acs.entity.dto.permission.GetPermissionDTO;
import com.aicallsystem.acs.entity.dto.user.MarkUserDto;
import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.exception.SysExceptionEnum;
import com.aicallsystem.acs.mapper.AcsPermissionInfoMapper;
import com.aicallsystem.acs.service.IAcsPermissionInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Service
public class AcsPermissionInfoServiceImpl extends ServiceImpl<AcsPermissionInfoMapper, AcsPermissionInfo> implements IAcsPermissionInfoService {

    @Autowired
    private AcsPermissionInfoMapper acsPermissionInfoMapper;

    @Override
    public GetPermissionDTO getPermission(MarkUserDto markUserDto) {

        AcsUserInfo userInfo = new AcsUserInfo();
        copyProperties(markUserDto,userInfo);
        List<AcsPermissionInfo> permissionList = acsPermissionInfoMapper.getPermission(userInfo);
        if(permissionList==null){
            throw new SysException(SysExceptionEnum.GET_PERMISSION_ERROR);
        }
        GetPermissionDTO getPermissionDTO = new GetPermissionDTO();
        List<Integer> permissions = new ArrayList();
        for(AcsPermissionInfo acsPermissionInfo:permissionList){
            permissions.add(acsPermissionInfo.getId());
        }
        getPermissionDTO.setPermissions(permissions);
        return getPermissionDTO;
    }
}
