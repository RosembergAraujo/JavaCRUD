package GUI;

import java.util.List;

import javax.swing.*;

import Classes.Allotment;
import Classes.Contact;
import Classes.Store;
import DAOs.AllotmentDAO;
import Tools.Allotment.AllotmentTools;
import Tools.Contact.ContactTools;
import Tools.Store.StoreTools;

public class Cadastro extends javax.swing.JFrame {

    public Cadastro() {
        initComponents();
    }

    private void habilitarInput(boolean IsTrue) {
        inputCNPJ.setEnabled(IsTrue);
        inputNomeLoja.setEnabled(IsTrue);
        lotesComboBox.setEnabled(IsTrue);
    }

    private void initComponents() {

        inputEmail = new javax.swing.JTextField();
        inputNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputTelefone1 = new javax.swing.JTextField();
        inputTelefone2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cadastroLojaRadio = new javax.swing.JRadioButton();
        inputNomeLoja = new javax.swing.JTextField();
        inputCNPJ = new javax.swing.JTextField();
        lotesComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        botaoAdicionar = new javax.swing.JButton();

        // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Responsavel*");

        jLabel2.setText("Email*");

        jLabel3.setText("Telefone*");

        jLabel4.setText("Telefone2");

        cadastroLojaRadio.setText("Adicionar Loja");

        habilitarInput(false);
        List<Object> addressList = AllotmentTools.getWithName("address", "available", "true");
        String[] address = new String[addressList.size()];
        int i = 0;
        for (Object c : addressList) {
            address[i] = c.toString();
            i++;
        }

        lotesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(address));
        lotesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lotesComboBoxActionPerformed(evt);
            }
        });
        cadastroLojaRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarInput(cadastroLojaRadio.isSelected());
            }
        });

        jLabel5.setText("Lotes Disponiveis*");

        jLabel6.setText("Nome Fantasia*");

        jLabel7.setText("CNPJ*");

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (inputNome.getText().length() > 0 && inputEmail.getText().length() > 0
                        && inputTelefone1.getText().length() > 0) {
                    if ((cadastroLojaRadio.isSelected() && inputCNPJ.getText().length() > 0
                            && inputNomeLoja.getText().length() > 0) || !cadastroLojaRadio.isSelected()) {
                        jButton1ActionPerformed(evt);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum campo pode ser vazio");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum campo pode ser vazio");
                }

            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 225,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cadastroLojaRadio).addComponent(jLabel6)
                                                .addComponent(inputNomeLoja, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(
                                                                        inputCNPJ,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 245,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel7))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel5).addComponent(lotesComboBox,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 206,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createSequentialGroup().addGap(12, 12, 12)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(inputEmail,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 237,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel2))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(inputTelefone1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 107,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel3))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel4).addComponent(inputTelefone2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 103,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
                        .addComponent(jLabel2).addComponent(jLabel3).addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cadastroLojaRadio)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5)
                        .addComponent(jLabel6).addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lotesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputNomeLoja, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap()));

        pack();
    }// </editor-fold>

    private void lotesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Contact contact = new Contact(inputNome.getText(), inputEmail.getText(), inputTelefone1.getText());
        contact.setContact_id(ContactTools.getLastContactId() + 1);
        contact.setPhone_2(inputTelefone2.getText());

        ContactTools.createContact(contact);

        if (cadastroLojaRadio.isSelected()) {
            Store store = new Store(inputNomeLoja.getText(), inputCNPJ.getText());

            store.setId(StoreTools.getLastStoreId() + 1);

            String allotmentAddress = lotesComboBox.getSelectedItem().toString();
            Allotment allotment = AllotmentTools.getObject(allotmentAddress);

            store.setAllotment(allotment);
            allotment.setStore_id(store.getId());
            allotment.setAvailable(false);

            store.setContact(contact);

            StoreTools.createStore(store);

            AllotmentTools.updateAllotment(allotment);
            Consulta.att();
        }
        dispose();
        Consulta.att();
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cadastro cadastro = new Cadastro();
                cadastro.setTitle("PROSS");
                cadastro.setVisible(true);
            }
        });
    }

    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JTextField inputCNPJ;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputNomeLoja;
    private javax.swing.JTextField inputTelefone1;
    private javax.swing.JTextField inputTelefone2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton cadastroLojaRadio;
    private javax.swing.JComboBox<String> lotesComboBox;

}
