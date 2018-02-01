package com.cyssxt.core;

import com.cyssxt.grammar.impl.DefaultRegParamGrammar;
import com.cyssxt.parser.impl.RegParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParamCore {
    List<RegParser> parserLinkedList = new ArrayList<RegParser>();
    private String source = null;
    private void end(){
        System.out.println("end");
    }
    public ParamCore(String source) throws Exception {
        this.source = source;
//        RegParser regParser = new RegParser(new DefaultRegParamGrammar());
//        parserLinkedList.add(regParser);
        end();
//        return regParser.parser(source).getValue();
    }

    private void start(){
        String value = source;
        for(RegParser regParser:parserLinkedList){
            try {
                String result = regParser.parser(value,new HashMap<String,String>());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
