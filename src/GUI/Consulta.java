package GUI;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Classes.Allotment;
import Classes.Contact;
import Classes.Store;
import Tools.Store.StoreTools;
public class Consulta extends javax.swing.JFrame {


    public Consulta() {
        initComponents();
    }
    public void att() {
        String[] array = { "Loja", "CNPJ", "Lote", "Email", "Telefone*", "Telefone", "aluguel", "Tamanho"};
        
        int len = StoreTools.getStores().size() ;
        Object[][] tableList = new Object[len][8];
        int i = 0;

        for (Store c : StoreTools.getStores()) {

            Contact contact = c.getContact();
            Allotment allotment = c.getAllotment();

            tableList[i][0] = c.getFantasy_name();
            tableList[i][1] = c.getCNPJ();
            tableList[i][2] = c.getAllotment_address();
            tableList[i][3] = contact.getEmail();
            tableList[i][4] = contact.getPhone_1();
            tableList[i][5] = contact.getPhone_2();
            tableList[i][6] = allotment.getRent();
            tableList[i][7] = allotment.getArea();
            i++;
        }

        jTable1 = new javax.swing.JTable(tableList, array);
        jScrollPane1.setViewportView(jTable1);
        
        System.out.println(
                "teste"
            );
    }

                     
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        inputPesquisarText = new javax.swing.JTextField();
        botaoPesquisar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        botaoCadastro = new javax.swing.JButton();
        botaoCadastroDeLote = new javax.swing.JButton();
        botaoAlterarCadastro = new javax.swing.JButton();
        botaoAlterarCadastro1 = new javax.swing.JButton();
        botaoAtualizarTable = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        botaoSuporte = new javax.swing.JMenu();

        jRadioButton1.setText("jRadioButton1");

        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        att();
        botaoPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("./search-magnifier.png")));
        botaoPesquisar.setText("Pesquisar");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CNPJ"}));

        botaoCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("./mais.png"))); // NOI18N
        botaoCadastro.setText("Cadastrar");
        botaoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastroActionPerformed(evt);
            }
        });
        botaoCadastroDeLote.setIcon(new javax.swing.ImageIcon(getClass().getResource("./terrain_icon_144084.png"))); // NOI18N
        botaoCadastroDeLote.setText("Cadastrar Lote");
        botaoCadastroDeLote.setToolTipText("");
        botaoCadastroDeLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastroDeLoteActionPerformed(evt);
            }
        });

        botaoAlterarCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("./twocirclingarrows1_120592.png"))); // NOI18N
        botaoAlterarCadastro.setText("Alterar Cadastro");

        botaoAlterarCadastro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("./twocirclingarrows1_120592.png"))); // NOI18N
        botaoAlterarCadastro1.setText("Alterar Lotes");
        botaoAlterarCadastro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        botaoAtualizarTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("./atualizar.png"))); // NOI18N
        botaoAtualizarTable.setText("Atualizar");
        botaoAtualizarTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                att();
            }
        });
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("./apple-touch-icon-120x120.png"))); // NOI18N
        logo.setText("jLabel1");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        botaoSuporte.setText("Suporte");
        jMenuBar1.add(botaoSuporte);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botaoAlterarCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                    .addComponent(botaoAlterarCadastro1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                    .addComponent(botaoCadastroDeLote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputPesquisarText, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoPesquisar))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoAtualizarTable)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputPesquisarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoPesquisar)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCadastroDeLote, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoAlterarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoAlterarCadastro1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoAtualizarTable))
        );

        pack();
    }// </editor-fold>                        

    private void botaoCadastroDeLoteActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        CadastrarLotes screenCadastro = new CadastrarLotes();
        screenCadastro.setVisible(true);
    }
    private void botaoCadastroActionPerformed(java.awt.event.ActionEvent evt){
        Cadastro cadastro = new Cadastro();
        cadastro.setVisible(true);
    }                                                 

    
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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoAlterarCadastro;
    private javax.swing.JButton botaoAlterarCadastro1;
    private javax.swing.JButton botaoAtualizarTable;
    private javax.swing.JButton botaoCadastro;
    private javax.swing.JButton botaoCadastroDeLote;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JMenu botaoSuporte;
    private javax.swing.JTextField inputPesquisarText;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel logo;
    // End of variables declaration                   
}
