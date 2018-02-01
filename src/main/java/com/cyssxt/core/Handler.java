package com.cyssxt.core;

import com.cyssxt.annotation.Filter;
import com.cyssxt.annotation.Grammar;
import com.cyssxt.constant.PropertyConstant;
import com.cyssxt.event.Event;
import com.cyssxt.event.EventData;
import com.cyssxt.event.EventTrigger;
import com.cyssxt.grammar.ParamGrammar;
import com.cyssxt.parser.Parser;
import com.cyssxt.util.ClassScanUtils;
import com.cyssxt.util.PropertiesUtils;

import java.util.*;

public class Handler {

    private final static List<ParamGrammar> executeList = new ArrayList<ParamGrammar>();
    private final static String DEFAULT_GRAMMAR_PACKAGE = "com.cyssxt.grammar";
    private final static String DEFAULT_PARSER_PACKAGE = "com.cyssxt.parser";
    private final static String SCAN_PACKAGE="scan_package";
    public String execute(){
        return "";
    }
    private final static Map<Integer,List<Rule>> grammarMap = new TreeMap<Integer, List<Rule>>();
    private final static Map<String,Rule> grammarMapName = new HashMap<String,Rule>();
    private final static List<String> grammarList = Arrays.asList(PropertiesUtils.getProperty(PropertyConstant.GRAMMAR,PropertyConstant.DEFAULT_GRAMMAR).split(","));
    private final static boolean sortType = PropertiesUtils.getProperty(PropertyConstant.SORT_TYPE,true);

    static{
        EventTrigger.on(SCAN_PACKAGE, new Event<Class>() {
            @Override
            public void execute(EventData<Class> data) {
                Class clazz = data.getT();
                addGrammar(clazz);
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

    /**
     * 增加grammar配置
     * @param claz ParamGrammar实现类
     */
    public static void addGrammar(Class claz){
       Grammar grammar = (Grammar) claz.getAnnotation(Grammar.class);
       if(grammar==null || !grammarList.contains(grammar.value())){
           return;
       }
        int seq = grammar.seq();
        Rule rule = new Rule(claz,grammar);
        List<Rule> ruleList = grammarMap.get(seq);
        if(ruleList==null){
            ruleList = new ArrayList<Rule>();
            grammarMap.put(seq,ruleList);
        }
        ruleList.add(rule);
        grammarMapName.put(grammar.value(),rule);
        grammarMap.put(seq,ruleList);
    }
    public String execute(String content,Map<String,String> paramMap) throws Exception {
        String result = content;
        if (sortType) {
            for(String str:grammarList){
                Rule rule = grammarMapName.get(str);
                result = rule.getParser().parser(result,paramMap);
            }
        }else{
            Iterator<Integer> iterator = grammarMap.keySet().iterator();
            while (iterator.hasNext()){
                Integer key = iterator.next();
                List<Rule> ruleList = grammarMap.get(key);
                for (Rule rule:ruleList){
                    Parser parser = rule.getParser();
                    result = parser.parser(result,paramMap);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        String content = "${a}${b}##${cd}+${dd}##{if ${cd}}${ed}{/if}";
        Map<String,String> map = new HashMap<String,String>();
        map.put("a","a");
        map.put("b","b");
        map.put("cd","1");
        map.put("dd","2");
        map.put("ed","3");
        String result = new Handler().execute(content,map);
        System.out.println(result);
    }
}
