package com.cyssxt.core;

import com.cyssxt.bean.FunctionParam;
import com.cyssxt.bean.RegParam;
import com.cyssxt.bean.RegValue;
import com.cyssxt.constant.PropertyConstant;
import com.cyssxt.grammar.ParamGrammar;
import com.cyssxt.grammar.impl.DefaultRegParamGrammar;
import com.cyssxt.grammar.impl.FunctionParamGrammar;
import com.cyssxt.grammar.impl.IfParamGrammar;
import com.cyssxt.parser.RegParser;
import com.cyssxt.util.PropertiesUtils;
import com.sun.org.apache.xerces.internal.xni.grammars.Grammar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule {

    private final static List<ParamGrammar> executeList = new ArrayList<ParamGrammar>();
    private final static Map<String,Class> cacheMap = new HashMap<String,Class>();
    static{
        cacheMap.put("DefaultRegParamGrammar",DefaultRegParamGrammar.class);
        cacheMap.put("FunctionParamGrammar",FunctionParamGrammar.class);
        cacheMap.put("IfParamGrammar",IfParamGrammar.class);
    }
    public String execute(){
        return "";
    }

    public void init() throws Exception {
        String value = PropertiesUtils.getProperty(PropertyConstant.GRAMMAR,"");
        String[] values = value.split(",");
        for(String val:values){
            Class.forName(val);
        }


//        String content = "${a}${b}##${cd}+${dd}##{if ${cd}}${ed}{/if}";
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("a","a");
//        map.put("b","b");
//        map.put("cd","1");
//        map.put("dd","2");
//        map.put("ed","3");
//        RegParam regParam = new RegParam(map);
//        RegParser regParser = new RegParser(new DefaultRegParamGrammar(regParam));
//        RegValue regValue = regParser.parser(content);
//        RegParser functionParse = new RegParser(new FunctionParamGrammar(regParam));
//        RegValue funcRegValue = functionParse.parser(regValue.getValue());
//        String value = funcRegValue.getValue();
//        RegParser ifParser = new RegParser(new IfParamGrammar(regParam));
//        RegValue regValue1 = ifParser.parser(value);
//        System.out.println(regValue1.getValue());
    }

    public static void main(String[] args) throws Exception {
        new Schedule().init();
    }
}
