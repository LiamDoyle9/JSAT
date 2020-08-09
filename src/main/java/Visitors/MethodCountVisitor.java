package Visitors;

import Collectors.Collector;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * Visitor class that traverses AST and collects the total number of
 * methods / synchronised methods
 */
public class MethodCountVisitor extends VoidVisitorAdapter<Collector> {
    /**
     * Override the VoidVisitorAdapter visit method to
     * visit each MethodDeclaration node in the AST and
     * collect the total number of methods / synchronised
     * methods.
     * @param md - First parameter represents the type of node you wish to visit
     * @param collector - Second node represents the Collector object used
     *                   to store information about each node visited
     */
    @Override
    public void visit(MethodDeclaration md, Collector collector){
        super.visit(md, collector);
        if(md.isSynchronized()){
            collector.incrementMethodCount("Synchronised Methods");
        }
        if(!md.isSynchronized()){
            collector.incrementMethodCount("Methods");
        }
    }
}
