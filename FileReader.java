/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    
    /**
     * Mathode qui fait la conversion d'un Array a une String
     * 
     * @param PathToFile repertoire
     * @return String converti
     */
    public String StringFromFile(String PathToFile){
        String fileContent = "";

        try {
            fileContent = new String(Files.readAllBytes(Paths.get(PathToFile)));
            
            System.out.println(fileContent);
            //fileContent = fileContent.replaceAll("<.*?>|\u00a0", "]");
           // replaceAll("<.*?>|\u00a0", "");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "[" + fileContent + "]";
        //return fileContent ;

    }

}