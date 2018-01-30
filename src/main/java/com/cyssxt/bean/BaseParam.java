package com.cyssxt.bean;

import java.util.Map;

public class BaseParam {
    private Map<String,String> paramMap;

    public BaseParam(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, String> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }
}
