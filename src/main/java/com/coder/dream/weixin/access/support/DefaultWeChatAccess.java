package com.coder.dream.weixin.access.support;

import com.coder.dream.weixin.access.WeChatAccessible;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Ĭ�ϵ�ƽ̨΢�Ž���ʵ��
 *
 * @see com.coder.dream.weixin.access.WeChatAccessible
 */
public class DefaultWeChatAccess implements WeChatAccessible{

    @Override
    public boolean validServerUrl(String signature, String timestamp, String nonce) {
        //0.�жϲ���
        if(StringUtils.isBlank(signature)
                || StringUtils.isBlank(timestamp)
                || StringUtils.isBlank(nonce)){
            return false;
        }

        //1.��token��timestamp��nonce�������������ֵ�������
        String token = getHoldToken();
        String[] params = new String[] { token, timestamp, nonce };
        Arrays.sort(params);

        //2.�����������ַ���ƴ�ӳ�һ���ַ�������sha1����
        StringBuilder stringBuilder = new StringBuilder();
        for(String param : params){
            stringBuilder.append(param);
        }
        String complexStr = stringBuilder.toString();
        MessageDigest md = null;
        String secretStr = null;
        try{
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(complexStr.getBytes());
            secretStr = byteToStr(digest);
        }catch (Exception e){
            e.printStackTrace();
        }

        //3.��sha1���ܺ���ַ�������signature�Աȣ���ʶ��������Դ��΢��
        return secretStr != null ? secretStr.equals(signature.toUpperCase()) : false;
    }

    @Override
    public String getHoldToken() {
        return "konghang158";
    }

    /**
     * ���ֽ�����ת��Ϊʮ�������ַ���
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * ���ֽ�ת��Ϊʮ�������ַ���
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }
}
