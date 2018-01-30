package com.cyssxt.grammar;

public interface ParamGrammar<T,V> {

    T loadData() throws Exception;

    V loadGrammar();

}
