import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

abstract class GeneralUtilities {
    static void outputMessage(String input){
        System.out.println(input);
    }

    static String capitalizeString(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
    
    static int randomChoice(int range){
        return (int)(Math.round(Math.random() * (range - 1)));
    }

    static int randomChoice(int start, int end){
        return (int)(Math.round(Math.random() * (end - start + 1)) + start);
    }

    static String randomName(char gender) throws FileNotFoundException{
        String randomName = "";
        Scanner fileReader;
        if(gender == 'm'){

            fileReader = new Scanner(new File("Java_testing/Zoo_Managing_Assignment/MaleNames.txt"));
            int nameChoice = randomChoice(2937);
            for(int i = 0; i < nameChoice; i++){
                randomName = fileReader.nextLine();
            }
            fileReader.close();
        } else if (gender == 'f'){
            fileReader = new Scanner(new File("Java_testing/Zoo_Managing_Assignment/FemaleNames.txt"));
            int nameChoice = randomChoice(4997);
            for(int i = 0; i < nameChoice; i++){
                randomName = fileReader.nextLine();
            }
            fileReader.close();
        }
        return randomName;
    }
}
