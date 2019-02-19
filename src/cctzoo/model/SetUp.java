/**
 * Class SetUp
 * 
 * Purpose:
 * 
 * Responsible for setting up a Random list of Animal and Keeper so when the programme runs for first time there is data to play with 
 * 
 * This class contains a set of methods that help to generate the data 
 * 
 * An Instance of this class will be called in TheModel class which will contain all the collection of object for the Model Architecture  
 */
package cctzoo.model;

import cctzoo.model.animals.Animal;
import cctzoo.model.animals.Aquatic;
import cctzoo.model.animals.Avian;
import cctzoo.model.animals.CreateAquatic;
import cctzoo.model.animals.CreateAvian;
import cctzoo.model.animals.CreateMammal;
import cctzoo.model.animals.CreateMammalAquatic;
import cctzoo.model.animals.CreateReptile;
import cctzoo.model.animals.CreateReptileAquatic;
import cctzoo.model.animals.Insect;
import cctzoo.model.animals.Mammal;
import cctzoo.model.animals.Medication;
import cctzoo.model.animals.Reptile;
import cctzoo.model.animals.Vacine;
import cctzoo.model.keepers.Keeper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */

/**
 * 
 * The public class SetUp needs to implements Serializable, as the data generated here will be serialized as method for our database system. 
 */
public class SetUp implements Serializable {
    private ArrayList<Animal> myAnimals;
    private ArrayList<Medication> myMedication;
    private ArrayList<Vacine> myVacines;
    private ArrayList<Keeper> myKeepers; 
    
    /**
     * Method used to get the list of Animals
     * 
     * @return returns an ArrayList of Animals 
     */
    public ArrayList<Animal> getMyAnimals() {
        return myAnimals;
    }
    
    /**
     * Method used to set  the list of Animals
     * 
     * It takes the parameters: 
     * 
     * @param myAnimals ArrayList of animals  
     */
    public void setMyAnimals(ArrayList<Animal> myAnimals) {
        this.myAnimals = myAnimals;
    }
    
    /**
     * Method used to get the list of Medication for Animals 
     * 
     * @return returns an ArrayList of Medications 
     */
    public ArrayList<Medication> getMyMedication() {
        return myMedication;
    }
    
    /**
     * Method used to get the list of Vaccines
     * 
     * @return returns an ArrayList of Vaccines  
     */
     public ArrayList<Vacine> getMyVacines() {
        return myVacines;
    }
    
    /**
     * Method used to set the list of Medications
     * 
     * It takes the parameters: 
     * 
     * @param myMedication ArrayList of Medications 
     */
    public void setMyMedication(ArrayList<Medication> myMedication) {
        this.myMedication = myMedication;
    }
    
    /**
     * Method used to get the list of Keepers 
     * 
     * @return returns an ArrayList of Keepers  
     */
    public ArrayList<Keeper> getMyKeepers() {
        return myKeepers;
    }
    
    /**
     * Arrays of data used to generate the random list of Animals and Keepers. 
     * 
     * Notice that medicine and vaccines are individual objects taken as parameters by the Animals. 
     */
    
    // Array of Species of type Mammal 
    private String[] mammalSpecies = {"Tiger", "Elephant", "Bear", "Deer", "Squirrel", "Armadillo", "Ape", "Hyena", "Lemur", "Simian", "Jirafe", "Leopard", "Ocelot"};
    
    // Array of Species of type Reptile 
    private String[] reptileSpecies = {"Lizard", "Geckos", "Skink", "Gekkota", "Iguanidae", "Chamaleons", "Turtle", "Snake", "Lacertid", "Gila Monster", "Viper", "Tuatara"}; 
    
    // Array of species of type Avian 
    private String[] avianSpecies = {"Parrot", "Owl", "Tucan", "Swallow", "Sparrow", "Goose", "Potoo", "Heron", "Tern", "Bustard", "Kingfisher", "Turaco", "Eagle"}; 
    
    // Array for species that are Mammal and Aquatic 
    private String[] mammalAquaticSpecies = {"Dolphin", "Wale","Pinguin", "See Cow", "Otter", "Pinniped", "Rhinoceros", "Seal", "American Beaver", "Manatee", "Capibara", "Hippopotamus" }; 
    
    // Array for species that are Reptile and Aquatic
    private String[] reptileAquatic = {"Crocodile", "Anaconda", "Coral Snake", "North Watter Snake", "Emydidae", "Homalopsis Snake", "Salamander", "Turtle", "Busmaster"}; 
    
    // Array of names for Animals 
    private String[] names = {"Charlene", "Benny", "Della", "Herietta", "Dixie", "Guadalupe", "Nancy", "Byron", "Cora", "Nora", "Jody", "Blanca", "Sara", "Jeannie", "Ginger", "Dwight", "Bennie", "Ana", "Rex", "Eleanor", "Danielle", "Mack", "Verna", "Erik", "Leona"};
    
    // Array of Medication for Animals 
    private String[] medication = {"Lovetoin", "Trandoronate", "Afanuma", "Cortimadin", "Tetapitant", "Ablastral", "Bactaxime", "Allokyn", "Sublamin", "Nornex", "Adiline", "Veratasol"};
    
    // Array of Vacines for Animals 
    private String[] vacine = {"AVA-BioThrax", "DTaP", "PCV13", "Rabies", "RV1", "RV5", "Vaccinia", "Tenivac", "MMRV", "Typhoid-Oral", "Flulaval", "MenACWY", "MenB", "Fluzone", "Zostavax"};
    
    // Array of dates
    private String[] dates = {"03/09/1986", "13/06/1991", "17/02/1988", "09/01/2001", "28/10/1996", "02/08/2002", "31/08/1989", "22/11/1997", "29/06/2002", "10/02/1992", "12/09/2001",
            "23/07/2002", "30/09/1993", "22/03/1988", "21/10/1988", "13/02/1990", "07/09/1965", "23/01/1978", "09/11/1986", "14/05/1998", "24/12/1996", "22/12/1975", "21/07/1978", 
            "25/08/1992", "26/10/2002", "24/04/1988", "14/10/2000", "15/09/1992", "29/01/2000", "09/12/1989", "12/12/1999", "02/05/2002", "17/12/1989", "05/03/2001"};
    
    private String[] dates2 = {"03/09/2003", "13/06/2011", "17/02/2018", "09/01/2009", "28/10/2006", "02/08/2002", "31/08/2009", "22/11/2010", "29/06/2014", "10/02/2013", "12/09/2004",
            "23/07/2003", "30/09/2017", "22/03/2018", "21/10/2010", "13/02/2015", "07/09/2008", "23/01/2011", "09/11/2015", "14/05/2015", "24/12/2008", "22/12/2011", "21/07/2016", 
            "25/08/2014", "26/10/2017", "24/04/2008", "14/10/2010", "15/09/2011", "29/01/2015", "09/12/2013", "12/12/2003", "02/05/2003", "17/12/2017", "05/03/2004"};
    
    // Array of names for Keepers 
    private String[] keepersNames = {"Jerold Rowser", "Anabelle Lilie", "Tory Linbdlon", "Elli Rinhaldo", "Lemuel Burget", "Jermaine Luong", "Manuela Forester", "Jeannie Yuen", "Bonita Ito", "Chery Meredith", "Gay Kettler", "Wendel Goldner", "Erika Luoma", "Lin Millighan"}; 
    
    // Array with Animal Types 
    private String[] animalTypes = {"Mammal", "Reptile", "Avian", "Aquatic", "Insect"};
    
   /**
    *
    * Constructor of SetUp class. 
    * 
    * It does not take any parameters 
    */
    public SetUp() {
        myAnimals = new ArrayList<>();
        myMedication = new ArrayList<>();
        myVacines = new ArrayList<>();
        myKeepers = new ArrayList<>(); 
    }
        
    /**
     * This Method fill out the List of Medication
     * 
     * @param numMed which is the number of medication to be created  
     */
    public void setListMedication(int numMed) { 
        Random r = new Random(); 
        for(int i = 0; i < numMed ; i++) {
            myMedication.add(new Medication());
            for(int j = 0 ; j < r.nextInt(6); j++) {
                myMedication.get(i).addMedication(medication[r.nextInt(medication.length)]);
            }
        }
    }
    
    /**
     * This Method fill out the List of Vaccines
     * 
     * @param numbVac which is the number of vaccines to be created 
     */
    public void setListVacine(int numbVac) {
        Random r = new Random(); 
        for(int i = 0; i < numbVac ; i++) {
            myVacines.add(new Vacine());
            for(int j = 0 ; j < r.nextInt(3); j++) {
                myVacines.get(i).addVacine(vacine[r.nextInt(vacine.length)]);
            }
        }
    }
    
    /**
     * This Method fill out the list of Animal 
     * 
     * Inside the method, the animals are being created randomly and each animal is given a specific number 
     * 
     * of offsprings, which will be created an added to the list of animals, so eventually the list of Animals 
     * 
     * will end up with a number of animals that is bigger than the initial parameter given in the method signature
     * 
     * It takes the following parameters: 
     * 
     * @param numAnimals which is the number of animals to be created 
     */
    public void setListAnimals (int numAnimals) {
        try {
            Random r = new Random();
            for (int i = 0; i< numAnimals; i++) { 
                switch (r.nextInt(5)) {
                    case 0: 
                        myAnimals.add(new CreateMammal(mammalSpecies[r.nextInt(mammalSpecies.length)], names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                        dates2[r.nextInt(dates2.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVacines.get(r.nextInt(myVacines.size()))));

                        // Down Casting to acces the mammal method furry
                        CreateMammal c; 
                        c = (CreateMammal) myAnimals.get(myAnimals.size()-1);
                        c.setFurry(r.nextInt(2));

                        //Create Offsprings 
                        for (int j = 0; j < r.nextInt(4); j++) {
                            c.createOffpring(names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                            dates2[r.nextInt(dates2.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVacines.get(r.nextInt(myVacines.size())));
                             
                        //Down Casting to set furry to the Offsprings 
                        CreateMammal d; 
                        d = (CreateMammal) c.getOffsprings().get(j);
                        d.setFurry(r.nextInt(2));
                        myAnimals.add(d);
                        }
                    break;

                    case 1:
                        myAnimals.add(new CreateMammalAquatic(mammalAquaticSpecies[r.nextInt(mammalAquaticSpecies.length)], names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                        dates2[r.nextInt(dates2.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVacines.get(r.nextInt(myVacines.size()))));

                        // Down Casting to acces the mammal Aquatic properties 
                        CreateMammalAquatic mAq; 
                        mAq =   (CreateMammalAquatic) myAnimals.get(myAnimals.size()-1);
                        mAq.setCanBeOutSideWatter(r.nextInt(2));
                        mAq.setFurry(r.nextInt(2));

                        //Create Offsprings 
                        for (int j = 0; j < r.nextInt(4); j++) {
                            mAq.createOffpring(names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                            dates2[r.nextInt(dates2.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVacines.get(r.nextInt(myVacines.size())));

                        //Down Casting to set unique fields to the Offsprings 
                        CreateMammalAquatic mA2; 
                        mA2 =  (CreateMammalAquatic) mAq.getOffsprings().get(j);
                        mA2.setCanBeOutSideWatter(r.nextInt(2));
                        mA2.setFurry(r.nextInt(2));
                        myAnimals.add(mA2);
                        
                        }
                    break;
                        
                    case 2:
                        myAnimals.add(new CreateReptile(reptileSpecies[r.nextInt(reptileSpecies.length)], names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                        dates2[r.nextInt(dates2.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVacines.get(r.nextInt(myVacines.size()))));

                        // Down Casting to acces the Reptile Method
                        CreateReptile rept;  
                        rept =   (CreateReptile) myAnimals.get(myAnimals.size()-1);
                        rept.setIsVennon(r.nextInt(2));

                        //Create Offsprings 
                        for (int j = 0; j < r.nextInt(4); j++) {
                            rept.createOffpring(names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                            dates2[r.nextInt(dates2.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVacines.get(r.nextInt(myVacines.size())));

                         
                        CreateReptile rept2; 
                        rept2 = (CreateReptile) rept.getOffsprings().get(j);
                        rept2.setIsVennon(r.nextInt(2));
                        myAnimals.add(rept2);
                        }
                    break;
                    
                    case 3: 
                        myAnimals.add(new CreateAvian(avianSpecies[r.nextInt(avianSpecies.length)], names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                        dates2[r.nextInt(dates2.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVacines.get(r.nextInt(myVacines.size()))));
                        
                        
                        // Down Casting to acces the Avian Method
                        CreateAvian av;  
                        av =    (CreateAvian) myAnimals.get(myAnimals.size()-1);
                        av.setCanFligh(r.nextInt(2));
                        av.setHasFeeders(r.nextInt(2));

                        //Create Offsprings 
                        for (int j = 0; j < r.nextInt(4); j++) {
                            av.createOffpring(names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                            dates2[r.nextInt(dates2.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVacines.get(r.nextInt(myVacines.size())));

                        CreateAvian av2; 
                        av2 = (CreateAvian) av.getOffsprings().get(j);
                        av2.setCanFligh(r.nextInt(2));
                        av2.setHasFeeders(r.nextInt(2));
                        myAnimals.add(av2);
                        }
                        break; 
                        
                    case 4: 
                        myAnimals.add(new CreateReptileAquatic(reptileSpecies[r.nextInt(reptileSpecies.length)], names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                        dates2[r.nextInt(dates2.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVacines.get(r.nextInt(myVacines.size()))));
                        
                        // Down Casting to access the Unique ReptileAquatic Methods 
                        CreateReptileAquatic ra;  
                        ra =     (CreateReptileAquatic) myAnimals.get(myAnimals.size()-1);
                        ra.canBeOutsideWatter(r.nextInt(2));
                        ra.isVennon(r.nextInt(2));

                        //Create Offsprings 
                        for (int j = 0; j < r.nextInt(4); j++) {
                            ra.createOffpring(names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                            dates2[r.nextInt(dates2.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVacines.get(r.nextInt(myVacines.size())));

                        CreateReptileAquatic ra2; 
                        ra2 =  (CreateReptileAquatic) ra.getOffsprings().get(j);
                        ra2.canBeOutsideWatter(r.nextInt(2));
                        ra2.isVennon(r.nextInt(2));
                        myAnimals.add(ra2);
                        }
                }
            }
        } catch(Exception e) {
            System.out.println("An Error has ocurred" + e);
            
        }
    }
    
    /**
     * This Method fill out the list of Keepers
     * 
     * Each keeper takes a randomly number of offsprings, some of them don't take any 
     * 
     * @param numKeepers which is the number of animals to be created  
     */
    public void setListKeepers(int numKeepers) {
        Random r = new Random();
        String type;
        for(int i = 0; i < numKeepers ; i++) {
            getMyKeepers().add(new Keeper(names[r.nextInt(names.length)], dates[r.nextInt(dates.length)]));
            // Every keeper will have at least 2 Qualifications (max 3)
            int numero = r.nextInt(3) + 1;
            for(int j = 0 ; j < numero ; j++) {
                do {
                    type = animalTypes[r.nextInt(animalTypes.length)];
                }while(getMyKeepers().get(i).getQualification().contains(type));
                getMyKeepers().get(i).addQualification(type);
            }
            
            ArrayList<String> repetido = new ArrayList<String>();
            int max = r.nextInt(5) + 5;
            for(int k = 0 ; k < max; k++) {
                ArrayList<String> noqualify = new ArrayList<>(Arrays.asList(animalTypes));
                noqualify.removeAll(getMyKeepers().get(i).getQualification());
                
                Animal a = null;
                boolean asignado = false;
                int c = 0;
                while (asignado == false && c < getMyAnimals().size()){
                    int animalRan = r.nextInt(myAnimals.size());
                    a = getMyAnimals().get(animalRan);
                    boolean calificado = true;
                    int l=0;
                    while (l < noqualify.size() && calificado == true) {
                        String noquali = noqualify.get(l);
                         switch (noquali) {
                            case "Mammal" :
                                if(a instanceof Mammal){
                                    calificado = false;
                                }
                                break;
                            case "Reptile" :
                                if(a instanceof Reptile){
                                    calificado = false;
                                }
                                break;
                            case "Avian" :
                                if(a instanceof Avian){
                                    calificado = false;
                                }
                                break;
                            case "Aquatic" :
                                if(a instanceof Aquatic){
                                    calificado = false;
                                }
                                break;
                            case "Insect" :
                                if(a instanceof Insect){
                                    calificado = false;
                                }
                                break;
                        }
                        l++;
                    }
                    if (calificado == true && !repetido.contains(String.valueOf(animalRan))){
                        getMyKeepers().get(i).addAnimal(a);
                        repetido.add(String.valueOf(animalRan));
                        asignado=true;
                    }
                    c++;
                }
            }
        }
    }
    
    
}

