public class ExprCondition {
    public String Field;
    public String Operator;
    public String Value;

    public ExprCondition(String field, String operator, String value) {
        this.Field = field;
        this.Operator = operator;
        this.Value = value;
    }

    public String toString() {
        return String.format("%s %s %s", Field, Operator, Value);
    }
}
