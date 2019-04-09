package com.aicallsystem.acs.service;

import com.aicallsystem.acs.entity.AcsAccountInfo;
import com.aicallsystem.acs.entity.dto.account.CreateAccountDTO;
import com.aicallsystem.acs.entity.dto.account.UserAuthDTO;
import com.aicallsystem.acs.entity.dto.token.MarkTokenDto;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户账号表 服务类
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
public interface IAcsAccountInfoService extends IService<AcsAccountInfo> {

    /**
     * <p>
     *     用户验证
     * </p>
     * @param
     * @return
     * @throws
     * @since 4/9/2019
     */
    MarkTokenDto userAuth(UserAuthDTO userAuthDTO);
    
    /**
     * <p>
     *     创建账号
     * </p>
     * @param 
     * @return
     * @throws
     * @since 4/9/2019
     */
    MarkTokenDto createAccount(CreateAccountDTO createAccountDTO);
}
