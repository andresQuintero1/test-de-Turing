/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_turing;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math.*;

/**
 *
 * @author FELIPE
 */
public class Test_Turing {

    /**
     * @param args the command line arguments
     */
                                //SALUDOS BASICOS
    private String[][] quotes={{"hola","buenos dias","buenas tardes","buenas noches","ola","hello"},
                               {"hola","hola, que tal?","buenos dias", "buenas tardes","un placer conocerle"},
                               //SALUDOS CON PREGUNTAS
                               {"que tal", "como esta","que tal", "como ha estado","como le va","como estas"},
                               {"bien, gracias","nada mal y usted?","bien gracias","bien, bien"},
                               //PREGUNTAS
                               {"como te llamas","donde estudias","cuantos años tienes","de donde eres"},
                               {"me llamo chatbot","me encuentro estudiando en la universidad distrital","tengo 18 años", "soy de Bogota, Colombia"}};
    
    private final ArrayList<String> Input=new ArrayList<>(Arrays.asList(
                                "cual es tu banda favorita","donde vives"));
    
    private final ArrayList<String> reponse=new ArrayList<>(Arrays.asList(
                                "Metallica","actualmente vivo en Colombia"));
    
    
    public String cleanInput (String str){
        str=str.trim();
        
        while(str.charAt(str.length()-1)=='¿'||str.charAt(str.length()-1)=='?'||
              str.charAt(str.length()-1)=='¡'||str.charAt(str.length()-1)=='!'||
              str.charAt(str.length()-1)=='.'||str.charAt(str.length()-1)==','||
                str.charAt(str.length()-1)=='-'){
            str=str.substring(0, str.length()-1);
            str=str.trim();

        }
        while(str.charAt(0)=='¿'||str.charAt(0)=='?'||
              str.charAt(0)=='¡'||str.charAt(0)=='!'||
              str.charAt(0)=='.'||str.charAt(0)==','||
                str.charAt(0)=='-'){
            str=str.substring(1);
            str=str.trim();
        }
        str=str.toLowerCase();
        
        return str;
    }
    
    public String getMessage(String str){
        boolean find=false;
        int j=0;
        int r=0;
        int pos=0;
        
        str=this.cleanInput(str);
        
        while(!find){
            if(this.buscar(str, quotes[2*j])){
                find=true;
                r=(int)Math.floor(Math.random()*this.quotes[(j*2)+1].length);
                return this.quotes[(j*2)+1][r];
            }
            j++;
            if((j*2+1)==quotes.length-1){
                pos=this.buscar1(str,quotes[2*j]);
                if(pos!=-1 ){
                  return this.quotes[(j*2)+1][pos];  
                }
                find=true;
            }
            
        }
        if(this.Input.contains(str)){
            return this.reponse.get(this.Input.indexOf(str));
        }else{
            return "no entiendo";
        }
    }
    
    public boolean buscar(String str,String[] s){
        for(int i=0;i<s.length;i++){
            if(str.equals(s[i])){
                return true;
            }
        } 
        return false;
    }
        public int buscar1(String str,String[] s){
        for(int i=0;i<s.length;i++){
            if(str.equals(s[i])){
                return i;
            }
        } 
        return-1;
    }
        public void addResponse(String in,String res){
            in=this.cleanInput(in);
            this.reponse.add(res);
            this.Input.add(in);
        }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Test_Turing c=new Test_Turing();
        ChatBot chat=new ChatBot(c);
        
    }
    
}
