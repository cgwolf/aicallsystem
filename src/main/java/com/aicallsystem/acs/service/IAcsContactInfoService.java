package com.aicallsystem.acs.service;

import com.aicallsystem.acs.entity.AcsContactInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 联系我们信息 服务类
 * </p>
 *
 * @author ispong
 * @since 2019-04-03
 */
public interface IAcsContactInfoService extends IService<AcsContactInfo> {

    void addContact(AcsContactInfo acsContactInfo);

    void deleteContact(AcsContactInfo acsContactInfo);

    void updateContactState(AcsContactInfo acsContactInfo);

}
