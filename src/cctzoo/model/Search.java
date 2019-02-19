/**
 * Class Search
 *
 * Purpose:
 *
 * This class is a collection of Methods that will be used to  perform the searches
 *
 */
package cctzoo.model;

import java.util.ArrayList;
/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio
 * Guerra (2016324)
 */

import cctzoo.model.animals.Animal;
import cctzoo.model.keepers.Keeper;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Search {

    /**
     * This Method search animals by type
     *
     * It takes the parameters:
     *
     * @param list which is the Array that contain the list of animals
     * @param type which is a String that contain the type of animal to search
     *
     * @return returns the list of animals which fulfill the requirements
     *
     */
    public ArrayList<Animal> searchAnimalByTypes(ArrayList<Animal> list, String type) {

        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        String typeName;
        boolean added = false;
        int i = 0;

        for (Animal a : list) {

            while (added == false && i < a.getClass().getInterfaces().length) {

                typeName = a.getClass().getInterfaces()[i].getSimpleName();

                if (typeName.matches(type)) {
                    listSearch.add(a);
                    added = true;
                }

                i++;
            }
            added = false;
            i = 0;
        }

        return listSearch;

    }

    /**
     * This Method search animals by specie
     *
     * It takes the parameters:
     *
     * @param list which is the Array that contain the list of animals
     * @param species String that contains the specie to be searched
     *
     * @return returns the list of animals which fulfill the requirements
     */
    public ArrayList<Animal> searchAnimalBySpecies(ArrayList<Animal> list, String species) {
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        for (Animal a : list) {
            if (a.getSpecie().matches(species)) {
                listSearch.add(a);
            }
        }
        return listSearch;
    }

    /**
     * Search Animal by Names
     *
     * @param list
     * @param name
     * @return
     */
    public ArrayList<Animal> searchAnimalByNames(ArrayList<Animal> list, String name) {
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        for (Animal a : list) {
            if (a.getName().matches(name)) {
                listSearch.add(a);
            }
        }
        return listSearch;
    }

    /**
     * This Method Search Keepers By Name
     *
     * It take the parameters
     *
     * @param list of animals
     * @param name name to be looked for
     * @return
     */
    public ArrayList<Keeper> searchKeeperByNames(ArrayList<Keeper> list, String name) {
        ArrayList<Keeper> listSearch = new ArrayList<Keeper>();
        for (Keeper a : list) {
            if (a.getName().matches(name)) {
                listSearch.add(a);
            }
        }
        return listSearch;
    }

    /**
     * This Method search for keepers according to Qualifications
     *
     * @param list of keepers
     * @param wordToSearch which is a String that contain the Qualification that
     * the keepers need to have
     *
     * @return returns a list of keepers that fulfill the Qualification
     */
    public ArrayList<Keeper> searchKeeperByQualifications(ArrayList<Keeper> list, String qualification) {
        ArrayList<Keeper> listSearch = new ArrayList<>();
        String qualificationName;
        int i = 0;
        boolean added = false;

        for (Keeper a : list) {

            while (added == false && i < a.getQualification().size()) {

                qualificationName = a.getQualification().get(i);

                if (qualificationName.matches(qualification)) {
                    listSearch.add(a);
                    added = true;
                }
                i++;

            }
            added = false;
            i = 0;
        }

        return listSearch;
    }

    /**
     * Method that search Animal by Keepers 
     * 
     * It takes the parameters: 
     * @param list
     * @param qualification
     * @return 
     */
    public ArrayList<Animal> searchAnimalByKeeper(ArrayList<Animal> list, ArrayList<String> qualification) {
        ArrayList<Animal> listSearch = new ArrayList<>();
        boolean added = false;
        int i = 0;
        int j = 0;

        for (Animal a : list) {

            while (added == false && i < qualification.size()) {

                String q = qualification.get(i);

                while (added == false && j < a.getClass().getInterfaces().length) {

                    if (q.matches(a.getClass().getInterfaces()[j].getSimpleName())) {
                        listSearch.add(a);
                        added = true;
                    }
                    j++;
                }
                i++;
                j = 0;
            }
            i = 0;
            added = false;
        }

        return listSearch;
    }

    /**
     * This Method search all the offspring in the list Animals
     *
     * @param list of animals
     *
     * @return returns a list that contains all the offsprings
     */
    public ArrayList<Animal> searchOffsprings(ArrayList<Animal> list) {
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getOffsprings().size(); j++) {
                //System.out.println(list.get(i));
                listSearch.add(list.get(i).getOffsprings().get(j));
            }
        }
        return listSearch;
    }

    /**
     * This Method search the offspring of a specific animal
     *
     * It takes the parameters:
     *
     * @param list list of animals
     * @param exhibitionNumb of the animal which offsprings are going to be
     * looked up
     *
     * @return returns the offspring of the animal which exhibitionNumber was
     * given as parameters
     */
    public ArrayList<Animal> searchOffsprings(ArrayList<Animal> list, int exhibitionNumb) {
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getExhibitionNumb() == exhibitionNumb) {
                for (int j = 0; j < list.get(i).getOffsprings().size(); j++) {
                    //System.out.println(list.get(i).getOffsprings().get(j));
                    listSearch.add(list.get(i).getOffsprings().get(j));
                }

            }
        }
        return listSearch;
    }

    /**
     * This Method search animals that are parents
     *
     * @param list a list of animals
     *
     * @return returns a list of animals that are parents (have one or more
     * offsprings)
     */
    public ArrayList<Animal> searchParents(ArrayList<Animal> list) {
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOffsprings().size() != 0) {
                //System.out.println(list.get(i));
                listSearch.add(list.get(i));
            }
        }
        return listSearch;
    }

    /**
     * This Method search for parents of a specific animal
     *
     * @param list a list of animals
     * @param exhibitionNumb id of the animal whose parent is going to be
     * searched
     *
     * @return returns the parent of the animal whose offspring was given as
     * parameters
     */
    public ArrayList<Animal> searchParents(ArrayList<Animal> list, int exhibitionNumb) {
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getOffsprings().size(); j++) {
                if (list.get(i).getOffsprings().get(j).getExhibitionNumb() == exhibitionNumb) {
                    //System.out.println(list.get(i));
                    listSearch.add(list.get(i));
                }
            }
        }
        return listSearch;
    }

    /**
     * This Method search for Keepers given a specific word
     *
     * It is a wild search method
     *
     * @param list of keepers
     * @param wordToSearch
     *
     * @return returns a list of keepers that fulfill the condition given in the
     * @param wordToSearch
     */
    public ArrayList<Keeper> whildSearchKeeper(ArrayList<Keeper> list, String wordToSearch) {
        String queryStr = "(?i:.*" + wordToSearch + ".*)";
        ArrayList<Keeper> listSearch = new ArrayList<Keeper>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().matches(queryStr)) {
                listSearch.add(list.get(i));
            }
        }
        return listSearch;
    }

    /**
     * This method search for keepers that look after animals of specific
     * species
     *
     * It takes the parameters:
     *
     * @param list of animals
     * @param wordToSearch specie to be looked up
     *
     * @return return a list of keepers that look after the specie was given as
     * parameters
     */
    public ArrayList<Keeper> SearchKeeperBySpecie(ArrayList<Keeper> list, String wordToSearch) {
        String queryStr = "(?i:.*" + wordToSearch + ".*)";
        ArrayList<Keeper> listSearch = new ArrayList<Keeper>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getkeeperAnimals().size(); j++) {
                if (list.get(i).getkeeperAnimals().get(j).getSpecie().matches(queryStr)) {
                    listSearch.add(list.get(i));
                }
            }
        }
        return listSearch;
    }

    /**
     * This Method search for keepers that look after a specific animal
     *
     * @param list of animals
     * @param id which is the id of the animal whose keeper we want to get
     *
     * @return returns a list whit the keepers that look after the specific
     * animal given as parameter
     */
    public ArrayList<Keeper> SearchKeeperByAnimalID(ArrayList<Keeper> list, int id) {
        ArrayList<Keeper> listSearch = new ArrayList<Keeper>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getkeeperAnimals().size(); j++) {
                if (list.get(i).getkeeperAnimals().get(j).getExhibitionNumb() == id) {
                    listSearch.add(list.get(i));
                }
            }
        }
        return listSearch;
    }

    /**
     * Method created for testing purposes 
     * 
     * @param listObjs 
     */
    public void printConsole(ArrayList<?> listObjs) {
        if (listObjs.size() > 0) {
            if (listObjs.get(0) instanceof Animal) {
                ArrayList<Animal> list = (ArrayList<Animal>) listObjs;
                for (int i = 0; i < list.size(); i++) {
                    //System.out.println(list.get(i));
                }
            } else {
                if (listObjs.get(0) instanceof Keeper) {
                    ArrayList<Keeper> list = (ArrayList<Keeper>) listObjs;
                    for (int i = 0; i < list.size(); i++) {
                        //System.out.println(list.get(i));
                    }
                }
            }
        }
    }

    /**
     * This Method is the base for returning information to the interface 
     * 
     * It takes as parameters: 
     * 
     * @param listaObjs which can be of any type 
     * @param instanceNames the instances that are going to be return 
     * @param columnsNames the columns that are going to be return 
     * 
     * @return return a multidirectional array that contains a table with the information needed  
     */
    public String[][] dataToString(ArrayList<?> listaObjs, String[] instanceNames, String[] columnsNames) {
        if (listaObjs.size() > 0) {

            if (listaObjs.get(0) instanceof Animal) {
                ArrayList<Animal> lista = (ArrayList<Animal>) listaObjs;

                int m = lista.size();

                int zz = columnsNames.length;
                String[][] stockArr = new String[m][zz];
                for (int i = 0; i < m; i++) {
                    int nn = lista.get(i).toArrayList().size();
                    int j = 0, s = 0;
                    while (s < zz && j < nn) {
                        if (lista.get(i).nameVariables().contains(instanceNames[s])) {
                            j++;
                            if (lista.get(i).nameVariables().get(j - 1) == instanceNames[s]) {
                                stockArr[i][s] = lista.get(i).toArrayList().get(j - 1);
                                s++;
                                j = 0;
                            }

                        } else {
                            stockArr[i][s] = "";
                            s++;
                        }
                    }
                }
                //toJFrame(stockArr, columnsNames);

                return stockArr;

            } else {
                ArrayList<Keeper> lista = (ArrayList<Keeper>) listaObjs;

                int m = lista.size();
                int n = lista.get(0).toArrayList().size();
                for (int i = 0; i < lista.size(); i++) {
                    if (n < lista.get(i).toArrayList().size()) {
                        n = lista.get(i).toArrayList().size();
                    }
                }

                int zz = columnsNames.length;
                String[][] stockArr = new String[m][zz];
                for (int i = 0; i < m; i++) {
                    int nn = lista.get(i).toArrayList().size();
                    int j = 0, s = 0;
                    while (s < zz && j < nn) {
                        j++;
                        if (lista.get(i).nameVariables().get(j - 1) == instanceNames[s]) {
                            stockArr[i][s] = lista.get(i).toArrayList().get(j - 1);
                            s++;
                            j = 0;
                        }
                    }
                }
                //toJFrame(stockArr, columnsNames);

                return stockArr;
            }
        } else {
            String[][] stockArr = new String[0][0];

            //toJFrame(stockArr, columnsNames);
            return stockArr;
        }

    }

    public void toJFrame(String[][] stockArr, String[] columnsNames) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);

        JTable tabla = new JTable(stockArr, columnsNames);
        JScrollPane barrapanel = new JScrollPane(tabla);
        frame.add(barrapanel);

        frame.setVisible(true);
    }

}
