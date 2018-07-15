package Weekopdrachten;

import java.util.Scanner;
import java.util.Random;

public class Zeeslag {

	public static void main(String[] args) {
		
		int[][] zee = new int[6][6]; //hiermee een tweedimensionaal veld van zee maken
		int[][] schepen = new int[2][2]; //twee schepen plaatsen, je kunt meerdere schepen plaatsen door een ander getal in het eerste paar haakjes te plaatsen, bijv. 3 schepen: [3][2]
		int[] bom = new int[2]; // bom plaatsen, keuze uit een plek in x-as en y-as
		int boem = 0; //als het spel begint begint deze loop (zie regel 22 en 24)
		
		spelBeginnen(); 
		zeeMaken(zee);
		schepenPlaatsen(schepen);
	
		do { //nadat het spel is begonnen, kunnen onderstaande methodes worden aangeroepen
			afvuren(bom);
			zeeMaken(zee);
			if(raak(bom,schepen)) {boem++;} //als een schip is geraakt gaat "boem" met 1 omhoog.
	
			}while(boem!=2); //als er 2 schepen zijn geraakt is het spel afgelopen
	
			System.out.println("\nVICTORY IS YOURS!" + "\nJe hebt beide schepen vernietigd en daarmee het gevecht op de zee gewonnen."); 
			System.out.println("\nWil je een gevecht aan met een andere vijand? Druk dan op Ctrl + F11");
	}
		
		public static void spelBeginnen() {
			System.out.println("Welkom bij het spel Zeeslag.\n" + "Er varen 2 vijandelijke schepen op de zee.\n" + 
		    "Jouw taak als kapitein-luitenant is om deze twee schepen zo snel mogelijk te laten bombarderen.");
		}  
	    
	    public static void zeeMaken(int[][] zee){
	    	for(int x = 0; x < 6; x++) 
	        for(int y = 0; y < 6; y++)
	        zee[x][y] = 36;  //dit mag elk getal zijn, zolang het maar een integer is. Zie regel 42
	    		System.out.println();
	    	for(int x = 0; x < 6; x++) {
	        for(int y = 0; y < 6; y++) {
	        if(zee[x][y] == 36){ // een integer die ik zelf heb gekozen (zie regel 38)
	        	System.out.print(" ~~ "); // ook hierbij zelf een keuze uit hoe je de zee wilt weergeven, kan bijvoorbeeld ook door "-", of "_", etc.
	               }
	        }
	       	System.out.println(); // Op deze rij uitprinten, anders krijg je een eendimensionaal veld ipv tweedimensioneel
	    	}   	
	    } 	
	
	    public static void schepenPlaatsen(int[][] schepen){ //2 paar haakjes, omdat het een tweedimensionaal veld bevat
	    	Random random = new Random();
	    	for(int schip = 0; schip < 2; schip++){ //één schip bevat ovat slechts in 'blok' in de zee. Je kan een schip ook groter maken natuurlijk
	    	schepen[schip][0] = random.nextInt(6);  //selecteert random een locatie in de zee (getal tussen 1 en 6, omdat het een zee is van 6 bij 6
	    	schepen[schip][1] = random.nextInt(6);  //zie vorige regel (53)
	    	
        }
    }
	
	public static void afvuren(int[] bom){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Kies een rang uit 1 t/m 6 van de X-as: "); //speler kan een rij kiezen (horizontale as)
        bom[0] = sc.nextInt(); //
        if(bom[0] >= 7 || bom[0] < 0) { //speler mag alleen een getal kiezen tussen 1 en 6, immers is het veld niet groter dan 6 bij 6
        	System.out.println("Je kan alleen nummer 1 t/m 6 invoeren."); 	
        }
        System.out.println("\nKies een rang uit 1 t/m 6 van de Y-as: "); //speler kan een kolom kiezen (verticale as)
        bom[1] = sc.nextInt();
        if(bom[1] >= 7 || bom[1] < 0) { //zie regel 64
        	System.out.println("Je kan alleen nummer 1 t/m 6 invoeren.");
       	
        }
	}
	 public static boolean raak(int[] bom, int[][] schepen){ //twee integers, omdat bom en schepen met elkaar samenhangen (bom moet schip raken)
	        
	        for(int schip = 0; schip < schepen.length; schip++){
	            if(bom[0] == schepen[schip][0] && bom[1] == schepen[schip][1]){ //hiermee aangeven dat als de locatie die de speler heeft gekozen, goed is, wordt uitgeprint dat de speler een schip heeft geraakt
	            System.out.printf("Goed gecöordineerd! Je hebt een schip geraakt en laten zinken! \n", bom[0]+1,bom[1]+1);
	            return true;
	            }else
	            	System.out.printf("Aii.. je cöordinatie klopte niet. Vuur de bom opnieuw af. \n");
	        	}
	        	return false;
	}
	
}