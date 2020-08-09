package Printers;

import Collectors.HashMapCollector;

/**
 * AbstractPrinter class allows us to pass out Collector object to
 * each Printer class.
 */
public abstract class AbstractPrinter {

    protected HashMapCollector collector;

    public AbstractPrinter(HashMapCollector collector){
        this.collector = collector;
    }

}
