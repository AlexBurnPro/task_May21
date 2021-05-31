package tasks.randarray;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandArray {

    public static void main(String[] args) {
        new Scan().scanInput();
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

class Scan{

    public void scanInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input array size: ");
        int size = sc.nextInt();
        System.out.print("Input number: ");
        int num = sc.nextInt();

        UserInput userInput = new UserInput(size, num);
        userInput.input();
    }
}

class UserInput {

    private int size;
    private int num;

    private UserInput userInput;
    private FindNumber find;
    private boolean isContinue;

    public UserInput(int size, int num){
        this.size = size;
        this.num = num;
    }

    public int getSize() {
        return size;
    }

    public int getNum() {
        return num;
    }

    public void input() {

        UserInput userInput = new UserInput(size, num);

        do {
            find = new FindNumber(userInput.getSize(), userInput.getNum());
            find.randomArray();

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
}



