package GUI;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Classes.Allotment;
import DAOs.AllotmentDAO;

public class CadastrarLotes extends javax.swing.JFrame {

        public CadastrarLotes() {
                initComponents();
        }

        private void initComponents() {

                inputEndereco = new javax.swing.JTextField();
                jLabel1 = new javax.swing.JLabel();
                jButton1 = new javax.swing.JButton();
                inputValor = new javax.swing.JTextField();
                inputArea = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setText("Endereco");

                jButton1.setText("Cadastrar");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jLabel2.setText("Valor");

                jLabel3.setText("Area");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(inputEndereco, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel1)).addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(inputValor,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                142,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel3)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                .addComponent(inputArea,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                114, Short.MAX_VALUE))
                                                .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(153, 153, 153)));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3))
                                                .addGap(4, 4, 4)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(inputEndereco,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(inputValor,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(inputArea,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 38,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        /**
         * @param args the command line arguments
         */
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
                if (inputArea.getText().length() > 0 && inputEndereco.getText().length() > 0
                                && inputValor.getText().length() > 0) {

                        Allotment allotment = new Allotment(inputEndereco.getText(),
                                        Double.parseDouble(inputValor.getText()), inputArea.getText(), true);
                        AllotmentDAO allotmentDAO = new AllotmentDAO();
                        allotmentDAO.createAllotment(allotment);
                        Consulta consulta = new Consulta();
                        dispose();
                } else {
                        JOptionPane.showMessageDialog(null, "Nenhum campo pode ser vazio");
                }
                // boolean addressAlreadyExists =
                // allotmentDAO.alreadyExists(textField1.getText());
                //// if(addressAlreadyExists){
                //
                // }
                // else{

                // }
        }

        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
                // (optional) ">
                /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel. For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(CadastrarLotes.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(CadastrarLotes.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(CadastrarLotes.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(CadastrarLotes.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new CadastrarLotes().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JTextField inputEndereco;
        private javax.swing.JTextField inputValor;
        private javax.swing.JTextField inputArea;
        private JButton jButton1;
        // End of variables declaration//GEN-END:variables
}
