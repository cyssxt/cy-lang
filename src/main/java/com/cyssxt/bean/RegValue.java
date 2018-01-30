package com.cyssxt.bean;

import java.util.regex.Matcher;

public class RegValue extends BaseValue{
    private String value;
    private Matcher matcher;

    public RegValue(Matcher matcher) {
        this.matcher = matcher;
    }

    public RegValue(String value, Matcher matcher) {
        this.value = value;
        this.matcher = matcher;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public void setMatcher(Matcher matcher) {
        this.matcher = matcher;
    }

    public RegValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
