package study;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Expression {
    private static final Pattern REGEX = Pattern.compile("^\\d+( ?[+\\-*/] ?\\d+)*$");

    private final String value;

    private Expression(String expr) {
        this.value = expr;
    }

    public static Expression from(String expr) {
        validate(expr);
        return new Expression(expr);
    }

    private static void validate(String expr) {
        if (expr == null || !REGEX.matcher(expr).matches()) {
            throw new IllegalArgumentException("잘못된 값 인데용?");
        }
    }

    public String get() {
        return this.value.replace(" ", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
