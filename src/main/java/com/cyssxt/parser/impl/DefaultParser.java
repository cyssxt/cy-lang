package com.cyssxt.parser.impl;


import com.cyssxt.annotation.ParserAnno;
import com.cyssxt.grammar.ParamGrammar;
import com.cyssxt.parser.Parser;

import java.util.Map;

@ParserAnno("parser")
public class DefaultParser implements Parser {


    @Override
    public String parser(String content, Map paramMap) throws Exception {
        return null;
    }

    @Override
    public void setParamGrammar(ParamGrammar paramGrammar) {

    }
}
