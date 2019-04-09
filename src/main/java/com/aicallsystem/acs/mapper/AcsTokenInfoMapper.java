package com.aicallsystem.acs.mapper;

import com.aicallsystem.acs.entity.AcsAccountInfo;
import com.aicallsystem.acs.entity.AcsTokenInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 令牌表 Mapper 接口
 * </p>
 *
 * @author ispong
 * @since 2019-04-04
 */
@Mapper
@Component
public interface AcsTokenInfoMapper extends BaseMapper<AcsTokenInfo> {


    /**
     * <p>
     *     失效所有的token值
     * </p>
     * @param
     * @return
     * @throws
     * @since 4/4/2019
     */
    void invalidToken(AcsTokenInfo acsTokenInfo);

    void addToken(AcsTokenInfo acsTokenInfo);

    AcsAccountInfo verifyToken(AcsTokenInfo acsTokenInfo);
}
