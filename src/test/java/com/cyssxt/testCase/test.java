package com.cyssxt.testCase;

import com.cyssxt.bean.RegParam;
import com.cyssxt.grammar.impl.DefaultRegParamGrammar;
import com.cyssxt.parser.Parser;
import com.cyssxt.parser.impl.RegParser;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class test {



    @Test
    public void regTest() throws Exception {
        Map<String, String> map = new HashMap<String,String>();
        map.put("a","a");
        map.put("b","b");
        RegParam regParam = new RegParam(map);
        Parser parser = new RegParser();
        parser.setParamGrammar(new DefaultRegParamGrammar());
        String value= parser.parser("${a}${b}",map);
        assert("ab".equals(value));
//        System.out.println(regValue.getValue());
    }

}
