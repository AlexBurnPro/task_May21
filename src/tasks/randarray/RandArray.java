package tasks.randarray;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandArray {

    public static void main(String[] args) {
        new Scan().scanInput();
    }
}

class Scan{

    UserInput userInput;

    public void scanInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input array size: ");
        int size = sc.nextInt();
        System.out.print("Input number: ");
        int num = sc.nextInt();

        userInput = new UserInput(size, num);
        userInput.input();
    }
}

class UserInput {

    private final int size;
    private static int num;
    private boolean isContinue;

    public UserInput(int size, int num){
        this.size = size;
        UserInput.num = num;
    }

    public static int getNum() {
        return num;
    }

    public void input() {

        do {
            randomArray();

            Scanner sc = new Scanner(System.in);
            System.out.print("\nYou`re want to continue? y/n : ");
            String s = sc.next();

            if (s.equalsIgnoreCase("y")) {
                isContinue = true;
                Scan scan = new Scan();
                scan.scanInput();
            } else {
                System.out.println("Bye-bye");
                System.exit(0);
            }
        } while (isContinue);
    }


    public void randomArray(){

        int[] arr = new int[size];
        Random random = new Random();

        for(int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(arr));
        new FindNumber().findNumberInArray(arr);
    }
}

class FindNumber{

    void findNumberInArray(int[] arr){

        int j = 0;
        boolean isFind = false;

        for (int i : arr){
            if(i == UserInput.getNum()){
                System.out.print("Number " + UserInput.getNum() + " is find! Position: " + j);
                isFind = true;
                break;
            }
            j++;
        }

        if(!isFind) System.out.println("Number " + UserInput.getNum() + " is not found");
    }
}


