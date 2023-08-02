package com.lingfenglong.ssm.bean;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(title = "用户")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Schema(title = "用户id")
    private Long id;
    @Schema(title = "用户登录名")
    private String loginName;
    @Schema(title = "用户昵称")
    private String nickName;
    @Schema(title = "密码")
    private String passwd;
}
