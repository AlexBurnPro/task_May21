package tasks.randarray;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandArray {

    static FindNumber find;
    static UserInput input;
    static boolean isContinue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            input = new UserInput();
            input.userInput();

            find = new FindNumber(input.getSize(), input.getNum());
            find.randomArray();

            System.out.print("\nYou`re want to continue? y/n : ");
            String s = sc.next();
            if (s.equalsIgnoreCase("y")) {
                isContinue = true;
            } else {
                System.out.println("Bye-bye");
                return;
            }
        } while(isContinue);
    }
}

class FindNumber{

    private int size;
    private int num;

    public FindNumber(int size, int num) {
        this.size = size;
        this.num = num;
    }

    public void randomArray(){

        int[] arr = new int[size];
        Random random = new Random();

        for(int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(arr));
        findNumberInArray(arr);
    }

    public void findNumberInArray(int[] arr){

        int j = 0;
        boolean isFind = false;

        for (int i : arr){
            if(i == num){
                System.out.print("Number " + num + " is find! Position: " + j);
                isFind = true;
                break;
            }
            j++;
        }

        if(!isFind) System.out.println("Number " + num + " is not found");
    }
}

class UserInput{

    private int size;
    private int num;

    public int getSize(){
        return size;
    }

    public int getNum() {
        return num;
    }

    public void userInput(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Input array size: ");
        size = sc.nextInt();
        System.out.print("Input number: ");
        num = sc.nextInt();
    }
}


