package GUI;

import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import Classes.Allotment;
import Classes.Contact;
import Classes.Store;
import DAOs.AllotmentDAO;
import DAOs.ContactDAO;
import DAOs.StoreDAO;
import Tools.Allotment.AllotmentTools;
import Tools.Store.StoreTools;
import java.awt.*;
public class AltCadastro extends javax.swing.JFrame {
        String SalvarIcon = "../Assets/salvar.png";
        String ExcluirIcon = "../Assets/apagar.png";
        String plusIcon = "../Assets/plus.png";
        String icon = "../Assets/icon.png";
        int storeID;
        static int ID;
        String address;
    
        public AltCadastro(boolean isTrue) {
            if(isTrue){
                initComponents();
                setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(icon)));
            }
            
        }
      
        protected JComponent jScrollPane1() {
                return null;
        }
        private void initComponents() {
    
            popupMenu1 = new java.awt.PopupMenu();
            popupMenu2 = new java.awt.PopupMenu();
            CheckBox = new javax.swing.JCheckBox();
            jProgressBar1 = new javax.swing.JProgressBar();
            jTextField8 = new javax.swing.JTextField();
            jSeparator7 = new javax.swing.JSeparator();
            jSeparator8 = new javax.swing.JSeparator();
            jSeparator9 = new javax.swing.JSeparator();
            popupMenu3 = new java.awt.PopupMenu();
            ComboBox = new javax.swing.JComboBox<>();
            jLabel8 = new javax.swing.JLabel();
            botaoAdcLote = new javax.swing.JButton();
            botaoApagar = new javax.swing.JButton();
            botaoSalvar = new javax.swing.JButton();
            inputPesquisar = new javax.swing.JTextField();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTable2 = new javax.swing.JTable();
            jSeparator1 = new javax.swing.JSeparator();
            CheckBoxPlus = new javax.swing.JCheckBox();
            botaoPesquisar = new javax.swing.JButton();
            inputEmail = new javax.swing.JTextField();
            jSeparator2 = new javax.swing.JSeparator();
            inputResponsavel = new javax.swing.JTextField();
            inputTelefone2 = new javax.swing.JTextField();
            inputTelefone = new javax.swing.JTextField();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jSeparator3 = new javax.swing.JSeparator();
            jLabel7 = new javax.swing.JLabel();
            jSeparator4 = new javax.swing.JSeparator();
            jLabel9 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            jSeparator5 = new javax.swing.JSeparator();
            jLabel11 = new javax.swing.JLabel();
            jSeparator6 = new javax.swing.JSeparator();
            inputArea = new javax.swing.JTextField();
            inputEndereco = new javax.swing.JTextField();
            inputAluguel = new javax.swing.JTextField();
            jLabel13 = new javax.swing.JLabel();
            jLabel14 = new javax.swing.JLabel();
            jLabel15 = new javax.swing.JLabel();
            jScrollPane2 = new javax.swing.JScrollPane();
            TextPane = new javax.swing.JTextPane();
            jLabel16 = new javax.swing.JLabel();
            jSeparator10 = new javax.swing.JSeparator();
            jLabel17 = new javax.swing.JLabel();
            ComboBoxServicos = new javax.swing.JComboBox<>();
            jLabel19 = new javax.swing.JLabel();
            inputRazaoSocial = new javax.swing.JTextField();
            inputCNPJ = new javax.swing.JTextField();
            inputNomeFantasia = new javax.swing.JTextField();
            inputVP = new javax.swing.JTextField();
            jLabel20 = new javax.swing.JLabel();
            jLabel21 = new javax.swing.JLabel();
            ComboBoxModelo = new javax.swing.JComboBox<>();
            ComboBoxLotes2 = new javax.swing.JComboBox<>();
    
            popupMenu1.setLabel("popupMenu1");
    
            popupMenu2.setLabel("popupMenu2");
            setTitle("PROSS - Editar Cadastro");
            inputAluguel.setEditable(false);
            inputArea.setEditable(false);
            inputEndereco.setEditable(false);
            List<Store> listStore = StoreDAO.getStores();
            String[] storee = new String[listStore.size()];
            List<Contact> contacts = ContactDAO.getContacts();
            CheckBox.setSelected(true);
            CheckBox.setText("CheckBox");
    
            jTextField8.setText("jTextField1");
    
            popupMenu3.setLabel("popupMenu3");
                
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    
            ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome Fantasia", "CNPJ", "Todos"}));
            ComboBox.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                        int j = 0;
                        if(ComboBox.getSelectedItem().toString() == "Nome Fantasia"){
                                for (Store a : StoreDAO.getStores()) {
                                        storee[j] = a.getFantasy_name().toUpperCase();
                                        j++;
                                    }
                        }
                        else{
                                for (Store a : StoreDAO.getStores()) {
                                        storee[j] = a.getCNPJ().toUpperCase();
                                        j++;
                                    }
                        }
                        
                }
            });
    
            botaoAdcLote.setIcon(new javax.swing.ImageIcon(getClass().getResource(plusIcon)));
            botaoAdcLote.setText("Adicionar Lote");
            
            botaoApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource(ExcluirIcon)));
            botaoApagar.setText("Excluir");
            botaoApagar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    int num = JOptionPane.showConfirmDialog(null, "Deseja relamente apagar?");
                    boolean confirm = (num == 0) ? true : false;
                    if (confirm) {
                        ContactDAO.deleteContact(ID);
                        StoreDAO.deleteStore(ID);
                        Allotment allotment = AllotmentDAO.getObject(address);
                        allotment.setAvailable(true);
                        allotment.setStore_id("NULL");
                        AllotmentDAO.updateAllotment(allotment);
                        dispose();
                    }
    
                }
            });
            botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource(SalvarIcon))); 
            botaoSalvar.setText("Salvar");
            botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (listStore.size() != 0) {
                        Store store = new Store(inputNomeFantasia.getText(), inputCNPJ.getText(), inputRazaoSocial.getText(),
                        ComboBoxServicos.getSelectedItem().toString(), ComboBoxModelo.getSelectedItem().toString(), TextPane.getText(), inputVP.getText());
                        StoreDAO.updateStore(store, storeID);
                        Contact contact = new Contact(inputResponsavel.getText(), inputEmail.getText(), inputTelefone.getText());
                        contact.setContact_id(ID);
                        contact.setPhone_2(inputTelefone2.getText());
                        ContactDAO.updateContact(contact);
                        dispose();
    
                    }
    
                }
            });
            
    
            jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };
    
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
           
            jScrollPane1.setViewportView(jTable2);
            CheckBoxPlus.setText("Visualizar todos");
           
    
            botaoPesquisar.setText("Pesquisar");
            botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (listStore.size() > 0) {
                        for (int i = 0; i < storee.length; i++) {
                            if (inputPesquisar.getText().equals(storee[i].toUpperCase())) {

                                storeID = (int) StoreTools.getWithName("id", ComboBox.getSelectedItem().toString(), inputPesquisar.getText()).get(0);
                                Store store = (Store) StoreDAO.getObject(storeID);
                                ID = store.getContact_id();
                                inputNomeFantasia.setText(store.getFantasy_name());
                                inputCNPJ.setText(store.getCNPJ());
                                TextPane.setText(store.getObsText());
                                inputRazaoSocial.setText(store.getSocial_reason());
                                ComboBoxServicos.setSelectedItem(store.getActivity());
                                ComboBoxModelo.setSelectedItem(store.getModel());
                                inputVP.setText(store.getSalesOrServiceProvision());
                                Contact contact = ContactDAO.getObject(ID);
                                inputResponsavel.setText(contact.getResponsible());
                                inputEmail.setText(contact.getEmail());
                                if (contacts.get(i).getPhone_2() != null) {
                                    inputTelefone2.setText(String.valueOf(contact.getPhone_2()));
                                }
                                inputTelefone.setText(contact.getPhone_1());
                                Allotment allotment = AllotmentTools.getObject(store.getAllotment_address());
                                address = allotment.getAddress();
                                inputEndereco.setText(allotment.getAddress());
                                inputArea.setText(allotment.getArea());
                                inputAluguel.setText(Double.toString(allotment.getRent()));
                                
    
                            }
    
                        }
                    }
    
                }
            });

            inputTelefone2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    inputTelefone2ActionPerformed(evt);
                }
            });


    
            jLabel1.setText("Responsavel*");
    
            jLabel2.setText("Email*");
    
            jLabel3.setText("Telefone*");
    
            jLabel4.setText("Telefone 2");
    
            jLabel5.setText("Dados de contato:");
    
            jLabel6.setText("Dados da loja:");
    
            jLabel7.setText("Razao social*");
    
            jLabel9.setText("CNPJ");
    
            jLabel10.setText("Lotes");
    
            jLabel11.setText("Dados do Lote veiculado ao cliente:");
    
            jLabel13.setText("Endereco");
    
            jLabel14.setText("Aluguel");
    
            jLabel15.setText("Area");
    
            jScrollPane2.setViewportView(TextPane);
    
            jLabel16.setText("Observação:");
    
            jLabel17.setText("Nome Fantasia*");
    
            ComboBoxServicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Serviços", "Comércio"}));
    
            jLabel19.setText("Atividade");
    
            jLabel20.setText("Vendas / Vendas de serviços");
    
            jLabel21.setText("Modelo");
    
            ComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filial", "Franquia"}));
    
            ComboBoxLotes2.setEnabled(false);
    
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(254, 254, 254)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator3)
                                .addComponent(jSeparator2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jSeparator5)
                                .addComponent(jSeparator6)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14)
                                    .addGap(93, 93, 93))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(inputNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputVP, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CheckBoxPlus)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(inputTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(inputPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(botaoPesquisar))
                                        .addComponent(jLabel16)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(inputRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(inputCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addGap(117, 117, 117)
                                            .addComponent(jLabel20))
                                        .addComponent(jLabel11)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ComboBoxLotes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(inputEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel13))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel15)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(inputArea, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(inputAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ComboBoxServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel19))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel21)
                                                .addComponent(ComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jSeparator10))))
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(botaoAdcLote)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(botaoSalvar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(botaoApagar)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoPesquisar))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(CheckBoxPlus)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inputRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel20)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(108, 108, 108)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inputNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(jLabel21))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboBoxServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13)
                        .addComponent(jLabel15))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboBoxLotes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel16)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoAdcLote, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
            );
    
            pack();
        }// </editor-fold>                        
    
        private void botaoApagarActionPerformed(java.awt.event.ActionEvent evt) {                                            
            // TODO add your handling code here:
        }                                           
    
        private void inputPesquisarActionPerformed(java.awt.event.ActionEvent evt) {                                               
            // TODO add your handling code here:
        }                                              
    
        private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                         
            // TODO add your handling code here:
        }                                        
    
        private void inputTelefone2ActionPerformed(java.awt.event.ActionEvent evt) {                                               
            // TODO add your handling code here:
        }                                              
    

                      
        private static javax.swing.JCheckBox CheckBoxPlus;
        private javax.swing.JComboBox<String> ComboBox;
        private javax.swing.JComboBox<String> ComboBoxLotes2;
        private javax.swing.JComboBox<String> ComboBoxModelo;
        private javax.swing.JComboBox<String> ComboBoxServicos;
        private javax.swing.JTextPane TextPane;
        private javax.swing.JButton botaoAdcLote;
        private javax.swing.JButton botaoApagar;
        private javax.swing.JButton botaoPesquisar;
        private javax.swing.JButton botaoSalvar;
        private javax.swing.JTextField inputAluguel;
        private javax.swing.JTextField inputArea;
        private javax.swing.JTextField inputEmail;
        private javax.swing.JTextField inputEndereco;
        private javax.swing.JTextField inputNomeFantasia;
        private javax.swing.JTextField inputPesquisar;
        private javax.swing.JTextField inputResponsavel;
        private javax.swing.JTextField inputTelefone;
        private javax.swing.JTextField inputTelefone2;
        private javax.swing.JCheckBox CheckBox;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel13;
        private javax.swing.JLabel jLabel14;
        private javax.swing.JLabel jLabel15;
        private javax.swing.JLabel jLabel16;
        private javax.swing.JLabel jLabel17;
        private javax.swing.JLabel jLabel19;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel20;
        private javax.swing.JLabel jLabel21;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JProgressBar jProgressBar1;
        private static javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JSeparator jSeparator10;
        private javax.swing.JSeparator jSeparator2;
        private javax.swing.JSeparator jSeparator3;
        private javax.swing.JSeparator jSeparator4;
        private javax.swing.JSeparator jSeparator5;
        private javax.swing.JSeparator jSeparator6;
        private javax.swing.JSeparator jSeparator7;
        private javax.swing.JSeparator jSeparator8;
        private javax.swing.JSeparator jSeparator9;
        private javax.swing.JTable jTable2;
        private javax.swing.JTextField inputRazaoSocial;
        private javax.swing.JTextField inputCNPJ;
        private javax.swing.JTextField inputVP;
        private javax.swing.JTextField jTextField8;
        private java.awt.PopupMenu popupMenu1;
        private java.awt.PopupMenu popupMenu2;
        private java.awt.PopupMenu popupMenu3;
        // End of variables declaration                   
    }
