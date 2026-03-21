import java.util.*;
import java.io.File;

public class Executor {
    public static List<String> execute(String searchpath, String filename, List<ExprCondition> conditions) {
        List<String> results = new ArrayList<>();
        File dir = new File(searchpath);
        if (!dir.isDirectory() || !dir.exists()) {
            System.out.println("Invalid search path: " + searchpath);
            return results;
        }
        searchFiles(dir, filename, conditions, results);
        return results;
    }

    public static void searchFiles(File dir, String filename, List<ExprCondition> conditions, List<String> results) {
        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                searchFiles(file, filename, conditions, results); //recurse down the directory
            } else {
                if (matches(file, filename, conditions)) {
                    results.add(file.getAbsolutePath());
                }
            }
        }
    }

public static boolean matches(File file, String filename, List<ExprCondition> conditions) {
    if (filename != null && !file.getName().equals(filename)) {
        return false;
    }

    for (ExprCondition condition : conditions) {
        switch (condition.Field) {

            case "ext":
                String ext = getFileExtension(file);
                if (!evaluateCondition(ext, condition.Operator, condition.Value)) {
                    return false;
                }
                break;
            
            case "size": // Evaluate size condition
                long size = file.length();
                if (!evaluateCondition(String.valueOf(size), condition.Operator, condition.Value)) {
                    return false;
                }
                break;
            
            case "created": // created codition
                long createdTime = file.lastModified();
                long targetTime;
                if(condition.Value.equals("recently")) {
                    targetTime = System.currentTimeMillis() - (15L * 24 * 60 * 60 * 1000); // 15 days ago
                    return createdTime >= targetTime;
                }

                else {
                    targetTime = Long.parseLong(condition.Value);
                    if (!evaluateCondition(String.valueOf(createdTime), condition.Operator, String.valueOf(targetTime))) {
                    return false;
                }
                }
                break;
            
             case "contains":
                return file.getName().contains(condition.Value);
            
            case "date_modified":
                long modifiedTime = file.lastModified();
                if (!evaluateCondition(String.valueOf(modifiedTime), condition.Operator, condition.Value)) {
                    return false;
                }
                break;
        }
    }
    return true;
}

public static boolean evaluateCondition(String parameter, String Operator, String value) {
    switch (Operator) {
        case "=":
            try {return Long.parseLong(parameter) == Long.parseLong(value);}
            catch(NumberFormatException e) {return parameter.equals(value);}
        case "!=":
            return Long.parseLong(parameter) != Long.parseLong(value);
        case ">":
            return Long.parseLong(parameter) > Long.parseLong(value);
        case ">=":
            return Long.parseLong(parameter) >= Long.parseLong(value);
        case "<":
            return Long.parseLong(parameter) < Long.parseLong(value);
        case "<=":
            return Long.parseLong(parameter) <= Long.parseLong(value);
        default:
            return false;
    }
}

public static String getFileExtension(File file) {
    String name = file.getName();
    int lastIndex = name.lastIndexOf('.');
    if (lastIndex > 0 && lastIndex < name.length() - 1) {
        return name.substring(lastIndex + 1);
    }
    return "";
}

}


