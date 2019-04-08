package com.aicallsystem.acs.service;

import com.aicallsystem.acs.common.PageHelperModel;
import com.aicallsystem.acs.entity.AcsContactInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 联系我们信息 服务类
 * </p>
 *
 * @author ispong
 * @since 2019-04-03
 */
public interface IAcsContactInfoService extends IService<AcsContactInfo> {

    List<AcsContactInfo> listContact(PageHelperModel pageHelperModel);

    void addContact(AcsContactInfo acsContactInfo);

    void deleteContact(AcsContactInfo acsContactInfo);

    void updateContactState(AcsContactInfo acsContactInfo);

}
