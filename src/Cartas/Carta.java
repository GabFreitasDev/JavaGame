package Cartas;

import Erros.ManaInsuficienteException;
import MecanicasJogo.*;
import java.awt.Image;
public abstract class Carta{

protected int resistencia;
    protected int poder;
    protected int mana;
    protected boolean vivo;
    private String nome;
    private String descricao;
    private Image imagem;

    public Carta(int poder, int mana, int resistencia, String nome, String descricao, Image imagem) {

        this.poder = poder;
        this.resistencia = resistencia;
        this.mana = mana;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public int getPoder() {
        return poder;
    }
    
    public int getMana() {
        return mana;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getResistencia() {
        return resistencia;
    }
    
    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void setResistencia(int resistencia) {
        // TODO Auto-generated method stub
        this.resistencia = resistencia;
    }
    
    public void setPoder(int poder){
        this.poder = poder;
    }
    
    public Image getImagem(){
        return imagem;
    }
}