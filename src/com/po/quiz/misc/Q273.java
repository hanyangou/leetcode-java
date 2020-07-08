package com.po.quiz.misc;

public class Q273 {
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        int billion = num / 1000000000;
        if(billion > 0)
            sb.append(threeDigits(billion) + " Billion ");
        int million = (num % 1000000000) / 1000000;
        if(million > 0)
            sb.append(threeDigits(million) + " Million ");
        int thousand = (num % 1000000) / 1000;
        if(thousand > 0)
            sb.append(threeDigits(thousand) + " Thousand ");
        int rest = num % 1000;
        sb.append(threeDigits(rest));
        return sb.toString().trim();
    }

    public String oneDigit(int num){
        return one(num);
    }

    public String twoDigits(int num){
        if(num <= 9) return oneDigit(num);
        if(num < 20) return lessTwenty(num);
        else {
            int tens = num / 10;
            int rest = num % 10;
            if(rest == 0) return tens(tens);
            else return tens(tens) + " " + oneDigit(rest);
        }
    }

    public String threeDigits(int num){
        if(num <= 99) return twoDigits(num);
        int hundreds = num / 100;
        int rest = num % 100;
        if(rest == 0) return oneDigit(hundreds) + " Hundred";
        else return oneDigit(hundreds) + " Hundred " + twoDigits(rest);
    }

    public String one(int num){
        switch (num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }

    public String lessTwenty(int num){
        switch (num){
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            default: return "";
        }
    }

    public String tens(int num){
        switch (num){
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
            default: return "";
        }
    }
}


/***
 public String one(int num){
 switch(num){
 case 1: return "One";
 case 2: return "Two";
 case 3: return "Three";
 case 4: return "Four";
 case 5: return "Five";
 case 6: return "Six";
 case 7: return "Seven";
 case 8: return "Eight";
 case 9: return "Nine";
 }
 return "";
 }

 public String lessTwenty(int n){
 switch (n){
 case 10: return "Ten";
 case 11: return "Eleven";
 case 12: return "Twelve";
 case 13: return "Thirteen";
 case 14: return "Fourteen";
 case 15: return "Fifteen";
 case 16: return "Sixteen";
 case 17: return "Seventeen";
 case 18: return "Eighteen";
 case 19: return "Nineteen";
 }
 return "";
 }

 public String ten(int n){
 switch (n){
 case 2: return "Twenty";
 case 3: return "Thirty";
 case 4: return "Forty";
 case 5: return "Fifty";
 case 6: return "Sixty";
 case 7: return "Seventy";
 case 8: return "Eighty";
 case 9: return "Ninwty";
 }
 return "";
 }

 public String two(int n){
 if(n == 0) return "";
 else if(n < 10) return one(n);
 else if(n < 20) return lessTwenty(n);
 else {
 int ten = n / 10;
 int rest = n - ten*10;
 if(rest != 0){
 return ten(ten) + " " + one(rest);
 } else {
 return ten(ten);
 }
 }
 }

 public String three(int n){
 int hundred = n / 100;
 int rest = n - hundred * 100;
 if(rest != 0 && hundred != 0){
 return one(hundred) + " Hundred " + two(rest);
 } else if (rest == 0) {
 return one(hundred) + " Hundred";
 } else {
 return two(rest);
 }
 }

 public String numberToWords(int num) {
 if(num == 0) return "Zero";

 int billion = num / 1000000000;
 int million = (num - billion * 1000000000) / 1000000;
 int thoudand = (num - billion * 1000000000 - million * 1000000) / 1000;
 int rest = num - billion * 1000000000 - million * 1000000 - thoudand * 1000;
 StringBuilder sb = new StringBuilder();

 if(billion != 0){
 sb.append(three(billion) + " Billion");
 }
 if(million != 0){
 if(sb.length() > 0) sb.append(" ");
 sb.append(three(million) + " Million");
 }
 if(thoudand != 0){
 if(sb.length() > 0) sb.append(" ");
 sb.append(three(thoudand) + " Thousand");
 }
 if(rest != 0){
 if(sb.length() > 0) sb.append(" ");
 sb.append(three(rest));
 }
 return sb.toString();
 }

 ***/