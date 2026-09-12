package com.kaustabhinand.filefind.cli;

import com.kaustabhinand.filefind.eval.evalvisitor;
import com.kaustabhinand.filefind.exec.Executor;
import com.kaustabhinand.filefind.model.ExprCondition;
import com.kaustabhinand.filefind.filefindLexer;
import com.kaustabhinand.filefind.filefindParser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.List;
import java.util.concurrent.Callable;

@Command(
        name = "filefind",
        mixinStandardHelpOptions = true, // gives --help and --version for free
        version = "FileFind 1.0",
        description = "Search your files using a simple, SQL-like query language.",
        header = "FileFind - search your files%n",
        synopsisHeading = "%nUsage:%n  ",
        descriptionHeading = "%nDescription:%n  ",
        optionListHeading = "%nOptions:%n",
        sortOptions = false
)
public class FileFindCommand implements Callable<Integer> {

    @Parameters(
            index = "0",
            paramLabel = "QUERY",
            description = "The FileFind query to run, e.g.:%n" +
                    "  \"find file from 'C:\\Users\\you\\Downloads' where ext = java\""
    )
    private String query;

    @Option(
            names = {"-v", "--verbose"},
            description = "Show extra detail while the query runs (parse tree, search path, condition list)."
    )
    private boolean verbose;

    @Option(
            names = {"-c", "--count"},
            description = "Print only the number of matching files instead of listing each path."
    )
    private boolean countOnly;

    public static void main(String[] args) {
        printBanner();
        int exitCode = new CommandLine(new FileFindCommand()).execute(args);
        System.exit(exitCode);
    }

    private static void printBanner() {
        System.out.println("FileFind - search your files");
        System.out.println();
    }

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

            String searchPath = visitor.getSearchPath();
            String filename = visitor.getFilename();
            List<ExprCondition> conditions = visitor.getConditions();

            if (verbose) {
                System.out.println("Search path: " + searchPath);
                if (filename != null) {
                    System.out.println("Filename: " + filename);
                }
                System.out.println("Conditions:");
                for (ExprCondition condition : conditions) {
                    System.out.println("  " + condition);
                }
                System.out.println();
            }

            List<String> results = Executor.execute(searchPath, filename, conditions);

            if (countOnly) {
                System.out.println(results.size() + " file(s) matched.");
                return 0;
            }

            if (results.isEmpty()) {
                System.out.println("No files found matching the query.");
                return 0;
            }

            System.out.println("Files retrieved:");
            for (String file : results) {
                System.out.println(file);
            }

            return 0;

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            if (verbose) {
                e.printStackTrace();
            }
            return 1;
        }
    }
}