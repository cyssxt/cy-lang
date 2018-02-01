package com.cyssxt.parser;

import com.cyssxt.annotation.Grammar;
import com.cyssxt.grammar.ParamGrammar;

import java.util.Map;

public interface Parser<T> {
    /**
     *
     * @param content 需要解析的类型
     * @return
     */
    String parser(String content,Map<String,String> paramMap) throws Exception;

    void setParamGrammar(ParamGrammar paramGrammar);
}
