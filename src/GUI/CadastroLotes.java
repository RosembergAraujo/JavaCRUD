package GUI;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import Classes.Allotment;
import Tools.Allotment.AllotmentTools;
import java.awt.*;

public class CadastroLotes extends javax.swing.JFrame {

        String icon = "../Assets/icon.png";
        String plusIcon = "../Assets/plus.png";

        public CadastroLotes(boolean isTrue) {
            if (isTrue) {
                initComponents();
                setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(icon)));
            }
    
        }

        private void initComponents() {
    
            inputEndereco = new javax.swing.JTextField();
            inputArea = new javax.swing.JTextField();
            inputValor = new javax.swing.JTextField();
            jButton1 = new javax.swing.JButton();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            setTitle("PROSS - Cadastro de lotes");    

            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    
            jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(plusIcon))); // NOI18N
            jButton1.setText("Adicionar");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });    
            jLabel1.setText("Endereco");
    
            jLabel2.setText("Area");
    
            jLabel3.setText("Aluguel");
    
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(inputEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(inputValor, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(inputArea, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(jButton1)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(4, 4, 4)
                    .addComponent(inputEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(jLabel2)
                    .addGap(1, 1, 1)
                    .addComponent(inputArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel3)
                    .addGap(1, 1, 1)
                    .addComponent(inputValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
    
            pack();
            setLocationRelativeTo(null);
        }                     
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
                if (inputArea.getText().length() > 0 && inputEndereco.getText().length() > 0
                        && inputValor.getText().length() > 0) {
                    Allotment allotment = new Allotment(inputEndereco.getText(), Double.parseDouble(inputValor.getText()),
                            inputArea.getText(), true);
                    if (AllotmentTools.getWithName("address", "address", "'" + allotment.getAddress() + "'").get(0) == null) {
                        AllotmentTools.createAllotment(allotment);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Endereço do lote já ocupado");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum campo pode ser vazio");
                }
        
            }                 
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JTextField inputEndereco;
        private javax.swing.JTextField inputArea;
        private javax.swing.JTextField inputValor;                 
    }
    
