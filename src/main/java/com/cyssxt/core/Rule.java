package com.cyssxt.core;


import com.cyssxt.grammar.ParamGrammar;
import com.cyssxt.parser.Parser;

public class Rule {
    private ParamGrammar grammar;
    private Parser parser;
    private String ruleName;
    private final static String SPLIT_FLAG = ":";
    public Rule(ParamGrammar grammar, Parser parser) {
        this.grammar = grammar;
        this.parser = parser;
    }

    public void excute(){
    }

    public Rule(String ruleName) {
        this.ruleName = ruleName;

    }
    public void initRule(){
        String[] vals = this.ruleName.split(SPLIT_FLAG);
        if(vals.length>1){
            String grammar = vals[0],parser = vals[1];

        }
    }

    public ParamGrammar getGrammar() {
        return grammar;
    }

    public void setGrammar(ParamGrammar grammar) {
        this.grammar = grammar;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }
}
