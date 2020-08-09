package Printers;

import Collectors.HashMapCollector;

import java.util.Map;

/**
 * Printer class that formats data relevant to the
 * JavaDoc metric and displays the results to the
 * user
 */
public class JavaDocPrinter extends AbstractPrinter{

    public JavaDocPrinter(HashMapCollector collector){
        super(collector);
    }

    /**
     * Prints contents of javaDocCollector
     */
    public void print(){
        System.out.println("\n----------------------- JavaDoc Comments -----------------------");
        for(Map.Entry<String, Integer> entry : collector.getJavaDocCollector().entrySet()){
            System.out.printf("%30s | %5s \n", entry.getKey(), entry.getValue());
        }
    }
}
