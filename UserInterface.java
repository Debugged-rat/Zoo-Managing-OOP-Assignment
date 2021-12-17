import java.io.FileNotFoundException;
import java.util.Arrays;

abstract class UserInterface {
    private static Location[] zooLocations = new Location[3];

    static void generateZoo() throws FileNotFoundException{
        zooLocations[0] = new OffExhibit();
        zooLocations[1] = new Exhibit();
        zooLocations[2] = new Circus();
    }

    static Location[] getZooLocations(){
        return zooLocations;
    }

    static Animal findAnimalByName(String name){
        for(int i = 0; i < zooLocations.length; i++){
            for(int j = 0; j < zooLocations[i].getPopulationArray().length; j++){
                if(i == 0){
                    if(((OffExhibit)zooLocations[i]).getPopulationArray()[j].getName().equals(GeneralUtilities.capitalizeString(name))){
                        return zooLocations[i].getPopulationArray()[j];
                    }
                } else if(i == 1){
                    if(((Exhibit)zooLocations[i]).getPopulationArray()[j].getName().equals(GeneralUtilities.capitalizeString(name))){
                        return zooLocations[i].getPopulationArray()[j];
                    }
                } else if(i == 2){
                    if(((Circus)zooLocations[i]).getPopulationArray()[j].getName().equals(GeneralUtilities.capitalizeString(name))){
                        return zooLocations[i].getPopulationArray()[j];
                    }
                }
                
            }
        }
        return null;
    }

    static void feedAnimal(Animal other){
        other.setHunger(false);
        other.setCurrentAction("feeding");
    }
    static void restAnimal(Animal other){
        other.setExhaustion(false);
        other.setCurrentAction("resting");
    }
    static void feedAllAnimals(){
        for(int i = 0; i < zooLocations.length; i++){
            for(int j = 0; j < zooLocations[i].getPopulationArray().length; j++){
                feedAnimal(zooLocations[i].getPopulationArray()[j]);
            }
        }
    }
    static void restAllAnimals(){
        for(int i = 0; i < zooLocations.length; i++){
            for(int j = 0; j < zooLocations[i].getPopulationArray().length; j++){
                restAnimal(zooLocations[i].getPopulationArray()[j]);
            }
        }
    }

    static void exhibitAnimal(Animal other){
        if(other.getCurrentLocation().equals("on-exhibit")){
            ((Exhibit)zooLocations[1]).putOnExhibit(other);
        } else {
            GeneralUtilities.outputMessage("Animals must be moved to the exhibit before being exhibited!");
        }
    }

    static void trainAnimal(Animal other){
        if(other.getCurrentLocation().equals("in the circus")){
            ((Circus)zooLocations[2]).train(other);
        } else {
            GeneralUtilities.outputMessage("Animals must be moved to the circus before being trained!");
        }
    }

    static void performAnimal(Animal other){
        if(other.getCurrentLocation().equals("in the circus")){
            ((Circus)zooLocations[2]).perform(other);
        } else {
            GeneralUtilities.outputMessage("Animals must be moved to the circus before performing!");
        }
    }

    static void moveAnimal(Animal other1, Location other2){
        if(other1.getCurrentLocation().equals(other2.returnStringOfLocation()) == false){
            Location.moveAnimal(other1, other2);
        } else {
            GeneralUtilities.outputMessage(other1.getName() + " the " + other1.getSpeciesName() + " is already " + other2.returnStringOfLocation() + "!");
        }
    }

    static void breedAnimals(Animal other1, Animal other2) throws FileNotFoundException{
        if(other1.getCurrentLocation().equals("off-exhibit") && other2.getCurrentLocation().equals("off-exhibit")){
            ((OffExhibit)zooLocations[0]).breed(other1, other2);
        } else {
            GeneralUtilities.outputMessage("Both animals must be moved off-exhibit before they can breed!!!");
        }
    }

    static void getAnimalCurrentAction(Animal other){
        GeneralUtilities.outputMessage(other.getName() + " the " + other.getSpeciesName() + " is currently " + other.getCurrentAction() + "!");
    }

    static void getAnimalCurrentState(Animal other){
        other.outputAnimalHealthStatus();
    }

    static void getAnimalLocation(Animal other){
        GeneralUtilities.outputMessage(other.getName() + " the " + other.getSpeciesName() + " is currently " + other.getCurrentLocation() + "!");
    }

    static void getAnimalInformation(Animal other){
        String genderString;
        if(other.getGender() == 'm'){
            genderString = "Male";
        } else {
            genderString = "Female";
        }

        GeneralUtilities.outputMessage("Information for " + other.getName() + ":\n");
        GeneralUtilities.outputMessage("Species: " + GeneralUtilities.capitalizeString(other.getSpeciesName()) + " | Gender: " + genderString);
        getAnimalCurrentState(other);
        getAnimalCurrentAction(other);
        getAnimalLocation(other);
    }

    static void getLocationPopulationArray(int locationIndex){
        GeneralUtilities.outputMessage("\nAnimals " + GeneralUtilities.capitalizeString(zooLocations[locationIndex].returnStringOfLocation()) + ":\n");
        Animal[] sortedPopulationArray = Arrays.copyOf(zooLocations[locationIndex].getPopulationArray(), zooLocations[locationIndex].getPopulationArray().length);
        Arrays.sort(sortedPopulationArray);
        for(int i = 0; i < sortedPopulationArray.length; i++){
            String genderString;
            if(sortedPopulationArray[i].getGender() == 'm'){
                genderString = "Male";
            } else {
                genderString = "Female";
            }
            GeneralUtilities.outputMessage("Species: " + GeneralUtilities.capitalizeString(sortedPopulationArray[i].getSpeciesName()) + " | Name: " + sortedPopulationArray[i].getName() + " | Gender: " + genderString);
        }
    }

    static void getAllLocationsPopulationArray(){
        for(int i = 0; i < zooLocations.length; i++){
            GeneralUtilities.outputMessage("\nAnimals " + GeneralUtilities.capitalizeString(zooLocations[i].returnStringOfLocation()) + ":\n");
            
            Animal[] sortedPopulationArray = Arrays.copyOf(zooLocations[i].getPopulationArray(), zooLocations[i].getPopulationArray().length);
            for(int j = 0; j < sortedPopulationArray.length; j++){
                String genderString;
                if(sortedPopulationArray[j].getGender() == 'm'){
                    genderString = "Male";
                } else {
                    genderString = "Female";
                }
                GeneralUtilities.outputMessage("Species: " + GeneralUtilities.capitalizeString(sortedPopulationArray[j].getSpeciesName()) + " | Name: " + sortedPopulationArray[j].getName() + " | Gender: " + genderString);
            }
        }
    }
}
