package com.cyssxt.testCase;

import com.cyssxt.bean.RegParam;
import com.cyssxt.bean.RegValue;
import com.cyssxt.grammar.ParamGrammar;
import com.cyssxt.grammar.impl.DefaultRegParamGrammar;
import com.cyssxt.parser.Parser;
import com.cyssxt.parser.RegParser;
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
        Parser<RegParam,RegValue> parser = new RegParser(new DefaultRegParamGrammar(regParam));
        RegValue regValue = parser.parser("${a}${b}");
        assert("ab".equals(regValue.getValue()));
//        System.out.println(regValue.getValue());
    }

}
