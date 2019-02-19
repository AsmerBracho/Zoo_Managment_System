/**
 * Interface Mammal
 * 
 */
package cctzoo.model.animals;

import java.util.ArrayList;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public interface Mammal {
    
    /**
     * Method hasFur
     * 
     * This is a default method since the implementation for it will be the same for any class that implements it
     * 
     * @param t
     * @return 
     */
    default String hasFur(int t) {
        return t == 1 ? "Yes" : "No"; 
    }
    
    /**
     * This Method is an extension of the toArayList method in class Animal which it will be used to add new Characteristics  to the object 
     * animal depending of the interface being used 
     *  
     */
    public ArrayList<String> toArrayList();
    
    /**
     * This Method is an extension of the nameVariable method in class Animal which it will be used to add new Characteristics  to the object 
     * animal depending of the interface being used 
     *   
     */
    public ArrayList<String> nameVariables();
}
