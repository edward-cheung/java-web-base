package cn.edcheung.javaWebBase.fileReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ReadProperties 读取properties
 *
 * @author Edward Cheung
 * 2019/5/14
 */
class ReadProperties {

    public static void main(String[] args) {
        // 读取properties
        ReadProperties.read();
    }

    static void read() {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("D:\\Work\\sclhzh\\lp\\src\\main\\resources\\config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("user"));
    }
}
