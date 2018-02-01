package com.cyssxt.core;


import com.cyssxt.annotation.Grammar;
import com.cyssxt.grammar.ParamGrammar;
import com.cyssxt.parser.Parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Rule {
    private Parser parser;
    private String ruleName;
    private final static String SPLIT_FLAG = ":";
    private Class grammarClazz;
    private Class parserClass;
    private Grammar grammar;
    public Rule(Class<ParamGrammar> clazz,Grammar grammar) {
        this.grammar = grammar;
        this.grammarClazz = clazz;
        this.parserClass = grammar.parser();
        initRule();
    }

    public Rule(String ruleName) {
        this.ruleName = ruleName;

    }
    public void initRule(){
        try {
            ParamGrammar paramGrammar = (ParamGrammar) this.grammarClazz.newInstance();
            Parser parser = (Parser) this.parserClass.newInstance();
            parser.setParamGrammar(paramGrammar);
            this.parser = parser;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }
}
