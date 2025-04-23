package CriaturasDeck1;
import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Minotauro extends Criatura{

    public Minotauro() {
		
        super(6, 3, 2, 4, "Minotauro", "Ele vaga e acaba com qualquer um que pise no seu labirinto.", new ImageIcon("src\\ImagensCartas\\cartaMinotauro.png").getImage());
        this.setHabilidadeNoCampo(false);    
    }

    @Override
    public void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        int novoPoder = jogador1.getCarta().getPoder() + 2;
        jogador1.getCarta().setPoder(novoPoder);
        int novaResistencia = jogador1.getCarta().getResistencia() - 2;
        jogador1.getCarta().setResistencia(novaResistencia);
        
        JOptionPane.showMessageDialog(telaCombate,"Minotauro agora possui o poder de " + jogador1.getCarta().getPoder() + " e a resistência de " + jogador1.getCarta().getResistencia());

	jogador1.gastaMana(2);
    }
	
}
