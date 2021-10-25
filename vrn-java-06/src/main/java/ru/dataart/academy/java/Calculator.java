package ru.dataart.academy.java;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Calculator {
    /**
     * @param zipFilePath -  path to zip archive with text files
     * @param character   - character to find
     * @return - how many times character is in files
     */
    public Integer getNumberOfChar(String zipFilePath, char character) {
        ZipFile zip = null;
        try {
            zip = new ZipFile(zipFilePath);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        StringBuilder finalString = new StringBuilder();
        assert zip != null;
        for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = entries.nextElement();
            if (!entry.isDirectory()) {
                StringBuilder out = new StringBuilder();
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(zip.getInputStream(entry)));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                String line;
                try {
                    while (true) {
                        assert reader != null;
                        if ((line = reader.readLine()) == null) break;
                        out.append(line).append(" ");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                finalString.append(out);
            }
        }
        return (int) finalString.chars().filter(num -> num == character).count();
    }

    /**
     * @param zipFilePath - path to zip archive with text files
     * @return - max length
     */

    public Integer getMaxWordLength(String zipFilePath) {
        ZipFile zip = null;
        try {
            zip = new ZipFile(zipFilePath);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        StringBuilder finalString = new StringBuilder();
        assert zip != null;
        for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = entries.nextElement();
            if (!entry.isDirectory()) {
                StringBuilder out = new StringBuilder();
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(zip.getInputStream(entry)));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                String line;
                try {
                    while (true) {
                        assert reader != null;
                        if ((line = reader.readLine()) == null) break;
                        out.append(line).append(" ");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                finalString.append(out);
            }
        }
        String stringForSplit = finalString.toString();
        String[] words = stringForSplit.split("\\s");
        String maxString = "";
        for (String subString : words) {
            if (subString.length() > maxString.length()) {
                maxString = subString;
            }
        }
        return maxString.length();
    }

}
