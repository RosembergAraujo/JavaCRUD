package GUI;

import Classes.Allotment;
import Classes.Contact;
import Classes.Store;
import Tools.Store.StoreTools;
import java.awt.*;
import java.util.List;
public class Consulta extends javax.swing.JFrame {
    String allotmentIcon = "../Assets/allotment_icon.png";
    String atualizeIcon = "../Assets/atualize.png";
    String plusIcon = "../Assets/plus.png";
    String refreshIcon = "../Assets/refresh_icon.png";
    String searchIcon = "../Assets/search.png";
    String prossIcon = "../Assets/LOGO.png";
    String icon = "../Assets/icon.png";
    String detalhesIcon ="../Assets/detalhes.png";
    String value;
    public Consulta(boolean isTrue) {
        if (isTrue) {
            initComponents();
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(icon)));
        }

    }
    static String[] array = { "Loja", "CNPJ", "Lote", "Email", "Telefone*", "Telefone", "aluguel", "Tamanho" };

    public static void Result(String res, int re, int index) {
        int pos = 0;
        Object[][] resultadoLista = new Object[re][8];

        for (int i = 0; i < Pesquisar.getLeng(); i++) {
            if (Pesquisar.getTable()[i][index].equals(res)) {
                resultadoLista[pos][0] = Pesquisar.getTable()[i][0];
                resultadoLista[pos][1] = Pesquisar.getTable()[i][1];
                resultadoLista[pos][2] = Pesquisar.getTable()[i][2];
                resultadoLista[pos][3] = Pesquisar.getTable()[i][3];
                resultadoLista[pos][4] = Pesquisar.getTable()[i][4];
                resultadoLista[pos][5] = Pesquisar.getTable()[i][5];
                resultadoLista[pos][6] = Pesquisar.getTable()[i][6];
                resultadoLista[pos][7] = Pesquisar.getTable()[i][7];
                pos++;
            }
        }
        jTable1 = new javax.swing.JTable(resultadoLista, array);
        jScrollPane1.setViewportView(jTable1);
    }


    public static void att() {
        int len = StoreTools.getStores().size();
        Object[][] tableList = new Object[len][8];
        int i = 0;
        Pesquisar.setLeng(len);
        for (Store c : StoreTools.getStores()) {

            Contact contact = c.getContact();
            Allotment allotment = c.getAllotment();

            tableList[i][0] = c.getFantasy_name().toUpperCase();
            tableList[i][1] = c.getCNPJ().toUpperCase();
            tableList[i][2] = c.getAllotment_address().toUpperCase();
            tableList[i][3] = contact.getEmail().toUpperCase();
            tableList[i][4] = contact.getPhone_1().toUpperCase();
            tableList[i][5] = contact.getPhone_2();
            tableList[i][6] = allotment.getRent();
            tableList[i][7] = allotment.getArea().toUpperCase();
            i++;
        }
        Pesquisar.setTable(tableList);
        jTable1 = new javax.swing.JTable(tableList, array);
        jScrollPane1.setViewportView(jTable1);

    } 

    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
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
        botaoDetalhes = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        botaoSuporte = new javax.swing.JMenu();

        att();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROSS - Consulta");
        String[] list = { "CNPJ", "Lote", "Loja" };
        botaoPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource(searchIcon)));
        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int re = 0;
                if (inputPesquisarText.getText().length() == 0) {
                    att();
                } else {
                    int index = 0;
                    if (jComboBox1.getSelectedItem().toString().equals("CNPJ")) {
                        index = 1;
                    } else if (jComboBox1.getSelectedItem().toString().equals("Lote")) {
                        index = 2;
                    } else if (jComboBox1.getSelectedItem().toString().equals("Loja")) {
                        index = 0;
                    }
                    for (int j = 0; j < Pesquisar.getLeng(); j++) {
                        if (Pesquisar.getTable()[j][index].equals(inputPesquisarText.getText().toUpperCase())) {
                            re++;
                        }
                    }
                    Result(inputPesquisarText.getText().toUpperCase(), re, index);
                }
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(list));
        botaoCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource(plusIcon))); // NOI18N
        botaoCadastro.setText("Cadastrar");
        botaoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastroActionPerformed(evt);
            }
        });
        botaoCadastroDeLote.setIcon(new javax.swing.ImageIcon(getClass().getResource(allotmentIcon))); // NOI18N
        botaoCadastroDeLote.setText("Cadastrar Lote");
        botaoCadastroDeLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastroDeLoteActionPerformed(evt);
            }
        });
        botaoAlterarCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource(refreshIcon)));

        botaoAlterarCadastro.setText("Alterar Cadastro");

        botaoAlterarCadastro1.setIcon(new javax.swing.ImageIcon(getClass().getResource(refreshIcon))); // NOI18N
        botaoAlterarCadastro1.setText("Alterar Lotes");
        botaoAlterarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new AltCadastro(true).setVisible(true);
            }
        });

        botaoAtualizarTable.setIcon(new javax.swing.ImageIcon(getClass().getResource(atualizeIcon))); // NOI18N
        botaoAtualizarTable.setText("Atualizar");
        botaoAtualizarTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                att();
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row  = jTable1.getSelectedRow();
                botaoDetalhes.setEnabled(true);
                
                
                value = String.valueOf(jTable1.getModel().getValueAt(row, 0));
                
                
            }
        });
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource(prossIcon))); // NOI18N
        botaoDetalhes.setEnabled(false);
        botaoDetalhes.setIcon(new javax.swing.ImageIcon(getClass().getResource(detalhesIcon))); // NOI18N
        botaoDetalhes.setText("Detalhes");
        botaoDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                List<Object> list = StoreTools.getWithName("id", "fantasy_name", value);
                new Visualizar((int)list.get(0), true).setVisible(true);
            }
        });
        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);
        botaoSuporte.setText("Suporte");
        jMenuBar1.add(botaoSuporte);
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                        .createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                                .createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(botaoCadastro, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botaoAlterarCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 191,
                                                Short.MAX_VALUE)
                                        .addComponent(botaoAlterarCadastro1, javax.swing.GroupLayout.DEFAULT_SIZE, 191,
                                                Short.MAX_VALUE)
                                        .addComponent(botaoCadastroDeLote, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 657,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputPesquisarText, javax.swing.GroupLayout.PREFERRED_SIZE, 477,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botaoPesquisar))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE).addComponent(botaoAtualizarTable)))
                .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap().addGroup(layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inputPesquisarText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botaoPesquisar).addComponent(jComboBox1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        652, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoCadastroDeLote, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoPesquisar))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAtualizarTable)
                    .addComponent(botaoDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }                        
    private void botaoCadastroDeLoteActionPerformed(java.awt.event.ActionEvent evt) {
        new CadastroLotes(true).setVisible(true);
    }

    private void botaoCadastroActionPerformed(java.awt.event.ActionEvent evt) {
        new Cadastro(true).setVisible(true);
    }

    private javax.swing.JButton botaoAlterarCadastro;
    private javax.swing.JButton botaoAlterarCadastro1;
    private javax.swing.JButton botaoAtualizarTable;
    private javax.swing.JButton botaoDetalhes;
    private javax.swing.JButton botaoCadastro;
    private javax.swing.JButton botaoCadastroDeLote;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JMenu botaoSuporte;
    private javax.swing.JTextField inputPesquisarText;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private javax.swing.JLabel logo;                  

}
