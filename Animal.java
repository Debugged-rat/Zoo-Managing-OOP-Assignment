abstract class Animal implements Comparable<Animal>{
    private String name;
    private int speciesIndex;
    private char gender;
    private boolean hunger;
    private boolean exhausted;
    private String currentAction;
    private String currentLocation;
    private int trainingSessionsCompleted;
    protected int[] offSpringQuantity = new int[2];

    Animal(String name, int speciesIndex, char gender){
        this.name = name;
        this.speciesIndex = speciesIndex;
        this.gender = gender;
        this.hunger = true;
        this.exhausted = false;
        this.currentAction = "doing nothing";
        this.trainingSessionsCompleted = 0;
    }

    String getName(){
        return this.name;
    }

    int getSpeciesIndex(){
        return this.speciesIndex;
    }

    String getSpeciesName(){
        String[] animalSpeciesNames = {"dolphin", "elephant", "flamingo", "hawk", "horse", "lion", "parrot", "seal", "tiger", "walrus"};
        return animalSpeciesNames[this.speciesIndex];
    }

    char getGender(){
        return this.gender;
    }

    boolean getHunger(){
        return this.hunger;
    }

    void setHunger(boolean hunger){
        this.hunger = hunger;
    }

    public boolean getExhaustion(){
        return this.exhausted;
    }

    public void setExhaustion(boolean exhausted){
        this.exhausted = exhausted;
    }

    String getCurrentAction(){
        return this.currentAction;
    }

    void setCurrentAction(String newCurrentAction){
        this.currentAction = newCurrentAction;
    }

    String getCurrentLocation(){
        return this.currentLocation;
    }

    void setCurrentLocation(String newLocation){
        this.currentLocation = newLocation;
    }

    int getOffspringQuantity(int index){
        return this.offSpringQuantity[index];
    }

    int getTrainingSessionsCompleted(){
        return this.trainingSessionsCompleted;
    }

    void incrementTrainingSessionsCompleted(){
        this.trainingSessionsCompleted++;
    }

    @Override
    public int compareTo(Animal animal2){
        return this.getSpeciesName().compareTo(animal2.getSpeciesName());
    }

    void outputAnimalHealthStatus(){
        String hungerStringStatus;
        String exhaustionStringStatus;

        if(this.getHunger() == true){
            hungerStringStatus = "MALNOURISHED";
        } else {
            hungerStringStatus = "fed";
        }

        if(this.getExhaustion() == true){
            exhaustionStringStatus = "FATIGUED";
        } else {
            exhaustionStringStatus = "well rested";
        }
        GeneralUtilities.outputMessage(this.getName() + " the " + this.getSpeciesName() + " is currently " + hungerStringStatus + " and " + exhaustionStringStatus + "!");
    }

    void perish(){
        if(this.getCurrentLocation().equals("off-exhibit")){
            UserInterface.getZooLocations()[0].removeAnimalFromLocation(this);
        } else if(this.getCurrentLocation().equals("on-exhibit")){
            UserInterface.getZooLocations()[1].removeAnimalFromLocation(this);
        } else if (this.getCurrentLocation().equals("in the circus")){
            UserInterface.getZooLocations()[2].removeAnimalFromLocation(this);
        }
    }
}

class Dolphin extends Animal{
    Dolphin(String name, char gender){
        super(name, 0, gender);
        offSpringQuantity[0] = 1;
        offSpringQuantity[1] = 1;
    }
}

class Elephant extends Animal{
    static int[] offSpringAmount = {1, 1};
    Elephant(String name, char gender){
        super(name, 1, gender);
        offSpringQuantity[0] = 1;
        offSpringQuantity[1] = 1;
    }
}

class Flamingo extends Animal{
    Flamingo(String name, char gender){
        super(name, 2, gender);
        offSpringQuantity[0] = 1;
        offSpringQuantity[1] = 1;
    }
}

class Hawk extends Animal{
    Hawk(String name, char gender){
        super(name, 3, gender);
        offSpringQuantity[0] = 1;
        offSpringQuantity[1] = 5;
    }
}

class Horse extends Animal{
    Horse(String name, char gender){
        super(name, 4, gender);
        offSpringQuantity[0] = 1;
        offSpringQuantity[1] = 1;
    }
}

class Lion extends Animal{
    Lion(String name, char gender){
        super(name, 5, gender);
        offSpringQuantity[0] = 2;
        offSpringQuantity[1] = 3;
    }
}

class Parrot extends Animal{
    Parrot(String name, char gender){
        super(name, 6, gender);
        offSpringQuantity[0] = 2;
        offSpringQuantity[1] = 8;
    }
    @Override
    public void setExhaustion(boolean exhausted){
    }
}

class Seal extends Animal{
    Seal(String name, char gender){
        super(name, 7, gender);
        offSpringQuantity[0] = 1;
        offSpringQuantity[1] = 1;
    }
}

class Tiger extends Animal{
    Tiger(String name, char gender){
        super(name, 8, gender);
        offSpringQuantity[0] = 2;
        offSpringQuantity[1] = 4;
    }
}

class Walrus extends Animal{
    Walrus(String name, char gender){
        super(name, 9, gender);
        offSpringQuantity[0] = 1;
        offSpringQuantity[1] = 1;
    }
}