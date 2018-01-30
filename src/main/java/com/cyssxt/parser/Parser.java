package com.cyssxt.parser;

public interface Parser<T,V> {
    /**
     *
     * @param content 需要解析的类型
     * @return
     */
    V parser(String content) throws Exception;
}
