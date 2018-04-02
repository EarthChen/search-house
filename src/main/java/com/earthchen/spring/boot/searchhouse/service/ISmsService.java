package com.earthchen.spring.boot.searchhouse.service;


/**
 * 验证码服务
 *
 * @author: EarthChen
 * @date: 2018/04/02
 */
public interface ISmsService {

    /**
     * 发送验证码到指定手机 并 缓存验证码 10分钟 及 请求间隔时间1分钟
     *
     * @param telephone
     * @return
     */
    ServiceResult<String> sendSms(String telephone);

    /**
     * 获取缓存中的验证码
     *
     * @param telehone
     * @return
     */
    String getSmsCode(String telehone);

    /**
     * 移除指定手机号的验证码缓存
     */
    void remove(String telephone);
}
