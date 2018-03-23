/*
 * Classe principale d'execution de l'application
 * @author Andre Langoni
 * @version mars 2018
 */
package tp1.tp1inf2015;

import javax.swing.JOptionPane;
import mesExceptions.*;
import repertoireFichiers.*;

public class TpInf2015 {
    
    public static final String MESSAGE_SUCCESS = "\n  Vos fichiers on été créés "
            + "avec success!  \n\n               Bonne Journée!  \n\n";
   
    public static void main(String[] args) throws LancerException {
        
    	new TraiterListeEtudiantsEvaluations();
        
        JOptionPane.showMessageDialog(null, MESSAGE_SUCCESS); 
    }
}
