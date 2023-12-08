package ej.unogame_maven;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class logicaCPU {

    private ArrayList<UnoCard> cpuHand;
    private Game game;
    private JuegoCPU juegoCpu;

    public logicaCPU() {

    }

    public logicaCPU(ArrayList<UnoCard> cpuHand, Game game, JuegoCPU juegoCpu) {
        this.cpuHand = cpuHand;
        this.game = game;
        this.juegoCpu = juegoCpu;
    }

    public void cpuJuegaCarta(UnoCard.Color declaredColor) {

        //cpuHand
        boolean cartaJugada = false;

        for (UnoCard carta : cpuHand) {
            if (carta.getColor() == game.getTopCard().getColor()
                    || carta.getColor() == UnoCard.Color.Wild
                    || carta.getValue() == game.getTopCard().getValue()) {

                try {

                    System.out.println(carta);
                    game.submitCpuCard(game.getJugador(), carta, declaredColor);

                } catch (Game.InvalidColorSubmissionExcpetion | Game.InvalidValueSubmissionException | Game.InvalidPlayerTurnException ex) {
                    Logger.getLogger(PopUpp.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (game.getCurrentPlayer() != "CPU") {

                    juegoCpu.setPidName(game.getCurrentPlayer());
                    juegoCpu.setButtonIcons();
                    juegoCpu.setTopCardButtonIcon();
                    juegoCpu.setCantCartas(cpuHand.size());
                    juegoCpu.revalidate();

                }

                cartaJugada = true;

                break;
            }
        }

        // Si ninguna carta se pudo jugar, robar una carta
        if (!cartaJugada) {
            
            JLabel message = new JLabel(game.getCurrentPlayer() + " levanto una carta!");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            
            UnoDeck mazo = game.getDeck();
            ArrayList<UnoCard> descarte = game.getStockpile();

            if (mazo.isEmpty()) {
                mazo.replaceDeckWith(descarte);
                mazo.shuffle();
            }

            UnoCard cartaRobada = mazo.drawCard();

            try {
                game.submitDraw(game.getCurrentPlayer());
            } catch (Game.InvalidPlayerTurnException ex) {
                Logger.getLogger(GameStagee.class.getName()).log(Level.SEVERE, null, ex);
            }

            juegoCpu.setCantCartas(cpuHand.size()); // setea la label de cantidad de cartas de cpu
            juegoCpu.revalidate();

            System.out.println("----------------");
            game.getPlayerHand(game.jugadores.get(1));

            for (UnoCard unoCard : cpuHand) {
                System.out.println(unoCard);
            }
            System.out.println("////////////////////");

            
        }
    }

    // Verificar si la carta recién robada se puede jugar
//            if (cartaRobada.getColor() == game.getTopCard().getColor() || cartaRobada.getColor() == UnoCard.Color.Wild || cartaRobada.getValue() == game.getTopCard().getValue()) {
//                try {
//                    game.submitCpuCard(game.getJugador(), cartaRobada, declaredColor);
//                } catch (InvalidColorSubmissionExcpetion | InvalidValueSubmissionException | InvalidPlayerTurnException ex) {
//                    Logger.getLogger(PopUpp.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                this.revalidate();
//                if (declaredColor != UnoCard.Color.Wild) {
//                    juegoCPU.setPidName(game.getCurrentPlayer());
//                    juegoCPU.setButtonIcons();
//                    topCardButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + game.getTopCardImage()));
//                    this.setVisible(false);
//                }
//            } else {
//
//                game.cambioDeTurno();
//                this.revalidate();
//            }
    //
    //            //aca roba una carta
    //            UnoDeck mazo = game.getDeck();
    //            ArrayList<UnoCard> descarte = game.getStockpile();
    //
    //            if (mazo.isEmpty()) {
    //                mazo.replaceDeckWith(descarte);
    //                mazo.shuffle();
    //            }
    //
    //            game.getPlayerHand(game.jugadores.get(1)).add(mazo.drawCard());
    //
    //        }
    //    }
}
