package designpattern.interpreter;

import java.text.NumberFormat;

public class MathInterpreter extends AbstractExpression{
    @Override
    Object interpreter(String info) {
        Double result = null;
        if(info.indexOf("+")!=-1){
            String[] strs  = info.split("\\+");
            result = Double.parseDouble(strs[0]) + Double.parseDouble(strs[1]);
        }else if(info.indexOf("-")!=-1){
            String[] strs  = info.split("-");
            result = Double.parseDouble(strs[0]) - Double.parseDouble(strs[1]);
        }else if(info.indexOf("*")!=-1){
            String[] strs  = info.split("\\*");
            result = Double.parseDouble(strs[0]) * Double.parseDouble(strs[1]);
        }else {
            return "暂时不支持";
        }
        NumberFormat nf = NumberFormat.getInstance();
        return nf.format(result);
    }

    public static void main(String[] args) {
        MathInterpreter interpreter = new MathInterpreter();
        System.out.println(interpreter.interpreter("12-3"));
    }
}
