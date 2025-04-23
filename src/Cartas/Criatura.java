package Cartas;

import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import java.awt.Image;

//import java.lang.reflect.Constructor;

public abstract class Criatura extends Carta{

    protected int poder;
    protected int resistencia;
    protected int custoManaHabilidade;
    protected String nome;
    private String descricao;
    private boolean vivo;
    private Image imagem;
    private boolean habilidadeNoCampo;
    
    public Criatura(int poder, int mana,int custoManaHabilidade, int resistencia, String nome, String descricao, Image imagem) {
    
    super(poder, mana, resistencia, nome, descricao, imagem);
    this.custoManaHabilidade = custoManaHabilidade;
    this.vivo = true;
    }
    
    //Métodos específicos da classe
    
    public void ataque(Criatura defensor, int danoVida) {
    if(getPoder() > defensor.getResistencia()) {
    System.out.println(getNome() + " destruiu " + defensor.getNome());
    danoVida = danoVida - (getPoder() - defensor.getResistencia());
    defensor.setVivo(false);
    }
    else {
    System.out.println(getNome() + " não destruiu " + defensor.getNome());
    }
    }
    
    public void mostrarCriatura() {
    System.out.println("Nome: " + getNome());
    System.out.println("Descrição: " + getDescricao());
    System.out.println("Poder: " + getPoder());
    System.out.println("resistencia: "+ getResistencia());
    }
    
    public int danoRecebido(Criatura defensora) {
    return this.poder - defensora.resistencia;
}
    
    public void receberFeitico(int quantidade) {
    
    this.resistencia -= quantidade;
    }
    
    public void receberCura(int quantidade) {
    
    this.resistencia += quantidade;
    }
    
    public abstract void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate);

    public int getCustoManaHabilidade(){
        return custoManaHabilidade;
    }
    
    public boolean getHabilidadeNoCampo(){
        return habilidadeNoCampo;
    }

    public void setHabilidadeNoCampo(boolean habilidadeNoCampo){
        this.habilidadeNoCampo = habilidadeNoCampo;
    }
 
}