


import edu.duke.*;
import java.io.*;

public class Part1 {
    
    public void findAbc(String input) {
        System.out.println("Input: " + input);
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1 || index + 4 > input.length()) {
                
                System.out.println("Last index: " + index);
                break;
            }
            System.out.println("Index: " + index);
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc", index+3);
        }
        System.out.println();        
    }
       public void test() {
        //no code yet
        // findAbc("abcd");
        // findAbc("abcbbbabcdddabc");
        // findAbc("aaaaabc");
        // findAbc("eusabce");
        
        findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
        findAbc("kdabcabcjei");
        findAbc("abcabcabcabca");
        
    }
    
    
    public static void main(String[] args) {
        
        Part1 test = new Part1();
        test.test(); 
    }
    
    
    
	
    
}
