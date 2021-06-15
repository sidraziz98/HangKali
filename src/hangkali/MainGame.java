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
import java.util.*;
public class MainGame {
    
    private WordBank word;
    private int length, chances;
    private ArrayList<String> dashes;
    private ArrayList<String> wrongChar;
    private String myWord,myWordMeaning;
    Scanner sc;
    
    MainGame(String level){
        sc = new Scanner(System.in);
        word = new WordBank();
        if (level.equals("Hard")) {
            myWord = word.getHardWord();
            myWordMeaning = word.getHardMeaning();
        } else {
            myWord = word.getEasyWord();
            myWordMeaning = word.getEasyMeaning();
        }
        length = myWord.length();
        chances = 5;
        dashes = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            dashes.add("__");
        }
        wrongChar = new ArrayList<>();
        System.out.println(myWord);
    }
    
    public String getWord(){
        return myWord;
    }
    
    public String getWordMeaning(){
        return myWordMeaning;
    }

    public String printDashes() {
        StringBuilder sb = new StringBuilder();
        for (String s : dashes) {
            sb.append(s);
            sb.append("\t");
        }
        return sb.toString();
    }
    
    public String getWrongChar() {
        StringBuilder sb = new StringBuilder();
        for (String s : wrongChar) {
            sb.append(s);
            sb.append("\t");
        }
        return sb.toString();
    }

    public boolean checkWin() {
        return !dashes.contains("__");
    }
    
    public boolean checkLose() {
        return chances<0;
    }

    public void checkLetter(String c){
        int x = 0;
        for(int i=0; i<length; i++){
            if(c.equals(myWord.substring(i,i+1))){
                dashes.set(i, c);
                x = 1;
            }
        }
        if(x==0 && !wrongChar.contains(c)){
            chances--;
            wrongChar.add(c);
            
        }
        
    }
    
    public int getChances(){
        return chances;
    }
    
    /*public void playAGame(){
        printDashes();
        do {
            System.out.print("Enter letter:");
            String str = sc.next().toLowerCase();
            checkLetter(str);
            System.out.println(printDashes());
            if(checkWin()){
                System.out.println("You Won!!!");
                break;
            }
        }while(!checkLose());
        if(checkLose()){
            System.out.println("You Lost:(");
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MainGame mg = new MainGame();
    }*/
    
}
