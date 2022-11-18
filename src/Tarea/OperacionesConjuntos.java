/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JUANK y Solo Cabrerita
 */
public class OperacionesConjuntos {
    
    public static boolean existe(int[] conjunto, int elemento){
        Boolean existe = false;
        for(int i = 0; i< conjunto.length; i++){
            if(conjunto[i] == elemento){
                existe = true;
            }
        }
        return existe;
    }
    
    public static int[] union(int[]a, int[]b){
        int[] u = new int[(a.length+b.length)];
        for(int i  = 0; i < a.length; i++){
            u[i] = a[i];
        }
        
        int x  = 0;
        int y = 0;
        
        for(int i = 0; i< b.length;i ++){
            if(existe(u,b[i])== false){
                u[a.length+x] = b[i];
                x++;
            }else{
                y++;
            }
        }
        
        int [] aux = u;
        u = new int[aux.length-y];
        
        for(int i = 0; i<u.length;i++){
            u[i]= aux[i];
        }
        return u;
    }
    
    public static int[] interseccion(int[]a, int[]b){
        int c = 0;
        
        for (int i = 0; i < a.length; i++) {
            if(existe(b,a[i])){
                c++;
            }
        }
        
        int[]I = new int [c];
        int x  = 0;
        
        for (int i = 0; i < a.length; i++) {
            if(existe(b,a[i])){
                I[x] = a[i];
                x++;
            }
        }
        return I;
    }
    
    public static ArrayList<Integer> diferencia(int[] a, int[]b){

        ArrayList<Integer> aux = new ArrayList<Integer>();

        for(int i=0; i<a.length; i++){
            aux.add(a[i]);
        }

        for(int i=0; i<aux.size(); i++){
            for(int j=0; j<b.length; j++){
                if(aux.get(i)==b[j]){
                    aux.remove(i);
                }
            }
        }

        return aux; 
    }
    
    public static void main(String[] args) {
        Scanner tek = new Scanner(System.in);
        System.out.println("Ingrese el numero de elementos de a");
        int ta = tek.nextInt();
        System.out.println("Ingrese el numero de elementos de b");
        int tb = tek.nextInt();
        
        int[] a = new  int [ta];
        int[] b = new  int [tb];
        
        System.out.println("datos de a");
        for(int i = 0; i< a.length; i++){
            a[i] = tek.nextInt();
        }
        
        System.out.println("datos de b");
        for(int i = 0; i< b.length; i++){
            b[i] = tek.nextInt();
        }
        
        int[]u = union(a, b);
        int[]I = interseccion(a, b);
        ArrayList<Integer> d1 = diferencia(a, b);
        ArrayList<Integer> d2 = diferencia(b, a); 
        
        System.out.println("Elementos de la union");
        for (int i = 0; i < u.length; i++) {
            System.out.println(u[i]);
        }

        System.out.println("Elementos de la interseccion");
        for (int i = 0; i < I.length; i++) {
            System.out.println(I[i]);
        }

        System.out.println("Elementos de A - B");
        for (int i = 0; i < d1.size(); i++) {
            System.out.println(d1.get(i));
        }

        System.out.println("Elementos de B -A");
        for (int i = 0; i < d2.size(); i++) {
            System.out.println(d2.get(i));
        }

    }
}
