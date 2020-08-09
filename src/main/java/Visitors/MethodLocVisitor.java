package Visitors;

import Collectors.Collector;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


/**
 * Visitor class that traverses AST and collects lines of code
 * for each method / synchronised method
 */
public class MethodLocVisitor extends VoidVisitorAdapter<Collector> {
     /**
      * Overrides the VoidVisitorAdapter visit method to visit
      * each MethodDeclaration node and use our Collector object
      * to store our line of code metric
      * @param md - First parameter represents the type of node you wish to visit
      * @param collector - Second node represents the Collector object used
      *                  to store information about each node visited
     */
     @Override
    public void visit(MethodDeclaration md, Collector collector){
        super.visit(md, collector);
        int firstLine = md.getName().getBegin().get().line;
        int lastLine = md.getEnd().get().line;
        int totalLoc = lastLine - firstLine;

        if(!md.isSynchronized()){
            collector.addLoc(md.getNameAsString(), totalLoc);
        } else {
            collector.addLoc("(Synchronised) " + md.getNameAsString(), totalLoc);
        }
    }
}
