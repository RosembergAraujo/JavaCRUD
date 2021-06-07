package GUI;

import java.util.List;

import javax.swing.*;

import Classes.Allotment;
import Classes.Contact;
import Classes.Store;
import Tools.Allotment.AllotmentTools;
import Tools.Contact.ContactTools;
import java.awt.*;
import Tools.Store.StoreTools;

public class Cadastro extends javax.swing.JFrame {
        String icon = "../Assets/icon.png";
        String plusIcon = "../Assets/plus.png";
        List<Object> addressList = AllotmentTools.getWithName("address", "available", "true");
        String[] address = new String[addressList.size()];
    
        public Cadastro(boolean isTrue) {
            if (isTrue) {
                initComponents();
                setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(icon)));
            }
    
        }
        
    private void habilitarInput(boolean IsTrue) {
        inputCNPJ.setEnabled(IsTrue);
        inputNomLoja.setEnabled(IsTrue);
        lotesComboBox2.setEnabled(IsTrue);
        inputRazaoSocial.setEnabled(IsTrue);
        comboBoxActivity.setEnabled(IsTrue);
        comboBoxModelo.setEnabled(IsTrue);
        inputVP.setEnabled(IsTrue);
        jTextPane1.setEnabled(IsTrue);
        
        if (addressList.get(0) == null) {
            lotesComboBox2.setEnabled(false);
        }

    }                        
        private void initComponents() {
    
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            inputTelefone2 = new javax.swing.JTextField();
            jLabel4 = new javax.swing.JLabel();
            cadastroLojaRadio = new javax.swing.JRadioButton();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jLabel7 = new javax.swing.JLabel();
            botaoAdicionar = new javax.swing.JButton();
            jSeparator1 = new javax.swing.JSeparator();
            inputEmail = new javax.swing.JTextField();
            inputTelefone3 = new javax.swing.JTextField();
            inputRazaoSocial = new javax.swing.JTextField();
            jLabel8 = new javax.swing.JLabel();
            lotesComboBox2 = new javax.swing.JComboBox<>();
            jLabel9 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            comboBoxModelo = new javax.swing.JComboBox<>();
            comboBoxActivity = new javax.swing.JComboBox<>();
            inputResponsavel = new javax.swing.JTextField();
            inputCNPJ = new javax.swing.JTextField();
            inputNomLoja = new javax.swing.JTextField();
            jRadioButton2 = new javax.swing.JRadioButton();
            inputVP = new javax.swing.JTextField();
            jLabel11 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTextPane1 = new javax.swing.JTextPane();
            jLabel12 = new javax.swing.JLabel();
            setTitle("PROSS - Cadastro");
    
            jLabel1.setText("Responsavel*");
    
            jLabel2.setText("Email*");
    
            jLabel3.setText("Telefone*");
    
            jLabel4.setText("Telefone 2");
    
            cadastroLojaRadio.setText("Adicionar Loja");
                
            jLabel5.setText("Lotes Disponiveis*");
    
            jLabel6.setText("Nome Fantasia*");
    
            jLabel7.setText("CNPJ*");
            
            habilitarInput(false);

            int i = 0;
            if (addressList.get(0) != null) {
                for (Object c : addressList) {
                    address[i] = c.toString().toUpperCase();
                    i++;
                }
                lotesComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(address));
            }
            botaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource(plusIcon))); // NOI18N
            botaoAdicionar.setText("Adicionar");
            botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (inputResponsavel.getText().length() > 0 && inputEmail.getText().length() > 0
                            && inputTelefone3.getText().length() > 0) {
                        if ((cadastroLojaRadio.isSelected() && inputCNPJ.getText().length() > 0
                                && inputNomLoja.getText().length() > 0) || !cadastroLojaRadio.isSelected()) {
                            jButton1ActionPerformed(evt);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhum campo pode ser vazio");
                        }
    
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum campo pode ser vazio");
                    }
    
                }
            });
    
            jLabel8.setText("Razao social*");
    
            lotesComboBox2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    lotesComboBoxActionPerformed(evt);
                }
            });
            cadastroLojaRadio.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton2.setSelected(false);
                    habilitarInput(cadastroLojaRadio.isSelected());
                }
            });
    
            jLabel9.setText("Atividade*");
    
            jLabel10.setText("Modelo*");
    
            comboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filial", "Franquia"}));
            comboBoxActivity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Serviços", "Comércio"}));
            jRadioButton2.setText("Adicionar Somente Loja");
    
            jLabel11.setText("Venda/Prestacao de servico de:");
    
            jScrollPane1.setViewportView(jTextPane1);
    
            jLabel12.setText("Observacao");
    
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputTelefone3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(inputTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cadastroLojaRadio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioButton2)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputRazaoSocial)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboBoxActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(comboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputNomLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(inputCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputVP, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lotesComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(botaoAdicionar)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel12)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputTelefone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cadastroLojaRadio)
                        .addComponent(jRadioButton2))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputNomLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10))
                    .addGap(4, 4, 4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxActivity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel5))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lotesComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel12)
                    .addGap(4, 4, 4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
    
            pack();
            setLocationRelativeTo(null);
        }                    
    
        private void lotesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {

        }
    
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
            Contact contact = new Contact(inputResponsavel.getText(), inputEmail.getText(), inputTelefone3.getText());
    
            if (inputTelefone2.getText().length() != 0) {
                contact.setPhone_2(inputTelefone2.getText());
            }
    
            ContactTools.createContact(contact);
    
            contact.setContact_id(ContactTools.getLastContactId());
            
            if (cadastroLojaRadio.isSelected()) {
                Store store = new Store(inputNomLoja.getText(), inputCNPJ.getText(), inputRazaoSocial.getText(),
                comboBoxActivity.getSelectedItem().toString(), comboBoxModelo.getSelectedItem().toString(), jTextPane1.getText(), inputVP.getText());
                
                String allotmentAddress = lotesComboBox2.getSelectedItem().toString();
                Allotment allotment = AllotmentTools.getObject(allotmentAddress);
                store.setAllotment(allotment);
                store.setContact_id(contact.getContact_id());
                store.setContact(contact);
    
                StoreTools.createStore(store);
    
                store.setId(StoreTools.getLastStoreId());
    
                allotment.setStore_id(store.getId());
                allotment.setAvailable(false);
    
                AllotmentTools.updateAllotment(allotment);
            }
            dispose();
            Consulta.att();
        }                                  

                 
        private javax.swing.JButton botaoAdicionar;
        private javax.swing.JComboBox<String> comboBoxActivity;
        private javax.swing.JTextField inputCNPJ;
        private javax.swing.JTextField inputEmail;
        private javax.swing.JComboBox<String> comboBoxModelo;
        private javax.swing.JTextField inputNomLoja;
        private javax.swing.JTextField inputRazaoSocial;
        private javax.swing.JTextField inputResponsavel;
        private javax.swing.JTextField inputTelefone2;
        private javax.swing.JTextField inputTelefone3;
        private javax.swing.JTextField inputVP;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JRadioButton cadastroLojaRadio;
        private javax.swing.JRadioButton jRadioButton2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JTextPane jTextPane1;
        private javax.swing.JComboBox<String> lotesComboBox2;                 
    }
    