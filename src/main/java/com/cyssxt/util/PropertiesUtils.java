package com.cyssxt.util;

import com.cyssxt.constant.PropertyConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {
    private final static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
    private final static Properties properties = new Properties();
    private final static String PROPERTIES_PATH = PropertiesUtils.class.getResource("/parse.properties").getPath();
    static {
        InputStream is = null;
        try {
            is = new FileInputStream(new File(PROPERTIES_PATH));
            properties.load(is);
        } catch (FileNotFoundException e) {
            logger.error("init properties[load file] error",e);
        } catch (IOException e) {
            logger.error("init properties[properties.load] error",e);
        }
    }



    public static String getProperty(String prefix,String key,String dft){
        String value = properties.getProperty(prefix+"."+key);
        return value==null?dft:value;
    }

    public static String getProperty(String key){
        return getProperty(key,null);
    }

    /**
     *
     * @param key 属性值
     * @param dft 默认值
     * @return
     */
    public static String getProperty(String key,String dft){
       return getProperty(PropertyConstant.PREFIX,key,dft);
    }

    public static boolean getProperty(String key,boolean dft){
        String value =  getProperty(key);
        return StringUtils.isEmpty(value)?dft:("true".equals(value)?true:false);
    }

    public static void main(String[] args) throws IOException {
        System.out.println();
    }
}
