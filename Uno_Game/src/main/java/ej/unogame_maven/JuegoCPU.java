package ej.unogame_maven;

import ej.unogame_maven.Game.InvalidPlayerTurnException;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class JuegoCPU extends javax.swing.JFrame {

    public String playerName;

    Game game;

    ArrayList<JButton> cardButtons = new ArrayList<JButton>();
    ArrayList<String> cardIds;
    PopUpp window;

    logicaCPU logicaCPU;

    public JuegoCPU() {
        initComponents();
    }

    public JuegoCPU(String playerName) {
        //this.setUndecorated(true);
        initComponents();
        this.playerName = playerName;
        game = new Game(playerName, this, topCardButton);
        populateArrayList();
        game.startCPU(game);
        setPidName();
        topCardButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + game.getTopCardImage()));
        setButtonIcons();
        
       String[] a = game.getPidsList();
       
       /////////////////////////////DELETE////////////////////////////////////////
        
        for (String string : a) {
            System.out.println(string);
        }
        
        System.out.println(game.getCurrentPlayer());
        System.out.println(game.getJugador());
        System.out.println(game.getCplayer());
        
        //////////////////////////////////////////////////////////////////////////  
    }

    public void setButtonIcons() {
        String listString = game.getPlayerHand(game.getCurrentPlayer()).stream().map(Object::toString).collect(Collectors.joining(","));
        String[] cardNames = listString.split(",");
        cardIds = new ArrayList<>(Arrays.asList(cardNames));
        for (int i = 0; i < cardIds.size(); i++) {
            cardButtons.get(i).setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + cardIds.get(i).toString() + ".png"));
        }

        for (int i = cardIds.size(); i < cardButtons.size(); i++) {
            cardButtons.get(i).setIcon(null);
        }

        for (JButton cardButton : cardButtons) {
            cardButton.setVisible(true);
           // cardButton.setEnabled(false);
            if (cardButton.getIcon() == null) {
                cardButton.setVisible(false);
            }
        }   
    }

    public void populateArrayList() {
        cardButtons.add(jButton1);
        cardButtons.add(jButton2);
        cardButtons.add(jButton3);
        cardButtons.add(jButton4);
        cardButtons.add(jButton5);
        cardButtons.add(jButton6);
        cardButtons.add(jButton7);
        cardButtons.add(jButton8);
        cardButtons.add(jButton9);
        cardButtons.add(jButton10);
        cardButtons.add(jButton11);
        cardButtons.add(jButton12);
        cardButtons.add(jButton13);
        cardButtons.add(jButton14);
    }

    public void habilitadorDeButtons(boolean estado){
    
        for (JButton cardButton : cardButtons) {
            cardButton.setEnabled(estado);
            
        }
    this.revalidate();
    }
    
    public void setTopCardButtonIcon() {
        this.topCardButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + game.getTopCardImage()));
    }

    public void setPidName() {
        String currentPlayer = game.getJugador();
        labelNombre.setText("Cartas de " + currentPlayer);
    }

    public void setPidName(String currentPlayer) {
        labelNombre.setText("Cartas de " + currentPlayer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        downCard = new javax.swing.JButton();
        topCardButton = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        downCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/Card_Back.png"))); // NOI18N
        downCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downCardActionPerformed(evt);
            }
        });

        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addComponent(downCard, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(topCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(downCard, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (cardIds.get(9) != null) {
            int index = 9;
            String cardId = cardIds.get(9);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (cardIds.get(10) != null) {
            int index = 10;
            String cardId = cardIds.get(10);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (cardIds.get(0) != null) {
            int index = 0;
            String cardId = cardIds.get(0);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (cardIds.get(11) != null) {
            int index = 11;
            String cardId = cardIds.get(11);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (cardIds.get(1) != null) {
            int index = 1;
            String cardId = cardIds.get(1);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (cardIds.get(12) != null) {
            int index = 12;
            String cardId = cardIds.get(12);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (cardIds.get(2) != null) {
            int index = 2;
            String cardId = cardIds.get(2);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (cardIds.get(13) != null) {
            int index = 13;
            String cardId = cardIds.get(13);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (cardIds.get(3) != null) {
            int index = 3;
            String cardId = cardIds.get(3);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (cardIds.get(4) != null) {
            int index = 4;
            String cardId = cardIds.get(4);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (cardIds.get(5) != null) {
            int index = 5;
            String cardId = cardIds.get(5);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (cardIds.get(6) != null) {
            int index = 6;
            String cardId = cardIds.get(6);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (cardIds.get(7) != null) {
            int index = 7;
            String cardId = cardIds.get(7);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (cardIds.get(8) != null) {
            int index = 8;
            String cardId = cardIds.get(8);
            window = new PopUpp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750, 40, 700, 800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void downCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downCardActionPerformed
        JLabel message = new JLabel(game.getCurrentPlayer() + " levanto una carta!");
        message.setFont(new Font("Arial", Font.BOLD, 48));
        JOptionPane.showMessageDialog(null, message);

        try {
            game.submitDraw(game.getCurrentPlayer());
        } catch (InvalidPlayerTurnException ex) {
            Logger.getLogger(GameStagee.class.getName()).log(Level.SEVERE, null, ex);
        }

       

        //==============================================================================================
        habilitadorDeButtons(false);
        game.instanciaCPU();     
    }//GEN-LAST:event_downCardActionPerformed

   
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
            java.util.logging.Logger.getLogger(JuegoCPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoCPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoCPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoCPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoCPU().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton downCard;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JButton topCardButton;
    // End of variables declaration//GEN-END:variables
}
