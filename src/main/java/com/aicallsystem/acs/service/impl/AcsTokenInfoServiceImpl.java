package com.aicallsystem.acs.service.impl;

import com.aicallsystem.acs.entity.AcsAccountInfo;
import com.aicallsystem.acs.entity.AcsTokenInfo;
import com.aicallsystem.acs.mapper.AcsTokenInfoMapper;
import com.aicallsystem.acs.service.IAcsTokenInfoService;
import com.aicallsystem.acs.util.TokenGenerator;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 令牌表 服务实现类
 * </p>
 *
 * @author ispong
 * @since 2019-04-04
 */
@Service
public class AcsTokenInfoServiceImpl extends ServiceImpl<AcsTokenInfoMapper, AcsTokenInfo> implements IAcsTokenInfoService {

    @Autowired
    private AcsTokenInfoMapper acsTokenInfoMapper;

    @Override
    public String tokenGenerator(AcsAccountInfo acsAccountInfo) {

        String token = TokenGenerator.tokenGenerator();

        AcsTokenInfo acsTokenInfo = new AcsTokenInfo(token,acsAccountInfo.getUserName());

        // 失效之前所有token
        acsTokenInfoMapper.invalidToken(acsAccountInfo);

        // 生成新的token
        acsTokenInfoMapper.insert(acsTokenInfo);

        return token;
    }
}
