package MecanicasJogo;

import CriaturasDeck1.Quimera;
import CriaturasDeck1.Basilisco;
import CriaturasDeck1.Sereia;
import CriaturasDeck1.Cerbero;
import CriaturasDeck1.Hidra;
import CriaturasDeck1.Grifo;
import CriaturasDeck1.Ciclope;
import CriaturasDeck1.Minotauro;
import java.util.ArrayList;
import Cartas.*;
import CriaturasDeck2.*;
import Encantamentos.*;
import Feiticos.*;
import GUI.TelaCombateGUI;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Deck {

        private TelaCombateGUI telaCombate;
	private ArrayList<Carta> deck1;
	private ArrayList<Carta> deck2;
	private int numCartasDeck;
	
//        private final Image cerbero = new ImageIcon("src\\ImagensCartas\\cartaCerbero.png").getImage();
//        private final Image minotauro = new ImageIcon("src\\ImagensCartas\\cartaMinotauro.png").getImage();
//        private final Image grifo = new ImageIcon("src\\ImagensCartas\\cartaGrifo.png").getImage();
//        private final Image hidra = new ImageIcon("src\\ImagensCartas\\cartaHidra.png").getImage();
//        private final Image bolaDeFogo = new ImageIcon("src\\ImagensCartas\\cartaBolaDeFogo.png").getImage();
//        private final Image cura = new ImageIcon("src\\ImagensCartas\\cartaCurar.png").getImage();
        
	public Deck() {
            deck1 = new ArrayList<>();  
            deck2 = new ArrayList<>();  
        

            setDeck1(deck1);
            setDeck2(deck2);
        }
	
	public ArrayList<Carta> getDeck1() {
		return deck1;
	}
	public void setDeck1(ArrayList<Carta> deck1) {
		Carta carta1 = new Cerbero();
		Carta carta2 = new Cerbero();
		Carta carta3 = new Grifo();
		Carta carta4 = new Grifo();
		Carta carta5 = new Hidra();
		Carta carta6 = new Hidra();
		Carta carta7 = new Minotauro();
		Carta carta8 = new Minotauro();
                Carta carta9 = new Basilisco();
		Carta carta10 = new Basilisco();
                Carta carta11 = new Ciclope();
		Carta carta12 = new Ciclope();
                Carta carta13 = new Quimera();
		Carta carta14 = new Quimera();
                Carta carta15 = new Sereia();
		Carta carta16 = new Sereia();
                Carta carta17 = new ExplosaoArcana();
                Carta carta18 = new ExplosaoArcana();
                Carta carta19 = new ExplosaoArcana();
		
		deck1.add(carta1);
		deck1.add(carta2);
		deck1.add(carta3);
		deck1.add(carta4);
		deck1.add(carta5);
		deck1.add(carta6);
		deck1.add(carta7);
		deck1.add(carta8);
		deck1.add(carta9);
		deck1.add(carta10);
		deck1.add(carta11);
		deck1.add(carta12);
		deck1.add(carta13);
		deck1.add(carta14);
                deck1.add(carta15);
                deck1.add(carta16);
                deck1.add(carta17);
                deck1.add(carta18);
                deck1.add(carta19);
                
		
	}
	public ArrayList<Carta> getDeck2() {
		return deck2;
	}
	public void setDeck2(ArrayList<Carta> deck2) {
		Carta carta1 = new Boitata();
		Carta carta2 = new Boitata();
		Carta carta3 = new Caipora();
		Carta carta4 = new Caipora();
		Carta carta5 = new Cuca();
		Carta carta6 = new Cuca();
		Carta carta7 = new Lobisomem();
		Carta carta8 = new Lobisomem();
		Carta carta9 = new CorpoSeco();
		Carta carta10 = new CorpoSeco();
		Carta carta11 = new MulaSemCabeca();
		Carta carta12 = new MulaSemCabeca();
		Carta carta13 = new Saci();
		Carta carta14 = new Saci();
                Carta carta15 = new OncaPintada();
		Carta carta16 = new OncaPintada();
                Carta carta17 = new ExplosaoArcana();
                Carta carta18 = new ExplosaoArcana();
                Carta carta19 = new ExplosaoArcana();
		
		deck2.add(carta1);
		deck2.add(carta2);
		deck2.add(carta3);
		deck2.add(carta4);
		deck2.add(carta5);
		deck2.add(carta6);
		deck2.add(carta7);
		deck2.add(carta8);
                deck2.add(carta9);
		deck2.add(carta10);
		deck2.add(carta11);
		deck2.add(carta12);
		deck2.add(carta13);
		deck2.add(carta14);
                deck2.add(carta15);
                deck2.add(carta16);
                deck1.add(carta17);
                deck1.add(carta18);
                deck1.add(carta19);
	}

	public int getNumCartasDeck1() {
		return deck1.size();
	}

	public int getNumCartasDeck2() {
		return deck2.size();
	}
	
	
}
