package com.aicallsystem.acs.service.impl;

import com.aicallsystem.acs.common.PageHelperModel;
import com.aicallsystem.acs.entity.AcsContactInfo;
import com.aicallsystem.acs.mapper.AcsContactInfoMapper;
import com.aicallsystem.acs.service.IAcsContactInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 联系我们信息 服务实现类
 * </p>
 *
 * @author ispong
 * @since 2019-04-03
 */
@Service
public class AcsContactInfoServiceImpl extends ServiceImpl<AcsContactInfoMapper, AcsContactInfo> implements IAcsContactInfoService {

    @Autowired
    private AcsContactInfoMapper acsContactInfoMapper;

    @Override
    public List<AcsContactInfo> listContact(PageHelperModel pageHelperModel) {
        return acsContactInfoMapper.listContact(pageHelperModel);
    }

    @Override
    public void addContact(AcsContactInfo acsContactInfo) {
        acsContactInfoMapper.addContact(acsContactInfo);
    }

    @Override
    public void deleteContact(AcsContactInfo acsContactInfo) {
        acsContactInfoMapper.deleteContact(acsContactInfo);
    }

    @Override
    public void updateContactState(AcsContactInfo acsContactInfo) {
        acsContactInfoMapper.updateContactState(acsContactInfo);
    }


}
