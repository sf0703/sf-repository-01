package org.jeecg.meeting.utils;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Component
public class MyZipCompressing {
    private int k = 1; // 定义递归次数变量

    public MyZipCompressing() {
        // TODO Auto-generated constructor stub
    }
    /**
     * 压缩方法
     * output 输出
     * input 输入
     * */
    public void zip(String zipFileName, File inputFile) throws Exception {
        System.out.println("压缩中...");
        //定义一个压缩流
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        //缓存输出流
        BufferedOutputStream bo = new BufferedOutputStream(out);
        //调用重载方法
        zip(out, inputFile, inputFile.getName(), bo);
        bo.close();
        out.close(); // 输出流关闭
        System.out.println("压缩完成");
    }
    /*
    *base 当前文件的文件夹名字
    * */
    public void zip(ZipOutputStream out, File f, String base,BufferedOutputStream bo) throws Exception {
        // 方法重载
        //判断是否是目录
        if (f.isDirectory()) {
            /*创建文件数组*/
            File[] fl = f.listFiles();
            System.out.println("fl.length="+fl.length);
            //如果是空文件将文件压入压缩中
            if (fl.length == 0) {
                out.putNextEntry(new ZipEntry(base + "/")); // 创建zip压缩进入点base
                System.out.println(base + "/");
            }
            //将文件逐个递归
            for (int i = 0; i < fl.length; i++) {
                zip(out, fl[i], base + "/" + fl[i].getName(), bo); // 递归遍历子文件夹
            }
            System.out.println("第" + k + "次递归");
            k++;
        } else {
            //如果不是文件夹，直接打入压缩包
            out.putNextEntry(new ZipEntry(base)); // 创建zip压缩进入点base
            System.out.println(base);
            //递归结束，将缓存buffer
            FileInputStream in = new FileInputStream(f);
            BufferedInputStream bi = new BufferedInputStream(in);
            int b;
            while ((b = bi.read()) != -1) {
                bo.write(b); // 将字节流写入当前zip目录
            }
            bi.close();
            in.close(); // 输入流关闭
        }
    }
}