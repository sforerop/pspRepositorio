/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class calculadorReales {

    /**
     * Linked list que guardara los datos (enteros) ingresados.
     */
    private static LinkedList<Double> listaDatos;

    public static void main(String[] args) {
        double media = 0;
        double desviacion = 0;
        System.err.println("///////////////////////////////////////");
        System.err.println("DATOS INGRESADOS PARA PRUEBA 1");
        listaDatos = llenarListaDatos("C:\\NetBeanProyect\\mi-primera-app\\src\\main\\resources\\datos.txt");
        media = calcularMedia(listaDatos);
        desviacion = desviacionEstandar(listaDatos, media);
        System.err.println("///////////////////////////////////////");
    }

    /**
     *
     * @param ruta: ruta donde se encuentra el archivo.
     * @return retorna la lista de Integer.
     */
    public static LinkedList<Double> llenarListaDatos(String ruta) {
        LinkedList<Double> listaRecuperada = new LinkedList<Double>();
        try {
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String numero;
            while ((numero = br.readLine()) != null) {
                listaRecuperada.add(Double.parseDouble(numero));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(calculadorReales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(calculadorReales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRecuperada;
    }

    /**
     * Este metodo se encarga de calcular la media de una lista de enteros
     * @param datos: lista que contiene todos los enteros ingresados.
     * @return media: retorna la media de los datos ingresados.
     */
    public static double calcularMedia(LinkedList<Double> datos) {
        double media = 0;
        double sumatoria = 0;
        for (Double dato : datos) {
            sumatoria += dato;
            System.err.println(datos.indexOf(dato) + " - " + dato);
        }
        media = sumatoria / datos.size();
        System.err.println("LA MEDIA ES: " + media);
        return media;
    }
    
    /**
     * Este metodo se encarga de calcular la desviacion estandar de una lista de enteros
     * @param datos: lista de enteros
     * @param media: media de los datos
     * @return retorna la desviacion estandar
     */
    public static double desviacionEstandar(LinkedList<Double> datos, double media) {
        double desviacion = 0;
        double sumatoria = 0;
        for (Double dato : datos) {
            sumatoria += Math.pow((dato-media), 2);
        }
        desviacion = (sumatoria / (datos.size()-1));
        desviacion = Math.sqrt(desviacion);
        System.err.println("LA DESVIACION ES: " + desviacion);
        return desviacion;
    }
}
