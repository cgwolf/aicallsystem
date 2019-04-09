package com.aicallsystem.acs.entity.dto.account;

import lombok.Data;

@Data
public class CreateAccountDTO {

    private UserAuthDTO userAccount;

    private UserInfoDTO userInfo;
}
