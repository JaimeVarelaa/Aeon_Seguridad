/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cifrado;

import Logica.main;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author jaime
 */
public class Cat {
    public static void cat(){
        try{
            FileWriter fw = new FileWriter(main.datos.getArchivo(), true);
            fw.write(main.datos.getMssgEncrypt());
            fw.close();
            System.out.println("cat nais");
        } catch(Exception ex){
            
        }
    }
}
