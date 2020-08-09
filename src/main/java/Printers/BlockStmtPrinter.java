package Printers;

import Collectors.HashMapCollector;

import java.util.Map;

/**
 * Printer class that formats data relevant to the
 * BlockStmt metric and displays the results to
 * the user
 */
public class BlockStmtPrinter extends AbstractPrinter {

    public BlockStmtPrinter(HashMapCollector collector){
        super(collector);
    }

    /**
     * Prints contents of blockStmtCollector
     */
    public void print(){
        System.out.println("\n----------------------- Block Statements -----------------------");
        for(Map.Entry<String, Integer> entry : collector.getSyncBlockStmtCollector().entrySet()){
            System.out.printf("%50s | %35s \n", entry.getKey(), entry.getValue());
        }
    }
}
