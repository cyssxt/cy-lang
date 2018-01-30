package com.cyssxt.grammar.impl;

import com.cyssxt.bean.RegParam;
import com.cyssxt.grammar.RegParamGrammar;

import java.util.Map;
import java.util.regex.Pattern;


public class DefaultRegParamGrammar<T extends RegParam> implements RegParamGrammar<T,Pattern> {
    private final static Pattern PARAM_REG = Pattern.compile("\\$\\{([a-zA-Z_]+[a-zA-z_0-9]?)\\}");
    private  T t;
    public DefaultRegParamGrammar(T t) {
        this.t = t;
    }

    @Override
    public T loadData() throws Exception {
        return t;
    }

    public String callback(String  regReplaceContent,Map<String,String> paramMap){return null;};

    @Override
    public Pattern loadGrammar() {
        return PARAM_REG;
    }
}
