import java.io.IOException;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args){
        System.out.println("Input:");
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("Output:\n "+Main.calc(scanner.next()));
        }
    }
    class Main {
        static int ind=0;
        public static String calc(String input){
            Main.ind=0;
            String A="",B="";
            char z='0';
            int w=0;
            String[] symbs4={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
            String[] symbs3={"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
            char[] symbs1= {'+', '-', '*', '/'};
            char[] inputs=input.toCharArray();
            for (int i=0;i<inputs.length;){
                for (int j=0;j<symbs1.length;){
                    if (inputs[i]==symbs1[j]){
                        w++;
                        if (w>1){Main.err8();
                        }
                        if (i==inputs.length-1){Main.err4();
                        }
                        if (i==0){Main.err5();
                        }
                        z=symbs1[j];
                        for (int k=0;k<i;k++){
                            A+=inputs[k];
                        }
                        for (int l=i+1;l<inputs.length;l++){
                            B+=inputs[l];
                        }
                    }
                    j++;
                }
                i++;
            }
            if (z=='0'){
                Main.err1();
            }
            int A1=Main.num(A,symbs3);
            int B1=Main.num(B,symbs3);
            if (Main.ind==1){
                Main.err6();
            }
            String S=Main.rez(A1,B1,z,symbs1);
            if (Main.ind==2){
                S=Main.rimRez(S,symbs3,symbs4);
            }
            return S;}
        static void err1(){
            try {
                throw new IOException();
            } catch (IOException e) {
                String text="Cтрока не является математической операцией или присутствует пробел!\"";
                System.out.println(text);
                System.exit(0);
            }
        }
        static void err2(){
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Введено число вне заданного диапазона");
                System.exit(0);
            }
        }
        static void err3(){
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Введены не числа");
                System.exit(0);
            }
        }
        static void err4(){
            try {
                throw new IOException();
            } catch (IOException e) {
                String text="Не введен второй операнд или присутствует пробел!\"";
                System.out.println(text);
                System.exit(0);
            }
        }
        static void err5(){
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Не введен первый операнд");
                System.exit(0);
            }
        }
        static void err6(){
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Используются одновременно разные системы счисления");
                System.exit(0);
            }
        }
        static void err7(){
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("В римской системе нет отрицательных чисел и ноля");
                System.exit(0);
            }
        }
        static void err8(){
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(0);
            }
        }
        static int num(String num,String[] symbs3){
            String Num="";
            int q=0;
            for (int j=1;j<symbs3.length;){
                if (num.equals(symbs3[j])){
                    q=j;
                    Num+=q;
                    Main.ind++;
                }
                j++;
            }
            if (q==0){
                int m=0;
                char[] symbs2={'0','1','2','3','4','5','6','7','8','9'};
                char[] nums=num.toCharArray();
                for (int j=0;j<nums.length;){
                    for (int i=0;i<symbs2.length;){
                        if (nums[j]==symbs2[i]){
                            Num+=nums[j];
                            m++;
                        }
                        i++;
                    }
                    j++;
                }
                if (m!=nums.length){
                    Main.err3();
                }
            }
            int Num1=Integer.parseInt(Num);
            return Num1;
        }
        static String rez(int A1,int B1,char z,char[] symbs1){
            if (A1>10|A1<1|B1>10|B1<1){
                Main.err2();
            }
            int S=0;
            if (z==symbs1[0]){
                S=A1+B1;
            }
            if (z==symbs1[1]){
                S=A1-B1;
            }
            if (z==symbs1[2]){
                S=A1*B1;
            }
            if (z==symbs1[3]){
                S=A1/B1;
            }
            String S1=S+"";
            return S1;
        }
        static String rimRez(String S1,String[] symbs3,String[] symbs4){
            int S=Integer.parseInt(S1),i=S/10,j=S%10;
            if (S<1){
                Main.err7();
            }
            String R=""+symbs4[i]+symbs3[j];
            return R;
        }
    }
}
