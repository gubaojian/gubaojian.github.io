package org.efurture.learn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class WordLinesQuery {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] sentencs = new String[n];
        String[] querys = new String[m];

        System.out.println(6 + " + " + 3);

        for(int i=0; i<n; i++){
            String line = scanner.nextLine();
            while (line == null || "null".equals(line) || line.trim().length() == 0){
                line = scanner.nextLine();
            }
            sentencs[i] = line;
            System.out.println((sentencs[i] == null) + "  " + sentencs[i]);
        }

        for(int i=0; i<m; i++){
            String line = scanner.nextLine();
            while (line == null || "null".equals(line) || line.trim().length() == 0){
                line = scanner.nextLine();
            }
            querys[i] = line;
        }
        HashSet<String>[] indexs = new HashSet[n];
        for(int i=0; i<n; i++){
            String sentenc = sentencs[i];
            String[] wordStrs =  sentenc.split(" ");
            HashSet<String> wordsSet = new HashSet<>();
            for(String wordStr : wordStrs){
                if(wordStr.length() == 0){
                    continue;
                }
                wordsSet.add(wordStr.toLowerCase());
            }
            indexs[i] = wordsSet;
        }
        String[] results = new String[m];
        for(int i=0; i<m; i++){
            String[] words = querys[i].split(" ");
            HashSet<String> wordsSet = new HashSet();
            for(String word : words){
                wordsSet.add(word.toLowerCase());
            }

            int maxCount = 0;
            for(int k=0; k<n; k++){
                HashSet<String> index = indexs[k];
                int count = 0;
                for(String word : wordsSet){
                    if(index.contains(word)){
                        count++;
                    }
                }
                if(count > maxCount){
                    maxCount = count;
                    results[i] = sentencs[k];
                }
            }
        }

        for(String result : results){
            System.out.println(result);
        }


    }


}
