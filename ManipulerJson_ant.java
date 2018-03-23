/*
 * Classe pour manipuler tous les fichiers Json
 * @author Andre Langoni
 * @version mars 2018
 */
package json;

import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import mesExceptions.LancerException;
import repertoireFichiers.GenererFichierTexte;

public class ManipulerJson_ant {

    private JSONArray fichiersJson = new JSONArray();
    private String jsonString = "";
    private double moyenneGroupe = 0.0;
    private ArrayList<String> listeEvaluation = new ArrayList<>();
    private String cheminDossier = "";
    private String unCours = "";
    private String fichierListeEtudiant = "";
    private String evaluation = "";
    // formater le nombre de decimal
    DecimalFormat df = new DecimalFormat("#.##");

    
    /**
     * Methode constructeur
     * @param evaluation
     * @param unCours
     * @param cheminDossier
     * @param fichierListeEtudiant
     * @throws LancerException 
     */
    public ManipulerJson_ant(String evaluation, String unCours,
            String cheminDossier, String fichierListeEtudiant) throws 
            LancerException {
        this.evaluation = evaluation;
        this.unCours = unCours;
        this.cheminDossier = cheminDossier;
        this.fichierListeEtudiant = fichierListeEtudiant + ".json";

        lireListeEtudiant();
    }
 
    
    /**
     * Methode cui va lire la liste d'etudiant e associer les codes permanents 
     * pour prendre les donnes de chaque etudiant
     *
     * @throws LancerException 
     */
     public void lireListeEtudiant() throws LancerException{

        System.out.println(new FileReader().StringFromFile(this.fichierListeEtudiant));
        // creation d'un object json avec le premier niveau des cles/valeur 
        /*
        JSONObject infoJsonNiveauUn = new JsonParser().JSONStringToJSONArray
        (new FileReader().StringFromFile(this.fichierListeEtudiant)).
                getJSONObject(0);
        
        JSONArray infoJsonNiveauDeux = new JSONArray(infoJsonNiveauUn.
                get("donnees").toString());

        for (int i = 0; i < infoJsonNiveauDeux.length(); i++) {
            
            /* creation d'un object avec le deuxieme niveau des cles/valeur 
             * qui correspondent a la cle donnees.
             */
   /*         JSONObject objectsNiveauDeux = infoJsonNiveauDeux.getJSONObject(i);

            lireEvaluations(moyenne(), String.valueOf(objectsNiveauDeux.get
                    ("code_permanent")),  String.valueOf(objectsNiveauDeux.get
                    ("nom")),  String.valueOf(objectsNiveauDeux.get("prenom")));
        }*/
    }
    
     
    /**
     * Methode qui va lire la les evaluations en fonction des parametres passes 
     * pour associer les etudiant aux notes 
     * 
     * @param moyenne moyenne du groupe
     * @param codePermanent
     * @param nom
     * @param prenom
     * @throws LancerException 
     */
    public void lireEvaluations(Double moyenne, String codePermanent, String nom,
            String prenom) throws LancerException {

        // creation d'un object json avec le premier niveau des cles/valeur 
        JSONObject infoJsonNiveauUn = new JsonParser().JSONStringToJSONArray(new 
        FileReader().StringFromFile(this.evaluation)).getJSONObject(0);
        JSONArray infoJsonNiveauDeux = new JSONArray(infoJsonNiveauUn.
                get("donnees").toString());

        for (int i = 0; i < infoJsonNiveauDeux.length(); i++) {
            
            /* creation d'un object avec le deuxieme niveau des cles/valeur 
             * qui correspondent a la cle donnees.
             */
            JSONObject objectsNiveauDeux = infoJsonNiveauDeux.getJSONObject(i);
            
            if (objectsNiveauDeux.get("code_permanent").equals(codePermanent)) {
               
                /* creation d'un object qui prend tous les informations pour 
                 * generer le fichier texte
                 */
                GenererFichierTexte fichierTexte = new GenererFichierTexte
                        (String.valueOf(infoJsonNiveauUn.get("commentaire")), 
                        cheminDossier, String.valueOf(infoJsonNiveauUn.get
                        ("nom_evaluation")),codePermanent, String.valueOf
                        (objectsNiveauDeux.get("note")), nom, prenom, unCours, 
                         moyenne);
            }
        }
    }

    /**
     * Methode qui retorne la moyenne du groupe 
     * 
     * @return double avec la moyenne dans le format ##,##
     */
    public double moyenne() {

        double notes = 0.0;
        int nbrEtudiants = 0;
        String jsonString = "";

            String nouvelleJsonString = new FileReader().StringFromFile(evaluation);
            jsonString = nouvelleJsonString;
            JSONArray nouveauFichiersJson = new JsonParser().JSONStringToJSONArray(jsonString);
            JSONArray fichiersJson = new JSONArray();
            fichiersJson = nouveauFichiersJson;
            JSONObject infoJsonNiveauUn = fichiersJson.getJSONObject(0);
            JSONArray infoJsonNiveauDeux = new JSONArray(infoJsonNiveauUn.get("donnees").toString());

            for (int i = 0; i < infoJsonNiveauDeux.length(); i++) {
                
                /* creation d'un object avec le deuxieme niveau des cles/valeur 
                 * qui correspondent a la cle donnees.
                 */
                JSONObject objectsNiveauDeux = infoJsonNiveauDeux.getJSONObject(i);

                notes += Double.parseDouble(String.valueOf(objectsNiveauDeux.get("note")));
                nbrEtudiants++;
            }
        
        return notes / nbrEtudiants;
    }
}