package com.coder.dream.weixin.access;

/**
 * ΢�Ž�������
 *
 * @auther konghang
 * @look �������ĵ�-����ָ�ϡ�
 */
public interface WeChatAccessible {
    /**
     * ��֤��������ַ����Ч��
     *
     * @param signature
     *  ΢�ż���ǩ����signature����˿�������д��token�����������е�timestamp������nonce������
     * @param timestamp
     *  ʱ���
     * @param nonce
     *  �����
     * @return
     */
    public boolean validServerUrl(String signature,String timestamp,String nonce);

    /**
     * ��ȡ���е�token����
     *
     * @return
     */
    public String getHoldToken();
}
