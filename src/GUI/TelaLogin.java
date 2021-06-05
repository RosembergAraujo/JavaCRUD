package GUI;

import javax.swing.JOptionPane;
import DAOs.LoginDAO;
import java.awt.*;

public class TelaLogin extends javax.swing.JFrame {
    String icon = "../Assets/icon.png";

    public TelaLogin() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(icon)));
    }

    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        inputPassword = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        setSize(600, 1000);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROSS - Entrar no sistema");
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String pass = String.copyValueOf(inputPassword.getPassword());
                String user = jTextField1.getText();
                if (LoginDAO.getUser(user, pass)) {
                    Consulta consulta = new Consulta(true);
                    consulta.setVisible(true);
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto");
                }
            }
        });

        jLabel1.setText("Usuário");
        jLabel2.setText("Senha");
        jLabel3.setText("Redefinir senha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addComponent(jTextField1).addComponent(jLabel1).addComponent(jLabel2))
                        .addContainerGap(92, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3).addGap(93, 93, 93)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap(56, Short.MAX_VALUE).addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24).addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel3)
                        .addGap(22, 22, 22).addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)));

        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JTextField jTextField1;
}
