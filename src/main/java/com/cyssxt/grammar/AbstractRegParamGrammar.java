package com.cyssxt.grammar;

import com.cyssxt.bean.RegParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractRegParamGrammar<T extends RegParam> implements RegParamGrammar<T,Pattern> {

    private T t;

    public AbstractRegParamGrammar(T t) {
        this.t = t;
    }

    @Override
    public T loadData() {
        return t;
    }

    @Override
    public String getParamKey(String key, Matcher matcher) {
        return matcher.group();
    }
}
