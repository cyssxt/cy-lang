package com.cyssxt.parser;

import com.cyssxt.bean.RegParam;
import com.cyssxt.bean.RegValue;
import com.cyssxt.grammar.RegParamGrammar;
import com.cyssxt.grammar.impl.DefaultRegParamGrammar;
import com.sun.org.apache.xerces.internal.xni.grammars.Grammar;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegParser implements Parser {

    private RegParamGrammar<Pattern> regParamGrammar = null;
    public RegParser(RegParamGrammar<Pattern> regParamGrammar) {
        this.regParamGrammar = regParamGrammar;
    }

    public String parser(String content,Map<String,String> paramMap) throws Exception {
//        RegParam regParam =  regParamGrammar.loadData();
        Pattern pattern = regParamGrammar.loadGrammar();
//        Map<String,String> paramMap = regParam.getParamMap();
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
        return value;
    }

}
