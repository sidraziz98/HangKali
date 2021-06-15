package hangkali;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sidra Aziz 14809
 */
import java.io.*;
import java.util.*;
public class WordBank {
    
    private ArrayList<String> HardWords,EasyWords;
    private ArrayList<String> EasyMeaning,HardMeaning;
    BufferedReader bR,brM;
    private String EasyWord,HardWord;//word for one game
    private String MeaningEasy,MeaningHard;//meaning of word
    
    WordBank() {
        try {
            java.net.URL bR_URL = getClass().getResource("/list.txt");
            bR = new BufferedReader(new FileReader(new File(bR_URL.toString().substring(5))));
            java.net.URL bRM_URL = getClass().getResource("/meaning.txt");
            brM = new BufferedReader(new FileReader(new File(bRM_URL.toString().substring(5))));
            HardWords = new ArrayList<>();
            EasyWords = new ArrayList<>();
            HardMeaning = new ArrayList<>();
            EasyMeaning = new ArrayList<>();
            
            String str,strM;
            while ((str = bR.readLine()) != null) {
                if (str.length() <= 6) {
                    EasyWords.add(str);
                    strM = brM.readLine();
                    EasyMeaning.add(strM);
                } else {
                    HardWords.add(str);
                    strM = brM.readLine();
                    HardMeaning.add(strM);
                }
            }bR.close(); brM.close();
        }catch(IOException e){
            System.err.println();
        }
        
        int indexE = (int)(Math.random()*EasyWords.size());
        EasyWord = EasyWords.get(indexE).toUpperCase();
        MeaningEasy = EasyMeaning.get(indexE);
        int indexH = (int)(Math.random()*HardWords.size());
        HardWord = HardWords.get(indexH).toUpperCase();
        MeaningHard = HardMeaning.get(indexH);
        
    }
    
    public String getEasyWord(){
        return EasyWord;
    }
    
    public String getHardWord(){
        return HardWord;
    }

    public String getEasyMeaning() {
        return MeaningEasy;
    }
    
    public String getHardMeaning() {
        return MeaningHard;
    }
    
    /*public static void main(String[] args){
        WordBank wb = new WordBank();
        for (String str : wb.EasyWords) {
            System.out.println(str);
        }System.out.println();
        for (String str : wb.HardWords) {
            System.out.println(str);
        }
        System.out.println("\n"+wb.getEasyWord());
        System.out.println(wb.getEasyMeaning());
        System.out.println("\n"+wb.getHardWord());
        System.out.println(wb.getHardMeaning());
    }*/
    
}
