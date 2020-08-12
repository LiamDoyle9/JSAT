package CollectorTests;

import Collectors.HashMapCollector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashMapCollectorTest {

    HashMapCollector collector = new HashMapCollector();

    @Test
    void addLoc() {
      int size = HashMapCollector.getMethodLocCollector().size();
      collector.addLoc("Method1", 1);
      assertEquals(size + 1, HashMapCollector.getMethodLocCollector().size());
    }

    @Test
    void incrementMethodCount() {
        collector.incrementMethodCount("Method1");
        collector.incrementMethodCount("Method2");
        assertEquals(2, HashMapCollector.getMethodCountCollector().size());
    }

    @Test
    void incrementJavaDocCollector() {
        collector.incrementJavaDocCollector("JavaDoc");
        assertEquals(1, HashMapCollector.getJavaDocCollector().size());
    }

    @Test
    void incrementBlockStmtCollector() {
        collector.incrementBlockStmtCollector("Block Stmt");
        assertEquals(1, HashMapCollector.getBlockStmtCollector().size());
    }

    @Test
    void addMethodStmt() {
        collector.addMethodStmt("main", 5);
        assertEquals(1, HashMapCollector.getMethodStmtCountCollector().size());
    }


    @Test
    void size(){
        collector.addLoc("MethodOne", 1);
        assertEquals(1, collector.getSize(HashMapCollector.getMethodLocCollector()));
    }
}