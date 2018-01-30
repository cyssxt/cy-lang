package com.cyssxt.grammar.impl;

import com.cyssxt.bean.FunctionParam;
import com.cyssxt.core.FunctionCore;

import java.util.Map;
import java.util.regex.Pattern;

public class FunctionParamGrammar extends DefaultRegParamGrammar<FunctionParam> {

    private final static Pattern REG = Pattern.compile("##(((?!##)\\w+))##");

    public FunctionParamGrammar(FunctionParam functionParam) {
        super(functionParam);
    }

    @Override
    public String callback(String regReplaceContent, Map<String, String> paramMap) {
        return new FunctionCore(regReplaceContent,paramMap).run();
    }

    @Override
    public Pattern loadGrammar() {
        return REG;
    }
}
