package com.aicallsystem.acs.service.impl;

import com.aicallsystem.acs.entity.AcsContactInfo;
import com.aicallsystem.acs.mapper.AcsContactInfoMapper;
import com.aicallsystem.acs.service.IAcsContactInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void addContact(AcsContactInfo acsContactInfo) {
        acsContactInfoMapper.addContact(acsContactInfo);
    }
}
