/*
 * @Author: ZHANGCHAO
 * @Date: 2025-02-24 16:25:30
 * @LastEditors: ZHANGCHAO
 * @LastEditTime: 2025-02-27 12:50:33
 * @FilePath: \Maven3.X\src\main\java\com\example\App.java
 */
package com.example;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * Hello World 示例应用
 */
public class App {
    public static void main(String[] args) {
        crackAsposePdfJar("C:\\Users\\13964\\Desktop\\aspose-cells-21.1.jar");
        System.out.println("Hello World!");
    }

    private static final String Desktop = "C:\\Users\\13964\\Desktop\\";

    private static void crackAsposePdfJar(String jarName) {
        try {
            // 这个是得到反编译的池
            ClassPool pool = ClassPool.getDefault();

            // 取得需要反编译的jar文件，设定路径
            pool.insertClassPath(jarName);

            CtClass ctClass = pool.get("com.aspose.cells.License");

            CtMethod method_isLicenseSet = ctClass.getDeclaredMethod("isLicenseSet");
            method_isLicenseSet.setBody("return true;");
            CtMethod method_setLicense = ctClass.getDeclaredMethod("setLicense");
            method_setLicense.setBody("{    a = new com.aspose.cells.License();\n"
                    + "    com.aspose.cells.zbjb.a();}");
            CtMethod methodL = ctClass.getDeclaredMethod("l");
            methodL.setBody("return new java.util.Date(Long.MAX_VALUE);");
            CtMethod method_k = ctClass.getDeclaredMethod("k");
            method_k.setBody("return true;");

            ctClass.writeFile(Desktop);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}