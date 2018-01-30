package com.cyssxt.core;

import com.cyssxt.bean.RegParam;
import com.cyssxt.bean.RegValue;
import com.cyssxt.grammar.impl.DefaultRegParamGrammar;
import com.cyssxt.parser.RegParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ParamCore {
    List<RegParser> parserLinkedList = new ArrayList<RegParser>();
    private String source = null;
    private void end(){
        System.out.println("end");
    }
    public ParamCore(String source) throws Exception {
        this.source = source;
        RegParam regParam = new RegParam(new HashMap<String, String>());
        RegParser regParser = new RegParser(new DefaultRegParamGrammar(regParam));
        parserLinkedList.add(regParser);
        end();
//        return regParser.parser(source).getValue();
    }

    private void start(){
        String value = source;
        for(RegParser regParser:parserLinkedList){
            try {
                RegValue regValue = regParser.parser(value);
                value = regValue.getValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
