/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.controller.keepers;

import cctzoo.controller.TheController;
import cctzoo.model.TheModel;
import cctzoo.model.animals.CreateAquatic;
import cctzoo.model.animals.CreateAvian;
import cctzoo.model.animals.CreateInsect;
import cctzoo.model.animals.CreateMammal;
import cctzoo.model.animals.CreateMammalAquatic;
import cctzoo.model.animals.CreateReptile;
import cctzoo.model.animals.CreateReptileAquatic;
import cctzoo.view.TheView;
import cctzoo.view.keepers.UpdateKeeperFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio
 * Guerra (2016324)
 */
public class UpdateKeeperController implements WindowListener {

    TheModel model;
    TheView view;
    TheController ctrl;
    UpdateKeeperFrame updateKeeper;
    int boxesClicked = 0;
    int index;
    int indexAnimal;
    boolean flag = false;
    int indexRow;
    ArrayList<Integer> addedIndexes = new ArrayList<Integer>();
    ArrayList<String> newQualifications = new ArrayList<>();

    public UpdateKeeperController(TheModel model, TheView view, TheController ctrl) {
        this.model = model;
        this.view = view;
        this.ctrl = ctrl;

    }

    public void setUpdateKeeper(UpdateKeeperFrame updateKeeper) {
        this.updateKeeper = updateKeeper;
        this.goBackButtonController();
        this.updateKeeper.addWindowListener(this);
        this.checkQualifications();
        this.addControllerToCheckBox();
        this.addControllerToAnimalsTable();
        this.addAnimalToKeeperController();
        this.checkNumberOfAnimals();
        this.updateKeeperDetailsController();

        this.updateKeeper.getOffspringsPanel().setVisible(false);

        this.updateKeeper.getAnimalView().setVisible(false);

        this.updateKeeper.getAddAnimalToKeeperButton().setVisible(false);
    }

    private void checkNumberOfAnimals() {
        if (model.getListKeepers().get(index).getkeeperAnimals().size() >= 10) {
            this.updateKeeper.getAddAnimalToKeeperButton().setEnabled(false);

        }

    }

    private void checkQualifications() {
        if (model.getListKeepers().get(index).getQualification().size() == 3) {
            boxesClicked = 15;
            disableAllBoxes();
        } else {
            boxesClicked = model.getListKeepers().get(index).getQualification().size() * 5;
        }
    }

    private void disableAllBoxes() {
        for (JCheckBox cb : updateKeeper.getQualifications()) {
            cb.setEnabled(false);
        }
    }

    private void addControllerToCheckBox() {

        for (int i = 0; i < updateKeeper.getQualifications().length; i++) {
            updateKeeper.getQualifications()[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {

                    if (e.getStateChange() == ItemEvent.SELECTED) {

                        if (e.getItem().toString().matches("(?i:.*Mammal.*)")) {
                            model.getListKeepers().get(index).getQualification().add("Mammal");
                        } else if (e.getItem().toString().matches("(?i:.*Reptile.*)")) {
                            model.getListKeepers().get(index).getQualification().add("Reptile");
                        } else if (e.getItem().toString().matches("(?i:.*Avian.*)")) {
                            model.getListKeepers().get(index).getQualification().add("Avian");
                        } else if (e.getItem().toString().matches("(?i:.*Aquatic.*)")) {
                            model.getListKeepers().get(index).getQualification().add("Aquatic");
                        } else if (e.getItem().toString().matches("(?i:.*Insect.*)")) {
                            model.getListKeepers().get(index).getQualification().add("Insect");
                        }

                        for (int i = 0; i < updateKeeper.getQualifications().length; i++) {

                            boxesClicked++;

                        }

                    } else {
                        if (e.getItem().toString().matches("(?i:.*Mammal.*)")) {
                            model.getListKeepers().get(index).getQualification().remove("Mammal");
                        } else if (e.getItem().toString().matches("(?i:.*Reptile.*)")) {
                            model.getListKeepers().get(index).getQualification().remove("Reptile");
                        } else if (e.getItem().toString().matches("(?i:.*Avian.*)")) {
                            model.getListKeepers().get(index).getQualification().remove("Avian");
                        } else if (e.getItem().toString().matches("(?i:.*Aquatic.*)")) {
                            model.getListKeepers().get(index).getQualification().remove("Aquatic");
                        } else if (e.getItem().toString().matches("(?i:.*Insect.*)")) {
                            model.getListKeepers().get(index).getQualification().remove("Insect");
                        }

                        for (int i = 0; i < updateKeeper.getQualifications().length; i++) {

                            boxesClicked--;

                        }
                    }
                    if (boxesClicked >= 15) {
                        for (int i = 0; i < updateKeeper.getQualifications().length; i++) {

                            if (!updateKeeper.getQualifications()[i].isSelected()) {
                                updateKeeper.getQualifications()[i].setEnabled(false);
                            }

                        }
                    } else {
                        for (int i = 0; i < updateKeeper.getQualifications().length; i++) {

                            if (!updateKeeper.getQualifications()[i].isSelected()) {
                                updateKeeper.getQualifications()[i].setEnabled(true);
                            }

                        }
                    }
                }
            });
        }
    }

    private void goBackButtonController() {

        updateKeeper.getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(updateKeeper, "Are you sure you want to go back?", "Did you update?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    addedIndexes.clear();
                    updateKeeper.dispose();
                    view.getUpdateKeeper().dispose();
                    view.getViewKeepers().setVisible(true);

                    view.getViewKeepers().getKeepersPanel().removeAllRows();
                    ctrl.getViewKeepersCtrl().resetAnimalDetails();

                    ctrl.getViewKeepersCtrl().setKeeperCard(index);
                    ctrl.getViewKeepersCtrl().setAnimalsTable();
                    ctrl.getViewKeepersCtrl().setKeeperCard(index);
                    ctrl.getViewKeepersCtrl().setKeepersTable(model.getListKeepers());
                    //view.getViewKeepers().validate();
                    //view.getViewKeepers().repaint();

                }
            }

        });
    }

    private void addAnimalToKeeperController() {

        updateKeeper.getAddAnimalToKeeperButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (indexRow > -1) {
                    addAnimalToKeeper();
                    indexRow = -1;
                    JOptionPane.showMessageDialog(updateKeeper, "The Animal has been added to the keeper!", "Yey!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(updateKeeper, "The Animal has already been added to the keeper!", "Psssssssssssssst!", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    private void updateKeeperDetailsController() {

        updateKeeper.getUpdateKeeperButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                updateKeeperDetails();
                JOptionPane.showMessageDialog(updateKeeper, "Keeper has been Updated!", "Yey!", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(updateKeeper, "Now you going to be promted to the previous windows!", "We are taking you back!", JOptionPane.INFORMATION_MESSAGE);
                //view.getViewKeepers().getKeepersPanel().getViewKeepersTable().setRowSelectionInterval(0, index);
                addedIndexes.clear();

                updateKeeper.dispose();
                view.getUpdateKeeper().dispose();
                view.getViewKeepers().setVisible(true);

                view.getViewKeepers().getKeepersPanel().removeAllRows();
                ctrl.getViewKeepersCtrl().resetAnimalDetails();

                ctrl.getViewKeepersCtrl().setKeeperCard(index);
                ctrl.getViewKeepersCtrl().setAnimalsTable();
                ctrl.getViewKeepersCtrl().setKeeperCard(index);
                ctrl.getViewKeepersCtrl().setKeepersTable(model.getListKeepers());
                //view.getViewKeepers().validate();
                //view.getViewKeepers().repaint();
            }

        });
    }

    private void updateKeeperDetails() {

        model.getListKeepers().get(index).setName(updateKeeper.getKeeperName().getText());
        model.getListKeepers().get(index).setDateOfBirth(updateKeeper.dateToString());

        for (JCheckBox cb : updateKeeper.getQualifications()) {
            if (cb.isSelected()) {
                cb.setEnabled(false);
            }
        }
    }

    private void addAnimalToKeeper() {
        model.getListKeepers().get(index).addAnimal(model.getListAnimals().get(indexAnimal));
        updateKeeper.getAnimalsPanel().removeRow(indexRow);
        updateKeeper.getAnimalsPanel().getSr().updateUI();
        updateKeepersAnimalsTable();

    }

    private void updateKeepersAnimalsTable() {

        updateKeeper.getKeepersAnimalsPanel().removeAllRows();
        updateKeeper.getKeepersAnimalsPanel().dataToString(model.getListKeepers().get(index).getkeeperAnimals());
        updateKeeper.getKeepersAnimalsPanel().setData();

        this.checkNumberOfAnimals();

    }

    private void addControllerToAnimalsTable() {
        this.updateKeeper.getAnimalsPanel().getViewAnimalsTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (event.getValueIsAdjusting()) {
                    if (updateKeeper.getAnimalsPanel().getViewAnimalsTable().getSelectedRow() > -1) {

                        updateKeeper.getAddAnimalToKeeperButton().setVisible(true);
                        resetAnimalDetails();

                        // Row clicked
                        int row = updateKeeper.getAnimalsPanel().getViewAnimalsTable().getSelectedRow();
                        indexRow = row;
                        // Exhibit Number
                        int en = Integer.parseInt((String) updateKeeper.getAnimalsPanel().getViewAnimalsTable().getValueAt(row, 0));
                        setAnimalCard(en);
                        indexAnimal = en;
                        // Initializing the offsprings table with all the data
                        setOffspringsTable();

                    } else {
                        updateKeeper.getViewAnimalsOnFrame().getImageLabel().setVisible(true);
                    }
                }
            }
        });
    }

    protected void resetAnimalDetails() {
        if (flag == true) {

            updateKeeper.getAnimalView().removeAll();
            updateKeeper.getAnimalView().updateUI();
            updateKeeper.getOffspringsPanel().removeAllRows();

        }
        flag = true;
    }

    protected void setOffspringsTable() {
        updateKeeper.getOffspringsPanel().setVisible(true);
        updateKeeper.getOffspringsPanel().dataToString(model.getListAnimals().get(indexAnimal).getOffsprings());
        updateKeeper.getOffspringsPanel().setData();
        updateKeeper.getUpdateKeeperButton().setEnabled(true);

    }

    protected void setAnimalCard(int en) {
        updateKeeper.getViewAnimalsOnFrame().getImageLabel().setVisible(false);
        updateKeeper.getAnimalView().setVisible(true);
        // Exhibit Number
        updateKeeper.getAnimalView().setExhibitNumber(Integer.toString(en));
        // Look For Animal Type
        String[] types = null;
        for (int i = 0; i < model.getListAnimals().get(en).getClass().getInterfaces().length; i++) {
            if (i == 0) {
                types = new String[model.getListAnimals().get(en).getClass().getInterfaces().length];
            }
            types[i] = model.getListAnimals().get(en).getClass().getInterfaces()[i].getSimpleName();
        }
        updateKeeper.getAnimalView().setType(types);
        // Specie
        String specie = model.getListAnimals().get(en).getSpecie();
        updateKeeper.getAnimalView().setSpecie(specie);
        // Name
        String name = model.getListAnimals().get(en).getName();
        updateKeeper.getAnimalView().setName(name);
        // gender
        String gender = model.getListAnimals().get(en).getGender();
        updateKeeper.getAnimalView().setGender(gender);
        // Day of birth
        String birth = model.getListAnimals().get(en).getDateOfBirth();
        updateKeeper.getAnimalView().setDayOfBirth(birth);
        // Day of Arrival
        String arrival = model.getListAnimals().get(en).getDateOfArrival();
        updateKeeper.getAnimalView().setDayOfArrival(arrival);
        // Medication
        ArrayList<String> med = model.getListAnimals().get(en).getMedication().getMedicationName();
        updateKeeper.getAnimalView().setMedication(med);
        // Vaccination
        ArrayList<String> vac = model.getListAnimals().get(en).getVacine().getVacineName();
        updateKeeper.getAnimalView().setVaccine(vac);
        // Number of Offsprings
        int no = model.getListAnimals().get(en).getOffsprings().size();
        updateKeeper.getAnimalView().setOffprings(Integer.toString(no));
        // extra details

        if (types.length == 1) {
            switch (types[0]) {
                case "Aquatic":

                    updateKeeper.getAnimalView().setExtraDetails("Amphibian", ((CreateAquatic) model.getListAnimals().get(en)).getCanBeOutSideWatter());
                    break;
                case "Avian":

                    updateKeeper.getAnimalView().setExtraDetails("Flight", ((CreateAvian) model.getListAnimals().get(en)).getCanFligh());
                    updateKeeper.getAnimalView().setExtraDetails("Feathers", ((CreateAvian) model.getListAnimals().get(en)).getHasFeeders());
                    break;
                case "Insect":

                    updateKeeper.getAnimalView().setExtraDetails("Venomous", ((CreateInsect) model.getListAnimals().get(en)).getIsVennon());
                    break;
                case "Mammal":

                    updateKeeper.getAnimalView().setExtraDetails("Fur", ((CreateMammal) model.getListAnimals().get(en)).getFurry());
                    break;
                case "Reptile":

                    updateKeeper.getAnimalView().setExtraDetails("Venomous", ((CreateReptile) model.getListAnimals().get(en)).getIsVennon());
                    break;
                default:
                    break;
            }
        } else {
            switch (types[0]) {
                case "Mammal":
                    updateKeeper.getAnimalView().setExtraDetails("Fur", ((CreateMammalAquatic) model.getListAnimals().get(en)).getFurry());
                    updateKeeper.getAnimalView().setExtraDetails("Amphibian", ((CreateMammalAquatic) model.getListAnimals().get(en)).getCanBeOutSideWatter());
                    break;
                case "Reptile":
                    updateKeeper.getAnimalView().setExtraDetails("Venomous", ((CreateReptileAquatic) model.getListAnimals().get(en)).getIsVennon());
                    updateKeeper.getAnimalView().setExtraDetails("Amphibian", ((CreateReptileAquatic) model.getListAnimals().get(en)).getCanBeOutSideWatter());
                    break;
                default:
                    break;
            }

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(updateKeeper, "Are you sure you want to go back?", "Did you update?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            addedIndexes.clear();
            updateKeeper.dispose();
            view.getUpdateKeeper().dispose();
            view.getViewKeepers().setVisible(true);

            view.getViewKeepers().getKeepersPanel().removeAllRows();
            ctrl.getViewKeepersCtrl().resetAnimalDetails();

            ctrl.getViewKeepersCtrl().setKeeperCard(index);
            ctrl.getViewKeepersCtrl().setAnimalsTable();
            ctrl.getViewKeepersCtrl().setKeeperCard(index);
            ctrl.getViewKeepersCtrl().setKeepersTable(model.getListKeepers());

        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public void setIndex(int index) {
        this.index = index;
    }

}
