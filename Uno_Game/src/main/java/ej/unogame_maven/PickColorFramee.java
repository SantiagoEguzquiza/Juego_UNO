package ej.unogame_maven;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PickColorFramee extends javax.swing.JFrame {

    private UnoCard.Color wildColor = null;
    private Boolean allow = false;
    private PopUpp popUp;
    private Boolean tipoJuego;
    private ColorChosenCallback callback;

    public PickColorFramee() {
        initComponents();
    }

    public PickColorFramee(PopUpp pop, boolean tipoJuego) {
        initComponents();
        popUp = pop;
        this.tipoJuego = tipoJuego;
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
     public PickColorFramee(PopUpp pop, boolean tipoJuego, ColorChosenCallback callback) {
         
         
        initComponents();  
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        popUp = pop;
        this.tipoJuego = tipoJuego;
        this.callback = callback;
    }

    public UnoCard.Color choseColor(UnoCard card) {
        if (card.getColor() == UnoCard.Color.Wild) {
            this.setVisible(true);
            this.setResizable(false);
            this.setBounds(100, 150, 600, 700);
        }
        return card.getColor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        redButton = new javax.swing.JButton();
        blueButton = new javax.swing.JButton();
        greenButton = new javax.swing.JButton();
        yellowButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        jLabel1.setText("Elige el color de tu carta");

        cancelButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        redButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        redButton.setText("Rojo");
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });

        blueButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        blueButton.setText("Azul");
        blueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueButtonActionPerformed(evt);
            }
        });

        greenButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        greenButton.setText("Verde");
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });

        yellowButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        yellowButton1.setText("Amarillo");
        yellowButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yellowButton1)
                    .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yellowButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(cancelButton)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButtonActionPerformed
        wildColor = UnoCard.Color.Red;
//        JLabel message = new JLabel("El color es rojo");
//        message.setFont(new Font("Arial", Font.BOLD, 24));
//        JOptionPane.showMessageDialog(null, message);
        allow = true;
        this.dispose();
        popUp.declaredColor = UnoCard.Color.Red;

        if (tipoJuego) {
            popUp.juegoCPU.setPidName(popUp.game.getJugador());
            popUp.juegoCPU.setButtonIcons();
            callback.colorChosen(UnoCard.Color.Red);
        } else {
            popUp.gameStage.setPidName(popUp.game.getCurrentPlayer());
            popUp.gameStage.setButtonIcons();
        }

        popUp.topCardButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + popUp.game.getTopCardImage()));
        popUp.game.setCardColor(UnoCard.Color.Red);
       
        popUp.dispose();
    }//GEN-LAST:event_redButtonActionPerformed

    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueButtonActionPerformed
        wildColor = UnoCard.Color.Blue;
//        JLabel message = new JLabel("El color es azul");
//        message.setFont(new Font("Arial", Font.BOLD, 24));
//        JOptionPane.showMessageDialog(null, message);
        allow = true;
        this.dispose();
        popUp.declaredColor = UnoCard.Color.Blue;
       
        
        if (tipoJuego) {
            popUp.juegoCPU.setPidName(popUp.game.getJugador());
            popUp.juegoCPU.setButtonIcons();
            callback.colorChosen(UnoCard.Color.Blue);
        } else {
            popUp.gameStage.setPidName(popUp.game.getCurrentPlayer());
            popUp.gameStage.setButtonIcons();
        }

        popUp.topCardButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + popUp.game.getTopCardImage()));
        popUp.game.setCardColor(UnoCard.Color.Blue);
        popUp.dispose();
    }//GEN-LAST:event_blueButtonActionPerformed

    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenButtonActionPerformed
        wildColor = UnoCard.Color.Green;
//        JLabel message = new JLabel("El color es verde");
//        message.setFont(new Font("Arial", Font.BOLD, 24));
//        JOptionPane.showMessageDialog(null, message);
        allow = true;
        this.dispose();
        popUp.declaredColor = UnoCard.Color.Green;
        
        
        if (tipoJuego) {
            popUp.juegoCPU.setPidName(popUp.game.getJugador());
            popUp.juegoCPU.setButtonIcons();
            callback.colorChosen(UnoCard.Color.Green);
        } else {
            popUp.gameStage.setPidName(popUp.game.getCurrentPlayer());
            popUp.gameStage.setButtonIcons();
        }

        popUp.topCardButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + popUp.game.getTopCardImage()));
        popUp.game.setCardColor(UnoCard.Color.Green);
        popUp.dispose();
    }//GEN-LAST:event_greenButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void yellowButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yellowButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yellowButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PickColorFramee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blueButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton greenButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton redButton;
    private javax.swing.JButton yellowButton1;
    // End of variables declaration//GEN-END:variables
}
