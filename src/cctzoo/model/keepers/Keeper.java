/**
 * Class Keeper
 * 
 * Purpose:
 * 
 * Responsible for creating keepers who take certain parameters such a pps number an name 
 * 
 * This class contains a set of methods that set Qualifications for Keeper and set animals according to it 
 * 
 * 
 */
package cctzoo.model.keepers;

import cctzoo.model.animals.Animal;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */

/**
 * 
 * The public class Keeper needs to implements Serializable, as a keeper is part of the object we  will be serialized.
 */
public class Keeper implements Serializable {
    private static int id; // Static Variable that help to keep track of number without redundance
    private final int pps; // unique number for each keeper
    private String name; // name
    private String dateOfBirth;
   
    private ArrayList<String> qualification; // list that contain the Qualification or the keeper
    
    private ArrayList<Animal> keeperAnimals; // List that contains the Animal that the keeper Looks after 
    
    /**
     * Default Constructor for Keeper
     */
    public Keeper() {
        pps = id;
        id++;
    }
    
    /**
     * Second Constructor for Keepers 
     * 
     * It Takes the parameters: 
     * 
     * @param name
     * @param dateOfBirth 
     */
    public Keeper(String name, String dateOfBirth) {
        pps = id;
        id++;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.qualification = new ArrayList<String>(); // Initialize the list of Qualifications
        this.keeperAnimals = new ArrayList<Animal>(); // Initialize the list of Animals 
    }
    
    /**
     * Method that add a Qualification to the Keeper
     * 
     * @param q which is a String containing the animal Type the keeper is allow to look after
     */
    public void addQualification(String q) {
        qualification.add(q);
    }
    
    /**
     * Method used to get keepers Qualifications
     * 
     * @return a list of Qualifications  
     */
    public ArrayList<String> getQualification() {
        return qualification;
    }
    
    /**
     * Method used to get the keepers animals
     * 
     * @return a list whit the keepers animals  
     */
    public ArrayList<Animal> getkeeperAnimals() {
        return keeperAnimals;
    }
    
    /**
     * Method to get PPS
     * 
     * @return an int (pps number)
     */
    public int getPps() {
        return pps;
    }
    
    /**
     * Method to get Name 
     * 
     * @return name 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Method to get Date Of Birth 
     * 
     * @return String Date of Birth in the format dd/mm/yyyy 
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    /**
     * MEthod used to add an animal to the list of animal for the keeper 
     * 
     * @param a which is an object Animal  
     */
    public void addAnimal(Animal a) {
        keeperAnimals.add(a);
    }
    
    /**
     * Method used for testing purposes 
     * 
     * @return a String 
     */
    public String toStringKeeperQualification(){
        String var = "";
        if (getQualification().size() != 0){
            for (int i = 0 ; i < getQualification().size() ; i++){
                if (i == getQualification().size() - 1){
                    var += getQualification().get(i);
                }else{
                    var += getQualification().get(i)+", ";
                }
            }
        }else{
            var = "No qualifications";
        }
        return var;
    }
    
    /**
     * Method used for testing purposes 
     * 
     * @return a String 
     */
    public String toStringKeeperAnimals(){
        String var = "";
        if (getkeeperAnimals().size() != 0){
            for (int i = 0 ; i < getkeeperAnimals().size() ; i++){
                if (i == getkeeperAnimals().size() - 1){
                    var += getkeeperAnimals().get(i).getExhibitionNumb();
                }else{
                    var += getkeeperAnimals().get(i).getExhibitionNumb()+", ";
                }
            }
        }else{
            var = "No animals";
        }
        return var;
    }
    
    /**
     * Method used for testing purposes 
     * 
     * @return a String 
     */
    public String toString(){
        return "Keeper «"+getPps()+"»:                                      \n"
                    +"\tName:            «"+getName()+"»                    \n"
                    +"\tDate of birth:   «"+getDateOfBirth() +"»            \n"
                    +"\tQualifications:  «"+toStringKeeperQualification()+"»\n"
                    +"\tAnimals:         «"+toStringKeeperAnimals()+"»      \n";
    }
    
    /**
     * Method that convert the object Keeper contained in this class to an Array List of Strings 
     * 
     * @return an ArrayList of Strings  
     */
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = new ArrayList<String>();
        list.add(String.valueOf(getPps()));
        list.add(getName());
        list.add(getDateOfBirth());
        list.add(toStringKeeperQualification());
        list.add(toStringKeeperAnimals());
        return list;
    }
    
    
    /**
     * Method that helps another methods in the Search class to generate a multidirectional array of Strings 
     * 
     * @return an ArrayList of String that contain the Variables names of the instances in the Keeper Class  
     */
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("pps");
        names.add("name");
        names.add("dateOfBirth");
        names.add("qualification");
        names.add("keeperAnimals");
        return names;
    }
    
    /**
     * This Method will assign the value of the given parameter to the static variable id. 
     * 
     * @param i 
     */
    public void setStaticVariable(int i) {
        this.id = i; 
    }
    
    /**
     * Method to set the Name
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Method to set the Date of Birth
     * 
     * @param dateOfBirth 
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * Method to set the Qualification
     * 
     * @param qualification 
     */
    public void setQualification(ArrayList<String> qualification) {
        this.qualification = qualification;
    }
    
}
