package GUI;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import Classes.Allotment;
import Tools.Allotment.AllotmentTools;
import java.awt.*;

public class CadastroLotes extends javax.swing.JFrame {
    String icon = "../Assets/icon.png";

    public CadastroLotes(boolean isTrue) {
        if (isTrue) {
            initComponents();
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(icon)));
        }

    }

    private void initComponents() {

        inputEndereco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        inputValor = new javax.swing.JTextField();
        inputArea = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setTitle("PROSS - Cadastro de lotes");

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
                .addGroup(layout.createSequentialGroup().addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputValor, javax.swing.GroupLayout.PREFERRED_SIZE, 142,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addComponent(jLabel3).addGap(0, 0,
                                        Short.MAX_VALUE))
                                .addComponent(inputArea, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                        .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton1,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inputEndereco, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputValor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputArea, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addContainerGap()));
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

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField inputEndereco;
    private javax.swing.JTextField inputValor;
    private javax.swing.JTextField inputArea;
    private JButton jButton1;
}
