package ej.unogame_maven;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AddPlayersNamess extends javax.swing.JFrame {

    public ArrayList<String> playerIds;
    public boolean cpu = false;

    public AddPlayersNamess() {
        //this.setUndecorated(true);
        initComponents();
        playerIds = new ArrayList<>();
    }

    public AddPlayersNamess(boolean cpu) {
       // this.setUndecorated(true);
        initComponents();
        this.cpu = cpu;
        btnGuardar.setVisible(false); //ocultamos boton guardar xq solo hay un player
    }

    public String[] getPids() {
        String[] pIds = playerIds.toArray(new String[playerIds.size()]);
        return pIds;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        textFieldNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnHecho = new javax.swing.JButton();
        labelPidOne = new javax.swing.JLabel();
        labelPidTwo = new javax.swing.JLabel();
        labelPidThree = new javax.swing.JLabel();
        labelPidFour = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitulo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        labelTitulo.setText("Agregue nombre de los jugadores");

        labelNombre.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        labelNombre.setText("Nombre del jugador:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnHecho.setText("Hecho");
        btnHecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHechoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHecho, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelNombre)
                        .addGap(48, 48, 48)
                        .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelPidOne, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(labelPidTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPidThree, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPidFour, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(textFieldNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPidOne, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPidThree, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPidTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPidFour, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHecho, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHechoActionPerformed

        if (cpu == false) {
            if (playerIds.size() == 1 || playerIds.size() == 0) {
                JLabel message = new JLabel("Deben haber al menos 2 jugadores");
                message.setFont(new Font("Arial", Font.BOLD, 24));
                JOptionPane.showMessageDialog(null, message);
            } else {

                new GameStagee(playerIds).setVisible(true);
                this.dispose();
            }
        } else {

            if (textFieldNombre.getText().isEmpty()) {

                JLabel message = new JLabel("Debe ingresar un nombre");
                message.setFont(new Font("Arial", Font.BOLD, 24));
                JOptionPane.showMessageDialog(null, message);

            } else {
                String nombre = textFieldNombre.getText();
                new JuegoCPU(nombre).setVisible(true);
                
                this.dispose();
            }

        }
    }//GEN-LAST:event_btnHechoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (textFieldNombre.getText().isEmpty()) {
            JLabel message = new JLabel("Ingrese un nombre");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
        } else {
            String name = textFieldNombre.getText().trim();
            playerIds.add(name);

            if (playerIds.size() == 1) {
                labelPidOne.setText(playerIds.get(0));
            } else if (playerIds.size() == 2) {
                labelPidOne.setText(playerIds.get(0));
                labelPidTwo.setText(playerIds.get(1));
            } else if (playerIds.size() == 3) {
                labelPidOne.setText(playerIds.get(0));
                labelPidTwo.setText(playerIds.get(1));
                labelPidThree.setText(playerIds.get(2));
            } else if (playerIds.size() == 4) {
                labelPidOne.setText(playerIds.get(0));
                labelPidTwo.setText(playerIds.get(1));
                labelPidThree.setText(playerIds.get(2));
                labelPidFour.setText(playerIds.get(3));
            }

            if (playerIds.size() > 0 && playerIds.size() < 5) {
                JLabel message = new JLabel("Guardado correctamente");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                textFieldNombre.setText("");
            }

            if (playerIds.size() == 5) {
                playerIds.remove(name);
                JLabel message = new JLabel("Pueden jugar hasta 4 jugadores");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                textFieldNombre.setText("");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(AddPlayersNamess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPlayersNamess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPlayersNamess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPlayersNamess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPlayersNamess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHecho;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPidFour;
    private javax.swing.JLabel labelPidOne;
    private javax.swing.JLabel labelPidThree;
    private javax.swing.JLabel labelPidTwo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textFieldNombre;
    // End of variables declaration//GEN-END:variables
}
