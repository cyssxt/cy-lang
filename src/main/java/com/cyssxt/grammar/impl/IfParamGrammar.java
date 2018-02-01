package com.cyssxt.grammar.impl;

import com.cyssxt.annotation.Grammar;
import com.cyssxt.core.JsCore;
import com.cyssxt.grammar.AbstractRegParamGrammar;
import com.cyssxt.parser.impl.RegParser;

import javax.script.ScriptException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Grammar(value = "ifParamGrammar",parser = RegParser.class,seq = -8)
public class IfParamGrammar extends AbstractRegParamGrammar {


    @Override
    public String callback(String regReplaceContent, Map<String, String> paramMap, Matcher matcher) throws ScriptException {
        System.out.println(matcher.groupCount());
        if(matcher.groupCount()<2){
            return regReplaceContent;
        }
        String key = matcher.group(1);
        String value = matcher.group(2);
        boolean flag = (Boolean)JsCore.executeJs("!!("+key+")");
        if(!flag){
            return "";
        }
        return value;
    }

    @Override
    public Pattern loadGrammar() {
        return Pattern.compile("\\{if ((?!\\{if\\}).+)\\}((?!\\{if\\}).+)\\{/if\\}");
    }
}
