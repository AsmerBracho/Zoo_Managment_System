/**
 * Class AddAnimalFrame
 *
 * Purpose:
 *
 * To generate a frame where animals can be added
 *
 * It has the attributes:
 *
 * private ComboBoxFieldsPanel medication;
 * private ComboBoxFieldsPanel vaccine;
 * private ComboBoxFieldsPanel type;
 * private ComboBoxFieldsPanel specie;
 * private ComboBoxFieldsPanel gender;
 * private Header header;
 * private final ImageLabel addAnimalImageLabel;
 * private TextFieldPanel addAnimalName;
 * private final ImageLabel addAnimalImageLabel2;
 * private CalendarPanel addAnimalDayOfBirth;
 * private CalendarPanel addAnimalDayOfArrival;
 * private GenericButton addAnimalButton;
 * private GenericButton resetAnimalButton;
 * private final ImageLabel addAnimalImageLabel3;
 * private CheckBoxPanel extraCharacteristics;
 *
 */
package cctzoo.view.animals;

import cctzoo.view.generic.CalendarPanel;
import cctzoo.view.generic.CheckBoxPanel;
import cctzoo.view.generic.ComboBoxFieldsPanel;
import cctzoo.view.generic.GenericButton;
import cctzoo.view.generic.Header;
import cctzoo.view.generic.ImageLabel;
import cctzoo.view.generic.MainFrame;
import cctzoo.view.generic.TextFieldPanel;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio
 * Guerra (2016324)
 *
 */
public class AddAnimalFrame extends MainFrame {

    private ComboBoxFieldsPanel medication;
    private ComboBoxFieldsPanel vaccine;
    private ComboBoxFieldsPanel type;
    private ComboBoxFieldsPanel specie;
    private ComboBoxFieldsPanel gender;
    private Header header;
    private final ImageLabel addAnimalImageLabel;
    private TextFieldPanel addAnimalName;
    private final ImageLabel addAnimalImageLabel2;
    private CalendarPanel addAnimalDayOfBirth;
    private CalendarPanel addAnimalDayOfArrival;
    private GenericButton addAnimalButton;
    private GenericButton resetAnimalButton;
    private final ImageLabel addAnimalImageLabel3;
    private CheckBoxPanel extraCharacteristics;

    /**
     * Contructor of the class AddAnimalFrame that takes the parameters:
     *
     * @param frameTitle
     * @param frameWidth
     * @param frameHeight
     * @param iconName
     */
    public AddAnimalFrame(String frameTitle, int frameWidth, int frameHeight, String iconName) {
        super(frameTitle, frameWidth, frameHeight, iconName);

        /**
         * Create header
         */
        this.header = new Header(frameWidth, 110, "Add Animal", "src/cctzoo/view/images/addanimal.png", "src/cctzoo/view/images/back.png", "Go Back");
        this.add(this.header);

        /**
         * Add image
         */
        this.addAnimalImageLabel = new ImageLabel(20, 70, 173, 200, "src/cctzoo/view/images/addditto.png");
        this.add(this.addAnimalImageLabel.getImageLabel());

        /**
         * Add combo box of types
         */
        this.type = new ComboBoxFieldsPanel(this.setTypesFields(), "Type", 200, 70, 60);
        this.add(this.type);
        this.type.setEnabled(true);
        this.type.getFieldOne().setEnabled(true);

        /**
         * Add combo box of specie
         */
        ArrayList<String> list = new ArrayList<>();
        this.specie = new ComboBoxFieldsPanel(list, "Specie", 200, 130, 60);
        this.add(this.specie);
        this.specie.setEnabled(true);
        this.specie.getFieldOne().setEnabled(true);

        /**
         * Add text field of name
         */
        this.addAnimalName = new TextFieldPanel(340, 70, 190, 60, "Name ");
        this.add(this.addAnimalName);
        this.addAnimalName.setEnabled(true);
        this.addAnimalName.getTextField().setEnabled(true);

        /**
         * Add combo box of gender
         */
        ArrayList<String> genders = new ArrayList<String>();
        genders.add("male");
        genders.add("female");
        this.gender = new ComboBoxFieldsPanel(genders, "Gender", 340, 130, 60);
        this.add(this.gender);
        this.gender.setEnabled(true);
        this.gender.getFieldOne().setEnabled(true);

        /**
         * Add image
         */
        this.addAnimalImageLabel2 = new ImageLabel(485, 140, 40, 40, "src/cctzoo/view/images/cat.png");
        this.add(this.addAnimalImageLabel2.getImageLabel());

        /**
         * Add day of birth date picker
         */
        this.addAnimalDayOfBirth = new CalendarPanel(540, 70, "Date Of Birth ", "Set day of birth of Animal");
        this.add(this.addAnimalDayOfBirth);
        this.addAnimalDayOfBirth.setEnabled(true);
        this.addAnimalDayOfBirth.getDatePicker().getComponent(0).setEnabled(true);
        this.addAnimalDayOfBirth.getDatePicker().getComponent(1).setEnabled(true);

        /**
         * Add day of arrival date picker
         */
        this.addAnimalDayOfArrival = new CalendarPanel(540, 130, "Date Of Arrival ", "Set day of Arrival of Animal");
        this.add(this.addAnimalDayOfArrival);
        this.addAnimalDayOfArrival.setEnabled(true);
        this.addAnimalDayOfArrival.getDatePicker().getComponent(0).setEnabled(true);
        this.addAnimalDayOfArrival.getDatePicker().getComponent(1).setEnabled(true);

        /**
         * Add combo box for medication
         */
        this.medication = new ComboBoxFieldsPanel(this.setMedicineFields(), "Medication", 200, 190);
        this.add(this.medication);

        /**
         * Add combo box for vaccine
         */
        this.vaccine = new ComboBoxFieldsPanel(this.setVaccineFields(), "Vaccine", 340, 190);
        this.add(this.vaccine);

        /**
         * Add extra characteristics
         */
        this.extraCharacteristics = new CheckBoxPanel(480, 190, 120, 80, "Extras ", "Add Extra Characteristics to Animal");
        this.add(this.extraCharacteristics);

        /**
         * Add button for adding animal
         */
        this.addAnimalButton = new GenericButton(495, 280, 90, "src/cctzoo/view/images/addanimal.png", "Add ", "Add Animal");
        this.add(this.addAnimalButton);
        this.addAnimalButton.setEnabled(true);

        /**
         * Add button to reset details
         */
        this.resetAnimalButton = new GenericButton(50, 280, 90, "src/cctzoo/view/images/reset.png", "Reset ", "Reset Values");
        this.add(this.resetAnimalButton);
        this.resetAnimalButton.setEnabled(true);

        /**
         * Add image
         */
        this.addAnimalImageLabel3 = new ImageLabel(610, 190, 130, 130, "src/cctzoo/view/images/snake.png");
        this.add(this.addAnimalImageLabel3.getImageLabel());

    }

    /**
     * Return method that returns:
     *
     * @return
     */
    private ArrayList<String> setTypesFields() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Avian");
        list.add("Mammal");
        list.add("Reptile");
        list.add("Mammal Aquatic");
        list.add("Reptile Aquatic");

        return list;
    }

    /**
     * Return method that takes the parameter:
     *
     * @param typeField
     *
     * And Returns:
     *
     * @return
     */
    public ArrayList<String> setSpeciesFields(String typeField) {
        ArrayList<String> list;

        switch (typeField) {
            case "Avian":
                String[] avianSpecies = {"Parrot", "Owl", "Tucan", "Swallow", "Sparrow", "Goose", "Potoo", "Heron", "Tern", "Bustard", "Kingfisher", "Turaco", "Eagle"};
                list = new ArrayList<>(Arrays.asList(avianSpecies));
                return list;
            case "Mammal":
                String[] mammalSpecies = {"Tiger", "Elephant", "Bear", "Deer", "Squirrel", "Armadillo", "Ape", "Hyena", "Lemur", "Simian", "Jirafe", "Leopard", "Ocelot"};
                list = new ArrayList<>(Arrays.asList(mammalSpecies));
                return list;
            case "Reptile":
                String[] reptileSpecies = {"Lizard", "Geckos", "Skink", "Gekkota", "Iguanidae", "Chamaleons", "Turtle", "Snake", "Lacertid", "Gila Monster", "Viper", "Tuatara"};
                list = new ArrayList<>(Arrays.asList(reptileSpecies));
                return list;
            case "Mammal Aquatic":
                String[] mammalAquaticSpecies = {"Dolphin", "Wale", "Pinguin", "See Cow", "Otter", "Pinniped", "Rhinoceros", "Seal", "American Beaver", "Manatee", "Capibara", "Hippopotamus"};
                list = new ArrayList<>(Arrays.asList(mammalAquaticSpecies));
                return list;
            case "Reptile Aquatic":
                String[] reptileAquaticSpecies = {"Crocodile", "Anaconda", "Coral Snake", "North Watter Snake", "Emydidae", "Homalopsis Snake", "Salamander", "Turtle", "Busmaster"};
                list = new ArrayList<>(Arrays.asList(reptileAquaticSpecies));
                return list;
            default:
                return null;
        }

    }

    /**
     * Return method that returns:
     *
     * @return
     */
    public ArrayList<String> setMedicineFields() {
        ArrayList<String> list;
        String[] medication = {"Lovetoin", "Trandoronate", "Afanuma", "Cortimadin", "Tetapitant", "Ablastral", "Bactaxime", "Allokyn", "Sublamin", "Nornex", "Adiline", "Veratasol"};
        list = new ArrayList<>(Arrays.asList(medication));
        return list;
    }

    /**
     * Return method that returns:
     *
     * @return
     */
    public ArrayList<String> setVaccineFields() {
        ArrayList<String> list;
        String[] vacine = {"AVA-BioThrax", "DTaP", "PCV13", "Rabies", "RV1", "RV5", "Vaccinia", "Tenivac", "MMRV", "Typhoid-Oral", "Flulaval", "MenACWY", "MenB", "Fluzone", "Zostavax"};
        list = new ArrayList<>(Arrays.asList(vacine));
        return list;
    }

    /**
     * Method that returns:
     *
     * @return
     */
    public ComboBoxFieldsPanel getMedication() {
        return medication;
    }

    /**
     * Method that returns:
     *
     * @return
     */
    public ComboBoxFieldsPanel getVaccine() {
        return vaccine;
    }

    /**
     * Method that returns:
     *
     * 
     * @return 
     */
    public ComboBoxFieldsPanel getTypeField() {
        return type;
    }

    /**
     * Method that returns: 
     * 
     * @return 
     */
    public ComboBoxFieldsPanel getSpecie() {
        return specie;
    }

    /**
     * Method that returns
     * 
     * @return 
     */
    public ComboBoxFieldsPanel getGender() {
        return gender;
    }

    /**
     * Method that returns: 
     * 
     * @return 
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Method that returns: 
     * 
     * @return 
     */
    public TextFieldPanel getAddAnimalName() {
        return addAnimalName;
    }

    /**
     * Method that returns: 
     * 
     * @return 
     */
    public CalendarPanel getAddAnimalDayOfBirth() {
        return addAnimalDayOfBirth;
    }

    /**
     * Method that returns: 
     * 
     * @return 
     */
    public CalendarPanel getAddAnimalDayOfArrival() {
        return addAnimalDayOfArrival;
    }

    /**
     * Method that returns: 
     * 
     * @return 
     */
    public GenericButton getAddAnimalButton() {
        return addAnimalButton;
    }

    /**
     * Method that returns: 
     * 
     * @return 
     */
    public GenericButton getResetAnimalButton() {
        return resetAnimalButton;
    }

    /**
     * Method that returns: 
     * 
     * @return 
     */
    public CheckBoxPanel getExtraCharacteristics() {
        return extraCharacteristics;
    }

}
