package com.cyssxt.grammar;

import com.cyssxt.bean.RegParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class AbstractRegParamGrammar implements RegParamGrammar<Pattern> {

    @Override
    public String getParamKey(String key, Matcher matcher) {
        return matcher.group();
    }
}
