package com.kaustabhinand.filefind.eval;

import com.kaustabhinand.filefind.model.ExprCondition;
import com.kaustabhinand.filefind.filefindBaseVisitor;
import com.kaustabhinand.filefind.filefindParser;

//import org.antlr.v4.runtime.tree.*;
//import org.antlr.v4.runtime.*;
import java.util.*;
public class evalvisitor extends filefindBaseVisitor<Object> {
    private  String searchpath = ".";
    private  String filename = null;
    public String getSearchPath() {return searchpath;}
    public String getFilename() {return filename;}

    private List<ExprCondition> conditions = new ArrayList<>();
    public List<ExprCondition> getConditions() {return conditions;}

       @Override 
        public Object visitQuery(filefindParser.QueryContext ctx) {
            // Implementation for visiting Query nodes

            if(ctx.FILE() != null) { // FILE keyword is given.
                  if(ctx.FROM() != null) {
                    searchpath = ctx.STRING(0).getText().replace("\"", "");
                  }    

                  else {
                    searchpath = "C:/Users"; // root directory, by default.
                    System.out.println("Searchpath: "+ searchpath);
                  }
            }

            else {
                filename = ctx.STRING(0).getText().replace("\"", "");
                if(ctx.FROM() != null) searchpath = ctx.STRING(1).getText().replace("\"", "");
            }

         return visitChildren(ctx);   
        }


    @Override
    public Object visitExpr(filefindParser.ExprContext ctx) {
        System.out.println("VisitExpr called!");
        if(ctx.EXT() != null) { // Extension is given
            String op = ctx.relop().getText();
            String value = ctx.STRING().getText().replace("\"", "");
            System.out.println("Extension: "+ value);
            conditions.add(new ExprCondition("ext", op, value));
        }

        if(ctx.SIZE() != null) { // Size is given
          String op = ctx.relop().getText();
          String value = ctx.NUMBER().getText();
          conditions.add(new ExprCondition("size", op, value));
        }

        if(ctx.CREATED() != null && ctx.RECENTLY() != null) { // Recently is given.
            String op = ctx.relop().getText();
            conditions.add(new ExprCondition("created", op, "recently"));
        }

        if(ctx.CREATED() != null && ctx.RECENTLY() == null) { // Time is mentioned.
            String op = ctx.relop().getText();
            String time = ctx.time().getText(); 
            conditions.add(new ExprCondition("created", op, time));
        }

        if(ctx.CONTAINS() != null) { // Contains is given.
            String value = ctx.STRING().getText();
            conditions.add(new ExprCondition("contains", "contains", value));
        }

        if(ctx.DATE_MODIFIED() != null) { // Date modified is given.
            String op = ctx.relop().getText();
            String date_modified = ctx.time().getText();
            conditions.add(new ExprCondition("date_modified", op, date_modified));
        }

        return visitChildren(ctx);
}
}