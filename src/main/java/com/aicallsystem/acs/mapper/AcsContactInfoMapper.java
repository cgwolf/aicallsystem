package com.aicallsystem.acs.mapper;

import com.aicallsystem.acs.entity.AcsContactInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 联系我们信息 Mapper 接口
 * </p>
 *
 * @author ispong
 * @since 2019-04-03
 */
@Mapper
@Component
public interface AcsContactInfoMapper extends BaseMapper<AcsContactInfo> {

    void addContact(AcsContactInfo acsContactInfo);

    void deleteContact(AcsContactInfo acsContactInfo);
}
