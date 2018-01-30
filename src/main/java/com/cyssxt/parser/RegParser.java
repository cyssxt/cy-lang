package com.cyssxt.parser;

import com.cyssxt.bean.RegParam;
import com.cyssxt.bean.RegValue;
import com.cyssxt.grammar.RegParamGrammar;
import com.cyssxt.grammar.impl.DefaultRegParamGrammar;
import com.sun.org.apache.xerces.internal.xni.grammars.Grammar;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegParser<T extends RegParam,V extends RegValue> implements Parser<T,V> {

    private RegParamGrammar<T,Pattern> regParamGrammar = null;
    public RegParser(RegParamGrammar<T,Pattern> regParamGrammar) {
        this.regParamGrammar = regParamGrammar;
    }

    public V parser(String content) throws Exception {
        RegParam regParam =  regParamGrammar.loadData();
        Pattern pattern = regParamGrammar.loadGrammar();
        Map<String,String> paramMap = regParam.getParamMap();
        Matcher matcher = pattern.matcher(content);
        String value = content;
        while(matcher.find()){
            if(matcher.groupCount()>0){
                String key = matcher.group(1);
                String paramValue = regParamGrammar.callback(key,paramMap,matcher);//paramMap.get(key);
                if(null==paramValue){
                    paramValue = paramMap.get(key);
                }
                value  = value.replace(regParamGrammar.getParamKey(key,matcher),paramValue);
            }
        }
        return (V)new RegValue(value,matcher);
    }

}
