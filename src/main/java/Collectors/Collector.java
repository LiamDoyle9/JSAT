package Collectors;

public interface Collector {

    void addLoc(String methodName, int value);
    void incrementMethodCount(String methodName);
    void incrementJavaDocCollector(String commentType);
    void incrementBlockStmtCollector(String metricName);
    void addMethodStmt(String methodName, int count);

}
