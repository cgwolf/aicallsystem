package com.aicallsystem.acs.service.impl;

import com.aicallsystem.acs.entity.AcsAccountInfo;
import com.aicallsystem.acs.entity.AcsTokenInfo;
import com.aicallsystem.acs.entity.dto.token.MarkTokenDto;
import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.exception.SysExceptionEnum;
import com.aicallsystem.acs.mapper.AcsTokenInfoMapper;
import com.aicallsystem.acs.service.IAcsTokenInfoService;
import com.aicallsystem.acs.util.TokenGenerator;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
@Component
public class AcsTokenInfoServiceImpl extends ServiceImpl<AcsTokenInfoMapper, AcsTokenInfo> implements IAcsTokenInfoService {

    @Autowired
    private AcsTokenInfoMapper acsTokenInfoMapper;

    @Override
    public MarkTokenDto tokenGenerator(AcsAccountInfo acsAccountInfo) {

        String token = TokenGenerator.tokenGenerator();

        AcsTokenInfo acsTokenInfo = new AcsTokenInfo(token,acsAccountInfo.getUserUuid());

        // 失效之前所有token
        try {
            acsTokenInfoMapper.invalidToken(acsTokenInfo);
        }catch (Exception e){
            throw new SysException(SysExceptionEnum.GENERATOR_TOKEN_ERROR);
        }

        // 生成新的token
        try {
            acsTokenInfoMapper.addToken(acsTokenInfo);
        }catch (Exception e){
            throw new SysException(SysExceptionEnum.GENERATOR_TOKEN_ERROR);
        }

        return new MarkTokenDto(token);
    }

    @Override
    public AcsAccountInfo verifyToken(AcsTokenInfo acsTokenInfo) {
        return acsTokenInfoMapper.verifyToken(acsTokenInfo);
    }
}
