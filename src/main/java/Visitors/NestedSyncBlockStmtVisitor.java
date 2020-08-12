package Visitors;

import Collectors.Collector;
import com.github.javaparser.ast.stmt.SynchronizedStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * Visitor class that traverses AST and collects the total number of
 * nested synchronised block statements
 */
public class NestedSyncBlockStmtVisitor extends VoidVisitorAdapter<Collector>{

    /**
     * Override the VoidVisitorAdapter visit method to visit each
     * SynchronizedStmt node in the AST and collect the total number of
     * nested synchronised block statements
     * @param bs - First parameter represents the type of node you wish to visit
     * @param collector - Second node represents the Collector object used
     *                  to store information about each node visited
     */
    @Override
    public void visit(SynchronizedStmt bs, Collector collector){
        super.visit(bs, collector);
        int count = bs.getChildNodesByType(SynchronizedStmt.class).size();
        for(int i = 0; i < count; i++){
            collector.incrementBlockStmtCollector("(Synchronised) Nested Block");
        }
    }
}
