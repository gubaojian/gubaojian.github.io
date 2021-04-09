package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LeeCodeUtils {


    public int[] toInts(String fileName, int line){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(ServerTest.class.getResourceAsStream("case.txt")));
            while (line > 0) {
                br.readLine();
            }
            String str = br.readLine();
            int[] result = toInts(str);
            br.close();
            return  result;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    public static String[] toStrs(String fileName, int line){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(ServerTest.class.getResourceAsStream("case.txt")));
            while (line > 0) {
                br.readLine();
            }
            String str = br.readLine();
            String[] result = toStrs(str);
            br.close();
            return  result;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }



    private static int[] toInts(String arrays){
        arrays= arrays.substring(1);
        arrays = arrays.substring(0, arrays.length()-1);
        String[] strs = arrays.split(",");
        int[] nums = new int[strs.length];
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            nums[i] = Integer.parseInt(str);
        }
        return nums;
    }

    private static String[] toStrs(String arrays){
        arrays= arrays.substring(1);
        arrays = arrays.substring(0, arrays.length()-1);
        String[] strs = arrays.split(",");

        return strs;
    }
}
