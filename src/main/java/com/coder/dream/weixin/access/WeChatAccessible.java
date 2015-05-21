package com.coder.dream.weixin.access;

/**
 * 微信接入能力
 *
 * @auther konghang
 * @look “开发文档-接入指南”
 */
public interface WeChatAccessible {
    /**
     * 验证服务器地址的有效性
     *
     * @param signature
     *  微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp
     *  时间戳
     * @param nonce
     *  随机数
     * @return
     */
    public boolean validServerUrl(String signature,String timestamp,String nonce);

    /**
     * 获取持有的token令牌
     *
     * @return
     */
    public String getHoldToken();
}
