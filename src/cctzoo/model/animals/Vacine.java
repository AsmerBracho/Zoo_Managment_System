/**
 * Class Vacine
 * 
 * Purpose: It create a object of type Vaccine which contain a serial number an Name
 * 
 * This class implements Serializable as the Vaccine is part of the object Animal which will be Serialized. 
 */
package cctzoo.model.animals;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */

public class Vacine implements Serializable {
    private int id;
    private final int serial; 
    private ArrayList<String> vacineName;
    
    /**
     * Default constructor for Vaccine 
     */
    public Vacine() {
        serial = id; 
        id++;
        vacineName = new ArrayList<>(); 
    }
    
    /**
     * Second Constructor for Vacine
     * 
     * @param name which is the name of the vaccine to be added to the list of vaccines
     */
    public Vacine(String name) {
        serial = id; 
        id++;
        vacineName = new ArrayList<>();
        vacineName.add(name); 
    }
    
    /**
     * Method used to add a new vaccine to the array
     * 
     * @param name which is the name of the vaccine to be added to the list of Vaccines 
     */
    public void addVacine(String name) {
        vacineName.add(name); 
    }
    
    /**
     * Method used to get Vaccine Name
     * 
     * @return vaccine name  
     */
    public ArrayList<String> getVacineName() {
        return vacineName;
    }
    
    /**
     * Method used for testing purposes
     * 
     * @return a variable of type String   
     */
    public String toString(){
        String var = "";
        if (getVacineName().size() != 0){
            for (int i = 0 ; i < getVacineName().size() ; i++){
                if (i == getVacineName().size() - 1){
                    var += String.valueOf(getVacineName().get(i));
                }else{
                    var += String.valueOf(getVacineName().get(i))+", ";
                }
            }
        }
        return var;
    }
    
     public void addVacine(ArrayList<String> vac) {
        for (String v : vac) {
            this.vacineName.add(v);
        }
    }
} 
       

