package org;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("HelloWorld");
        XStream xstream = new XStream();
        xstream.alias("d:multistatus",List_Calendars.class);
        xstream.aliasField("d:href", List_Calendars.class, "href");
        List_Calendars list [] = (List_Calendars[]) xstream.fromXML(new FileReader(new File("src/main/java/org/test.xml").getAbsoluteFile()));
        // add  d:multistatus
    }
}
 