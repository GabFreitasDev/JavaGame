/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Cartas.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import MecanicasJogo.*;
import java.awt.GridLayout;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author gabri
 */
public class TelaCombateGUI extends javax.swing.JFrame {

    /**
     * Creates new form FormMainJF
     */
    private Random random = new Random();
    private Jogadores jogador1, jogador2;
    private JogoGUI jogo;
    private int randomNum;
    private Carta carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8, carta9, carta10;
    private Carta carta1Campo1, carta2Campo1, carta3Campo1, carta1Campo2, carta2Campo2, carta3Campo2;
    private Deck deck1, deck2;
    private Cemiterio cemiterio1, cemiterio2;
    private int turno = 1;

    public TelaCombateGUI(Jogadores jogador1, Jogadores jogador2) {
        this.jogo = new JogoGUI();
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deck1 = new Deck();
        this.deck2 = new Deck();
        this.cemiterio1 = new Cemiterio();
        this.cemiterio2 = new Cemiterio();
        initComponents();

        setMaos();
        setInfoJogadores(jogador1, deck1, cemiterio1, NomeJogador1, VidaJogador1, ManaJogador1, DeckJogador1, CemiterioJogador1);
        setInfoJogadores(jogador2, deck2, cemiterio2, NomeJogador2, VidaJogador2, ManaJogador2, DeckJogador2, CemiterioJogador2);
//        this.jpJogo.setLayout(new GridLayout(4,1));
//        this.jpJogo.add(this.jpMao1);
//        this.jpJogo.add(this.jpMao2);
//        this.jpMao1.setLayout(new GridLayout(1,5));
//        this.jpMao2.setLayout(new GridLayout(1,5));
//        this.jpCampo1.setLayout(new GridLayout(1,1));
//        this.jpCampo2.setLayout(new GridLayout(1,1));

        this.jpAcaoCampo1.setVisible(false);
        this.jpAcaoCampo2.setVisible(false);
    }

    private Carta getCartaSorteada(JButton btn, Deck deck, Jogadores jogador) {
        Carta cartaSlotMao;

        if (jogador == jogador1) {
            randomNum = random.nextInt(deck.getDeck1().size());
            cartaSlotMao = deck.getDeck1().get(randomNum);

            if (cartaSlotMao != null) {
                jogador.getMao().add(cartaSlotMao);
                deck.getDeck1().remove(cartaSlotMao);
            }

            btn.setIcon(new javax.swing.ImageIcon(cartaSlotMao.getImagem()));
            return cartaSlotMao;
        } else {
            randomNum = random.nextInt(deck.getDeck2().size());
            cartaSlotMao = deck.getDeck2().get(randomNum);

            if (cartaSlotMao != null) {
                jogador.getMao().add(cartaSlotMao);
                deck.getDeck2().remove(cartaSlotMao);
            }

            btn.setIcon(new javax.swing.ImageIcon(cartaSlotMao.getImagem()));
            return cartaSlotMao;
        }
    }

    private void setInfoJogadores(Jogadores jogador, Deck deckJ, Cemiterio cemiterioJ, JLabel nome, JLabel vida, JLabel mana, JLabel deck, JLabel cemiterio) {

        String vidaTxt = String.valueOf(jogador.getVidaJogador());
        String manaTxt = String.valueOf(jogador.getManaJogador());
        String nivelTxt = String.valueOf(jogador.getNivelJogador());

        if (jogador == jogador1) {
            String deckTxt = String.valueOf(deckJ.getNumCartasDeck1());
            deck.setText("Deck: " + deckTxt);
            String cemiterioTxt = String.valueOf(cemiterioJ.getNumCartasCemiterio1());
            cemiterio.setText("Cemiterio: " + cemiterioTxt);
        } else if (jogador == jogador2) {
            String deckTxt = String.valueOf(deckJ.getNumCartasDeck2());
            deck.setText("Deck: " + deckTxt);
            String cemiterioTxt = String.valueOf(cemiterioJ.getNumCartasCemiterio2());
            cemiterio.setText("Cemiterio: " + cemiterioTxt);
        }

        nome.setText(jogador.getNomeJogador() + " Nível: " + nivelTxt);
        vida.setText("Vida: " + vidaTxt);
        mana.setText("Mana: " + manaTxt);

    }

    public void setMaos() {
        //Mao1
        this.carta1 = this.getCartaSorteada(this.btn1CartaMao1, deck1, jogador1);
        this.carta2 = this.getCartaSorteada(this.btn2CartaMao1, deck1, jogador1);
        this.carta3 = this.getCartaSorteada(this.btn3CartaMao1, deck1, jogador1);
        this.carta4 = this.getCartaSorteada(this.btn4CartaMao1, deck1, jogador1);
        this.carta5 = this.getCartaSorteada(this.btn5CartaMao1, deck1, jogador1);

        //Mao2
        this.carta6 = this.getCartaSorteada(this.btn1CartaMao2, deck2, jogador2);
        this.carta7 = this.getCartaSorteada(this.btn2CartaMao2, deck2, jogador2);
        this.carta8 = this.getCartaSorteada(this.btn3CartaMao2, deck2, jogador2);
        this.carta9 = this.getCartaSorteada(this.btn4CartaMao2, deck2, jogador2);
        this.carta10 = this.getCartaSorteada(this.btn5CartaMao2, deck2, jogador2);
    }

    public void desabilitaMao(JButton carta1, JButton carta2, JButton carta3, JButton carta4, JButton carta5, JButton carta6, JButton carta7, JButton carta8) {
        carta1.setEnabled(false);
        carta2.setEnabled(false);
        carta3.setEnabled(false);
        carta4.setEnabled(false);
        carta5.setEnabled(false);
        carta6.setEnabled(false);
        carta7.setEnabled(false);
        carta8.setEnabled(false);
    }

    public void habilitaMao(JButton carta1, JButton carta2, JButton carta3, JButton carta4, JButton carta5, JButton carta6, JButton carta7, JButton carta8) {
        carta1.setEnabled(true);
        carta2.setEnabled(true);
        carta3.setEnabled(true);
        carta4.setEnabled(true);
        carta5.setEnabled(true);
        carta6.setEnabled(true);
        carta7.setEnabled(true);
        carta8.setEnabled(true);
    }

    public void confereAdicionaCartaMao(Jogadores jogador, Carta carta1J, Carta carta2J, Carta carta3J, Carta carta4J, Carta carta5J) {
        if (carta1J == null) {
            if (jogador == jogador1) {
                carta1J = this.getCartaSorteada(this.btn1CartaMao1, deck1, jogador1);
                carta1 = carta1J;
            } else if (jogador == jogador2) {
                carta1J = this.getCartaSorteada(this.btn1CartaMao2, deck2, jogador2);
                carta6 = carta1J;
            }
        }
        if (carta2J == null) {
            if (jogador == jogador1) {
                carta2J = this.getCartaSorteada(this.btn2CartaMao1, deck1, jogador1);
                carta2 = carta2J;
            } else if (jogador == jogador2) {
                carta2J = this.getCartaSorteada(this.btn2CartaMao2, deck2, jogador2);
                carta7 = carta2J;
            }
        }
        if (carta3J == null) {
            if (jogador == jogador1) {
                carta3J = this.getCartaSorteada(this.btn3CartaMao1, deck1, jogador1);
                carta3 = carta3J;
            } else if (jogador == jogador2) {
                carta3J = this.getCartaSorteada(this.btn3CartaMao2, deck2, jogador2);
                carta8 = carta3J;
            }
        }
        if (carta4J == null) {
            if (jogador == jogador1) {
                carta4J = this.getCartaSorteada(this.btn4CartaMao1, deck1, jogador1);
                carta4 = carta4J;
            } else if (jogador == jogador2) {
                carta4J = this.getCartaSorteada(this.btn4CartaMao2, deck2, jogador2);
                carta9 = carta4J;
            }
        }
        if (carta5J == null) {
            if (jogador == jogador1) {
                carta5J = this.getCartaSorteada(this.btn5CartaMao1, deck1, jogador1);
                carta5 = carta5J;
            } else if (jogador == jogador2) {
                carta5J = this.getCartaSorteada(this.btn5CartaMao2, deck2, jogador2);
                carta10 = carta5J;
            }
        }
    }

    public void confereAdicionaCartaCampo(Jogadores jogador, Carta carta) {
        if (jogador == jogador1) {
            if (carta1Campo1 == null) {
                if (carta instanceof Criatura) {
                    carta1Campo1 = carta;
                    btn1CampoDeBatalha1.setIcon(new javax.swing.ImageIcon(carta1Campo1.getImagem()));
                    jogador.setCarta(carta1Campo1);

                    jogador.getCampoDeBatalha().add(carta1Campo1);
                    jogador.getMao().remove(carta);
                } else if (carta instanceof Feitico) {
                    this.jogador1.setCarta(carta);
                    this.cartaDaMaoFeitico(jogador1, jogador2);
                }
            } else if (carta2Campo1 == null) {
                if (carta instanceof Criatura) {
                    carta2Campo1 = carta;
                    btn2CampoDeBatalha1.setIcon(new javax.swing.ImageIcon(carta2Campo1.getImagem()));
                    jogador.setCarta(carta2Campo1);

                    jogador.getCampoDeBatalha().add(carta2Campo1);
                    jogador.getMao().remove(carta);
                } else if (carta instanceof Feitico) {
                    this.jogador1.setCarta(carta);
                    this.cartaDaMaoFeitico(jogador1, jogador2);
                }
            } else if (carta3Campo1 == null) {
                if (carta instanceof Criatura) {
                    carta3Campo1 = carta;
                    btn3CampoDeBatalha1.setIcon(new javax.swing.ImageIcon(carta3Campo1.getImagem()));
                    jogador.setCarta(carta3Campo1);

                    jogador.getCampoDeBatalha().add(carta3Campo1);
                    jogador.getMao().remove(carta);
                } else if (carta instanceof Feitico) {
                    this.jogador1.setCarta(carta);
                    this.cartaDaMaoFeitico(jogador1, jogador2);
                }

            } else {
                JOptionPane.showMessageDialog(this, this.jogador1.getNomeJogador() + " seu campo de batalha já está cheio!");
            }
        } else {
            if (carta1Campo2 == null) {
                if (carta instanceof Criatura) {
                    carta1Campo2 = carta;
                    btn1CampoDeBatalha2.setIcon(new javax.swing.ImageIcon(carta1Campo2.getImagem()));
                    jogador.setCarta(carta1Campo2);

                    jogador.getCampoDeBatalha().add(carta1Campo2);
                    jogador.getMao().remove(carta);
                } else if (carta instanceof Feitico) {
                    this.jogador2.setCarta(carta);
                    this.cartaDaMaoFeitico(jogador2, jogador1);
                }
            } else if (carta2Campo2 == null) {
                if (carta instanceof Criatura) {
                    carta2Campo2 = carta;
                    btn2CampoDeBatalha2.setIcon(new javax.swing.ImageIcon(carta2Campo2.getImagem()));
                    jogador.setCarta(carta2Campo2);

                    jogador.getCampoDeBatalha().add(carta2Campo2);
                    jogador.getMao().remove(carta);
                } else if (carta instanceof Feitico) {
                    this.jogador2.setCarta(carta);
                    this.cartaDaMaoFeitico(jogador2, jogador1);
                }
            } else if (carta3Campo2 == null) {
                if (carta instanceof Criatura) {
                    carta3Campo2 = carta;
                    btn3CampoDeBatalha2.setIcon(new javax.swing.ImageIcon(carta3Campo2.getImagem()));
                    jogador.setCarta(carta3Campo2);

                    jogador.getCampoDeBatalha().add(carta3Campo2);
                    jogador.getMao().remove(carta);
                } else if (carta instanceof Feitico) {
                    this.jogador2.setCarta(carta);
                    this.cartaDaMaoFeitico(jogador2, jogador1);
                }
            } else {
                JOptionPane.showMessageDialog(this, this.jogador2.getNomeJogador() + " seu campo de batalha já está cheio!");
            }
        }
    }

    public void destroiCartaCampo(Jogadores jogador) {
        if (jogador == jogador1) {
            if (jogador.getCarta() == carta1Campo1) {
                btn1CampoDeBatalha1.setIcon(null);
                carta1Campo1 = null;
            } else if (jogador.getCarta() == carta2Campo1) {
                btn2CampoDeBatalha1.setIcon(null);
                carta2Campo1 = null;
            } else {
                btn3CampoDeBatalha1.setIcon(null);
                carta3Campo1 = null;
            }
        } else {
            if (jogador.getCarta() == carta1Campo2) {
                btn1CampoDeBatalha2.setIcon(null);
                carta1Campo2 = null;
            } else if (jogador.getCarta() == carta2Campo2) {
                btn2CampoDeBatalha2.setIcon(null);
                carta2Campo2 = null;
            } else {
                btn3CampoDeBatalha2.setIcon(null);
                carta3Campo2 = null;
            }
        }
    }

    public void cartaDaMaoFeitico(Jogadores usuario, Jogadores oponente) {

        Feitico feitico = (Feitico) usuario.getCarta();

        if (usuario == jogador1) {
            cemiterio1.getCemiterio1().add(jogador1.getCarta());
        } else if (usuario == jogador2) {
            cemiterio2.getCemiterio2().add(jogador2.getCarta());
        }

        if (feitico.getParaAtaque() == true) {
            TelaEscolhaDuelo tela4 = new TelaEscolhaDuelo(oponente, jogo, this);
            tela4.setVisible(true);
            feitico.usarFeitico(usuario, oponente, this);

        } else {
            feitico.usarFeitico(usuario, oponente, this);
            JOptionPane.showMessageDialog(this, this.jogador1.getCarta().getNome() + " foi ativada!");
        }
    }

    public void getDialogoAleatrorio(Jogadores receptor) {
        randomNum = random.nextInt(4);

        switch (randomNum) {
            case 0:
                JOptionPane.showMessageDialog(this, receptor.getNomeJogador() + " se for pra chorar manda audio!");
                break;
            case 1:
                JOptionPane.showMessageDialog(this, receptor.getNomeJogador() + " mizeravel boy!!!");
                break;
            case 2:
                JOptionPane.showMessageDialog(this, receptor.getNomeJogador() + " pega essa bomba!");
                break;
            case 3:
                JOptionPane.showMessageDialog(this, receptor.getNomeJogador() + " ai me lasquei!");
                break;
            default:
                break;
        }
    }

    public void quemRecebeAtaqueNoCampo(Jogadores jogador) {
        if (jogador == jogador2) {
            if (jogador1.getCarta() instanceof Criatura) {
                jogo.atacar(jogador1, jogador2);
            }

            if (jogador2.getCarta().isVivo() == false) {
                this.destroiCartaCampo(jogador2);
                this.setInfoJogadores(jogador2, deck2, cemiterio2, NomeJogador2, VidaJogador2, ManaJogador2, DeckJogador2, CemiterioJogador2);
                JOptionPane.showMessageDialog(this, this.jogador1.getCarta().getNome() + " destruiu " + this.jogador2.getCarta().getNome());
                cemiterio2.getCemiterio2().add(jogador2.getCarta());

                this.jpAcaoCampo1.setVisible(false);

                if (jogador2.getVidaJogador() <= 0 || (carta6 == null && carta7 == null && carta8 == null && carta9 == null && carta10 == null)) {
                    jogador1.ganhaExperiencia();
                    jogador1.setExperiencia(jogador1.ganhaExperiencia());
                    jogador1.quantoFaltaNovoNivel(jogador1, jogador1.getNivelJogador());
                    JOptionPane.showMessageDialog(this, this.jogador2.getNomeJogador() + " foi derrotado! " + this.jogador1.getNomeJogador() + "-Nível:" + this.jogador1.getNivelJogador() + "--" + this.jogador1.getExperiencia() + "/" + this.jogador1.getExperienciaNovoNivel());

                    TelaFimDoDuelo tela3 = new TelaFimDoDuelo(jogador1, jogador2);
                    this.dispose();
                    tela3.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, this.jogador2.getCarta().getNome() + " agora possui " + this.jogador2.getCarta().getResistencia() + " de resistência!");
                this.setInfoJogadores(jogador2, deck2, cemiterio2, NomeJogador2, VidaJogador2, ManaJogador2, DeckJogador2, CemiterioJogador2);
                this.jpAcaoCampo1.setVisible(false);
            }
        } else if (jogador == jogador1) {
            if (jogador2.getCarta() instanceof Criatura) {
                jogo.atacar(jogador2, jogador1);
            }

            if (jogador1.getCarta().isVivo() == false) {
                this.destroiCartaCampo(jogador1);
                this.setInfoJogadores(jogador1, deck1, cemiterio1, NomeJogador1, VidaJogador1, ManaJogador1, DeckJogador1, CemiterioJogador1);
                JOptionPane.showMessageDialog(this, this.jogador2.getCarta().getNome() + " destruiu " + this.jogador1.getCarta().getNome());
                cemiterio1.getCemiterio1().add(jogador1.getCarta());

                this.jpAcaoCampo2.setVisible(false);

                if (jogador1.getVidaJogador() <= 0 || (carta1 == null && carta2 == null && carta3 == null && carta4 == null && carta5 == null)) {
                    jogador2.ganhaExperiencia();
                    jogador2.setExperiencia(jogador2.ganhaExperiencia());
                    jogador2.quantoFaltaNovoNivel(jogador2, jogador2.getNivelJogador());
                    JOptionPane.showMessageDialog(this, this.jogador1.getNomeJogador() + " foi derrotado! " + this.jogador2.getNomeJogador() + "-Nível:" + this.jogador2.getNivelJogador() + "--" + this.jogador2.getExperiencia() + "/" + this.jogador2.getExperienciaNovoNivel());

                    TelaFimDoDuelo tela3 = new TelaFimDoDuelo(jogador1, jogador2);
                    this.dispose();
                    tela3.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, this.jogador1.getCarta().getNome() + " agora possui " + this.jogador1.getCarta().getResistencia() + " de resistência!");
                this.setInfoJogadores(jogador1, deck1, cemiterio1, NomeJogador1, VidaJogador1, ManaJogador1, DeckJogador1, CemiterioJogador1);
                this.jpAcaoCampo2.setVisible(false);
            }
        }
    }

    public Jogadores getJogador1() {
        return jogador1;
    }

    public Jogadores getJogador2() {
        return jogador2;
    }

    public Carta getCarta1Campo1() {
        return carta1Campo1;
    }

    public Carta getCarta2Campo1() {
        return carta2Campo1;
    }

    public Carta getCarta3Campo1() {
        return carta3Campo1;
    }

    public Carta getCarta1Campo2() {
        return carta1Campo2;
    }

    public Carta getCarta2Campo2() {
        return carta2Campo2;
    }

    public Carta getCarta3Campo2() {
        return carta3Campo2;
    }

    public JButton getBtn1CampoDeBatalha1() {
        return btn1CampoDeBatalha1;
    }

    public JButton getBtn1CampoDeBatalha2() {
        return btn1CampoDeBatalha2;
    }

    public JButton getBtn1CartaMao1() {
        return btn1CartaMao1;
    }

    public JButton getBtn1CartaMao2() {
        return btn1CartaMao2;
    }

    public JButton getBtn2CampoDeBatalha1() {
        return btn2CampoDeBatalha1;
    }

    public JButton getBtn2CampoDeBatalha2() {
        return btn2CampoDeBatalha2;
    }

    public JButton getBtn2CartaMao1() {
        return btn2CartaMao1;
    }

    public JButton getBtn2CartaMao2() {
        return btn2CartaMao2;
    }

    public JButton getBtn3CampoDeBatalha1() {
        return btn3CampoDeBatalha1;
    }

    public JButton getBtn3CampoDeBatalha2() {
        return btn3CampoDeBatalha2;
    }

    public JButton getBtn3CartaMao1() {
        return btn3CartaMao1;
    }

    public JButton getBtn3CartaMao2() {
        return btn3CartaMao2;
    }

    public JButton getBtn4CartaMao1() {
        return btn4CartaMao1;
    }

    public JButton getBtn4CartaMao2() {
        return btn4CartaMao2;
    }

    public JButton getBtn5CartaMao1() {
        return btn5CartaMao1;
    }

    public JButton getBtn5CartaMao2() {
        return btn5CartaMao2;
    }

    public JPanel getJpAcaoCampo1() {
        return jpAcaoCampo1;
    }

    public JPanel getJpAcaoCampo2() {
        return jpAcaoCampo2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpJogo = new javax.swing.JPanel();
        jpMao1 = new javax.swing.JPanel();
        btn2CartaMao1 = new javax.swing.JButton();
        btn3CartaMao1 = new javax.swing.JButton();
        btn4CartaMao1 = new javax.swing.JButton();
        btn5CartaMao1 = new javax.swing.JButton();
        btn1CartaMao1 = new javax.swing.JButton();
        jpCampo1 = new javax.swing.JPanel();
        btn1CampoDeBatalha1 = new javax.swing.JButton();
        btn2CampoDeBatalha1 = new javax.swing.JButton();
        btn3CampoDeBatalha1 = new javax.swing.JButton();
        jpAcaoCampo1 = new javax.swing.JPanel();
        btnHabilidade1 = new javax.swing.JButton();
        btnAtaque1 = new javax.swing.JButton();
        jpInfJogador1 = new javax.swing.JPanel();
        jpJogador1 = new javax.swing.JPanel();
        NomeJogador1 = new javax.swing.JLabel();
        VidaJogador1 = new javax.swing.JLabel();
        ManaJogador1 = new javax.swing.JLabel();
        jpDeck1 = new javax.swing.JPanel();
        DeckJogador1 = new javax.swing.JLabel();
        jpCemiterio1 = new javax.swing.JPanel();
        CemiterioJogador1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbDialogo1 = new javax.swing.JButton();
        jbPassaTurno1 = new javax.swing.JButton();
        jpCampo2 = new javax.swing.JPanel();
        btn1CampoDeBatalha2 = new javax.swing.JButton();
        btn2CampoDeBatalha2 = new javax.swing.JButton();
        btn3CampoDeBatalha2 = new javax.swing.JButton();
        jpAcaoCampo2 = new javax.swing.JPanel();
        btnHabilidade2 = new javax.swing.JButton();
        btnAtaque2 = new javax.swing.JButton();
        jpInfJogador2 = new javax.swing.JPanel();
        jpJogador2 = new javax.swing.JPanel();
        NomeJogador2 = new javax.swing.JLabel();
        VidaJogador2 = new javax.swing.JLabel();
        ManaJogador2 = new javax.swing.JLabel();
        jpDeck2 = new javax.swing.JPanel();
        DeckJogador2 = new javax.swing.JLabel();
        jpCemiterio2 = new javax.swing.JPanel();
        CemiterioJogador2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jbDialogo2 = new javax.swing.JButton();
        jbPassaTurno2 = new javax.swing.JButton();
        jpMao2 = new javax.swing.JPanel();
        btn1CartaMao2 = new javax.swing.JButton();
        btn2CartaMao2 = new javax.swing.JButton();
        btn3CartaMao2 = new javax.swing.JButton();
        btn4CartaMao2 = new javax.swing.JButton();
        btn5CartaMao2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(75, 0));

        jpJogo.setBackground(new java.awt.Color(153, 102, 0));
        jpJogo.setPreferredSize(new java.awt.Dimension(1340, 1181));
        jpJogo.setLayout(new java.awt.GridLayout(4, 1));

        jpMao1.setBackground(new java.awt.Color(153, 102, 0));
        jpMao1.setPreferredSize(new java.awt.Dimension(1340, 260));
        jpMao1.setVerifyInputWhenFocusTarget(false);
        jpMao1.setLayout(new java.awt.GridLayout(1, 5));

        btn2CartaMao1.setBackground(new java.awt.Color(102, 51, 0));
        btn2CartaMao1.setAlignmentY(0.0F);
        btn2CartaMao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2CartaMao1ActionPerformed(evt);
            }
        });
        jpMao1.add(btn2CartaMao1);

        btn3CartaMao1.setBackground(new java.awt.Color(102, 51, 0));
        btn3CartaMao1.setAlignmentY(0.0F);
        btn3CartaMao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3CartaMao1ActionPerformed(evt);
            }
        });
        jpMao1.add(btn3CartaMao1);

        btn4CartaMao1.setBackground(new java.awt.Color(102, 51, 0));
        btn4CartaMao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4CartaMao1ActionPerformed(evt);
            }
        });
        jpMao1.add(btn4CartaMao1);

        btn5CartaMao1.setBackground(new java.awt.Color(102, 51, 0));
        btn5CartaMao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5CartaMao1ActionPerformed(evt);
            }
        });
        jpMao1.add(btn5CartaMao1);

        btn1CartaMao1.setBackground(new java.awt.Color(102, 51, 0));
        btn1CartaMao1.setAlignmentY(0.0F);
        btn1CartaMao1.setMargin(null);
        btn1CartaMao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1CartaMao1ActionPerformed(evt);
            }
        });
        jpMao1.add(btn1CartaMao1);

        jpJogo.add(jpMao1);

        jpCampo1.setBackground(new java.awt.Color(153, 102, 0));

        btn1CampoDeBatalha1.setBackground(new java.awt.Color(102, 51, 0));
        btn1CampoDeBatalha1.setToolTipText("");
        btn1CampoDeBatalha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1CampoDeBatalha1ActionPerformed(evt);
            }
        });

        btn2CampoDeBatalha1.setBackground(new java.awt.Color(102, 51, 0));
        btn2CampoDeBatalha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2CampoDeBatalha1ActionPerformed(evt);
            }
        });

        btn3CampoDeBatalha1.setBackground(new java.awt.Color(102, 51, 0));
        btn3CampoDeBatalha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3CampoDeBatalha1ActionPerformed(evt);
            }
        });

        jpAcaoCampo1.setBackground(new java.awt.Color(153, 102, 0));

        btnHabilidade1.setBackground(new java.awt.Color(204, 204, 0));
        btnHabilidade1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        btnHabilidade1.setText("Habilidade");
        btnHabilidade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilidade1ActionPerformed(evt);
            }
        });

        btnAtaque1.setBackground(new java.awt.Color(153, 153, 0));
        btnAtaque1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        btnAtaque1.setText("Ataque");
        btnAtaque1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtaque1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAcaoCampo1Layout = new javax.swing.GroupLayout(jpAcaoCampo1);
        jpAcaoCampo1.setLayout(jpAcaoCampo1Layout);
        jpAcaoCampo1Layout.setHorizontalGroup(
            jpAcaoCampo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAcaoCampo1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpAcaoCampo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtaque1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHabilidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jpAcaoCampo1Layout.setVerticalGroup(
            jpAcaoCampo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAcaoCampo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtaque1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHabilidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpInfJogador1.setBackground(new java.awt.Color(102, 0, 0));

        jpJogador1.setBackground(new java.awt.Color(0, 102, 204));

        NomeJogador1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        NomeJogador1.setForeground(new java.awt.Color(51, 255, 255));
        NomeJogador1.setText("NomeJogador1");
        NomeJogador1.setToolTipText("");

        VidaJogador1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        VidaJogador1.setForeground(new java.awt.Color(0, 255, 51));
        VidaJogador1.setText("VidaJogador1");

        ManaJogador1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        ManaJogador1.setForeground(new java.awt.Color(255, 255, 0));
        ManaJogador1.setText("ManaJogador1");

        javax.swing.GroupLayout jpJogador1Layout = new javax.swing.GroupLayout(jpJogador1);
        jpJogador1.setLayout(jpJogador1Layout);
        jpJogador1Layout.setHorizontalGroup(
            jpJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NomeJogador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(VidaJogador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ManaJogador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpJogador1Layout.setVerticalGroup(
            jpJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpJogador1Layout.createSequentialGroup()
                .addComponent(NomeJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VidaJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ManaJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpDeck1.setBackground(new java.awt.Color(153, 102, 0));

        DeckJogador1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        DeckJogador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeckJogador1.setText("Deck1");
        DeckJogador1.setMaximumSize(new java.awt.Dimension(32, 26));

        javax.swing.GroupLayout jpDeck1Layout = new javax.swing.GroupLayout(jpDeck1);
        jpDeck1.setLayout(jpDeck1Layout);
        jpDeck1Layout.setHorizontalGroup(
            jpDeck1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDeck1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DeckJogador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpDeck1Layout.setVerticalGroup(
            jpDeck1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDeck1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(DeckJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jpCemiterio1.setBackground(new java.awt.Color(204, 0, 204));

        CemiterioJogador1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        CemiterioJogador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CemiterioJogador1.setText("Cemiterio1");
        CemiterioJogador1.setMaximumSize(new java.awt.Dimension(26, 26));
        CemiterioJogador1.setPreferredSize(new java.awt.Dimension(36, 16));

        javax.swing.GroupLayout jpCemiterio1Layout = new javax.swing.GroupLayout(jpCemiterio1);
        jpCemiterio1.setLayout(jpCemiterio1Layout);
        jpCemiterio1Layout.setHorizontalGroup(
            jpCemiterio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCemiterio1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CemiterioJogador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpCemiterio1Layout.setVerticalGroup(
            jpCemiterio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCemiterio1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(CemiterioJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jLabel1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jLabel1.setText("Feitiço1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jLabel1)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel1)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jpInfJogador1Layout = new javax.swing.GroupLayout(jpInfJogador1);
        jpInfJogador1.setLayout(jpInfJogador1Layout);
        jpInfJogador1Layout.setHorizontalGroup(
            jpInfJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfJogador1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpJogador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDeck1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpInfJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpCemiterio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpInfJogador1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        jpInfJogador1Layout.setVerticalGroup(
            jpInfJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfJogador1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDeck1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpCemiterio1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbDialogo1.setBackground(new java.awt.Color(204, 204, 255));
        jbDialogo1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jbDialogo1.setText("Dialogo");
        jbDialogo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDialogo1ActionPerformed(evt);
            }
        });

        jbPassaTurno1.setBackground(new java.awt.Color(51, 255, 255));
        jbPassaTurno1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jbPassaTurno1.setText("End Turn");
        jbPassaTurno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPassaTurno1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCampo1Layout = new javax.swing.GroupLayout(jpCampo1);
        jpCampo1.setLayout(jpCampo1Layout);
        jpCampo1Layout.setHorizontalGroup(
            jpCampo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCampo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpInfJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btn2CampoDeBatalha1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn1CampoDeBatalha1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn3CampoDeBatalha1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpCampo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCampo1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jpAcaoCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(143, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCampo1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpCampo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbDialogo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbPassaTurno1))
                        .addContainerGap())))
        );
        jpCampo1Layout.setVerticalGroup(
            jpCampo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCampo1Layout.createSequentialGroup()
                .addGroup(jpCampo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCampo1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jpAcaoCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCampo1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jpCampo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCampo1Layout.createSequentialGroup()
                                .addComponent(jbPassaTurno1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbDialogo1))
                            .addGroup(jpCampo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jpInfJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn2CampoDeBatalha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn3CampoDeBatalha1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                .addComponent(btn1CampoDeBatalha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpJogo.add(jpCampo1);

        jpCampo2.setBackground(new java.awt.Color(153, 102, 0));
        jpCampo2.setPreferredSize(new java.awt.Dimension(330, 248));

        btn1CampoDeBatalha2.setBackground(new java.awt.Color(102, 51, 0));
        btn1CampoDeBatalha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1CampoDeBatalha2ActionPerformed(evt);
            }
        });

        btn2CampoDeBatalha2.setBackground(new java.awt.Color(102, 51, 0));
        btn2CampoDeBatalha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2CampoDeBatalha2ActionPerformed(evt);
            }
        });

        btn3CampoDeBatalha2.setBackground(new java.awt.Color(102, 51, 0));
        btn3CampoDeBatalha2.setToolTipText("");
        btn3CampoDeBatalha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3CampoDeBatalha2ActionPerformed(evt);
            }
        });

        jpAcaoCampo2.setBackground(new java.awt.Color(153, 102, 0));

        btnHabilidade2.setBackground(new java.awt.Color(204, 204, 0));
        btnHabilidade2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        btnHabilidade2.setText("Habilidade");
        btnHabilidade2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilidade2ActionPerformed(evt);
            }
        });

        btnAtaque2.setBackground(new java.awt.Color(153, 153, 0));
        btnAtaque2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        btnAtaque2.setText("Ataque");
        btnAtaque2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtaque2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAcaoCampo2Layout = new javax.swing.GroupLayout(jpAcaoCampo2);
        jpAcaoCampo2.setLayout(jpAcaoCampo2Layout);
        jpAcaoCampo2Layout.setHorizontalGroup(
            jpAcaoCampo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAcaoCampo2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpAcaoCampo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtaque2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHabilidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpAcaoCampo2Layout.setVerticalGroup(
            jpAcaoCampo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAcaoCampo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtaque2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHabilidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpInfJogador2.setBackground(new java.awt.Color(102, 0, 0));

        jpJogador2.setBackground(new java.awt.Color(204, 0, 0));

        NomeJogador2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        NomeJogador2.setForeground(new java.awt.Color(255, 153, 102));
        NomeJogador2.setText("NomeJogador2");
        NomeJogador2.setToolTipText("");

        VidaJogador2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        VidaJogador2.setForeground(new java.awt.Color(51, 255, 0));
        VidaJogador2.setText("VidaJogador2");

        ManaJogador2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        ManaJogador2.setForeground(new java.awt.Color(255, 255, 0));
        ManaJogador2.setText("ManaJogador2");

        javax.swing.GroupLayout jpJogador2Layout = new javax.swing.GroupLayout(jpJogador2);
        jpJogador2.setLayout(jpJogador2Layout);
        jpJogador2Layout.setHorizontalGroup(
            jpJogador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NomeJogador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(VidaJogador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ManaJogador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpJogador2Layout.setVerticalGroup(
            jpJogador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpJogador2Layout.createSequentialGroup()
                .addComponent(NomeJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VidaJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ManaJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpDeck2.setBackground(new java.awt.Color(153, 102, 0));

        DeckJogador2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        DeckJogador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeckJogador2.setText("Deck2");

        javax.swing.GroupLayout jpDeck2Layout = new javax.swing.GroupLayout(jpDeck2);
        jpDeck2.setLayout(jpDeck2Layout);
        jpDeck2Layout.setHorizontalGroup(
            jpDeck2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDeck2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DeckJogador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpDeck2Layout.setVerticalGroup(
            jpDeck2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDeck2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(DeckJogador2)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jpCemiterio2.setBackground(new java.awt.Color(204, 0, 204));

        CemiterioJogador2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        CemiterioJogador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CemiterioJogador2.setText("Cemiterio2");

        javax.swing.GroupLayout jpCemiterio2Layout = new javax.swing.GroupLayout(jpCemiterio2);
        jpCemiterio2.setLayout(jpCemiterio2Layout);
        jpCemiterio2Layout.setHorizontalGroup(
            jpCemiterio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCemiterio2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CemiterioJogador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpCemiterio2Layout.setVerticalGroup(
            jpCemiterio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCemiterio2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(CemiterioJogador2)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jLabel2.setText("Feitiço2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jLabel2)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel2)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jpInfJogador2Layout = new javax.swing.GroupLayout(jpInfJogador2);
        jpInfJogador2.setLayout(jpInfJogador2Layout);
        jpInfJogador2Layout.setHorizontalGroup(
            jpInfJogador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfJogador2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfJogador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpCemiterio2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpInfJogador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpJogador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDeck2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpInfJogador2Layout.setVerticalGroup(
            jpInfJogador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfJogador2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfJogador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDeck2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpCemiterio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpInfJogador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jbDialogo2.setBackground(new java.awt.Color(204, 204, 255));
        jbDialogo2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jbDialogo2.setText("Dialogo");
        jbDialogo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDialogo2ActionPerformed(evt);
            }
        });

        jbPassaTurno2.setBackground(new java.awt.Color(255, 0, 0));
        jbPassaTurno2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jbPassaTurno2.setText("End Turn");
        jbPassaTurno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPassaTurno2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCampo2Layout = new javax.swing.GroupLayout(jpCampo2);
        jpCampo2.setLayout(jpCampo2Layout);
        jpCampo2Layout.setHorizontalGroup(
            jpCampo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCampo2Layout.createSequentialGroup()
                .addGroup(jpCampo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCampo2Layout.createSequentialGroup()
                        .addContainerGap(130, Short.MAX_VALUE)
                        .addComponent(jpAcaoCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jpCampo2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpCampo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbDialogo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbPassaTurno2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btn2CampoDeBatalha2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn1CampoDeBatalha2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn3CampoDeBatalha2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jpInfJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpCampo2Layout.setVerticalGroup(
            jpCampo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCampo2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpCampo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCampo2Layout.createSequentialGroup()
                        .addComponent(jpAcaoCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCampo2Layout.createSequentialGroup()
                        .addGroup(jpCampo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpCampo2Layout.createSequentialGroup()
                                .addComponent(jbPassaTurno2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbDialogo2))
                            .addGroup(jpCampo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn2CampoDeBatalha2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn1CampoDeBatalha2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn3CampoDeBatalha2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpCampo2Layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jpInfJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );

        jpJogo.add(jpCampo2);

        jpMao2.setPreferredSize(new java.awt.Dimension(1340, 260));
        jpMao2.setLayout(new java.awt.GridLayout(1, 5));

        btn1CartaMao2.setBackground(new java.awt.Color(102, 51, 0));
        btn1CartaMao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1CartaMao2ActionPerformed(evt);
            }
        });
        jpMao2.add(btn1CartaMao2);

        btn2CartaMao2.setBackground(new java.awt.Color(102, 51, 0));
        btn2CartaMao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2CartaMao2ActionPerformed(evt);
            }
        });
        jpMao2.add(btn2CartaMao2);

        btn3CartaMao2.setBackground(new java.awt.Color(102, 51, 0));
        btn3CartaMao2.setAlignmentY(0.0F);
        btn3CartaMao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3CartaMao2ActionPerformed(evt);
            }
        });
        jpMao2.add(btn3CartaMao2);

        btn4CartaMao2.setBackground(new java.awt.Color(102, 51, 0));
        btn4CartaMao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4CartaMao2ActionPerformed(evt);
            }
        });
        jpMao2.add(btn4CartaMao2);

        btn5CartaMao2.setBackground(new java.awt.Color(102, 51, 0));
        btn5CartaMao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5CartaMao2ActionPerformed(evt);
            }
        });
        jpMao2.add(btn5CartaMao2);

        jpJogo.add(jpMao2);

        jMenu1.setText("File");

        jMenuItem1.setText("Opção Menu 1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btn1CartaMao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1CartaMao1ActionPerformed
        if (carta1.getMana() <= jogador1.getManaJogador()) {
            btn1CartaMao1.setIcon(null);

            this.confereAdicionaCartaCampo(jogador1, carta1);
            btn1CartaMao1.setEnabled(false);
            carta1 = null;

            int novaMana = jogador1.getManaJogador() - jogador1.getCarta().getMana();
            jogador1.setManaJogador(novaMana);
            this.setInfoJogadores(jogador1, deck1, cemiterio1, NomeJogador1, VidaJogador1, ManaJogador1, DeckJogador1, CemiterioJogador1);
        } else {
            JOptionPane.showMessageDialog(this, this.jogador1.getNomeJogador() + " não possui mana suficiente para lançar essa carta");
        }
    }//GEN-LAST:event_btn1CartaMao1ActionPerformed

    private void btn1CampoDeBatalha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1CampoDeBatalha1ActionPerformed

        this.jogador1.setCarta(carta1Campo1);

        this.jpAcaoCampo1.setVisible(true);
    }//GEN-LAST:event_btn1CampoDeBatalha1ActionPerformed

    private void btn3CartaMao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3CartaMao2ActionPerformed
        if (carta8.getMana() <= jogador2.getManaJogador()) {
            btn3CartaMao2.setIcon(null);

            this.confereAdicionaCartaCampo(jogador2, carta8);
            btn3CartaMao2.setEnabled(false);
            carta8 = null;

            int novaMana = jogador2.getManaJogador() - jogador2.getCarta().getMana();
            jogador2.setManaJogador(novaMana);
            this.setInfoJogadores(jogador2, deck1, cemiterio1, NomeJogador2, VidaJogador2, ManaJogador2, DeckJogador1, CemiterioJogador1);
        } else {
            JOptionPane.showMessageDialog(this, this.jogador2.getNomeJogador() + " não possui mana suficiente para lançar essa carta");
        }
    }//GEN-LAST:event_btn3CartaMao2ActionPerformed

    private void btn2CartaMao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2CartaMao2ActionPerformed
        if (carta7.getMana() <= jogador2.getManaJogador()) {
            btn2CartaMao2.setIcon(null);

            this.confereAdicionaCartaCampo(jogador2, carta7);
            btn2CartaMao2.setEnabled(false);
            carta7 = null;

            int novaMana = jogador2.getManaJogador() - jogador2.getCarta().getMana();
            jogador2.setManaJogador(novaMana);
            this.setInfoJogadores(jogador2, deck2, cemiterio2, NomeJogador2, VidaJogador2, ManaJogador2, DeckJogador2, CemiterioJogador2);
        } else {
            JOptionPane.showMessageDialog(this, this.jogador2.getNomeJogador() + " não possui mana suficiente para lançar essa carta");
        }
    }//GEN-LAST:event_btn2CartaMao2ActionPerformed

    private void btn1CartaMao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1CartaMao2ActionPerformed
        if (carta6.getMana() <= jogador2.getManaJogador()) {
            btn1CartaMao2.setIcon(null);

            this.confereAdicionaCartaCampo(jogador2, carta6);
            btn1CartaMao2.setEnabled(false);
            carta6 = null;

            int novaMana = jogador2.getManaJogador() - jogador2.getCarta().getMana();
            jogador2.setManaJogador(novaMana);
            this.setInfoJogadores(jogador2, deck2, cemiterio2, NomeJogador2, VidaJogador2, ManaJogador2, DeckJogador2, CemiterioJogador2);
        } else {
            JOptionPane.showMessageDialog(this, this.jogador2.getNomeJogador() + " não possui mana suficiente para lançar essa carta");
        }
    }//GEN-LAST:event_btn1CartaMao2ActionPerformed

    private void btn1CampoDeBatalha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1CampoDeBatalha2ActionPerformed

        this.jogador2.setCarta(carta1Campo2);

        this.jpAcaoCampo2.setVisible(true);
    }//GEN-LAST:event_btn1CampoDeBatalha2ActionPerformed

    private void btn3CartaMao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3CartaMao1ActionPerformed
        if (carta3.getMana() <= jogador1.getManaJogador()) {
            btn3CartaMao1.setIcon(null);

            this.confereAdicionaCartaCampo(jogador1, carta3);
            btn3CartaMao1.setEnabled(false);
            carta3 = null;

            int novaMana = jogador1.getManaJogador() - jogador1.getCarta().getMana();
            jogador1.setManaJogador(novaMana);
            this.setInfoJogadores(jogador1, deck1, cemiterio1, NomeJogador1, VidaJogador1, ManaJogador1, DeckJogador1, CemiterioJogador1);
        } else {
            JOptionPane.showMessageDialog(this, this.jogador1.getNomeJogador() + " não possui mana suficiente para lançar essa carta");
        }
    }//GEN-LAST:event_btn3CartaMao1ActionPerformed

    private void btn2CartaMao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2CartaMao1ActionPerformed
        if (carta2.getMana() <= jogador1.getManaJogador()) {
            btn2CartaMao1.setIcon(null);

            this.confereAdicionaCartaCampo(jogador1, carta2);
            btn2CartaMao1.setEnabled(false);
            carta2 = null;

            int novaMana = jogador1.getManaJogador() - jogador1.getCarta().getMana();
            jogador1.setManaJogador(novaMana);
            this.setInfoJogadores(jogador1, deck1, cemiterio1, NomeJogador1, VidaJogador1, ManaJogador1, DeckJogador1, CemiterioJogador1);
        } else {
            JOptionPane.showMessageDialog(this, this.jogador1.getNomeJogador() + " não possui mana suficiente para lançar essa carta");
        }

    }//GEN-LAST:event_btn2CartaMao1ActionPerformed

    private void btn4CartaMao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4CartaMao2ActionPerformed
        if (carta9.getMana() <= jogador2.getManaJogador()) {
            btn4CartaMao2.setIcon(null);

            this.confereAdicionaCartaCampo(jogador2, carta9);
            btn4CartaMao2.setEnabled(false);
            carta9 = null;

            int novaMana = jogador2.getManaJogador() - jogador2.getCarta().getMana();
            jogador2.setManaJogador(novaMana);
            this.setInfoJogadores(jogador2, deck2, cemiterio2, NomeJogador2, VidaJogador2, ManaJogador2, DeckJogador2, CemiterioJogador2);
        } else {
            JOptionPane.showMessageDialog(this, this.jogador2.getNomeJogador() + " não possui mana suficiente para lançar essa carta");
        }
    }//GEN-LAST:event_btn4CartaMao2ActionPerformed

    private void btn4CartaMao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4CartaMao1ActionPerformed
        if (carta4.getMana() <= jogador1.getManaJogador()) {
            btn4CartaMao1.setIcon(null);

            this.confereAdicionaCartaCampo(jogador1, carta4);
            btn4CartaMao1.setEnabled(false);
            carta4 = null;

            int novaMana = jogador1.getManaJogador() - jogador1.getCarta().getMana();
            jogador1.setManaJogador(novaMana);
            this.setInfoJogadores(jogador1, deck1, cemiterio1, NomeJogador1, VidaJogador1, ManaJogador1, DeckJogador1, CemiterioJogador1);
        } else {
            JOptionPane.showMessageDialog(this, this.jogador1.getNomeJogador() + " não possui mana suficiente para lançar essa carta");
        }

    }//GEN-LAST:event_btn4CartaMao1ActionPerformed

    private void btn5CartaMao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5CartaMao1ActionPerformed
        if (carta5.getMana() <= jogador1.getManaJogador()) {
            btn5CartaMao1.setIcon(null);

            this.confereAdicionaCartaCampo(jogador1, carta5);
            btn5CartaMao1.setEnabled(false);
            carta5 = null;

            int novaMana = jogador1.getManaJogador() - jogador1.getCarta().getMana();
            jogador1.setManaJogador(novaMana);
            this.setInfoJogadores(jogador1, deck1, cemiterio1, NomeJogador1, VidaJogador1, ManaJogador1, DeckJogador1, CemiterioJogador1);
        } else {
            JOptionPane.showMessageDialog(this, this.jogador1.getNomeJogador() + " não possui mana suficiente para lançar essa carta");
        }

    }//GEN-LAST:event_btn5CartaMao1ActionPerformed

    private void btn5CartaMao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5CartaMao2ActionPerformed
        if (carta10.getMana() <= jogador2.getManaJogador()) {
            btn5CartaMao2.setIcon(null);

            this.confereAdicionaCartaCampo(jogador2, carta10);
            btn5CartaMao2.setEnabled(false);
            carta10 = null;

            int novaMana = jogador2.getManaJogador() - jogador2.getCarta().getMana();
            jogador2.setManaJogador(novaMana);
            this.setInfoJogadores(jogador2, deck2, cemiterio2, NomeJogador2, VidaJogador2, ManaJogador2, DeckJogador2, CemiterioJogador2);
        } else {
            JOptionPane.showMessageDialog(this, this.jogador2.getNomeJogador() + " não possui mana suficiente para lançar essa carta");
        }
    }//GEN-LAST:event_btn5CartaMao2ActionPerformed

    private void btnHabilidade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilidade1ActionPerformed

        Criatura criatura = (Criatura) jogador1.getCarta();

        if (criatura.getCustoManaHabilidade() <= jogador1.getManaJogador()) {
            criatura.usarHabilidade(jogador1, jogador2, this);
            this.setInfoJogadores(jogador1, deck1, cemiterio1, NomeJogador1, VidaJogador1, ManaJogador1, DeckJogador1, CemiterioJogador1);
            this.setInfoJogadores(jogador2, deck2, cemiterio2, NomeJogador2, VidaJogador2, ManaJogador2, DeckJogador2, CemiterioJogador2);

            this.jpAcaoCampo1.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, this.jogador1.getNomeJogador() + " não possui mana suficiente para usar a habilidade essa carta");
        }
    }//GEN-LAST:event_btnHabilidade1ActionPerformed

    private void btnHabilidade2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilidade2ActionPerformed

        Criatura criatura = (Criatura) jogador2.getCarta();

        if (criatura.getCustoManaHabilidade() <= jogador2.getManaJogador()) {

            criatura.usarHabilidade(jogador2, jogador1, this);
            this.setInfoJogadores(jogador1, deck1, cemiterio1, NomeJogador1, VidaJogador1, ManaJogador1, DeckJogador1, CemiterioJogador1);
            this.setInfoJogadores(jogador2, deck2, cemiterio2, NomeJogador2, VidaJogador2, ManaJogador2, DeckJogador2, CemiterioJogador2);

            this.jpAcaoCampo2.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(this, this.jogador2.getNomeJogador() + " não possui mana suficiente para usar a habilidade essa carta");
        }
    }//GEN-LAST:event_btnHabilidade2ActionPerformed

    private void btnAtaque1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtaque1ActionPerformed
        if(turno == 1){
            JOptionPane.showMessageDialog(this, this.jogador1.getNomeJogador() + " você não pode atacar no primeiro turno!");
            this.jpAcaoCampo1.setVisible(false);
        }
        else{
            TelaEscolhaDuelo tela4 = new TelaEscolhaDuelo(jogador2, jogo, this);
            tela4.setVisible(true);
        }
    }//GEN-LAST:event_btnAtaque1ActionPerformed

    private void btnAtaque2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtaque2ActionPerformed
        
        if(turno == 1){
            JOptionPane.showMessageDialog(this, this.jogador2.getNomeJogador() + " você não pode atacar no primeiro turno!");
            this.jpAcaoCampo2.setVisible(false);
        }
        else{
            TelaEscolhaDuelo tela4 = new TelaEscolhaDuelo(jogador1, jogo, this);
            tela4.setVisible(true);
        }

    }//GEN-LAST:event_btnAtaque2ActionPerformed

    private void btn2CampoDeBatalha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2CampoDeBatalha1ActionPerformed

        this.jogador1.setCarta(carta2Campo1);

        this.jpAcaoCampo1.setVisible(true);
    }//GEN-LAST:event_btn2CampoDeBatalha1ActionPerformed

    private void btn3CampoDeBatalha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3CampoDeBatalha1ActionPerformed

        this.jogador1.setCarta(carta3Campo1);

        this.jpAcaoCampo1.setVisible(true);
    }//GEN-LAST:event_btn3CampoDeBatalha1ActionPerformed

    private void btn2CampoDeBatalha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2CampoDeBatalha2ActionPerformed

        this.jogador2.setCarta(carta2Campo2);

        this.jpAcaoCampo2.setVisible(true);
    }//GEN-LAST:event_btn2CampoDeBatalha2ActionPerformed

    private void btn3CampoDeBatalha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3CampoDeBatalha2ActionPerformed

        this.jogador2.setCarta(carta3Campo2);

        this.jpAcaoCampo2.setVisible(true);
    }//GEN-LAST:event_btn3CampoDeBatalha2ActionPerformed

    private void jbDialogo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDialogo2ActionPerformed
        this.getDialogoAleatrorio(jogador1);
    }//GEN-LAST:event_jbDialogo2ActionPerformed

    private void jbDialogo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDialogo1ActionPerformed
        this.getDialogoAleatrorio(jogador2);
    }//GEN-LAST:event_jbDialogo1ActionPerformed

    private void jbPassaTurno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPassaTurno2ActionPerformed
        jbPassaTurno2.setEnabled(false);
        jbPassaTurno1.setEnabled(true);
        desabilitaMao(btn1CartaMao2, btn2CartaMao2, btn3CartaMao2, btn4CartaMao2, btn5CartaMao2, btn1CampoDeBatalha2, btn2CampoDeBatalha2, btn3CampoDeBatalha2);
        habilitaMao(btn1CartaMao1, btn2CartaMao1, btn3CartaMao1, btn4CartaMao1, btn5CartaMao1, btn1CampoDeBatalha1, btn2CampoDeBatalha1, btn3CampoDeBatalha1);

        jogador2.setManaJogador(jogador2.getManaJogador() + 1);
        if (deck1.getNumCartasDeck1() > 0) {
            this.confereAdicionaCartaMao(jogador1, carta1, carta2, carta3, carta4, carta5);
        }
        turno++;

        JOptionPane.showMessageDialog(this, "Turno " + this.turno + " vez de " + this.jogador1.getNomeJogador() + " jogar!");
    }//GEN-LAST:event_jbPassaTurno2ActionPerformed

    private void jbPassaTurno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPassaTurno1ActionPerformed
        jbPassaTurno1.setEnabled(false);
        jbPassaTurno2.setEnabled(true);
        desabilitaMao(btn1CartaMao1, btn2CartaMao1, btn3CartaMao1, btn4CartaMao1, btn5CartaMao1, btn1CampoDeBatalha1, btn2CampoDeBatalha1, btn3CampoDeBatalha1);
        habilitaMao(btn1CartaMao2, btn2CartaMao2, btn3CartaMao2, btn4CartaMao2, btn5CartaMao2, btn1CampoDeBatalha2, btn2CampoDeBatalha2, btn3CampoDeBatalha2);

        jogador1.setManaJogador(jogador1.getManaJogador() + 1);
        if (deck2.getNumCartasDeck2() > 0) {
            this.confereAdicionaCartaMao(jogador2, carta6, carta7, carta8, carta9, carta10);
        }
        turno++;

        JOptionPane.showMessageDialog(this, "Turno " + this.turno + " vez de " + this.jogador2.getNomeJogador() + " jogar!");
    }//GEN-LAST:event_jbPassaTurno1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCombateGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCombateGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCombateGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCombateGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaCombateGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CemiterioJogador1;
    private javax.swing.JLabel CemiterioJogador2;
    private javax.swing.JLabel DeckJogador1;
    private javax.swing.JLabel DeckJogador2;
    private javax.swing.JLabel ManaJogador1;
    private javax.swing.JLabel ManaJogador2;
    private javax.swing.JLabel NomeJogador1;
    private javax.swing.JLabel NomeJogador2;
    private javax.swing.JLabel VidaJogador1;
    private javax.swing.JLabel VidaJogador2;
    private javax.swing.JButton btn1CampoDeBatalha1;
    private javax.swing.JButton btn1CampoDeBatalha2;
    private javax.swing.JButton btn1CartaMao1;
    private javax.swing.JButton btn1CartaMao2;
    private javax.swing.JButton btn2CampoDeBatalha1;
    private javax.swing.JButton btn2CampoDeBatalha2;
    private javax.swing.JButton btn2CartaMao1;
    private javax.swing.JButton btn2CartaMao2;
    private javax.swing.JButton btn3CampoDeBatalha1;
    private javax.swing.JButton btn3CampoDeBatalha2;
    private javax.swing.JButton btn3CartaMao1;
    private javax.swing.JButton btn3CartaMao2;
    private javax.swing.JButton btn4CartaMao1;
    private javax.swing.JButton btn4CartaMao2;
    private javax.swing.JButton btn5CartaMao1;
    private javax.swing.JButton btn5CartaMao2;
    private javax.swing.JButton btnAtaque1;
    private javax.swing.JButton btnAtaque2;
    private javax.swing.JButton btnHabilidade1;
    private javax.swing.JButton btnHabilidade2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbDialogo1;
    private javax.swing.JButton jbDialogo2;
    private javax.swing.JButton jbPassaTurno1;
    private javax.swing.JButton jbPassaTurno2;
    private javax.swing.JPanel jpAcaoCampo1;
    private javax.swing.JPanel jpAcaoCampo2;
    private javax.swing.JPanel jpCampo1;
    private javax.swing.JPanel jpCampo2;
    private javax.swing.JPanel jpCemiterio1;
    private javax.swing.JPanel jpCemiterio2;
    private javax.swing.JPanel jpDeck1;
    private javax.swing.JPanel jpDeck2;
    private javax.swing.JPanel jpInfJogador1;
    private javax.swing.JPanel jpInfJogador2;
    private javax.swing.JPanel jpJogador1;
    private javax.swing.JPanel jpJogador2;
    private javax.swing.JPanel jpJogo;
    private javax.swing.JPanel jpMao1;
    private javax.swing.JPanel jpMao2;
    // End of variables declaration//GEN-END:variables
}
