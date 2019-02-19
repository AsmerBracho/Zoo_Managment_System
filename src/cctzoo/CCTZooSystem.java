/**
 * Class:
 *
 * Purpose:
 *
 * To initialize the main three components of our project.
 *
 * The Model,
 * The View, and
 * The Controller
 *
 */
package cctzoo;

import cctzoo.controller.TheController;
import cctzoo.model.TheModel;
import cctzoo.view.TheView;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public class CCTZooSystem {

    TheModel model;
    TheView view;
    TheController control;
    
    /**
     * Constructor of the Class CCTZooSystem.
     * 
     * It only has an empty constructor
     */
    public CCTZooSystem() {

        model = new TheModel();
        view = new TheView(model);
        control = new TheController(model, view);

    }

}
