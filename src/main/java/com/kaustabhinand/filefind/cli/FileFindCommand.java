package com.kaustabhinand.filefind.cli;

import com.kaustabhinand.filefind.filefindLexer;
import com.kaustabhinand.filefind.filefindParser;
import com.kaustabhinand.filefind.eval.evalvisitor;
import com.kaustabhinand.filefind.exec.Executor;
import com.kaustabhinand.filefind.model.ExprCondition;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.List;
import java.util.concurrent.Callable;

@Command(
        name = "filefind",
        mixinStandardHelpOptions = true,
        version = "filefind 1.0",
        description = "A custom DSL to search for files on the filesystem."
)
public class FileFindCommand implements Callable<Integer> {

    @Parameters(index = "0", description = "The filefind query, e.g. \"find file from \\\"C:\\\\Users\\\" where ext = \\\"pdf\\\"\"")
    private String query;

    @Option(names = {"-v", "--verbose"}, description = "Print the parse tree and extra debug info.")
    private boolean verbose;

    @Override
    public Integer call() {
        try {
            CharStream input = CharStreams.fromString(query);
            filefindLexer lexer = new filefindLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            filefindParser parser = new filefindParser(tokens);
            ParseTree tree = parser.query();

            if (verbose) {
                System.out.println("Parse tree: " + tree.toStringTree(parser));
            }

            evalvisitor visitor = new evalvisitor();
            visitor.visit(tree);

            String searchpath = visitor.getSearchPath();
            String filename = visitor.getFilename();
            List<ExprCondition> conditions = visitor.getConditions();

            List<String> results = Executor.execute(searchpath, filename, conditions);

            if (results.isEmpty()) {
                System.out.println("No files found matching the query.");
            } else {
                System.out.println("Files retrieved:");
                for (String file : results) {
                    System.out.println(file);
                }
            }
            return 0;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new FileFindCommand()).execute(args);
        System.exit(exitCode);
    }
}