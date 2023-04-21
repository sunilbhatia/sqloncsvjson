package dev.sunilb.utils;

import java.io.File;

public class Utils {

    public static File loadResourceFile(String fileName) {
        ClassLoader classLoader = Utils.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file;
    }
}
