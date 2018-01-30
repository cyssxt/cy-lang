package com.cyssxt.bean;

import java.util.Map;
import java.util.regex.Pattern;

public class RegParam extends BaseParam {
    private String desc;
    private String name;

    public RegParam( Map<String, String> paramValue) {
        super(paramValue);
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
