package com.aicallsystem.acs.mapper;

import com.aicallsystem.acs.entity.AcsPermissionInfo;
import com.aicallsystem.acs.entity.AcsUserInfo;
import com.aicallsystem.acs.entity.dto.user.MarkUserDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Mapper
@Component
public interface AcsPermissionInfoMapper extends BaseMapper<AcsPermissionInfo> {

    List<AcsPermissionInfo> getPermission(AcsUserInfo acsUserInfo);
}

