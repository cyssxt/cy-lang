package com.cyssxt.grammar.impl;

import com.cyssxt.annotation.Grammar;
import com.cyssxt.core.FunctionCore;
import com.cyssxt.grammar.AbstractRegParamGrammar;
import com.cyssxt.parser.impl.RegParser;

import javax.script.ScriptException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Grammar(value = "functionParamGrammar",parser= RegParser.class,seq = -9)
public class FunctionParamGrammar extends AbstractRegParamGrammar{

    private final static Pattern REG = Pattern.compile("##((?!##).+)##");
    private final static String PARAM_KEY_EXP = "##name##";
//    public String getParamKey(String key,Matcher matcher){
//        return PARAM_KEY_EXP.replace("name",key);
//    }

    @Override
    public String callback(String regReplaceContent, Map<String, String> paramMap, Matcher matcher) throws ScriptException {
        return new FunctionCore(regReplaceContent,paramMap).run();
    }

    @Override
    public Pattern loadGrammar() {
        return REG;
    }
}
