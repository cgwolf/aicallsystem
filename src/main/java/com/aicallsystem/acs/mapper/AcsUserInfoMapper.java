package com.aicallsystem.acs.mapper;

import com.aicallsystem.acs.entity.AcsUserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Mapper
@Component
public interface AcsUserInfoMapper extends BaseMapper<AcsUserInfo> {

    void addUserInfo(AcsUserInfo acsUserInfo);
}
