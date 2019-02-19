/**
 * Class CreateAvian
 * 
 * Purpose: 
 * 
 * This class is the responsible for creating an Animal of Type Avian  
 * 
 */
package cctzoo.model.animals;

import java.util.ArrayList;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public class CreateAvian extends Animal implements Avian {
    
    private int canFly; // New atribute for the type of Animal Avian
    private int hasFeeders; // New atribute for the type of Animal Avian
    
    
    /**
     * Constructor for CreateAvian
     * 
     * This class extends the class Animal which has all the properties and instances shown bellow 
     * 
     * It takes the parameters:
     * 
     * @param specie which is the specie of the animal (Tiger, Panter, Snake, Tucan, Dolphin, etc)
     * @param name which is the name of the animal 
     * @param dateOfBirth 
     * @param dateOfArrival
     * @param gender which is an int 0 or 1 
     * @param medication an object that contain a list of medication 
     * @param vacine an object that contain a list of vaccines 
     */
    public CreateAvian(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vacine);
    
    }
    
    /**
     * This method takes parameters that are added to create a new Animal of the same type we created in this class for the Parent
     * 
     * The Offspring does not take an specie as parameter as it will be added directly from the parents specie 
     * 
     * It takes the parameters: 
     * 
     * @param name which is the name of the animal
     * @param dateOfBirth
     * @param dateOfArrival
     * @param gender which is an int 0 or 1
     * @param medication an object that contain a list of medication
     * @param vacine an object that contain a list of vaccines
     */
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine) {
        getOffsprings().add(new CreateAvian(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vacine));
    }
    
     /**
     * Method that get the unique property for Avian Animals (canFly)
     * 
     * @return an int which it will be converted latter to a String by using the method in the Interface 
     */
    public int getCanFligh() {
        return canFly;
    }
    
    /**
     * Method to set parameter canFly  
     * 
     * @param canFly which is the value to update (or set)
     */
    public void setCanFligh(int canFly) {
        this.canFly = canFly;
    }
    
     /**
     * Method that get the unique property for Avian Animals (hasFeeders)
     * 
     * @return an int which it will be converted latter to a String by using the method in the Interface 
     */
    public int getHasFeeders() {
        return hasFeeders;
    }
    
    /**
     * Method to set parameter hasFeeders 
     * 
     * @param hasFeeders which is the value to update (or set)
     */
    public void setHasFeeders(int hasFeeders) {
        this.hasFeeders = hasFeeders;
    }
    
    /**
     * This Method comes from the parent class Animal 
     * 
     * It takes the List from the super class and add a new value which is the unique property for this class.
     * 
     * @return the list with the updated values.  
     */    
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(canFly(canFly));
        list.add(hasFeeders(hasFeeders));
        return list;
    }
    
    /**
     * This Method comes from the parent class Animal 
     * 
     * It takes the values from the super class and update it with a new Name Variable which is the unique property for this class.
     * 
     * @return the list of names updated.  
     */
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("canFly");
        names.add("hasFeeders");
        return names;
    }
      
}
