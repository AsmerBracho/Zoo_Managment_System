/**
 * Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 * Object Oriented Constructs - Group B
 * Application Development Project - Zoo
 * Last Modified 13/05/2018
 * 
 * Requires JDatePicker Library to work. This jar file is already included.
 *
 * Purpose:
 *
 * We have been tasked to create a Zoo management system.
 * The Zoo has a number of Animals. These Animals are broken down into types:
 *
 * Mammal
 * Reptile
 * Avian
 * Aquatic
 * Insect
 *
 * Each Animal has a Zoo keeper that looks after it.
 *
 * Zoo keepers are only allowed to care for animals if they are qualified to do so.
 *
 * A zoo keeper can look after a max of 3 Animal types for a max of 10 animals.
 *
 * Our system is capable of run on test data before the Zoo will accept it. We are
 * required to have a data set of at least 100 animals and 40 zoo keepers.
 *
 * The system must allow a user to:
 * 
 * Search for Animals.
 * Search for Keepers.
 * Add new animals.
 * Add new keepers.
 * Update animals.
 * Update keepers.
 * 
 * Assumptions:
 *
 * For Animals:
 * 
 * We think that nobody is going to change either the name, specie or day of birth, or the day of arrival
 * of the animals. That is why we are not allowing the user to change them. An easy implementation of action
 * listener will help us add this functionality. Update animal only add new offsprings to the selected animal.
 * 
 * For keepers we are updating everything and we are doing the validations by GUI. You might see some blank spaces
 * on the Frames. This are for functionality that we were not able to add to our system due to lack of time.
 * 
 * Extra:
 * 
 * Any bugs that are find on this beta version of the system please inform the creators to sort them out.
 *
 */
package cctzoo;

import cctzoo.view.animals.ViewAnimalsFrame;
import cctzoo.view.generic.RefineByPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public class CCTZoo {

    /**
     * Main method of our program
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new CCTZooSystem();

            }
        });

    }

}
