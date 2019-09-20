package com.github.tianyunperfect.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;

/**
 * @Description
 * @Author tianyunperfect
 * @Date 2019/6/27 14:03
 * @Version 1.0
 */
public class JsonUtil {

    /**
     * 转换为json字符串
     * @param object
     * @return
     */
    public static String toJsonStr(Object object) {
        return new Gson().toJson(object);
    }


    /**
     * 将json字符串 转换为 普通类
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toObjet(String jsonStr, Class<T> clazz) {
        return JSON.parseObject(jsonStr, clazz);
    }

    /**
     * 将json字符串 转换为 泛型类、集合等
     * @param jsonStr
     * @param tTypeReference
     * @param <T>
     * @return
     */
    public static <T> T toObjet(String jsonStr, TypeReference<T> tTypeReference) {
        return JSON.parseObject(jsonStr, tTypeReference);
    }
}