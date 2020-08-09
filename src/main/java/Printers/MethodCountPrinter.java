package Printers;

import Collectors.HashMapCollector;

import java.util.Map;

/**
 * Printer class that formats data relevant
 * to the MethodCount metric and displays the results to
 * the user
 */
public class MethodCountPrinter extends AbstractPrinter {

    public MethodCountPrinter(HashMapCollector collector){
        super(collector);
    }

    public void print(){
        System.out.println("\n------------------------- Method Count -------------------------");
        for(Map.Entry<String, Integer> entry : collector.getMethodCountCollector().entrySet()){
            System.out.printf("%50s | %35s \n", entry.getKey(), entry.getValue());
        }
    }
}
