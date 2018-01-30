package com.cyssxt.grammar.impl;

import com.cyssxt.bean.BaseParam;
import com.cyssxt.grammar.ParamGrammar;

import java.util.regex.Pattern;

public class DefaultParamGrammar<T extends BaseParam> implements ParamGrammar<T, java.util.regex.Pattern> {
    private final static Pattern PARAM_REG = Pattern.compile("\\$\\{([a-zA-Z_]+[a-zA-z_0-9]?)\\}");
    private  T t;
    public DefaultParamGrammar(T t) {
        this.t = t;
    }

    @Override
    public T loadData() throws Exception {
        return t;
    }

    @Override
    public Pattern loadGrammar() {
        return PARAM_REG;
    }
}
