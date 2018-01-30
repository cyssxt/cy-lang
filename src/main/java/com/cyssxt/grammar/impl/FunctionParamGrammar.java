package com.cyssxt.grammar.impl;

import com.cyssxt.bean.FunctionParam;
import com.cyssxt.bean.RegParam;
import com.cyssxt.core.FunctionCore;
import com.cyssxt.grammar.AbstractRegParamGrammar;

import javax.script.ScriptException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionParamGrammar extends AbstractRegParamGrammar<RegParam>{

    private final static Pattern REG = Pattern.compile("##((?!##).+)##");
    private final static String PARAM_KEY_EXP = "##name##";
//    public String getParamKey(String key,Matcher matcher){
//        return PARAM_KEY_EXP.replace("name",key);
//    }

    public FunctionParamGrammar(FunctionParam functionParam) {
        super(functionParam);
    }

    @Override
    public String callback(String regReplaceContent, Map<String, String> paramMap, Matcher matcher) throws ScriptException {
        return new FunctionCore(regReplaceContent,paramMap).run();
    }

    @Override
    public Pattern loadGrammar() {
        return REG;
    }
}
