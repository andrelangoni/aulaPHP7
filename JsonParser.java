/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import mesExceptions.LancerException;
import org.json.JSONArray;


public class JsonParser {

    /**
     * Methode qui lance une exception une fois qu'elle est appellee
     * @param get
     * @return rien a retouner
     * @throws LancerException 
     */
    public static String StringFromFile(String get) throws LancerException {
        throw new LancerException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Methode qui fait la conversion de String a Array
     * @param jsonString String a etre traitee
     * @return appel de la classe JSONArray avec qui traite le parametre passe
     */
    public JSONArray JSONStringToJSONArray(String jsonString){
        
       // System.out.println(jsonString);
        return new JSONArray(jsonString);

    }

}
