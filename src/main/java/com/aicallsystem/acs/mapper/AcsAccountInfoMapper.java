package com.aicallsystem.acs.mapper;

import com.aicallsystem.acs.entity.AcsAccountInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户账号表 Mapper 接口
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Mapper
@Component
public interface AcsAccountInfoMapper extends BaseMapper<AcsAccountInfo> {

    AcsAccountInfo getPassword(AcsAccountInfo acsAccountInfo);

    void addAccountInfo(AcsAccountInfo acsAccountInfo);

}
