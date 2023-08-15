import java.util.Scanner;

public class Strings {

    public static void printLetters(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
    } 

    public static boolean palindrome(String str){
        for(int i=0,j=str.length()-1;i<j;i++,j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void shortestPath(String str){
        int x=0,y=0;
        char c;

        for(int i=0;i<str.length();i++){
            c=str.charAt(i);
            switch(c){
                case 'N' : y=y+1;
                            break;
                case 'S' : y=y-1;
                            break;
                case 'E' : x=x+1;
                            break;
                case 'W' : x=x-1;
                            break;
                default  : break;
            }
        }
        // System.out.println(x);
        // System.out.println(y);

        double d = Math.sqrt(x*x + y*y);
        System.out.println(d);
    }

    public static String subString(String str, int begin,int end){
        String substr="";
        for(int i=begin;i<end;i++){
            substr += str.charAt(i);
        }
        return substr;
    }

    public static String largestString(String arr[]){
        String largest = arr[0];
        for(int i=1;i<arr.length;i++){
            if(largest.compareToIgnoreCase(arr[i])<0){
                largest=arr[i];
            }
        }
        return largest;
    }

    public static String toUpperCases(String str){
        StringBuilder sb=new StringBuilder("");

        sb.append(Character.toUpperCase(str.charAt(0)));

        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static String compress(String str){
        StringBuilder sb = new StringBuilder("");

        for(int i=0;i<str.length();i++){
            Integer count=1;

            sb.append(str.charAt(i));
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            if(count>1){
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        // char arr[]={'a','b','c','d'};
        // String str="abcd";
        // String str1 =new String("xyz");

        // Scanner sc=new Scanner(System.in);
        // String str=new String();
        // str=sc.nextLine();

        // System.out.println(str);
        // printLetters(str);

        // System.out.println(palindrome(str));
        String str1 = "moon";
        System.out.println(palindrome(str1));
        String str2 = "madam";        
        System.out.println(palindrome(str2));

        // String comparisn 
        String str3=new String("moon");
        if(str1.equals(str3)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        String path="WNEENESENNN";
        shortestPath(path);

        String substr=subString("helloworld", 3, 6);
        System.out.println(substr);

        String strarr[]={"apple","mengo","banana"};
        System.out.println(largestString(strarr));

        String welcome ="hi, i am suvajit";
        System.out.println(toUpperCases(welcome));

        String word="aaabbcccdd";
        System.out.println(compress(word));

        String word1="abcd";
        System.out.println(compress(word1));
    }
}
