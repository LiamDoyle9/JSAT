package Visitors;

import Collectors.Collector;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Optional;

/**
 * Visitor class that traverses AST and collects the total number of
 * statements / synchronised method statements
 */
public class MethodStmtCountVisitor extends VoidVisitorAdapter<Collector>{

    /**
     * Override the VoidVisitorAdapter visit method to visit each
     * MethodDeclaration node in the AST and collect the total number of
     * method statements
     * @param md - First parameter represents the type of node you wish to visit
     * @param collector - Second node represents the Collector object used
     *                  to store information about each node visited
     */
    @Override
    public void visit(MethodDeclaration md, Collector collector){
        Optional<BlockStmt> block = md.getBody();
        NodeList<Statement> statements = block.get().getStatements();
        String name = md.getNameAsString();
        int size = statements.size();
        if(md.isSynchronized()){
            collector.addMethodStmt("(Synchronised) " + name, size);
        } else {
            collector.addMethodStmt(name, size);
        }
    }
}
