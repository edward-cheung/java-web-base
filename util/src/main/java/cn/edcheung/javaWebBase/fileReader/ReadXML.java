package cn.edcheung.javaWebBase.fileReader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * ReadXML 读取xml
 *
 * @author Edward Cheung
 * 2019/5/14
 */
class ReadXML {

    public static void main(String[] args) {
        // 读取xml
        ReadXML.read();
    }

    static void read() {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(new File("D:\\Study\\IDEA\\java-web-base\\util\\pom.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root;
        if (document != null) {
            root = document.getRootElement();
            List<Element> list = root.elements();
            for (Element element : list) {
                System.out.println(element.getName());
            }
        }
    }
}
