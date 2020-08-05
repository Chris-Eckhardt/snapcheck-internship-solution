package com.chriseckhardt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws Exception {

        String str;

        URL path = Main.class.getResource("data.txt");
        File fd = new File(path.getFile());
        BufferedReader reader = new BufferedReader(new FileReader(fd));

        while((str = reader.readLine()) != null)
            System.out.println(encrypt(str));
    }



    private static String encrypt(String str) {

        str = str.replaceAll("\\s+", "");
        double dim = Math.sqrt(str.length());
        int rows = (int) Math.floor(dim);
        int columns = (int) Math.ceil(dim);
        char[][] arr = new char[rows][columns];
        return "";
    }

}
