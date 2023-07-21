package lab1p2_jesusrodriguez;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JColorChooser;

public class Lab1P2_JesusRodriguez {

    static Scanner leer = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {
        int res = 0;

        do {
            System.out.println("\"----- Bienvenido al menu -----\"\n"
                    + " 1 -> Newton Raphson \n"
                    + "2-> Serie Taylor (Seno, coseno, tanjente)\n"
                    + "0-> Salir\"\n"
                    + "Ingrese la opcion que desea: ");
            res = leer.nextInt();

            switch (res) {

                case 1: {
                    int a = 0;
                    int b = 0;
                    int c = 0;
                    System.out.println("Ingrese A: ");
                    a = leer.nextInt();
                    System.out.println("Ingrese B: ");
                    b = leer.nextInt();
                    System.out.println("Ingrese C: ");
                    c = leer.nextInt();
                    while (a == 0 || b == 0 || c == 0) {
                        System.out.println("No se puede hacer ");
                        break;
                    }
                    double vx =(-b / (2 * a));
                    double izq = vx - 200;
                    double der = vx + 200;
                    int cont = 0;

                    double resizq = izquierdo(a,b,c,cont, izq);
                    double resder= derecho(a,b,c,cont,der);
                    
                    
                    System.out.println("Izquierda: "+resizq);
                    System.out.println("Derecha: "+resder);

                }
                break;

                case 2: {
                    int Hola = 0;
                    System.out.println("Ingrese El numero que quiere evauluar: ");
                    Hola = leer.nextInt();
                    System.out.println("Ingrese el limite que desea parar: ");
                    int lim = leer.nextInt();
                    int cont1 = 0;
                    int cont2 = 0;
                    int cont3 = 1;
                    double res1 = 0;
                    double res2 = 0;
                    double res3 = 0;
                    double sin = sen(Hola, lim, cont1, res1);
                    double cos = cose(Hola, lim, cont2, res2);
                    double tan = tang(Hola, lim, cont3, res3);
                    System.out.println("Seno: " + sin);
                    System.out.println("Coseno: " + cos);
                    System.out.println("Tangente: " + tan);
                }
                break;

                case 0: {
                    System.out.println("Adios");
                }
                break;

                default: {
                    System.out.println("No disponible");
                }
                break;
            }
        } while (res != 0);
    }

    public static double sen(int numero, int lim, int cont, double res1) {

        //System.out.println("COUNTER: " + cont);
        if (cont == lim) {
            return res1;
        } else {
            double eq1 = Math.pow(-1, cont);
            double eq2 = ((2 * cont) + 1);
            double eq3 = fact(eq2);
            double eq4 = eq1 / eq3;
            double eq5 = ((2 * cont) + 1);
            double eq6 = Math.pow(numero, eq5);
            double eq7 = eq4 * eq6;
            res1 = res1 + eq7;
            // System.out.println(" respuesta "+res1);
            cont++;
            return sen(numero, lim, cont, res1);

        }

    }

    public static double fact(double eq2) {
        if (eq2 == 0 || eq2 == 1) {
            return 1;
        } else {
            return eq2 * fact(eq2 - 1);
        }
    }

    public static double cose(int numero, int lim, int cont, double res2) {

        if (cont == lim) {
            return res2;
        } else {
            double eq1 = Math.pow(-1, cont);
            double eq2 = (2 * cont);
            double eq3 = fact(eq2);
            double eq4 = eq1 / eq3;
            double eq5 = 2 * cont;
            double eq6 = Math.pow(numero, eq5);
            double eq7 = eq4 * eq6;
            res2 = res2 + eq7;
            cont++;

            return cose(numero, lim, cont, res2);
        }

    }

    public static double tang(int numero, int lim, int cont, double res3) {
        double mayor = (3.1416 / 2);
        if (cont == lim) {
            if (res3 < mayor) {
                res3 = 0;
                return res3;

            } else {
                return res3;
            }
        } else {
            double eq1 = Math.pow(2, cont);
            double eq2 = Math.pow(-4, cont);
            double eq3 = 1 - eq2;
            double eq4 = eq1 * eq2 * eq3;
            double eq5 = 2 * cont;
            double eq6 = fact(eq5);
            double eq7 = eq4 / eq6;
            double eq8 = (2 * cont) - 1;
            double eq9 = Math.pow(numero, eq8);
            double eq10 = eq7 * eq9;
            res3 = res3 + eq10;
            cont++;

            return tang(numero, lim, cont, res3);
        }

    }

    public static double izquierdo(int a, int b, int c, int cont, double r) {
        if (cont == 100) {
            return r;
        }else{
            
            double eq2= ((a*(r*r))+(b*r)+(c));
            double eq3= ((2*(a*r))+b);
            double div= eq2/eq3;
            r-=div;
            return izquierdo(a,b,c,cont+1,r);
            
        }
    }

    
     public static double derecho(int a, int b, int c, int cont, double r) {
        if (cont == 100) {
            return r;
        }else{
    
            double eq2= ((a*(r*r))+(b*r)+(c));
            double eq3= (2*(a*r)+b);
            double div= eq2/eq3;
            r-=div;
            return derecho(a,b,c,cont+1,r);
            
        }
    }

}
