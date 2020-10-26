# Java Static Analysis Tool 

The Java Static Analysis Tool (JSAT) is a tool to collect quantitative data on a variety of different code quality metrics for concurrent software.

**Metrics**
1.  Method Count
    1. Synchronised Method Count (SMC)
    1. Method Count (MC)
2.  Javadoc Comment (JDC)
3.  Method Lines of Code 
    3.  Synchronised Method Lines of Code (SMLoC)
    3.  Method Lines of Code (MLoC)
4.  Block Statements
    4.  Synchronised Block Statements (SBS)
    4.  Nested Synchronised Block Statements (NSBS)
    4.  Block Statements (BS)
    4.  Nested Block Statements (NBS).
5.  Method Statement Count (MSc).




### Running JSAT
JSAT provides 4 test files that need to be exluded from compilation in order to run. 

Preferences -> Build, Execution and Deployment -> Compiler -> Excludes -> "+" -> select all 4 of the test files

To chose which test file you wish to use, simply change the variable name to reflect to relevant test file on the line shown below from the Run class. E.g. the example shown below will run test file 1. 


``` 
CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH_1));
```

