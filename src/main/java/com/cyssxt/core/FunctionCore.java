package com.cyssxt.core;


import com.cyssxt.bean.Function;

import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FunctionCore extends BaseCore{

    //{{add(1,2)}}
    public FunctionCore(String content,Map<String,String> paramMap) {
        super(content);
    }

    public String run() throws ScriptException {
        String value = JsCore.executeJs(getContent())+"";
        return value;
    }


}
