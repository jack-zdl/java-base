package com.zhang.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;

/**
 * 功能说明:  test big number output file
 *          if you want to get big number,
 *          you can try io,
 *          FIleWrite can output very big number.<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/6/6 17:55<br>
 * <br>
 */
public class FileIo {

    public static void main(String[] args) throws IOException {
        int a = 123456789;
        int b = 987654321;
        System.out.println("===="+(a * b));
        BigInteger ba = new BigInteger("1234567890000000000000");
        BigInteger bb = new BigInteger("987654321000000000000");
        System.out.println("------"+(ba.multiply(bb)));
        Writer file = new FileWriter("C:/javaIO.txt");
        file.write(ba.multiply(bb)+"\n");
        file.close();
    }
}
