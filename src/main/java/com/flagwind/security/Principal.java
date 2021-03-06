package com.flagwind.security;

/**
 * 定义用户对象的基本功能
 */
public interface Principal {
    /**
     * 获取当前用户的凭证。
     * 
     * @return string
     */
    Credential getCredential();

    /**
     * 获取当前用户是否为有效。
     * 
     * @return boolean
     */
    boolean isAuthenticated();
}