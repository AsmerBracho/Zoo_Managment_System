/**
 * Class Medication
 * 
 * Purpose: It create a object of type Medication which contain a serial number an Name
 * 
 * This class implements Serializable as the medication is part of the object Animal which will be Serialized. 
 */
package cctzoo.model.animals;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */

public class Medication implements Serializable {
    private int id;
    private final int serial; 
    private ArrayList<String> medicationName;
    
    /**
     * Default Constructor for Medication
     */
    public Medication() {
        serial = id; 
        id++;
        medicationName = new ArrayList<>();
    }
    
    /**
     * Second Constructor for the class Medication 
     * 
     * @param name which is the name of the medication to be added to the list of medication 
     */
    public Medication(String name) {
        serial = id; 
        id++;
        medicationName = new ArrayList<>();
        medicationName.add(name); 
    }
    
    /**
     * Method used to add a new medication to the array
     * 
     * @param name which is the name of the medication to be added to the list of medication 
     */
    public void addMedication(String name) {
        medicationName.add(name); 
    }
    
    /**
     * Method used to get Medication Name
     * 
     * @return medication name  
     */
    public ArrayList<String> getMedicationName() {
        return medicationName;
    }
    
    /**
     * Method used for testing purposes
     * 
     * @return a variable of type String   
     */
    public String toString(){
        String var = "";
        if (getMedicationName().size() != 0){
            for (int i = 0 ; i < getMedicationName().size() ; i++){
                if (i == getMedicationName().size() - 1){
                    var += String.valueOf(getMedicationName().get(i));
                }else{
                    var += String.valueOf(getMedicationName().get(i))+", ";
                }
            }
        }
        return var;
    }
    
    public void addMedication(ArrayList<String> medication) {
        for (String m : medication) {
            this.medicationName.add(m);
        }
    }
}
