package com.cyssxt.grammar;

import com.cyssxt.bean.RegParam;

import javax.script.ScriptException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface RegParamGrammar<V> extends ParamGrammar<V>{

    public String getParamKey(String key,Matcher matcher);

    /**
     * 回调函数
     * @param regReplaceContent 替换内容
     * @param paramMap 参数列表
     * @return
     * @throws ScriptException
     */
    public String callback(String  regReplaceContent, Map<String,String> paramMap, Matcher matcher) throws ScriptException;

}
