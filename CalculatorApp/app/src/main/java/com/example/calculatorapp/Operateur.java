package com.example.calculatorapp;

import java.text.DecimalFormat;


class Operateur {
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    public static String Op(String s){
        String[] equation = cutString(s);
        double sol = 0;

        switch (equation[1]){
            case "/":
                sol = Double.parseDouble(equation[0])/Double.parseDouble(equation[2]);
                break;
            case "*":
                sol = Double.parseDouble(equation[0])*Double.parseDouble(equation[2]);
                break;
            case "+":
                sol = Double.parseDouble(equation[0])+Double.parseDouble(equation[2]);
                break;
            case "-":
                sol = Double.parseDouble(equation[0])-Double.parseDouble(equation[2]);
                break;
        }
        return sol+"";
    }


    public static String[] cutString(String s){
        String[] arr = new String[0];
        if(s.contains("+")){
            arr = s.split("((?=[//+])|(?<=[//+]))");
        }
        if(s.contains("-")){
            arr = s.split("((?=-)|(?<=-))");
        }
        if(s.contains("*")){
            arr = s.split("((?=[//*])|(?<=[//*]))");
        }
        if(s.contains("/")){
            arr = s.split("((?=[///])|(?<=[///]))");
        }
        return arr;
    }


    public static String orderOp(String equation){
        while(equation.contains("/")){
            equation = equation.replace(getOp(equation),(decfor.format(Double.parseDouble(Op(getOp(equation))))).replace(',', '.'));

        }
        System.out.println("Division :" +equation);
        while(equation.contains("*")){
            equation = equation.replace(getOp(equation),decfor.format(Double.parseDouble(Op(getOp(equation)))).replace(',', '.'));
        }
        System.out.println("Multiplication:" +equation);
        while(equation.contains("+")){
            equation = equation.replace(getOp(equation),Op(getOp(equation)));
        }
        System.out.println("addition:" +equation);
        while(equation.contains("-")&& (equation.replaceAll("[^.]", "").length()>1)){
            equation = equation.replace(getOp(equation),Op(getOp(equation)).replace(',', '.'));
            equation = RemoveNegative(equation);
            System.out.println(equation);
        }
        return equation;

    }

    public static String getOp(String s){
        String r ="";
        if(s.contains("/")){
            int slash = s.indexOf("/");
            int first = slash;
            int last = slash;
            first -= 1;
            while((first >= 0)&&(s.charAt(first) != '+')&(s.charAt(first) != '-')&(s.charAt(first) != '*')&(s.charAt(first) != '/')){
                first -= 1;
            }
            first += 1;
            last += 1;
            while((last < s.length())&&(s.charAt(last) != '+')&(s.charAt(last) != '-')&(s.charAt(last) != '*')&(s.charAt(last) != '/')&&(s.charAt(last) != '/')){//&(last >= s.length())
                if(last < s.length()) {
                    last += 1;
                }
            }
            r = s.substring(first,last);
        }
        else if(s.contains("*")){
            int slash = s.indexOf("*");
            int first = slash;
            int last = slash;
            first -= 1;
            while((first >= 0)&&(s.charAt(first) != '+')&(s.charAt(first) != '-')&(s.charAt(first) != '*')&(s.charAt(first) != '/')){
                first -= 1;
            }
            first += 1;
            last += 1;
            while((last < s.length())&&(s.charAt(last) != '+')&&(s.charAt(last) != '-')&&(s.charAt(last) != '*')&&(s.charAt(last) != '/')){
                if(last < s.length()) {
                    last += 1;
                }
            }
            r = s.substring(first,last);
        }
        else if(s.contains("+")){
            int slash = s.indexOf("+");
            int first = slash;
            int last = slash;
            first -= 1;
            while((first >= 0)&&(s.charAt(first) != '+')&(s.charAt(first) != '-')&(s.charAt(first) != '*')&(s.charAt(first) != '/')){
                first -= 1;
            }
            first += 1;
            last += 1;
            while((last < s.length())&&(s.charAt(last) != '+')&&(s.charAt(last) != '-')&&(s.charAt(last) != '*')&&(s.charAt(last) != '/')){
                if(last < s.length()) {
                    last += 1;
                }
            }
            r = s.substring(first,last);
        }
        else if(s.contains("-")){
            int slash = s.indexOf("-");
            int first = slash;
            int last = slash;
            first -= 1;
            while((first >= 0)&&(s.charAt(first) != '+')&(s.charAt(first) != '-')&(s.charAt(first) != '*')&(s.charAt(first) != '/')){
                first -= 1;
            }
            first += 1;
            last += 1;
            while((last < s.length())&&(s.charAt(last) != '+')&&(s.charAt(last) != '-')&&(s.charAt(last) != '*')&&(s.charAt(last) != '/')){
                if(last < s.length()) {
                    last += 1;
                }
            }
            r = s.substring(first,last);
        }

        return r;
    }


    public static String RemoveNegative(String s){
        s = s.replace("-+","-");
        s = s.replace("+-","-");
        if(s.charAt(0) == '-'){
            s = s.replaceFirst("-","");
            s = s.replace("-","+");
            while(s.contains("+")){
                s = s.replace(getOp(s),Op(getOp(s)));
            }
            s = "-"+s;
        }
        return s;
    }

}
