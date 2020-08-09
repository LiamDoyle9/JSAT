package Visitors;

import Collectors.Collector;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * Visitor class that traverses AST and collects the total number of
 * block statements
 */
public class BlockStmtVisitor extends VoidVisitorAdapter<Collector>{

    /**
     * Override the VoidVisitorAdapter visit method to visit each
     * BlockStmt node in the AST and collect the total number of
     * block statements
     * @param bs - First parameter represents the type of node you wish to visit
     * @param collector - Second node represents the Collector object used
     *                  to store information about each node visited
     */
    @Override
    public void visit(BlockStmt bs, Collector collector){
        super.visit(bs, collector);
        collector.incrementBlockStmtCollector("Block");
    }
}
