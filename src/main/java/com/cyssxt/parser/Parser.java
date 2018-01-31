package com.cyssxt.parser;

import java.util.Map;

public interface Parser {
    /**
     *
     * @param content 需要解析的类型
     * @return
     */
    String parser(String content,Map<String,String> paramMap) throws Exception;
}
