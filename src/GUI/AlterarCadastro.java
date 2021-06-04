package GUI;

import java.util.List;

import javax.swing.JOptionPane;

import Classes.Allotment;
import Classes.Contact;
import Classes.Store;
import DAOs.AllotmentDAO;
import DAOs.ContactDAO;
import DAOs.StoreDAO;
import Tools.Allotment.AllotmentTools;

public class AlterarCadastro extends javax.swing.JFrame {
        String SalvarIcon = "../Assets/salvar.png";
        String ExcluirIcon = "../Assets/apagar.png";
        String plusIcon = "../Assets/plus.png";
        String cnpjPadrao;
        static int ID;
        String adress;

        public AlterarCadastro() {
                initComponents();
        }

        private void initComponents() {

                popupMenu1 = new java.awt.PopupMenu();
                popupMenu2 = new java.awt.PopupMenu();
                ComboBox = new javax.swing.JComboBox<>();
                inputNome = new javax.swing.JTextField();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                inputTelefone2 = new javax.swing.JTextField();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                inputTelefone1 = new javax.swing.JTextField();
                inputRes = new javax.swing.JTextField();
                inputEndereco = new javax.swing.JTextField();
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();
                inputEndereco1 = new javax.swing.JTextField();
                inputEndereco2 = new javax.swing.JTextField();
                jLabel11 = new javax.swing.JLabel();
                botaoAdcLote = new javax.swing.JButton();
                ComboBox2 = new javax.swing.JComboBox<>();
                jLabel12 = new javax.swing.JLabel();
                botaoApagar = new javax.swing.JButton();
                botaoSalvar = new javax.swing.JButton();
                inputCNPJ = new javax.swing.JTextField();
                inputEmail = new javax.swing.JTextField();

                popupMenu1.setLabel("popupMenu1");

                popupMenu2.setLabel("popupMenu2");

                int j = 0;
                List<Store> listStore = StoreDAO.getStores();
                int len = (listStore.size() > 0) ? listStore.size() : 1;
                String[] store = new String[listStore.size()];
                List<Contact> contacts = ContactDAO.getContacts();
                for (Store a : StoreDAO.getStores()) {
                        store[j] = a.getCNPJ();
                        j++;
                }

                inputEndereco.setEditable(false);
                inputEndereco1.setEditable(false);
                inputEndereco2.setEditable(false);
                ComboBox2.setEnabled(false);
                ComboBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                if (listStore.size() > 0) {
                                        for (int i = 0; i < store.length; i++) {
                                                if (ComboBox.getSelectedItem().equals(store[i])) {

                                                        cnpjPadrao = ComboBox.getSelectedItem().toString();
                                                        Store store = (Store) StoreDAO.getObject2(cnpjPadrao);
                                                        System.out.println(store.getId() + "teste");
                                                        ID = store.getId();
                                                        System.out.println(ID);
                                                        inputNome.setText(store.getFantasy_name());
                                                        inputCNPJ.setText(store.getCNPJ());
                                                        Contact contact = ContactDAO.getObject(ID);
                                                        inputRes.setText(contact.getResponsible());
                                                        inputEmail.setText(contact.getEmail());
                                                        if (contacts.get(i).getPhone_2() != null) {
                                                                inputTelefone2.setText(
                                                                                String.valueOf(contact.getPhone_2()));
                                                        }
                                                        inputTelefone1.setText(contact.getPhone_1());
                                                        Allotment allotment = AllotmentTools
                                                                        .getObject(store.getAllotment_address());
                                                        adress = allotment.getAddress();
                                                        inputEndereco.setText(allotment.getAddress());
                                                        inputEndereco1.setText(allotment.getArea());
                                                        inputEndereco2.setText(Double.toString(allotment.getRent()));

                                                }

                                        }
                                }

                        }
                });
                ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(store));
                jLabel1.setText("Nome");

                jLabel2.setText("CNPJ");

                jLabel3.setText("Responsavel");

                jLabel4.setText("Email");

                jLabel5.setText("Telefone*");

                jLabel6.setText("Telefone2");

                jLabel9.setText("Endereco");

                jLabel10.setText("Valor");

                inputEndereco1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                inputEndereco1ActionPerformed(evt);
                        }
                });

                jLabel11.setText("Area");

                botaoAdcLote.setIcon(new javax.swing.ImageIcon(getClass().getResource(plusIcon))); // NOI18N
                botaoAdcLote.setText("Adicionar Lote");

                ComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indisponivel" }));

                jLabel12.setText("Lotes");

                botaoApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource(ExcluirIcon))); // NOI18N
                botaoApagar.setText("Excluir");
                botaoApagar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                int num = JOptionPane.showConfirmDialog(null, "Deseja relamente apagar?");
                                boolean confirm = (num == 0) ? true : false;
                                if (confirm) {
                                        ContactDAO.deleteContact(ID);
                                        StoreDAO.deleteStore(ID);
                                        Allotment allotment = AllotmentDAO.getObject(adress);
                                        allotment.setAvailable(true);
                                        allotment.setStore_id("NULL");
                                        AllotmentDAO.updateAllotment(allotment);
                                        dispose();
                                }

                        }
                });

                botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource(SalvarIcon))); // NOI18N
                botaoSalvar.setText("Salvar");
                botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                if (listStore.size() != 0) {
                                        System.out.println(cnpjPadrao);
                                        Store store = new Store(inputNome.getText(), inputCNPJ.getText());
                                        System.out.println(store.getCNPJ());
                                        StoreDAO.updateStore(store, cnpjPadrao);
                                        Contact contact = new Contact(inputRes.getText(), inputEmail.getText(),
                                                        inputTelefone1.getText());
                                        contact.setContact_id(ID);
                                        contact.setPhone_2(inputTelefone2.getText());
                                        ContactDAO.updateContact(contact);
                                        dispose();

                                }

                        }
                });
                inputCNPJ.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                inputCNPJActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGap(0,
                                                                0, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup().addGroup(layout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(ComboBox, 0,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(ComboBox2, 0,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createSequentialGroup().addGroup(layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(botaoAdcLote)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(botaoSalvar)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(botaoApagar))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(inputEndereco1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                77,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel9))
                                                                                                .addGap(12, 12, 12)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(inputEndereco,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                77,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel10))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel11)
                                                                                                                .addComponent(inputEndereco2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                77,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addComponent(jLabel12)
                                                                                .addComponent(jLabel8)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(inputRes,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                210,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(inputNome,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                210,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addComponent(jLabel3))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel4)
                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                                .addComponent(inputCNPJ,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                210,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(inputEmail))
                                                                                                                .addComponent(jLabel2)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(inputTelefone1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                114,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel5))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel6)
                                                                                                                .addComponent(inputTelefone2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                114,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addContainerGap()))));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup().addContainerGap()
                                                .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel2).addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(inputNome,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(inputCNPJ,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(4, 4, 4)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel3).addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(inputRes,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(inputEmail,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel5).addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(inputTelefone2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(inputTelefone1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel9,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                16,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel10).addComponent(jLabel11))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(inputEndereco1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(inputEndereco,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(inputEndereco2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(43, 43, 43).addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(botaoAdcLote,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(botaoSalvar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(botaoApagar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))));

                pack();
        }// </editor-fold>

        private void inputEndereco1ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void botaoApagarActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void inputCNPJActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        /**
         * @param args the command line arguments
         */
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
                        java.util.logging.Logger.getLogger(AlterarCadastro.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(AlterarCadastro.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(AlterarCadastro.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(AlterarCadastro.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new AlterarCadastro().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify
        private javax.swing.JComboBox<String> ComboBox;
        private javax.swing.JComboBox<String> ComboBox2;
        private javax.swing.JButton botaoAdcLote;
        private javax.swing.JButton botaoApagar;
        private javax.swing.JButton botaoSalvar;
        private javax.swing.JTextField inputRes;
        private javax.swing.JTextField inputEmail;
        private javax.swing.JTextField inputEndereco;
        private javax.swing.JTextField inputEndereco1;
        private javax.swing.JTextField inputEndereco2;
        private javax.swing.JTextField inputNome;
        private javax.swing.JTextField inputCNPJ;
        private javax.swing.JTextField inputTelefone2;
        private javax.swing.JTextField inputTelefone1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private java.awt.PopupMenu popupMenu1;
        private java.awt.PopupMenu popupMenu2;
        // End of variables declaration
}
