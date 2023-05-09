import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class Calculator extends CalculatorBaseListener {

    Deque<Integer> numbers = new ArrayDeque<>();
    List<Integer> temp = new ArrayList<>();
    List<Integer> temp2 = new ArrayList<>();
/* Przetestowane przykłady:
sqrt(5+4)*(3-5)^2+3/2
sqrt(5^(2+4))
10/sqrt(1+3)+2*(4-7)
sqrt(20-2^2)
5^sqrt9+2^(15-2*6)
 */
    public static void main(String[] args) throws Exception {
        Integer result = calc("5^sqrt9+2^(15-2*6)");
        System.out.println("Result = " + result);
    }

    private Integer getResult() {
        return numbers.peekLast();
    }
    @Override
    public void exitExpression(CalculatorParser.ExpressionContext ctx) {
        System.out.println("exitExpression:" + ctx.getText());
        super.exitExpression(ctx);
    }


    @Override
    public void exitAdditiveExpression(CalculatorParser.AdditiveExpressionContext ctx) {
        System.out.println("exitExpression:" + ctx.getText());
        Integer value = numbers.peekLast();
        //children numer 1,3,5 itp mają w sobie znak działania (ie jest działań tyle razy pętla działa)
        for (int i = 1; i < ctx.getChildCount(); i = i + 2) {
            if (Objects.equals(ctx.getChild(i).getText(), "+")) {
                numbers.pollLast();
                value = value + numbers.peekLast();
                numbers.pollLast();
            } else if (Objects.equals(ctx.getChild(i).getText(), "-")){
                numbers.pollLast();
                value = numbers.peekLast() - value;
                numbers.pollLast();
            }
        }
        numbers.addLast(value);
        super.exitAdditiveExpression(ctx);
    }

    @Override
    public void exitMultiplicativeExpression(CalculatorParser.MultiplicativeExpressionContext ctx) {
        System.out.println("exitMultiplicativeExpression:" + ctx.getText());
        Integer value = numbers.peekLast();
       boolean flaga=false;
            for (int i = 1; i < ctx.getChildCount(); i = i + 2) {
                if (Objects.equals(ctx.getChild(i).getText(), "*")) {
                    numbers.pollLast();
                    value = value * numbers.peekLast();
                    flaga=true;
                } else if(Objects.equals(ctx.getChild(i).getText(), "/")){
                    numbers.pollLast();
                    value = (int) numbers.peekLast()/value;
                    flaga=true;
                }
            }
            if(flaga==true) {
                numbers.pollLast();
                numbers.addLast(value);
            }

        //temp2.clear();
        super.exitMultiplicativeExpression(ctx);
    }

    @Override
    public void exitExponentialExpression(CalculatorParser.ExponentialExpressionContext ctx) {
        System.out.println("exitExponentialExpression:" + ctx.getText());
        boolean flaga=false;
        Integer value = numbers.peekLast();
        for (int i = 1; i < ctx.getChildCount(); i = i + 2) {
            if (Objects.equals(ctx.getChild(i).getText(), "^")) {
                numbers.pollLast();
                value= (int) Math.pow(numbers.peekLast(), value);
                numbers.pollLast();
                numbers.addLast(value);
            }
        }

        super.exitExponentialExpression(ctx);
    }

    @Override
    public void exitPrimaryExpression(CalculatorParser.PrimaryExpressionContext ctx) {
        System.out.println("exitPrimaryExpression:" + ctx.getText());
       if (ctx.SQRT() != null) {
            int pom = (int) Math.round(Math.sqrt(numbers.peekLast()));
            numbers.pollLast();
            numbers.addLast(pom);
        }else if (ctx.LPAREN()!=null){
           //exitPrimaryExpression(ctx);
        }
        super.exitPrimaryExpression(ctx);
    }

    @Override
    public void exitNumberExpression(CalculatorParser.NumberExpressionContext ctx) {
        if (ctx.MINUS() != null) {
            numbers.addLast(-1 * Integer.valueOf(ctx.INT().toString()));
            temp.add(-1 * Integer.valueOf(ctx.INT().toString()));
        } else {
            numbers.addLast(Integer.valueOf(ctx.INT().toString()));
            temp.add(Integer.valueOf(ctx.INT().toString()));
        }
        super.exitNumberExpression(ctx);
    }


    public static Integer calc(String expression) {
        return calc(CharStreams.fromString(expression));
    }

    public static Integer calc(CharStream charStream) {
        CalculatorLexer lexer = new CalculatorLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.expression();

        ParseTreeWalker walker = new ParseTreeWalker();
        Calculator mainListener = new Calculator();
        walker.walk(mainListener, tree);
        return mainListener.getResult();
    }
}
