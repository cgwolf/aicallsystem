package com.aicallsystem.acs.service.impl;

import com.aicallsystem.acs.entity.AcsAccountInfo;
import com.aicallsystem.acs.entity.AcsUserInfo;
import com.aicallsystem.acs.entity.dto.account.CreateAccountDTO;
import com.aicallsystem.acs.entity.dto.account.UserAuthDTO;
import com.aicallsystem.acs.entity.dto.account.UserInfoDTO;
import com.aicallsystem.acs.entity.dto.token.MarkTokenDto;
import com.aicallsystem.acs.exception.SysException;
import com.aicallsystem.acs.exception.SysExceptionEnum;
import com.aicallsystem.acs.mapper.AcsAccountInfoMapper;
import com.aicallsystem.acs.mapper.AcsUserInfoMapper;
import com.aicallsystem.acs.service.IAcsAccountInfoService;
import com.aicallsystem.acs.service.IAcsTokenInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.aicallsystem.acs.util.UserGenerator.userGenerator;
import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * <p>
 * 用户账号表 服务实现类
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Service
public class AcsAccountInfoServiceImpl extends ServiceImpl<AcsAccountInfoMapper, AcsAccountInfo> implements IAcsAccountInfoService {

    @Autowired
    private AcsAccountInfoMapper acsAccountInfoMapper;

    @Autowired
    private IAcsTokenInfoService iAcsTokenInfoService;

    @Autowired
    private AcsUserInfoMapper acsUserInfoMapper;

    @Override
    public MarkTokenDto userAuth(UserAuthDTO userAuthDTO) {

        AcsAccountInfo acsAccountInfo = new AcsAccountInfo();
        copyProperties(userAuthDTO,acsAccountInfo);
        AcsAccountInfo accountInfo = acsAccountInfoMapper.getPassword(acsAccountInfo);

        if( accountInfo==null ){
            throw new SysException(SysExceptionEnum.AUTH_ERROR);
        }

        if( !accountInfo.getPassword().equals(userAuthDTO.getPassword())){
            throw new SysException(SysExceptionEnum.AUTH_ERROR);
        }

        return iAcsTokenInfoService.tokenGenerator(accountInfo);
    }

    @Override
    @Transactional
    public MarkTokenDto createAccount(CreateAccountDTO createAccountDTO) {

        UserInfoDTO userInfo = createAccountDTO.getUserInfo();
        AcsUserInfo acsUserInfo = new AcsUserInfo();
        copyProperties(userInfo,acsUserInfo);

        String userUuid = userGenerator();
        acsUserInfo.setUserUuid(userUuid);

        try{
            acsUserInfoMapper.addUserInfo(acsUserInfo);
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException(SysExceptionEnum.CREATE_ACCOUNT_ERROR);
        }

        UserAuthDTO userAccount = createAccountDTO.getUserAccount();
        AcsAccountInfo acsAccountInfo = new AcsAccountInfo();
        copyProperties(userAccount,acsAccountInfo);
        acsAccountInfo.setUserUuid(userUuid);

        try {
            acsAccountInfoMapper.addAccountInfo(acsAccountInfo);
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException(SysExceptionEnum.CREATE_ACCOUNT_ERROR);
        }

        MarkTokenDto token = iAcsTokenInfoService.tokenGenerator(acsAccountInfo);

        return token;
    }
}
