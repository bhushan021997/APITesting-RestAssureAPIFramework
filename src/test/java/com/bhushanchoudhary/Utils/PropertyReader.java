package com.bhushanchoudhary.Utils;

import java.io.FileInputStream;
import java.util.Properties;



public class PropertyReader {

    public static String readkey(String key) {
        Properties prop = new Properties();
    try

    {
        FileInputStream fo = new FileInputStream("src/test/resources/Data.properties");
        prop.load(fo);
    }

    catch(Exception e) {
        throw new RuntimeException(e);
    }

return prop.getProperty(key);
}
}
