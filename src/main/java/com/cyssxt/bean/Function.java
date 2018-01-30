package com.cyssxt.bean;

import java.util.List;

public abstract class Function {
    private String name;
    private List paramList;
    private String value;
    public abstract String run();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getParamList() {
        return paramList;
    }

    public void setParamList(List paramList) {
        this.paramList = paramList;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
