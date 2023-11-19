package ej.unogame_maven;

import ej.unogame_maven.Game.InvalidColorSubmissionExcpetion;
import ej.unogame_maven.Game.InvalidPlayerTurnException;
import ej.unogame_maven.Game.InvalidValueSubmissionException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class PopUpp extends javax.swing.JFrame {

    String cardImage = "";
    Game game;
    ArrayList<UnoCard> playerHand;
    ArrayList<UnoCard> cpuHand;
    int choice;
    ArrayList<JButton> cardButtons;
    GameStagee gameStage;
    JuegoCPU juegoCPU;
    JButton topCardButton;
    UnoCard.Color declaredColor;

    public PopUpp() {
    }

    public PopUpp(String cardName, Game game, int index, ArrayList<JButton> cardButtons, GameStagee gamestage, JButton topCardButton) {
        initComponents();
        cardImage = cardName;
        this.game = game;
        playerHand = game.getPlayerHand(game.getCurrentPlayer());
        choice = index;
        this.cardButtons = cardButtons;
        cardLabel.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + cardImage.toString() + ".png"));
        this.gameStage = gamestage;
        this.topCardButton = topCardButton;
        useCardCPU.setVisible(false);
    }

    public PopUpp(String cardName, Game game, int index, ArrayList<JButton> cardButtons, JuegoCPU juegocpu, JButton topCardButton) {
        initComponents();
        cardImage = cardName;
        this.game = game;
        playerHand = game.getPlayerHand(game.getCurrentPlayer());
        choice = index;
        this.cardButtons = cardButtons;
        cardLabel.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + cardImage.toString() + ".png"));
        this.juegoCPU = juegocpu;
        this.topCardButton = topCardButton;
        useCardButton.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardLabel = new javax.swing.JLabel();
        useCardButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        useCardCPU = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 500));

        useCardButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        useCardButton.setText("Usar Carta");
        useCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useCardButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        useCardCPU.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        useCardCPU.setText("Usar Carta");
        useCardCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useCardCPUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(cardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(useCardCPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(useCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(cardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(useCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(useCardCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void useCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useCardButtonActionPerformed
        boolean eleccion = false;
        PickColorFramee pickColor = new PickColorFramee(this, eleccion);
        declaredColor = pickColor.choseColor(playerHand.get(choice));

        if (declaredColor != null) {
            try {
                game.submitPlayerCard(game.getCurrentPlayer(), playerHand.get(choice), declaredColor);
            } catch (InvalidColorSubmissionExcpetion ex) {
                Logger.getLogger(PopUpp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidValueSubmissionException ex) {
                Logger.getLogger(PopUpp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidPlayerTurnException ex) {
                Logger.getLogger(PopUpp.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.revalidate();
            if (declaredColor != UnoCard.Color.Wild) {
                gameStage.setPidName(game.getCurrentPlayer());
                gameStage.setButtonIcons();
                topCardButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + game.getTopCardImage()));
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_useCardButtonActionPerformed

    private void useCardCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useCardCPUActionPerformed

        
        if( playerHand.get(choice).getColor() == UnoCard.Color.Wild){
        
        wildCardPickColor();
            
        }else{
        
        PickColorFramee pickColor = new PickColorFramee(this, true);
        declaredColor = pickColor.choseColor(playerHand.get(choice));

        boolean eleccion = true;

       
        if (declaredColor != null) {
            try {
                game.submitPlayerCard(game.getCurrentPlayer(), playerHand.get(choice), declaredColor);
                this.revalidate();
                juegoCPU.setPidName(game.getCurrentPlayer());
                juegoCPU.setButtonIcons();
                topCardButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + game.getTopCardImage()));
                this.setVisible(false);

                logicaCPU logicaCPU = new logicaCPU(game.getPlayerHand(game.jugadores.get(1)), this.game, this.juegoCPU);
                logicaCPU.cpuJuegaCarta(declaredColor);

            } catch (InvalidColorSubmissionExcpetion | InvalidValueSubmissionException | InvalidPlayerTurnException ex) {
                Logger.getLogger(PopUpp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
        }
        
    }//GEN-LAST:event_useCardCPUActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopUpp().setVisible(true);
            }
        });
    }
    
    public void wildCardPickColor(){
    
     ColorChosenCallback callback = (declaredColor) -> {
            if (declaredColor != null) {
                try {
                    game.submitPlayerCard(game.getCurrentPlayer(), playerHand.get(choice), declaredColor);
                    this.revalidate();
                    juegoCPU.setPidName(game.getCurrentPlayer());
                    juegoCPU.setButtonIcons();
                    topCardButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + game.getTopCardImage()));
                    this.setVisible(false);

                    logicaCPU logicaCPU = new logicaCPU(game.getPlayerHand(game.jugadores.get(1)), this.game, this.juegoCPU);
                    logicaCPU.cpuJuegaCarta(declaredColor);

                } catch (InvalidColorSubmissionExcpetion | InvalidValueSubmissionException | InvalidPlayerTurnException ex) {
                    Logger.getLogger(PopUpp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        PickColorFramee pickColor = new PickColorFramee(this, true, callback);
        declaredColor = pickColor.choseColor(playerHand.get(choice));
    
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cardLabel;
    private javax.swing.JButton useCardButton;
    private javax.swing.JButton useCardCPU;
    // End of variables declaration//GEN-END:variables
}
