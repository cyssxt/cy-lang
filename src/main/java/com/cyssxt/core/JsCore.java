package com.cyssxt.core;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Date;

public class JsCore {
    private static JsCore instance;
    final static ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    final static String JS = "js";
    final static ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(JS);

    /**
     * 执行js
     * @param js js脚本
     * @return
     * @throws ScriptException
     */
    public static Object executeJs(String js) throws ScriptException {
        return scriptEngine.eval(js);
    }

    public static void main(String[] args) throws ScriptException {
        long start = System.currentTimeMillis();
        System.out.println(executeJs("1+1"));
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(System.currentTimeMillis());
        long start1 = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis()-start1);
    }
}
