package com.cyssxt.util;

import com.cyssxt.annotation.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassScanUtils {

    private final static Logger logger = LoggerFactory.getLogger(ClassScanUtils.class);
    private final static String CLASSPATH = ClassScanUtils.class.getClassLoader().getResource("").getPath();
    public static final String TARGET = "/";

    public static void addClass(String packageName, Filter[] filters, Map map){
        Class clazz = null;
        try {
            clazz = Class.forName(packageName);
            if(filters!=null){
                for(Filter filter:filters){
                    if(filter.accept(clazz)){
                        map.put(packageName,clazz);
                    }
                }
            }else{
                map.put(packageName,clazz);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Map<String,Class> getAllClass(String basePackage,Filter[] filter) throws ClassNotFoundException {
        return getAllClass( basePackage,filter,null);
    }
    public static Map<String,Class> getAllClass(String basePackage) throws ClassNotFoundException {
        return getAllClass( basePackage,null);
    }

    public static Map<String,Class> getAllClassIncludeJar(String basePackage,Filter[] filter,Map<String,Class> map){
        if(null == map){
            map = new HashMap<String,Class>();
        }
        String path = basePackage.replace(".",TARGET);
        try {
            Enumeration<URL> urls = ClassScanUtils.class.getClassLoader().getResources(path);
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                String tmpPath = url.getPath();
                if(tmpPath.contains(".jar!")){
                    String[] tmpPaths = tmpPath.split(".jar!");
                    String jarPath = tmpPaths[0]+".jar";
                    JarFile jarFile = new JarFile(jarPath.replaceFirst("file:","").replaceAll("%20"," "));
                    Enumeration<JarEntry> jarEntry = jarFile.entries();
                    while(jarEntry.hasMoreElements()){
                        JarEntry entry = jarEntry.nextElement();
                        String name = entry.getName();
                        String packageName =  name.replace(TARGET,".");
                        if(name.toLowerCase().endsWith(".class") && packageName.startsWith(basePackage)){
//                            System.out.println(packageName);
                            addClass(packageName.replace(".class",""),filter,map);
                        }
                    }
                }else{
                    try {
                        getAllClass(basePackage,filter,map);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String,Class> getAllClass(String basePackage,Filter[] filter,Map<String,Class> map) throws ClassNotFoundException {
        if(map==null) {
            map = new HashMap<String,Class>(100);
        }
        String path = basePackage.replace(".",TARGET);
        path = "".equals(path)?"":(File.separator+path);
        path = CLASSPATH+path;
        File rootFile = new File(path);
        if(rootFile.isDirectory()){
            String[] fileNameList = rootFile.list();
            for(String fileName:fileNameList){
                File file = new File(path+File.separator+fileName);
                String packageName = ("".equals(basePackage)?"":(basePackage+"."))+fileName.split(".class")[0];
                if(fileName.endsWith(".class") && !file.isDirectory()){
                    addClass(packageName,filter,map);
                }else if(file.isDirectory()){
                    getAllClass(packageName,filter,map);
                }
            }
        }else{
            String packageName = basePackage;//+"."+rootFile.getName();
            addClass(packageName,filter,map);
        }
        return map;
    }


    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("");
        Map map = getAllClassIncludeJar("com.cyssxt",null,null);
//        URL url = ClassScanUtils.class.getClassLoader().getResource("com");
//        File file = new File(url.getPath());
//        System.out.println(file);
//        System.out.println(url);
////        Map map = getAllClass("org");
//
//        getAllClass("", new Filter() {
//            @Override
//            public boolean accept(Class clazz) {
//                Grammar grammar = (Grammar) clazz.getAnnotation(Grammar.class);
//                if(null!=grammar){
//                    System.out.println(grammar.value());
//                }
//                return false;
//            }
//        });
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
