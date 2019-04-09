package com.aicallsystem.acs.entity;

import com.aicallsystem.acs.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 令牌表
 * </p>
 *
 * @author ispong
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="AcsTokenInfo对象", description="令牌表")
public class AcsTokenInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "令牌")
    private String token;

    @ApiModelProperty(value = "令牌使用类型")
    private String type;

    @ApiModelProperty(value = "令牌状态")
    private Integer state;

    @ApiModelProperty(value = "用户uuid")
    private String userUuid;

    public AcsTokenInfo(String token, String userUuid) {
        this.token = token;
        this.userUuid = userUuid;
    }

    public AcsTokenInfo(String token) {
        this.token = token;
    }

    public AcsTokenInfo() {
    }
}
