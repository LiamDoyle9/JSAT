package Collectors;

import java.util.HashMap;

public class HashMapCollector implements Collector {

    protected static HashMap<String, Integer> methodLocCollector;
    protected static HashMap<String, Integer> methodCountCollector;
    protected static HashMap<String, Integer> javaDocCollector;
    protected static HashMap<String, Integer> blockStmtCollector;
    protected static HashMap<String, Integer> methodStmtCountCollector;

    /**
     * HashMapCollector constructor
     */
    public HashMapCollector(){
        methodLocCollector = new HashMap<>();
        methodCountCollector = new HashMap<>();
        javaDocCollector = new HashMap<>();
        blockStmtCollector = new HashMap<>();
        methodStmtCountCollector = new HashMap<>();
    }

    /**
     * Get methodLocCollector object
     * @return
     */
    public static HashMap<String, Integer> getMethodLocCollector() {
        return  methodLocCollector;
    }

    /**
     * Insert line of code metric to methodLocCollector
     * @param methodName
     * @param value
     */
    public void addLoc(String methodName, int value){
        methodLocCollector.put(methodName, value);
    }


    /**
     * Get methodCountCollector object
     * @return
     */
    public static HashMap<String, Integer> getMethodCountCollector() {
        return methodCountCollector;
    }

    /**
     * Get javaDocCollector object
     * @return
     */
    public static HashMap<String, Integer> getJavaDocCollector() {
        return javaDocCollector;
    }

    /**
     * get syncBlockStmtCollector object
     * @return
     */
    public static HashMap<String, Integer> getBlockStmtCollector() {
        return blockStmtCollector;
    }

    /**
     * Get methodStmtCountCollector object
     * @return
     */
    public static HashMap<String, Integer> getMethodStmtCountCollector() {
        return methodStmtCountCollector;
    }


    /**
     * Return size of collector object
     * @param collector - First parameter represents the collector object
     * @return
     */
    public int getSize(HashMap collector){
        return collector.size();
    }









    /**
     * Increment the value with corresponding key (methodName). If key already
     * exists in Collector object, then the value is incremented by 1, else
     * a new entry is created with an initial value of 1.
     * @param methodName - First parameter represents the method name
     */
    public void incrementMethodCount(String methodName){
        if (methodCountCollector.containsKey(methodName)){
            methodCountCollector.put(methodName, methodCountCollector.get(methodName) + 1);
        } else {
            methodCountCollector.put(methodName, 1);
        }
    }

    /**
     * Increment the value with corresponding key (commentType). If key already
     * exists in Collector object, then the value is incremented by 1, else
     * a new entry is created with an initial value of 1.
     * @param commentType - First parameter represents comment type
     */
    public void incrementJavaDocCollector(String commentType){
        if(javaDocCollector.containsKey(commentType)){
            javaDocCollector.put(commentType, javaDocCollector.get(commentType) + 1);
        } else {
            javaDocCollector.put(commentType, 1);
        }
    }

    /**
     * Increment the value with corresponding key (metricName). If key already
     * exists in Collector object, then the value is incremented by 1, else
     * a new entry is created with an initial value of 1.
     * @param metricName - First parameter represents the name of the metric
     */
    public void incrementBlockStmtCollector(String metricName){
        if (blockStmtCollector.containsKey(metricName)){
            blockStmtCollector.put(metricName, blockStmtCollector.get(metricName) + 1);
        } else {
            blockStmtCollector.put(metricName, 1);
        }
    }

    /**
     * Add new method statement count metric to methodStmtCountCollector
     * object
     * @param methodName - First parameter represents the name of the
     *                     method
     * @param count -      Second parameter represents the the number of
     *                     statements
     */
    public void addMethodStmt(String methodName, int count){
        methodStmtCountCollector.put(methodName, count);
    }

}
