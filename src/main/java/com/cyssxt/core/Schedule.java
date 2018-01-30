package com.cyssxt.core;

import com.cyssxt.bean.FunctionParam;
import com.cyssxt.bean.RegParam;
import com.cyssxt.bean.RegValue;
import com.cyssxt.grammar.impl.DefaultRegParamGrammar;
import com.cyssxt.grammar.impl.FunctionParamGrammar;
import com.cyssxt.grammar.impl.IfParamGrammar;
import com.cyssxt.parser.RegParser;

import java.util.HashMap;
import java.util.Map;

public class Schedule {

    public void init() throws Exception {
        String content = "${a}${b}##${cd}+${dd}##{if ${cd}}${ed}{/if}";
        Map<String,String> map = new HashMap<String,String>();
        map.put("a","a");
        map.put("b","b");
        map.put("cd","1");
        map.put("dd","2");
        map.put("ed","3");
        RegParam regParam = new RegParam(map);
        RegParser regParser = new RegParser(new DefaultRegParamGrammar(regParam));
        RegValue regValue = regParser.parser(content);
        FunctionParam functionParam = new FunctionParam(new HashMap<>());
        RegParser functionParse = new RegParser(new FunctionParamGrammar(functionParam));
        RegValue funcRegValue = functionParse.parser(regValue.getValue());
        String value = funcRegValue.getValue();
        RegParser ifParser = new RegParser(new IfParamGrammar(regParam));
        RegValue regValue1 = ifParser.parser(value);
        System.out.println(regValue1.getValue());
    }

    public static void main(String[] args) throws Exception {
        new Schedule().init();
    }
}
