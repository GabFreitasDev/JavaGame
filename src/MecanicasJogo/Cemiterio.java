package MecanicasJogo;

import java.util.ArrayList;
import Cartas.*;
import CriaturasDeck2.*;
import Encantamentos.*;
import Feiticos.*;

public class Cemiterio {

	private ArrayList<Carta> cemiterio1;
	private ArrayList<Carta> cemiterio2;
	
	public Cemiterio() {
		cemiterio1 = new ArrayList<>();  
		cemiterio2 = new ArrayList<>();
                
                setCemiterio1(cemiterio1);
                setCemiterio2(cemiterio2);
	}
	
	public ArrayList<Carta> getCemiterio1() {
		return cemiterio1;
	}

	public ArrayList<Carta> getCemiterio2() {
		return cemiterio2;
	}

        public void setCemiterio1(ArrayList<Carta> cemiterio1) {
		this.cemiterio1 = cemiterio1;
	}

	public void setCemiterio2(ArrayList<Carta> cemiterio2) {
		this.cemiterio2 = cemiterio2;
	}
        
	public int getNumCartasCemiterio1() {
		return cemiterio1.size();
	}
	
        public int getNumCartasCemiterio2() {
		return cemiterio2.size();
	}
	
}
