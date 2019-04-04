package com.aicallsystem.acs.service;

import com.aicallsystem.acs.entity.AcsAccountInfo;
import com.aicallsystem.acs.entity.AcsTokenInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 令牌表 服务类
 * </p>
 *
 * @author ispong
 * @since 2019-04-04
 */
public interface IAcsTokenInfoService extends IService<AcsTokenInfo> {

    /**
     * <p>
     *     生成用户新的token,失效前一个token
     * </p>
     * @param
     * @return
     * @throws
     * @since 4/4/2019
     */
    String tokenGenerator(AcsAccountInfo acsAccountInfo);

}
