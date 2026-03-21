import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) {

        String query = "find file from \"c:\\antlr\" where ext = \"java\""; // test query 
        CharStream input = CharStreams.fromString(query);
        filefindLexer lexer = new filefindLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        filefindParser parser = new filefindParser(tokens);
        ParseTree tree = parser.query();
        System.out.println("Parse tree: "+ tree.toStringTree(parser));

        evalvisitor visitor = new evalvisitor();
        visitor.visit(tree); // traverse the tree.

        String searchpath = visitor.getSearchPath();
        String filename = visitor.getFilename();
        List<ExprCondition> conditions = visitor.getConditions();

        List<String> results = Executor.execute(searchpath, filename, conditions);

        if(results.isEmpty()) {
            System.out.println("No files found, matching the query. :(");
            return;
        }

        else {
            System.out.println("Files retrieved: ");
            for(String file: results) {
                System.out.println(file);
            }
        }
    }
}
