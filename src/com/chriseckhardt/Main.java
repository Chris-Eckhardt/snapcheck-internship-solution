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


    /************************
     * Encrypt() will process a string as input,
     * build and return a resulting encrypted version
     * of the input string.
     * @param str
     * @return encrypted string of str
     ************************/

    private static String encrypt(String str) {

        String result = "";

        /* STEP 1: remove spaces */
        str = str.replaceAll("\\s+", "");

        /* STEP 2: calculate dimensions */
        double dim = Math.sqrt(str.length());
        int rows = (int) Math.floor(dim);
        int columns = (int) Math.ceil(dim);

        /* STEP 3: check dimensions */
        if(columns*rows < str.length()) {
            if(columns > rows) {
                rows = columns;
            } else {
                columns = rows;
            }
        }

        /* STEP 4: build resulting string from column and index offset */
        for(int i = 0; i < columns; i++) {
            for(int j = 0; j < rows; j++) {
                if(j*columns+i < str.length())
                    result += str.charAt(j*columns+i);
            }
            if(i < columns-1)
                result += " ";
        }

        return result;
    }

}
