package com.kaustabhinand.filefind.cli;

import com.kaustabhinand.filefind.eval.evalvisitor;
import com.kaustabhinand.filefind.exec.Executor;
import com.kaustabhinand.filefind.filefindLexer;
import com.kaustabhinand.filefind.filefindParser;
import com.kaustabhinand.filefind.model.Expr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
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
                    "  \"find file from 'C:\\Users\\you\\Downloads' where name like 'report' and ext = pdf\""
    )
    private String query;

    @Option(
            names = {"-v", "--verbose"},
            description = "Show extra detail while the query runs (parse tree, search path, filter)."
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
            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            filefindParser parser = new filefindParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);

            ParseTree tree = parser.query();

            if (verbose) {
                System.out.println("Parse tree: " + tree.toStringTree(parser));
            }

            evalvisitor visitor = new evalvisitor();
            visitor.visit(tree);

            String searchPath = visitor.getSearchPath();
            String filename = visitor.getFilename();
            Expr filter = visitor.getFilter();

            if (verbose) {
                System.out.println("Search path: " + searchPath);
                if (filename != null) {
                    System.out.println("Filename: " + filename);
                }
                System.out.println("Filter: " + (filter == null ? "(none)" : filter));
                System.out.println();
            }

            if (countOnly) {
                long count = Executor.execute(searchPath, filename, filter, hit -> {
                });
                System.out.println(count + " file(s) matched.");
                return 0;
            }

            long count = Executor.execute(searchPath, filename, filter, System.out::println);

            System.out.println();
            if (count == 0) {
                System.out.println("No files found matching the query.");
            } else {
                System.out.println(count + " file(s) matched.");
            }
            return 0;
        }
        catch (RecognitionException e) {
            throw new RuntimeException(e);
        }
    }
}