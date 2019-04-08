package com.aicallsystem.acs.entity.dto.contact;

import com.aicallsystem.acs.entity.AcsContactInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 *      查看联系方式列表
 * </p>
 * @author ispong
 * @since 4/7/2019
 * @version 1.0.0
 */
@Data
public class ListContactDTO {

    @ApiModelProperty("联系方式列表")
    private List<AcsContactInfo> acsContactInfos;

    @ApiModelProperty("分页总页数")
    private long total;
}
