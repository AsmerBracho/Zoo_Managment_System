/**
 * Class The controller
 *
 * Purpose:
 *
 * Create and set up the controller for all different frames:
 *
 * It has the attributes:
 *
 * ViewAnimalsController viewAnimalsCtrl;
 * UpdateAnimalController updateAnimalCtrl;
 * AdminDashboardController adminCtrl;
 * AddAnimalController addAnimalCtrl;
 * AddKeeperController addKeeperCtrl;
 * ViewKeepersController viewKeepersCtrl;
 * UpdateKeeperController updateKeeperCtrl;
 *
 */
package cctzoo.controller;

import cctzoo.controller.animals.AddAnimalController;
import cctzoo.controller.keepers.AddKeeperController;
import cctzoo.controller.animals.UpdateAnimalController;
import cctzoo.controller.animals.ViewAnimalsController;
import cctzoo.controller.keepers.UpdateKeeperController;
import cctzoo.controller.keepers.ViewKeepersController;
import cctzoo.model.TheModel;
import cctzoo.view.TheView;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio
 * Guerra (2016324)
 */
public class TheController {

    ViewAnimalsController viewAnimalsCtrl;
    UpdateAnimalController updateAnimalCtrl;
    AdminDashboardController adminCtrl;
    AddAnimalController addAnimalCtrl;
    AddKeeperController addKeeperCtrl;
    ViewKeepersController viewKeepersCtrl;
    UpdateKeeperController updateKeeperCtrl;

    public TheController(TheModel model, TheView view) {

        this.adminCtrl = new AdminDashboardController(model, view, this);
        this.viewAnimalsCtrl = new ViewAnimalsController(model, view, this);
        this.updateAnimalCtrl = new UpdateAnimalController(model, view, this);
        this.addAnimalCtrl = new AddAnimalController(model, view, this);
        this.addKeeperCtrl = new AddKeeperController(model, view, this);
        this.viewKeepersCtrl = new ViewKeepersController(model, view, this);
        this.updateKeeperCtrl = new UpdateKeeperController(model, view, this);

    }

    public AddAnimalController getAddAnimalCtrl() {
        return addAnimalCtrl;
    }

    public ViewAnimalsController getViewAnimalsCtrl() {
        return viewAnimalsCtrl;
    }

    public UpdateAnimalController getUpdateAnimalCtrl() {
        return updateAnimalCtrl;
    }

    public AdminDashboardController getAdminCtrl() {
        return adminCtrl;
    }

    public AddKeeperController getAddKeeperCtrl() {
        return addKeeperCtrl;
    }

    public ViewKeepersController getViewKeepersCtrl() {
        return viewKeepersCtrl;
    }

    public UpdateKeeperController getUpdateKeeperCtrl() {
        return updateKeeperCtrl;
    }

}
