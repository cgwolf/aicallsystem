package com.aicallsystem.acs.entity;

import java.time.LocalDateTime;
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
 * @since 2019-04-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel( description="令牌表")
public class AcsTokenInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "令牌")
    private String token;

    @ApiModelProperty(value = "用户账号")
    private String account;

    @ApiModelProperty(value = "令牌使用类型")
    private String type;

    @ApiModelProperty(value = "令牌状态")
    private Integer state;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;


    public AcsTokenInfo(String token, String account) {
        this.token = token;
        this.account = account;
    }

    public AcsTokenInfo(String token) {
        this.token = token;
    }
}
