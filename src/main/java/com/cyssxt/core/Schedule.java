package com.cyssxt.core;

import com.cyssxt.annotation.Filter;
import com.cyssxt.annotation.Grammar;
import com.cyssxt.constant.PropertyConstant;
import com.cyssxt.event.Event;
import com.cyssxt.event.EventData;
import com.cyssxt.event.EventTrigger;
import com.cyssxt.grammar.ParamGrammar;
import com.cyssxt.util.ClassScanUtils;
import com.cyssxt.util.PropertiesUtils;
import org.junit.platform.commons.util.ClassUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule {

    private final static List<ParamGrammar> executeList = new ArrayList<ParamGrammar>();
    private final static String DEFAULT_GRAMMER_PACKAGE = "com.cyssxt.grammar";
    private final static String DEFAULT_PARSER_PACKAGE = "com.cyssxt.parser";
    private final static String SCAN_PACKAGE="scan_package";
    public String execute(){
        return "";
    }
    private final static Map<String,Class> grammarMap = new HashMap<String,Class>();
    private final static Map<String,Class> parserList = new HashMap<String,Class>();

    static{
        EventTrigger.on(SCAN_PACKAGE, new Event<Class>() {
            @Override
            public void execute(EventData<Class> data) {
                Class clazz = data.getT();
                Grammar grammar = (Grammar) clazz.getAnnotation(Grammar.class);
                if(grammar!=null){
                    String keyValue = grammar.value();
                    grammarMap.put(keyValue,clazz);
                }
            }
        });

        ClassScanUtils.getAllClassIncludeJar("com.cyssxt",new Filter[]{
                new Filter() {
                    @Override
                    public boolean accept(Class clazz) {
                        EventTrigger.emit(SCAN_PACKAGE,new EventData(clazz));
                        return false;
                    }
                }
        },null);
        System.out.println(grammarMap.size());
    }

    public void init() throws Exception {
        List<Rule> ruleList = new ArrayList<Rule>();
        String value = PropertiesUtils.getProperty(PropertyConstant.GRAMMAR,"");
        String[] values = value.split(",");

        for(String val:values){
            Rule rule = new Rule(val);
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
