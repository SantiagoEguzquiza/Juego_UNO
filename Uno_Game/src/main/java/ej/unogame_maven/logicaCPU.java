package ej.unogame_maven;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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

                juegoCpu.setPidName(game.getCurrentPlayer());
                juegoCpu.setButtonIcons();
                juegoCpu.setTopCardButtonIcon();
                juegoCpu.revalidate();

                cartaJugada = true;

                break;
            }
        }

        // Si ninguna carta se pudo jugar, robar una carta
        if (!cartaJugada) {
            UnoDeck mazo = game.getDeck();
            ArrayList<UnoCard> descarte = game.getStockpile();

            if (mazo.isEmpty()) {
                mazo.replaceDeckWith(descarte);
                mazo.shuffle();
            }

            UnoCard cartaRobada = mazo.drawCard();

            juegoCpu.revalidate();

            try {
                game.submitDraw(game.getCurrentPlayer());
            } catch (Game.InvalidPlayerTurnException ex) {
                Logger.getLogger(GameStagee.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("----------------");
            game.getPlayerHand(game.jugadores.get(1));

            for (UnoCard unoCard : cpuHand) {
                System.out.println(unoCard);
            }
            System.out.println("////////////////////");

           
        }
    }
    
    
    public String cantidadCartas(){
    
    String cartas = String.valueOf(this.cpuHand.size());
    return cartas;
    
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
