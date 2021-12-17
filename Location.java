import java.io.FileNotFoundException;
import java.util.Arrays;

abstract class Location {
    String returnStringOfLocation(){
        return "";
    }

    Animal[] getPopulationArray(){
        return new Animal[0];
    }

    void addAnimalToLocation(Animal other){
    }

    void removeAnimalFromLocation(Animal other){
    }



    static void moveAnimal(Animal other1, Location other2){
        if(other1.getCurrentLocation().equals("off-exhibit")){
            other2.addAnimalToLocation(other1);
            UserInterface.getZooLocations()[0].removeAnimalFromLocation(other1);
        } else if(other1.getCurrentLocation().equals("on-exhibit")){
            other2.addAnimalToLocation(other1);
            UserInterface.getZooLocations()[1].removeAnimalFromLocation(other1);
        } else if(other1.getCurrentLocation().equals("in the circus")){
            other2.addAnimalToLocation(other1);
            UserInterface.getZooLocations()[2].removeAnimalFromLocation(other1);
        }
        GeneralUtilities.outputMessage(other1.getName() + " the " + other1.getSpeciesName() + " has been moved to " + other1.getCurrentLocation() + "!");
    }
}
class OffExhibit extends Location {
    private Animal[] offExhibitAnimals = new Animal[0];

    OffExhibit() throws FileNotFoundException{
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < GeneralUtilities.randomChoice(5, 15); j++){
                char randomGender = 'm';
                if(GeneralUtilities.randomChoice(2) == 0){
                    randomGender = 'f';
                }
                switch(i){
                    case 0:
                        this.addAnimalToLocation(new Dolphin(GeneralUtilities.randomName(randomGender), randomGender));
                        break;
                    case 1:
                        this.addAnimalToLocation(new Elephant(GeneralUtilities.randomName(randomGender), randomGender));
                        break;
                    case 2:
                        this.addAnimalToLocation(new Flamingo(GeneralUtilities.randomName(randomGender), randomGender));
                        break;
                    case 3:
                        this.addAnimalToLocation(new Hawk(GeneralUtilities.randomName(randomGender), randomGender));
                        break;
                    case 4:
                        this.addAnimalToLocation(new Horse(GeneralUtilities.randomName(randomGender), randomGender));
                        break;
                    case 5:
                        this.addAnimalToLocation(new Lion(GeneralUtilities.randomName(randomGender), randomGender));
                        break;
                    case 6:
                        this.addAnimalToLocation(new Parrot(GeneralUtilities.randomName(randomGender), randomGender));
                        break;
                    case 7:
                        this.addAnimalToLocation(new Seal(GeneralUtilities.randomName(randomGender), randomGender));
                        break;
                    case 8:
                        this.addAnimalToLocation(new Tiger(GeneralUtilities.randomName(randomGender), randomGender));
                        break;
                    case 9:
                        this.addAnimalToLocation(new Walrus(GeneralUtilities.randomName(randomGender), randomGender));
                        break;
                }
            }
        }
    }

    @Override
    String returnStringOfLocation(){
        return "off-exhibit";
    }

    @Override
    Animal[] getPopulationArray(){
        return offExhibitAnimals;
    }

    @Override
    void addAnimalToLocation(Animal other){
        Animal[] newArray = new Animal[offExhibitAnimals.length + 1];
        for(int i = 0; i < offExhibitAnimals.length; i++){
            newArray[i] = offExhibitAnimals[i];
        }
        newArray[offExhibitAnimals.length] = other;
        offExhibitAnimals = Arrays.copyOf(newArray, newArray.length);
        other.setCurrentLocation(returnStringOfLocation());
    }

    @Override
    void removeAnimalFromLocation(Animal other){

        int animalIndex = Arrays.asList(offExhibitAnimals).indexOf(other);
        Animal[] newArray = new Animal[offExhibitAnimals.length - 1];
        int arrayIndexCounter = 0;
        for(int i = 0; i < offExhibitAnimals.length - 1; i++){
            if(i != animalIndex){
                newArray[arrayIndexCounter] = offExhibitAnimals[i];
                arrayIndexCounter++;
            }
        }
        offExhibitAnimals = null;
        offExhibitAnimals = newArray.clone();
    }

    void breed(Animal maleAnimal, Animal femaleAnimal) throws FileNotFoundException{
        if(maleAnimal.getGender() != femaleAnimal.getGender()){
            if(maleAnimal.getSpeciesIndex() == femaleAnimal.getSpeciesIndex()){
                if((maleAnimal.getHunger() == false) && (maleAnimal.getExhaustion() == false) && (femaleAnimal.getHunger() == false) && (femaleAnimal.getExhaustion() == false)){
                    switch(maleAnimal.getSpeciesIndex()){
                        case 0:
                            for(int i = 0; i < GeneralUtilities.randomChoice(maleAnimal.getOffspringQuantity(0), maleAnimal.getOffspringQuantity(1)); i++){
                                char randomGender = 'm';
                                String genderString = "male";
                                String randomName;
                                if(GeneralUtilities.randomChoice(2) == 0){
                                    randomGender = 'f';
                                    genderString = "female";
                                }
                                randomName = GeneralUtilities.randomName(randomGender);
                                this.addAnimalToLocation(new Dolphin(randomName, randomGender));
                                GeneralUtilities.outputMessage(femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " has given birth to " + GeneralUtilities.capitalizeString(randomName) + " a " + genderString + " " + femaleAnimal.getSpeciesName() + "!");
                            }
                            break;
                        case 1:
                            for(int i = 0; i < GeneralUtilities.randomChoice(maleAnimal.getOffspringQuantity(0), maleAnimal.getOffspringQuantity(1)); i++){
                                char randomGender = 'm';
                                String genderString = "male";
                                String randomName;
                                if(GeneralUtilities.randomChoice(2) == 0){
                                    randomGender = 'f';
                                    genderString = "female";
                                }
                                randomName = GeneralUtilities.randomName(randomGender);
                                this.addAnimalToLocation(new Elephant(randomName, randomGender));
                                GeneralUtilities.outputMessage(femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " has given birth to " + GeneralUtilities.capitalizeString(randomName) + " a " + genderString + " " + femaleAnimal.getSpeciesName() + "!");
                            }
                            break;
                        case 2:
                            for(int i = 0; i < GeneralUtilities.randomChoice(maleAnimal.getOffspringQuantity(0), maleAnimal.getOffspringQuantity(1)); i++){
                                char randomGender = 'm';
                                String genderString = "male";
                                String randomName;
                                if(GeneralUtilities.randomChoice(2) == 0){
                                    randomGender = 'f';
                                    genderString = "female";
                                }
                                randomName = GeneralUtilities.randomName(randomGender);
                                this.addAnimalToLocation(new Flamingo(randomName, randomGender));
                                GeneralUtilities.outputMessage(femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " has given birth to " + GeneralUtilities.capitalizeString(randomName) + " a " + genderString + " " + femaleAnimal.getSpeciesName() + "!");
                            }
                            break;
                        case 3:
                            for(int i = 0; i < GeneralUtilities.randomChoice(maleAnimal.getOffspringQuantity(0), maleAnimal.getOffspringQuantity(1)); i++){
                                char randomGender = 'm';
                                String genderString = "male";
                                String randomName;
                                if(GeneralUtilities.randomChoice(2) == 0){
                                    randomGender = 'f';
                                    genderString = "female";
                                }
                                randomName = GeneralUtilities.randomName(randomGender);
                                this.addAnimalToLocation(new Hawk(randomName, randomGender));
                                GeneralUtilities.outputMessage(femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " has given birth to " + GeneralUtilities.capitalizeString(randomName) + " a " + genderString + " " + femaleAnimal.getSpeciesName() + "!");
                            }
                            break;
                        case 4:
                            for(int i = 0; i < GeneralUtilities.randomChoice(maleAnimal.getOffspringQuantity(0), maleAnimal.getOffspringQuantity(1)); i++){
                                char randomGender = 'm';
                                String genderString = "male";
                                String randomName;
                                if(GeneralUtilities.randomChoice(2) == 0){
                                    randomGender = 'f';
                                    genderString = "female";
                                }
                                randomName = GeneralUtilities.randomName(randomGender);
                                this.addAnimalToLocation(new Horse(randomName, randomGender));
                                GeneralUtilities.outputMessage(femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " has given birth to " + GeneralUtilities.capitalizeString(randomName) + " a " + genderString + " " + femaleAnimal.getSpeciesName() + "!");
                            }
                            break;
                        case 5:
                            for(int i = 0; i < GeneralUtilities.randomChoice(maleAnimal.getOffspringQuantity(0), maleAnimal.getOffspringQuantity(1)); i++){
                                char randomGender = 'm';
                                String genderString = "male";
                                String randomName;
                                if(GeneralUtilities.randomChoice(2) == 0){
                                    randomGender = 'f';
                                    genderString = "female";
                                }
                                randomName = GeneralUtilities.randomName(randomGender);
                                this.addAnimalToLocation(new Lion(randomName, randomGender));
                                GeneralUtilities.outputMessage(femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " has given birth to " + GeneralUtilities.capitalizeString(randomName) + " a " + genderString + " " + femaleAnimal.getSpeciesName() + "!");
                            }
                            break;
                        case 6:
                            for(int i = 0; i < GeneralUtilities.randomChoice(maleAnimal.getOffspringQuantity(0), maleAnimal.getOffspringQuantity(1)); i++){
                                char randomGender = 'm';
                                String genderString = "male";
                                String randomName;
                                if(GeneralUtilities.randomChoice(2) == 0){
                                    randomGender = 'f';
                                    genderString = "female";
                                }
                                randomName = GeneralUtilities.randomName(randomGender);
                                this.addAnimalToLocation(new Parrot(randomName, randomGender));
                                GeneralUtilities.outputMessage(femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " has given birth to " + GeneralUtilities.capitalizeString(randomName) + " a " + genderString + " " + femaleAnimal.getSpeciesName() + "!");
                            }
                            break;
                        case 7:
                            for(int i = 0; i < GeneralUtilities.randomChoice(maleAnimal.getOffspringQuantity(0), maleAnimal.getOffspringQuantity(1)); i++){
                                char randomGender = 'm';
                                String genderString = "male";
                                String randomName;
                                if(GeneralUtilities.randomChoice(2) == 0){
                                    randomGender = 'f';
                                    genderString = "female";
                                }
                                randomName = GeneralUtilities.randomName(randomGender);
                                this.addAnimalToLocation(new Seal(randomName, randomGender));
                                GeneralUtilities.outputMessage(femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " has given birth to " + GeneralUtilities.capitalizeString(randomName) + " a " + genderString + " " + femaleAnimal.getSpeciesName() + "!");
                            }
                            break;
                        case 8:
                            for(int i = 0; i < GeneralUtilities.randomChoice(maleAnimal.getOffspringQuantity(0), maleAnimal.getOffspringQuantity(1)); i++){
                                char randomGender = 'm';
                                String genderString = "male";
                                String randomName;
                                if(GeneralUtilities.randomChoice(2) == 0){
                                    randomGender = 'f';
                                    genderString = "female";
                                }
                                randomName = GeneralUtilities.randomName(randomGender);
                                this.addAnimalToLocation(new Tiger(randomName, randomGender));
                                GeneralUtilities.outputMessage(femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " has given birth to " + GeneralUtilities.capitalizeString(randomName) + " a " + genderString + " " + femaleAnimal.getSpeciesName() + "!");
                            }
                            break;
                        case 9:
                            for(int i = 0; i < GeneralUtilities.randomChoice(maleAnimal.getOffspringQuantity(0), maleAnimal.getOffspringQuantity(1)); i++){
                                char randomGender = 'm';
                                String genderString = "male";
                                String randomName;
                                if(GeneralUtilities.randomChoice(2) == 0){
                                    randomGender = 'f';
                                    genderString = "female";
                                }
                                randomName = GeneralUtilities.randomName(randomGender);
                                this.addAnimalToLocation(new Walrus(randomName, randomGender));
                                GeneralUtilities.outputMessage(femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " has given birth to " + GeneralUtilities.capitalizeString(randomName) + " a " + genderString + " " + femaleAnimal.getSpeciesName() + "!");
                            }
                            break;
                    }
                    maleAnimal.setHunger(true);
                    maleAnimal.setExhaustion(true);
                    maleAnimal.outputAnimalHealthStatus();
                    femaleAnimal.setHunger(true);
                    femaleAnimal.setExhaustion(true);
                    femaleAnimal.outputAnimalHealthStatus();
                    maleAnimal.setCurrentAction("breeding");
                    femaleAnimal.setCurrentAction("breeding");
                } else {
                    if((maleAnimal.getHunger() == true) && (maleAnimal.getExhaustion() == true)){
                        GeneralUtilities.outputMessage("You have caused " + maleAnimal.getName() + " the " + maleAnimal.getSpeciesName() + " to decease due to starvation and exaustion! ");
                        maleAnimal.perish();
                    } else if(maleAnimal.getHunger() == true){
                        GeneralUtilities.outputMessage("You have caused " + maleAnimal.getName() + " the " + maleAnimal.getSpeciesName() + " to decease due to starvation! ");
                        maleAnimal.perish();
                    } else if(maleAnimal.getExhaustion() == true){
                        GeneralUtilities.outputMessage("You have caused " + maleAnimal.getName() + " the " + maleAnimal.getSpeciesName() + " to decease due to exaustion! ");
                        maleAnimal.perish();
                    }
                    if((femaleAnimal.getHunger() == true) && (femaleAnimal.getExhaustion() == true)){
                        GeneralUtilities.outputMessage("You have caused " + femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " to decease due to starvation and exaustion! ");
                        femaleAnimal.perish();
                    } else if(femaleAnimal.getHunger() == true){
                        GeneralUtilities.outputMessage("You have caused " + femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " to decease due to starvation! ");
                        femaleAnimal.perish();
                    } else if(femaleAnimal.getExhaustion() == true){
                        GeneralUtilities.outputMessage("You have caused " + femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " to decease due to exaustion! ");
                        femaleAnimal.perish();
                    }
                }
            } else {
                GeneralUtilities.outputMessage("You cannot breed two animals of different species!!!");
                if((maleAnimal.getHunger() == false) && (maleAnimal.getExhaustion() == false) && (femaleAnimal.getHunger() == false) && (femaleAnimal.getExhaustion() == false)){
                    maleAnimal.setHunger(true);
                    maleAnimal.setExhaustion(true);
                    maleAnimal.outputAnimalHealthStatus();
                    femaleAnimal.setHunger(true);
                    femaleAnimal.setExhaustion(true);
                    femaleAnimal.outputAnimalHealthStatus();
                } else {
                    if((maleAnimal.getHunger() == true) && (maleAnimal.getExhaustion() == true)){
                        GeneralUtilities.outputMessage("You have caused " + maleAnimal.getName() + " the " + maleAnimal.getSpeciesName() + " to decease due to starvation and exaustion! ");
                        maleAnimal.perish();
                    } else if(maleAnimal.getHunger() == true){
                        GeneralUtilities.outputMessage("You have caused " + maleAnimal.getName() + " the " + maleAnimal.getSpeciesName() + " to decease due to starvation! ");
                        maleAnimal.perish();
                    } else if(maleAnimal.getExhaustion() == true){
                        GeneralUtilities.outputMessage("You have caused " + maleAnimal.getName() + " the " + maleAnimal.getSpeciesName() + " to decease due to exaustion! ");
                        maleAnimal.perish();
                    }
                    if((femaleAnimal.getHunger() == true) && (femaleAnimal.getExhaustion() == true)){
                        GeneralUtilities.outputMessage("You have caused " + femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " to decease due to starvation and exaustion! ");
                        femaleAnimal.perish();
                    } else if(femaleAnimal.getHunger() == true){
                        GeneralUtilities.outputMessage("You have caused " + femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " to decease due to starvation! ");
                        femaleAnimal.perish();
                    } else if(femaleAnimal.getExhaustion() == true){
                        GeneralUtilities.outputMessage("You have caused " + femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " to decease due to exaustion! ");
                        femaleAnimal.perish();
                    }
                }                
            }

        } else {
            GeneralUtilities.outputMessage("You cannot not force two animals of the same gender to breed!!!");
            if((maleAnimal.getHunger() == false) && (maleAnimal.getExhaustion() == false)){
                maleAnimal.setHunger(true);
                maleAnimal.setExhaustion(true);
                maleAnimal.outputAnimalHealthStatus();
            } else {
                if((maleAnimal.getHunger() == true) && (maleAnimal.getExhaustion() == true)){
                    GeneralUtilities.outputMessage("You have caused " + maleAnimal.getName() + " the " + maleAnimal.getSpeciesName() + " to decease due to starvation and exaustion! ");
                    maleAnimal.perish();
                } else if(maleAnimal.getHunger() == true){
                    GeneralUtilities.outputMessage("You have caused " + maleAnimal.getName() + " the " + maleAnimal.getSpeciesName() + " to decease due to starvation! ");
                    maleAnimal.perish();
                } else if(maleAnimal.getExhaustion() == true){
                    GeneralUtilities.outputMessage("You have caused " + maleAnimal.getName() + " the " + maleAnimal.getSpeciesName() + " to decease due to exaustion! ");
                    maleAnimal.perish();
                }
            }
            if((femaleAnimal.getHunger() == false) && (femaleAnimal.getExhaustion() == false)){
                femaleAnimal.setHunger(true);
                femaleAnimal.setExhaustion(true);
                femaleAnimal.outputAnimalHealthStatus();
            } else {
                if((femaleAnimal.getHunger() == true) && (femaleAnimal.getExhaustion() == true)){
                    GeneralUtilities.outputMessage("You have caused " + femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " to decease due to starvation and exaustion! ");
                    femaleAnimal.perish();
                } else if(femaleAnimal.getHunger() == true){
                    GeneralUtilities.outputMessage("You have caused " + femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " to decease due to starvation! ");
                    femaleAnimal.perish();
                } else if(femaleAnimal.getExhaustion() == true){
                    GeneralUtilities.outputMessage("You have caused " + femaleAnimal.getName() + " the " + femaleAnimal.getSpeciesName() + " to decease due to exaustion! ");
                    femaleAnimal.perish();
                }
            }
        }
    }
}

class Exhibit extends Location {
    private Animal[] exhibitAnimals = new Animal[0];

    Exhibit(){
    }

    @Override
    String returnStringOfLocation(){
        return "on-exhibit";
    }

    @Override
    Animal[] getPopulationArray(){
        return exhibitAnimals;
    }

    @Override
    void addAnimalToLocation(Animal other){
        Animal[] newArray = new Animal[exhibitAnimals.length + 1];
        for(int i = 0; i < exhibitAnimals.length; i++){
            newArray[i] = exhibitAnimals[i];
        }
        newArray[exhibitAnimals.length] = other;
        exhibitAnimals = Arrays.copyOf(newArray, newArray.length);
        other.setCurrentLocation(returnStringOfLocation());
    }

    @Override
    void removeAnimalFromLocation(Animal other){
        int animalIndex = Arrays.asList(exhibitAnimals).indexOf(other);
        Animal[] newArray = new Animal[exhibitAnimals.length - 1];
        int arrayIndexCounter = 0;
        for(int i = 0; i < exhibitAnimals.length - 1; i++){
            if(i != animalIndex){
                newArray[arrayIndexCounter] = exhibitAnimals[i];
                arrayIndexCounter++;
            }
        }
        exhibitAnimals = null;
        exhibitAnimals = newArray.clone();
    }

    void putOnExhibit(Animal other){
        if((other.getHunger() == false) && (other.getExhaustion() == false)){
            other.setCurrentAction("on exhibit");
            GeneralUtilities.outputMessage(other.getName() + " the " + other.getSpeciesName() + " is now on exhibit!");
            other.setHunger(true);
            other.setExhaustion(true);
            other.outputAnimalHealthStatus();
        } else {
            if((other.getHunger() == true) && (other.getExhaustion() == true)){
                GeneralUtilities.outputMessage("You have caused " + other.getName() + " the " + other.getSpeciesName() + " to decease due to starvation and exaustion! ");
                other.perish();
            } else if(other.getHunger() == true){
                GeneralUtilities.outputMessage("You have caused " + other.getName() + " the " + other.getSpeciesName() + " to decease due to starvation! ");
                other.perish();
            } else if(other.getExhaustion() == true){
                GeneralUtilities.outputMessage("You have caused " + other.getName() + " the " + other.getSpeciesName() + " to decease due to exaustion! ");
                other.perish();
            }
        }
    }
}

class Circus extends Location {
    private Animal[] circusAnimals = new Animal[0];

    Circus(){
    }

    @Override
    String returnStringOfLocation(){
        return "in the circus";
    }

    @Override
    Animal[] getPopulationArray(){
        return circusAnimals;
    }

    @Override
    void addAnimalToLocation(Animal other){
        Animal[] newArray = new Animal[circusAnimals.length + 1];
        for(int i = 0; i < circusAnimals.length; i++){
            newArray[i] = circusAnimals[i];
        }
        newArray[circusAnimals.length] = other;
        circusAnimals = Arrays.copyOf(newArray, newArray.length);
        other.setCurrentLocation(returnStringOfLocation());
    }

    @Override
    void removeAnimalFromLocation(Animal other){
        int animalIndex = Arrays.asList(circusAnimals).indexOf(other);
        Animal[] newArray = new Animal[circusAnimals.length - 1];
        int arrayIndexCounter = 0;
        for(int i = 0; i < circusAnimals.length - 1; i++){
            if(i != animalIndex){
                newArray[arrayIndexCounter] = circusAnimals[i];
                arrayIndexCounter++;
            }
        }
        circusAnimals = null;
        circusAnimals = newArray.clone();
    }

    void train(Animal other){
        if((other.getHunger() == true) || (other.getExhaustion() == true)){
            if((other.getHunger() == true) && (other.getExhaustion() == true)){
                GeneralUtilities.outputMessage("You have caused " + other.getName() + " the " + other.getSpeciesName() + " to decease due to starvation and exaustion! ");
                other.perish();
            } else if(other.getHunger() == true){
                GeneralUtilities.outputMessage("You have caused " + other.getName() + " the " + other.getSpeciesName() + " to decease due to starvation! ");
                other.perish();
            } else if(other.getExhaustion() == true){
                GeneralUtilities.outputMessage("You have caused " + other.getName() + " the " + other.getSpeciesName() + " to decease due to exaustion! ");
                other.perish();
            }
        } else {
            other.setCurrentAction("training at the circus");
            if(other.getTrainingSessionsCompleted() < 3){
                GeneralUtilities.outputMessage(other.getName() + " the " + other.getSpeciesName() + " has completed their training session! ");
                other.incrementTrainingSessionsCompleted();
                if(other.getTrainingSessionsCompleted() < 3){
                    GeneralUtilities.outputMessage(other.getName() + " the " + other.getSpeciesName() + " needs " + (3 - other.getTrainingSessionsCompleted()) + " more training sessions to be ready to perform!");
                }
            } else {
                GeneralUtilities.outputMessage(other.getName() + " the " + other.getSpeciesName() + " has already completed all 3 training sessions needed to perform!");
            }
            other.setHunger(true);
            other.setExhaustion(true);
            other.outputAnimalHealthStatus();
        }
    }

    void perform(Animal other){
        if((other.getHunger() == true) || (other.getExhaustion() == true)){
            if((other.getHunger() == true) && (other.getExhaustion() == true)){
                GeneralUtilities.outputMessage("You have caused " + other.getName() + " the " + other.getSpeciesName() + " to decease due to starvation and exaustion! ");
                other.perish();
            } else if(other.getHunger() == true){
                GeneralUtilities.outputMessage("You have caused " + other.getName() + " the " + other.getSpeciesName() + " to decease due to starvation! ");
                other.perish();
            } else if(other.getExhaustion() == true){
                GeneralUtilities.outputMessage("You have caused " + other.getName() + " the " + other.getSpeciesName() + " to decease due to exaustion! ");
                other.perish();
            }
        } else {
            other.setCurrentAction("performing at the circus");
            if(other.getTrainingSessionsCompleted() >= 3){
                String[] circusPerformances = {"acrobatics", "tightrope walking", "juggling", "unicycle"};
                GeneralUtilities.outputMessage(other.getName() + " the " + other.getSpeciesName() + " performs " + circusPerformances[GeneralUtilities.randomChoice(circusPerformances.length)] + "!");
                other.setHunger(true);
                other.setExhaustion(true);
                other.outputAnimalHealthStatus();
            } else {
                GeneralUtilities.outputMessage(other.getName() + " the " + other.getSpeciesName() + " has not been trained enough to perform!");
            }
        } 
    }
}