package Printers;

import Collectors.HashMapCollector;

import java.util.Map;

/**
 * Printer class that formats data relevant
 * to the LinesOfCode metric and displays the results to
 * the user
 */
public class MethodLocPrinter extends AbstractPrinter {

    public MethodLocPrinter(HashMapCollector collector){
        super(collector);
    }

    /**
     * Prints contents of methodLocCollector.
     */
    public void print(){
        System.out.println("\n--------------------- Method Lines of Code ---------------------");
        for(Map.Entry<String, Integer> entry : collector.getMethodLocCollector().entrySet()){
            System.out.printf("%35s | %35s \n", entry.getKey(), entry.getValue());
        }


    }

}
