import Collectors.HashMapCollector;
import Printers.*;
import Visitors.*;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;

public class Run {

    protected static final String FILE_PATH_1 = "src/main/java/SleepingBarber.java";

    public static void main(String[] args) throws Exception{

        //Collector object initialised
        HashMapCollector collector = new HashMapCollector();
        //Compilation unit (Root node) initialised
        CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH_1));

        new MethodCountVisitor().visit(cu, collector);
        new MethodCountPrinter(collector).print();

        new JavaDocVisitor().visit(cu, collector);
        new JavaDocPrinter(collector).print();

        new MethodLocVisitor().visit(cu, collector);
        new MethodLocPrinter(collector).print();

        new SyncBlockStmtVisitor().visit(cu, collector);
        new BlockStmtVisitor().visit(cu, collector);
        new NestedBlockStmtVisitor().visit(cu, collector);
        new NestedSyncBlockStmtVisitor().visit(cu, collector);
        new BlockStmtPrinter(collector).print();

        new MethodStmtCountVisitor().visit(cu, collector);
        new MethodStmtCountPrinter(collector).print();












    }

}
