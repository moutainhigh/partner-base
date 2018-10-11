package com.zaiou.common.enums;

import com.zaiou.common.service.CacheService;
import com.zaiou.common.utils.SpringContextHolder;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;

/**
 * @Description: 系统结果信息
 * @auther: LB 2018/9/19 12:09
 * @modify: LB 2018/9/19 12:09
 */
@Getter
@AllArgsConstructor
public enum  ResultInfo {
    SUCCESS("00", "0000", "操作成功"),
    SYS_ERROR("00", "9999","系统异常"),
    NOT_NULL("00", "9001", "{0}参数不能为空"),

    /** web端 **/
    //WEB系统异常
    WEB_SYS_ERROR("01", "9999", "管理端系统异常"),

    /** BOSS公共错误码**/
    WEB_COMMON_NOT_NULL_0001		("01", "0001","{0}不能为空"),
    WEB_COMMON_MAX_0002			("01", "0002","{0}字段过长"),
    WEB_COMMON_FILASIZE_LIMIT_0003	("01", "0003","文件大小不可超过{0}M"),
    WEB_COMMON_IDCARD_0005	        ("01", "0005","身份证号码格式错误"),

    //登录权限错误码
    WEB_1000	("01","1000", "登录超时,请重新登录"),
    WEB_1001	("01","1001","登录密码错误，错误6次账号将被锁定"),
    WEB_1002	("01","1002","账号不存在"),
    WEB_1005	("01","1005","首次登陆,请修改密码"),
    WEB_1006	("01","1006","用户状态发生改变，你已被强制下线"),
    WEB_1007	("01","1007","用户{0}已在别处登录，如非本人操作，请及时修改密码"),
    WEB_1008	("01","1008","登录超时,请重新登录"),
    WEB_1009	("01","1009","授权过期"),


    //用户角色管理错误码
    WEB_2000	("01","2000", "账号异常，请联系管理员"),
    WEB_2001	("01","2001", "账号已被注销，请联系管理员"),
    ;

    public String getCode() {
        return system + code;
    }

    public String getCacheMsg(Object... params) {
        String msg = SpringContextHolder.getBean(CacheService.class).getResultMsg(system, code);
        return MessageFormat.format(msg, params);
    }

    public static ResultInfo getResultCode(String system, String code) {
        for (ResultInfo resultInfo : ResultInfo.values()) {
            if (resultInfo.system.equals(system) && resultInfo.code.equals(code)) {
                return resultInfo;
            }
        }
        return null;
    }

    private String system;
    private String code;
    private String msg;
}
