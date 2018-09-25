package com.zaiou.web.vo.system;

import com.zaiou.common.annotation.IdCardValidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Description: 系统用户vo
 * @auther: LB 2018/9/20 19:51
 * @modify: LB 2018/9/20 19:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class SysUserVo extends WebVo{
    private static final long serialVersionUID = 6828388274867366306L;

    @NotBlank(message = "0001,主键")
    private String id;

    @NotBlank(message = "0001,登录账号")
    @Length(max = 40, message = "0004,登录账号,40")
    private String userCode;

    @NotBlank(message = "0001,用户名")
    @Length(max = 33, message = "0004,用户名,33")
    private String userName;

    @NotBlank(message = "0001,用户密码")
    @Length(max = 20, message = "0004,用户密码,33")
    private String userPassword;

    @IdCardValidate(message="身份证号格式不正确")
    @NotBlank(message = "0001,身份证号")
    private String idCard;

    @NotBlank(message = "0001,手机号码")
    @Length(max = 30, message = "0004,手机号码,30")
    private String mobile;

    @NotBlank(message = "0001,用户状态")
    private String status;

    @NotBlank(message = "0001,角色")
    @Length(max = 100, message = "0004,角色,100")
    private String roleCode;

    private String roleName;

}
