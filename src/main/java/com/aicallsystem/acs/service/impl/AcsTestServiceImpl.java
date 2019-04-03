package com.aicallsystem.acs.service.impl;

import com.aicallsystem.acs.entity.AcsTest;
import com.aicallsystem.acs.mapper.AcsTestMapper;
import com.aicallsystem.acs.service.IAcsTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据库测试 服务实现类
 * </p>
 *
 * @author ispong
 * @since 2019-04-03
 */
@Service
public class AcsTestServiceImpl extends ServiceImpl<AcsTestMapper, AcsTest> implements IAcsTestService {

}
