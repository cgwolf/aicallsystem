package com.aicallsystem.acs.mapper;

import com.aicallsystem.acs.entity.AcsPermissionRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 权限关联表 Mapper 接口
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Mapper
@Component
public interface AcsPermissionRelationMapper extends BaseMapper<AcsPermissionRelation> {

}
