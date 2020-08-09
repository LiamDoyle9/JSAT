package Visitors;

import Collectors.Collector;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * Visitor class that traverses AST and collects the total number of
 * JavaDocs comments
 */
public class JavaDocVisitor extends VoidVisitorAdapter<Collector> {
    /**
     * Override the VoidVisitorAdapter visit method to visit each
     * JavadocComment node in the AST and collect the total number
     * of JavaDoc comments
     * @param jdc - First parameter represents the type of node you wish to visit
     * @param collector - Second node represents the Collector object used
     *                  to store information about each node visited
     */
    @Override
    public void visit(JavadocComment jdc, Collector collector){
        super.visit(jdc, collector);
        if(jdc.isJavadocComment()){
            collector.incrementJavaDocCollector("JavaDoc Comments: ");
        }
    }
}
