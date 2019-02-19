/**
 * Class The View
 *
 * Purpose:
 *
 * Create and initialise all the Frame that are going to show the functionality of our system.
 *
 * This class is it going to be create with the following Characteristics:
 *
 * ViewAnimalsFrame viewAnimals;
 * UpdateAnimalFrame updateAnimal;
 * AdminDashboard adminDash;
 * AddAnimalFrame addAnimal;
 * AddKeeperFrame addKeeper;
 * UpdateKeeperFrame updateKeeper;
 * ViewKeepersFrame viewKeepers;
 *
 * ArrayList<Animal> animals; ArrayList<Keeper> keepers;
 */
package cctzoo.view;

import cctzoo.model.TheModel;
import cctzoo.model.animals.Animal;
import cctzoo.model.keepers.Keeper;
import cctzoo.view.animals.AddAnimalFrame;
import cctzoo.view.animals.UpdateAnimalFrame;
import cctzoo.view.animals.ViewAnimalsFrame;
import cctzoo.view.keepers.AddKeeperFrame;
import cctzoo.view.keepers.UpdateKeeperFrame;
import cctzoo.view.keepers.ViewKeepersFrame;
import java.util.ArrayList;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 * 
 */
public class TheView {

    ViewAnimalsFrame viewAnimals;
    UpdateAnimalFrame updateAnimal;
    AdminDashboard adminDash;
    AddAnimalFrame addAnimal;
    AddKeeperFrame addKeeper;
    UpdateKeeperFrame updateKeeper;
    ViewKeepersFrame viewKeepers;

    ArrayList<Animal> animals;
    ArrayList<Keeper> keepers;

    /**
     * Constructor of the class TheView
     *
     * This constructor takes the parameter:
     *
     * @param model
     */
    public TheView(TheModel model) {

        this.animals = model.getListAnimals();
        this.keepers = model.getListKeepers();

        this.adminDash = new AdminDashboard(this, "Admin - Dashboard", 435, 300, "src/cctzoo/view/images/animal.png");

    }

    /**
     * Void method to set the AddAnimalFrame object
     *
     * It takes the parameters
     *
     * @param addAnimal
     */
    public void setAddAnimal(AddAnimalFrame addAnimal) {
        this.addAnimal = addAnimal;
    }

    /**
     * Void method to set the AddKeeperFrame object
     *
     * It takes the parameters
     *
     * @param addAnimal
     */
    public void setAddKeeper(AddKeeperFrame addKeeper) {
        this.addKeeper = addKeeper;
    }

    /**
     * Return method to get the AddAnimalFrame object
     *
     * It does not take any parameters
     *
     * @return
     */
    public AddAnimalFrame getAddAnimal() {
        return addAnimal;
    }

    /**
     * Return method to get the ViewAnimalsFrame object
     *
     * It does not take any parameters
     *
     * @return
     */
    public ViewAnimalsFrame getViewAnimals() {
        return viewAnimals;
    }

    /**
     * Void method to set the ViewAnimalsFrame object
     *
     * It takes the parameters
     *
     * @param viewAnimals
     */
    public void setViewAnimals(ViewAnimalsFrame viewAnimals) {
        this.viewAnimals = viewAnimals;
    }

    /**
     * Void method to set the UpdateAnimalFrame object
     *
     * It takes the parameters
     *
     * @param updateAnimal
     */
    public void setUpdateAnimal(UpdateAnimalFrame updateAnimal) {
        this.updateAnimal = updateAnimal;
    }

    /**
     * REturn method that does not take any parameters
     *
     * @return
     */
    public UpdateAnimalFrame getUpdateAnimal() {
        return updateAnimal;
    }

    /**
     * Return method that does not take any parameter
     *
     * @return
     */
    public AdminDashboard getAdminDash() {
        return adminDash;
    }

    /**
     * Return method that does not take any parameter
     *
     * @return
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    /**
     * Return method that does not take any parameter
     *
     * @return
     */
    public AddKeeperFrame getAddKeeper() {
        return addKeeper;
    }

    /**
     * Return method that does not take any parameter
     *
     * @return
     */
    public UpdateKeeperFrame getUpdateKeeper() {
        return updateKeeper;
    }

    /**
     * Void method that takes the parameter:
     *
     * @param adminDash
     */
    public void setAdminDash(AdminDashboard adminDash) {
        this.adminDash = adminDash;
    }

    /**
     * Void method that takes the parameter:
     *
     * @param updateKeeper
     */
    public void setUpdateKeeper(UpdateKeeperFrame updateKeeper) {
        this.updateKeeper = updateKeeper;
    }

    /**
     * Return method that does not take any parameter
     *
     * @return
     */
    public ArrayList<Keeper> getKeepers() {
        return keepers;
    }

    /**
     * Void method that takes the parameter:
     *
     * @param viewKeeper
     */
    public void setViewKeepers(ViewKeepersFrame viewKeeper) {
        this.viewKeepers = viewKeeper;
    }

    /**
     * Return method that does not take any parameter
     *
     * @return
     */
    public ViewKeepersFrame getViewKeepers() {
        return viewKeepers;
    }

}
