package com.company;

public class PatternTest {

    public static void main(String[] args){

        String s = "mississippi";
        String pattern = "mis*is*p*.";

        String s1 = "ab";
        String p1 = "a.*";


        System.out.println(isMatch(s, pattern));

        System.out.println(isMatch(s1, p1));

        System.out.println(isMatch("a", "ab*"));



    }


    public static boolean isMatch(String s, String p) {
        return isMatchPattern(s, 0, p, 0);
    }


    public static boolean isMatchPattern(String s, int sStart, String p, int pStart){
        if(pStart == p.length() && sStart == s.length()){
            return true;
        }
        if(pStart >= p.length()){
            if(sStart < s.length()){
                return false;
            }
            return true;
        }

        char ch = p.charAt(pStart);
        if((pStart + 1) < p.length() && p.charAt(pStart + 1) == '*'){
            boolean nextMatch = isMatchPattern(s, sStart, p,  pStart + 2);
            while(!nextMatch){
                if(sStart < s.length()){
                    char sch = s.charAt(sStart);
                    if(sch == ch || ch == '.'){
                        sStart++;
                    }else{
                        return false;
                    }
                }else{
                    break;
                }
                nextMatch = isMatchPattern(s, sStart, p,  pStart + 2);
            }
            return nextMatch;
        }else{
            if(sStart >= s.length()){
                return false;
            }
            char sch = s.charAt(sStart);
            if(sch == ch || ch == '.'){
                if(!isMatchPattern(s, sStart + 1, p,  pStart + 1)){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }




}
