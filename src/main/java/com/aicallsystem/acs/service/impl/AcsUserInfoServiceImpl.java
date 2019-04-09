package com.aicallsystem.acs.service.impl;

import com.aicallsystem.acs.entity.AcsUserInfo;
import com.aicallsystem.acs.mapper.AcsUserInfoMapper;
import com.aicallsystem.acs.service.IAcsUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Service
public class AcsUserInfoServiceImpl extends ServiceImpl<AcsUserInfoMapper, AcsUserInfo> implements IAcsUserInfoService {

}
