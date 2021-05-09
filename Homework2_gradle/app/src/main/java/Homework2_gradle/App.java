/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Homework2_gradle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        int rowGlobal = 0;
        int columnGlobal = 0;
        int choiceGlobal;


        String[][] matrix = new String[50][50];
        Scanner scanner = new Scanner(System.in);

        do {
            displayChoice();
            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            choiceGlobal = choice;

            switch (choice) {
                case 1:

                    Random random = new Random();
                    //Generate matrix size, add value each cell
                    System.out.print("Enter matrix size: ");
                    int row = scanner.nextInt();
                    int column = scanner.nextInt();



                    rowGlobal = row; columnGlobal = column;
                    scanner.nextLine();
                    for (int i = 0 ; i < row; i++){
                        for (int j = 0; j < column; j++){
                            randomGenerated();
                            matrix[i][j] = String.valueOf(randomGenerated());
                        }
                    }

                    System.out.println("\n");
                    for (int i = 0 ; i < row; i++){
                        for (int j = 0; j < column; j++){
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println("\n");
                    }
                    break;

                case 2:
                    //search character occurrences
                    System.out.print("Enter character to search: ");
                    String characterSearch = scanner.nextLine();

                    char[] stringToChar = characterSearch.toCharArray();

                    for (int i = 0 ; i < rowGlobal; i++){
                        for (int j = 0; j < columnGlobal; j++){
                            int ctr = 0;
                            for (char splitChar : stringToChar){
                                String s = String.valueOf(splitChar);
                                if (matrix[i][j].contains(s)){
                                    ++ctr;
                                    if (ctr == characterSearch.length()){
                                        System.out.println("\n[" + i + "," + j +
                                                "] - 1" + " Occurrence/s");
                                    }else
                                        continue;
                                }
                                else
                                    break;
                            }


                        }
                    }
                    break;

                case 3:
                    //edit cell in matrix
                    Map<String, String> newAdd = new HashMap<>();
                    System.out.print("Enter matrix index:");
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter key value: ");
                    String keyNewValue = scanner.nextLine();
                    System.out.print("Enter pair value: ");
                    String pairNewValue = scanner.nextLine();
                    newAdd.put(keyNewValue, pairNewValue);
                    matrix[a][b] = String.valueOf(newAdd);

                    System.out.println("Matrix [" + a + "," + b + "]" + " is changed with a new value " +
                            keyNewValue + " " + pairNewValue);

                    for (int i = 0 ; i < rowGlobal; i++){
                        for (int j = 0; j < columnGlobal; j++){
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println("\n");
                    }
                    break;

                case 4:
                    //Print table
                    System.out.println("Printing Matrix....... \n");

                    for (int i = 0 ; i < rowGlobal; i++){
                        for (int j = 0; j < columnGlobal; j++){
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println("\n");
                    }
                    break;

                case 5:
                    //Reset matrix
                    System.out.println("Resetting Matrix Table....... Done resetting");
                    for (int i = 0 ; i < rowGlobal; i++){
                        for (int j = 0; j < columnGlobal; j++){
                            matrix[i][j] = "0";
                        }
                    }

                    for (int i = 0 ; i < rowGlobal; i++){
                        for (int j = 0; j < columnGlobal; j++){
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println("\n");
                    }
                    break;

                case 6:
                    System.out.println("Exiting program.......... terminated successfully");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Choice " + choice + " is invalid :(");
                    break;
            }
        } while (choiceGlobal != 6);
        System.out.println(new App().getGreeting());
    }

    public static void displayChoice(){
        System.out.println("SELECT OPTION:");
        System.out.println("[1] - GENERATE N X N MATRIX");
        System.out.println("[2] - SEARCH FOR CHARACTER OCCURRENCES");
        System.out.println("[3] - EDIT CELL IN MATRIX");
        System.out.println("[4] - PRINT TABLE");
        System.out.println("[5] - RESET MATRIX");
        System.out.println("[6] - QUIT");
    }

    public static Map<String, String> randomGenerated (){
        Map<String, String> key_pair = new HashMap();
        Random random = new Random();

        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();

        int ctr = 0;
        while (ctr < 6) {

            int a = random.nextInt((126-33) + 1) + 33;
            if (ctr < 3){ key.append((char) a); }
            else if (ctr > 2){ value.append((char) a); }
            ctr++;
        }

        String keyString = key.toString();
        String valueString = value.toString();
        key_pair.put(keyString, valueString);
        return key_pair;
    }
}
