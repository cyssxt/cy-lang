package com.cyssxt.parser.impl;

import com.cyssxt.bean.RegParam;
import com.cyssxt.bean.RegValue;
import com.cyssxt.grammar.ParamGrammar;
import com.cyssxt.grammar.RegParamGrammar;
import com.cyssxt.grammar.impl.DefaultRegParamGrammar;
import com.cyssxt.parser.Parser;
import com.sun.org.apache.xerces.internal.xni.grammars.Grammar;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegParser implements Parser<RegParamGrammar<Pattern>> {

    private RegParamGrammar<Pattern> regParamGrammar;

    public String parser(String content,Map<String,String> paramMap) throws Exception {
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

    @Override
    public void setParamGrammar(ParamGrammar paramGrammar) {
        this.regParamGrammar = (RegParamGrammar<Pattern>)paramGrammar;
    }

//    @Override
//    public void setGrammar(ParamGrammar paramGrammar) {
//        this.regParamGrammar = (RegParamGrammar)paramGrammar;
//    }

}
