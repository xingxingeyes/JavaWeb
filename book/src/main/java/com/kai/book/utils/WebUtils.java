package com.kai.book.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/16
 **/
public class WebUtils {
    public static <T> T copyParamToBean(Map vaule, T bean) {
        try {
            // 把所有请求的参数都注入User对象中
            BeanUtils.populate(bean, vaule);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转化成int类型值
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            // e.printStackTrace();
        }
        return defaultValue;
    }

}
