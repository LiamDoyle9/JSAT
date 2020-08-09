package Visitors;

import Collectors.Collector;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * Visitor class that traverses AST and collects the total number of
 * nested block statements
 */
public class NestedBlockStmtVisitor extends VoidVisitorAdapter<Collector>{
    /**
     * Override the VoidVisitorAdapter visit method to visit each
     * BlockStmt node in the AST and collect the total number of
     * nested block statements
     * @param bs - First parameter represents the type of node you wish to visit
     * @param collector - Second node represents the Collector object used
     *                  to store information about each node visited
     */
    @Override
    public void visit(BlockStmt bs, Collector collector){
        int count = bs.getChildNodesByType(BlockStmt.class).size();
        for (int i = 0; i < count; i++){
            collector.incrementBlockStmtCollector("Nested Block");
        }
    }
}
