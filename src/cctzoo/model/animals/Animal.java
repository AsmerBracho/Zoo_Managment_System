/**
 * Abstract Class Animal
 * 
 * Purpose: 
 * 
 * This is the parent class for all animals 
 * 
 * It contains all the common attributes for animals as well as the behavior for them
 * 
 * This class implements Serializable as it is the core for the creation of animals and each of them have to be serialized 
 * 
 */
package cctzoo.model.animals;

import cctzoo.model.SetUp;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public abstract class Animal implements Serializable {
    
    private static int id; // Static Variable that help to keep track of number without redundance
    private final int exhibitionNumb; // Exhibition Number for each animal
    private String specie; // Specie   
    private String name; // Name of the animal 
    private String dateOfBirth; // Date of Birth  
    private String dateOfArrival; // Date of Arrival to the Zoo 
    private String gender; // Male or Female  
    private Medication medication; // Object Medication
    private Vacine vacine; // Object Vaccine  
    private ArrayList<Animal> offsprings; // a List of Offpring for each Animal 
    
    SetUp s = new SetUp();
    
    /**
     * Default Constructor for the Class Animal
     */
    public Animal() {
        exhibitionNumb = id; 
        id++;    
    }
    
    /**
     * Constructor of the Class Animal 
     * 
     * It takes the parameters 
     * @param specie which is the specie of the animal (Tiger, Panter, Snake, Tucan, Dolphin, etc)
     * @param name which is the name of the animal 
     * @param dateOfBirth 
     * @param dateOfArrival
     * @param gender which is an int 0 or 1 
     * @param medication an object that contain a list of medication 
     * @param vacine an object that contain a list of vaccines 
     */
    public Animal(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine) {
        exhibitionNumb = id;  // Exhibition Number for each animal 
        id++; // Static Variable that help to keep track of number without redundance  
        this.specie = specie; // Specie  
        this.name = name; 
        this.dateOfBirth = dateOfBirth; 
        this.dateOfArrival = dateOfArrival;
        this.medication = medication; 
        this.vacine = vacine; 
        if (gender == 1) {
            this.gender = "Male";
        } else {
            this.gender = "Female";
        }
        this.offsprings = new ArrayList<Animal>();
    }
    
    /**
     * Method used to get the exhibition Number
     * 
     * @return return ant int which is the ID or exhibition number of the animal  
     */
    public int getExhibitionNumb() {
        return exhibitionNumb;
    }
    
    /**
     * Method that get the date of Birth 
     * 
     * @return returns a String with the format dd/mm/yyyy 
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    /**
     * Method used to get the date of Arrival 
     * 
     * @return returns a String with the format dd/mm/yyyy 
     */
    public String getDateOfArrival() {
        return dateOfArrival;
    }
    
    /**
     * Method used to get the gender 
     * 
     * @return returns an String (Female or Male)  
     */
    public String getGender() {
        return gender;
    }
    
    /**
     * Method used to get the medications
     * 
     * @return returns a object of type Medication  
     */
    public Medication getMedication() {
        return medication;
    }
    
    /**
     * Method used to get the Vaccines
     * 
     * @return returns a object of type Vaccines  
     */
    public Vacine getVacine() {
        return vacine;
    }
    
    /**
     * Method used to get the Specie of the Animal
     * 
     * @return returns a String specie  
     */
    public String getSpecie() {
        return specie;
    }
    
    /**
     * Method used to get the name of the animal 
     * 
     * @return returns a name of Type String 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Method used to get the list of offsprings for each Animal
     * 
     * @return returns a List of Animals which are the offsprings  
     */
    public ArrayList<Animal> getOffsprings() {
        return offsprings;
    }
    
    /**
     * This is an abstract Method that will be implements in each specific class to create offsprings 
     * 
     * It take the parameters 
     * 
     * @param name which is the name of the Animal 
     * @param dateOfBirth
     * @param dateOfArrival
     * @param gender
     * @param medication an object of Type Medication 
     * @param vacine an Object of Type Vaccine 
     */
    public abstract void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine);

    
    /**
     * Method used for testing purposes 
     * 
     * @return a String which contain an Animal which is offspring 
     */
    public String toStringOffsprings(){
        String offpring = "";
        if (getOffsprings().size() != 0){
            for (int i = 0 ; i < getOffsprings().size() ; i++){
                if (i == getOffsprings().size() - 1){
                    offpring += String.valueOf(getOffsprings().get(i).getExhibitionNumb());
                }else{
                    offpring += String.valueOf(getOffsprings().get(i).getExhibitionNumb())+", ";
                }
            }
            offpring = "Animal: "+offpring+"";
        }
        return offpring;
    }
    
    /**
     *  String Method Modified for testing purposes when printing to the console
     * 
     * @return returns a String 
     */
    public String toString(){
        return "Animal «"+getExhibitionNumb()+"»:                       \n"
                    +"\tExhibition Numb: «"+getExhibitionNumb()+"»      \n"
                    +"\tSpecie:          «"+getSpecie()+"»              \n"
                    +"\tName:            «"+getName()+"»                \n"
                    +"\tDate of birth:   «"+getDateOfBirth()+"»         \n"
                    +"\tDate of arrival: «"+getDateOfArrival()+"»       \n"
                    +"\tGender:          «"+getGender()+"»              \n"
                    +"\tMedication:      "+getMedication().toString()+" \n"
                    +"\tVaccine:         "+getVacine().toString()+"     \n"
                    +"\tOffprings:       "+toStringOffsprings()+"       \n";
    }
    
    /**
     * Method that convert the object Animal contained in this class to an Array List of Strings 
     * 
     * @return an ArrayList of Strings  
     */
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = new ArrayList<String>();
        list.add(String.valueOf(getExhibitionNumb()));
        list.add(getSpecie());
        list.add(getName());
        list.add(getDateOfBirth());
        list.add(getDateOfArrival());
        list.add(String.valueOf(getGender()));
        list.add(getMedication().toString());
        list.add(getVacine().toString());
        list.add(toStringOffsprings());
        return list;
    }
    
    
    /**
     * Method that helps another methods in the Search class to generate a multidirectional array of Strings 
     * 
     * @return an ArrayList of String that contain the Variables names of the instances in the Animal Class  
     */
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("exhibitionNumb");
        names.add("specie");
        names.add("name");
        names.add("dateOfBirth");
        names.add("dateOfArrival");
        names.add("gender");
        names.add("medication");
        names.add("vacine");
        names.add("offsprings");
        return names;
    }
    
    /**
     * This Method will assign the value of the given parameter to the static variable id. 
     * 
     * @param i 
     */
    public  void setStaticVariable(int i) {
        this.id = i; 
    }
     
}
