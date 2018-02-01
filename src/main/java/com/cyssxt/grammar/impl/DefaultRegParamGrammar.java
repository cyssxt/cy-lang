package com.cyssxt.grammar.impl;

import com.cyssxt.annotation.Grammar;
import com.cyssxt.grammar.AbstractRegParamGrammar;
import com.cyssxt.parser.impl.RegParser;

import javax.script.ScriptException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Grammar(value = "defaultRegParamGrammar",parser = RegParser.class,seq = -10)
public class DefaultRegParamGrammar extends AbstractRegParamGrammar{
    private final static Pattern PARAM_REG = Pattern.compile("\\$\\{([a-zA-Z_]+[a-zA-z_0-9]?)\\}");
    private final static String PARAM_KEY_EXP = "${name}";


//    @Override
//    public String getParamKey(String key,Matcher matcher){
//        return PARAM_KEY_EXP.replace("name",key);
//    }

    @Override
    public String callback(String  regReplaceContent, Map<String,String> paramMap, Matcher matcher) throws ScriptException {
        return null;
    };

    @Override
    public Pattern loadGrammar() {
        return PARAM_REG;
    }
}
