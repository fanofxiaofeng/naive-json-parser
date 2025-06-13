package com.study.util;

import java.io.File;

public class SimpleOptionHandler {

    private boolean fileSpecified;
    private String fileName;

    public SimpleOptionHandler(String[] args) {
        if (args.length < 2) {
            fileSpecified = false;
            return;
        }
        if ("-f".equals(args[0]) || "--file".equals(args[0])) {
            if (!new File(args[1]).exists()) {
                System.out.printf("File [%s] doesn't exist, please check!", args[1]);
                System.exit(1);
            }
            fileSpecified = true;
            fileName = args[1];
        }
    }

    public boolean isFileSpecified() {
        return fileSpecified;
    }

    public String getFileName() {
        return fileName;
    }
}
