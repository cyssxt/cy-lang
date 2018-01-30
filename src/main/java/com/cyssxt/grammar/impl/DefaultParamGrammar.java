package com.cyssxt.grammar.impl;

import com.cyssxt.bean.BaseParam;
import com.cyssxt.bean.RegParam;
import com.cyssxt.grammar.AbstractRegParamGrammar;
import com.cyssxt.grammar.ParamGrammar;

import javax.script.ScriptException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultParamGrammar<T extends RegParam> extends AbstractRegParamGrammar<T>{
    private final static Pattern PARAM_REG = Pattern.compile("\\$\\{([a-zA-Z_]+[a-zA-z_0-9]?)\\}");

    public DefaultParamGrammar(T t) {
        super(t);
    }

    @Override
    public Pattern loadGrammar() {
        return PARAM_REG;
    }

    @Override
    public String getParamKey(String key,Matcher matcher) {
        return null;
    }

    @Override
    public String callback(String regReplaceContent, Map<String, String> paramMap, Matcher matcher) throws ScriptException {
        return null;
    }
}
