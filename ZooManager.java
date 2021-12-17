/*
@Author: Henry Yang
@Version: December 11

This is a program that allows the user to manage a randomly generated zoo, where they can use a variety of commands to do different things in the zoo.
*/
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZooManager {
    public static void main(String[] args) throws FileNotFoundException{
        boolean runProgram = true;
        String userInput;
        Scanner keyboard = new Scanner(System.in);

        UserInterface.generateZoo();

        GeneralUtilities.outputMessage("Welcome to the Local Zoo! Here is a list of the commands you can use to manage the zoo: \n\nRequest [animalname] [currentaction, currentstate, currentlocation, allinfo]\nList [offexhibitanimals, onexhibitanimals, circusanimals, allanimals]\nMove [animalname] [offexhibit, onexhibit, circus]\nBreed [maleanimalname] [femaleanimalname]\nFeed [animalname]\nFeedAll\nRest [animalname]\nRestAll\nExhibit [animalname]\nTrain [animalname]\nPerform [animalname]\nQuit");

        while(runProgram){
            System.out.print("\nEnter your command into the console: ");
            userInput = keyboard.nextLine();
            runProgram = parseUserInput(userInput);
        }
        keyboard.close();
    }

    private static boolean parseUserInput(String input) throws FileNotFoundException{
        boolean outputBoolean = true;
        String[] inputArray = input.split(" ");
        switch(inputArray[0].toLowerCase()){
            case "request":
                Animal targetAnimal = UserInterface.findAnimalByName(inputArray[1]);
                if(targetAnimal != null){
                    switch(inputArray[2].toLowerCase()){
                        case "currentaction":
                            UserInterface.getAnimalCurrentAction(targetAnimal);
                            break;
                        case "currentstate":
                            UserInterface.getAnimalCurrentState(targetAnimal);
                            break;
                        case "currentlocation":
                            UserInterface.getAnimalLocation(targetAnimal);
                            break;
                        case "allinfo":
                            UserInterface.getAnimalInformation(targetAnimal);
                            break;
                        default:
                            GeneralUtilities.outputMessage("Invalid command! Please try again.");
                    }
                } else {
                    GeneralUtilities.outputMessage("No such animal with the name \'" + inputArray[1] + "\' was found!");
                }
                break;

            case "list":
                switch(inputArray[1]){
                    case "offexhibitanimals":
                        UserInterface.getLocationPopulationArray(0);
                        break;
                    case "onexhibitanimals":
                        UserInterface.getLocationPopulationArray(1);
                        break;
                    case "circusanimals":
                        UserInterface.getLocationPopulationArray(2);
                        break;
                    case "allanimals":
                        UserInterface.getAllLocationsPopulationArray();
                        break;
                    default:
                        GeneralUtilities.outputMessage("Invalid command! Please try again.");
                }
                break;

            case "move":
                Animal targetedAnimal = UserInterface.findAnimalByName(inputArray[1]);
                if(targetedAnimal != null){
                    switch(inputArray[2].toLowerCase()){
                        case "offexhibit":
                            UserInterface.moveAnimal(targetedAnimal, UserInterface.getZooLocations()[0]);
                            break;
                        case "onexhibit":
                            UserInterface.moveAnimal(targetedAnimal, UserInterface.getZooLocations()[1]);
                            break;
                        case "circus":
                            UserInterface.moveAnimal(targetedAnimal, UserInterface.getZooLocations()[2]);
                            break;
                        default:
                            GeneralUtilities.outputMessage("Invalid command! Please try again.");
                    }
                } else {
                    GeneralUtilities.outputMessage("No such animal with the name \'" + inputArray[1] + "\' was found! Please try again.");
                }
                break;
                
            case "breed":
                Animal breedingAnimal1 = UserInterface.findAnimalByName(inputArray[1]);
                Animal breedingAnimal2 = UserInterface.findAnimalByName(inputArray[2]);

                if(breedingAnimal1 != null && breedingAnimal2 != null){
                    UserInterface.breedAnimals(breedingAnimal1, breedingAnimal2);
                } else {
                    GeneralUtilities.outputMessage("At least one of your animals entered could not be found! Please try again.");
                }
                break;

            case "feed":
                Animal animalTarget = UserInterface.findAnimalByName(inputArray[1]);

                if(animalTarget != null){
                    UserInterface.feedAnimal(animalTarget);
                } else {
                    GeneralUtilities.outputMessage("No such animal with the name \'" + inputArray[1] + "\' was found! Please try again.");
                }
                break;
            
            case "feedall":
                UserInterface.feedAllAnimals();
                break;
            
            case "rest":
                Animal animalSubject = UserInterface.findAnimalByName(inputArray[1]);

                if(animalSubject != null){
                    UserInterface.restAnimal(animalSubject);
                } else {
                    GeneralUtilities.outputMessage("No such animal with the name \'" + inputArray[1] + "\' was found! Please try again.");
                }
                break;

            case "restall":
                UserInterface.restAllAnimals();
                break;

            case "exhibit":
                Animal subjectAnimal = UserInterface.findAnimalByName(inputArray[1]);
                if(subjectAnimal != null){
                    UserInterface.exhibitAnimal(subjectAnimal);
                } else {
                    GeneralUtilities.outputMessage("No such animal with the name \'" + inputArray[1] + "\' was found! Please try again.");
                }
                break;
                
            case "train":
                Animal animalInQuestion = UserInterface.findAnimalByName(inputArray[1]);
                if(animalInQuestion != null){
                    UserInterface.trainAnimal(animalInQuestion);
                } else {
                    GeneralUtilities.outputMessage("No such animal with the name \'" + inputArray[1] + "\' was found! Please try again.");
                }
                break;

            case "perform":
                Animal animalUnderConsideration = UserInterface.findAnimalByName(inputArray[1]);
                if(animalUnderConsideration != null){
                    UserInterface.performAnimal(animalUnderConsideration);
                } else {
                    GeneralUtilities.outputMessage("No such animal with the name \'" + inputArray[1] + "\' was found! Please try again.");
                }
                break;
            case "quit":
                outputBoolean = false;
                break;
            default:
                GeneralUtilities.outputMessage("Invalid command! Please try again.");
        }
        return outputBoolean;
    }
}
