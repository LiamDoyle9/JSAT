package Printers;

import Collectors.HashMapCollector;

import java.util.Map;

/**
 * Printer class that formats data relevant to the
 * MethodStmtCount metric and displays the results to
 * the user
 */
public class MethodStmtCountPrinter extends AbstractPrinter{

    public MethodStmtCountPrinter(HashMapCollector collector) {
        super(collector);
    }
    /**
     * Prints contents of methodStmtCount
     */
    public void print(){
        System.out.println("\n-------------------- Method Statement Count --------------------");
            for(Map.Entry<String, Integer> entry : collector.getMethodStmtCountCollector().entrySet()){
            System.out.printf("%35s | %35s \n", entry.getKey(), entry.getValue());
        }
    }
}

