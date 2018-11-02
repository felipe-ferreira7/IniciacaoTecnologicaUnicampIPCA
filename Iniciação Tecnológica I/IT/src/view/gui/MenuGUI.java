package view.gui;

import javax.swing.JButton;

public class MenuGUI extends javax.swing.JFrame {

    public MenuGUI() {
        initComponents();
    }

    public void sair() {
        this.dispose();
    }

    public JButton getBtnSair() {
        return btnSair;
    }

    public JButton getBtnConsultarVariacaoMensal() {
        return btnConsultarVariacaoMensal;
    }

    public JButton getBtnConsultarPrevisaoVariacao() {
        return btnConsultarPrevisaoVariacao;
    }

    public JButton getBtnSobreIPCA() {
        return btnSobreIPCA;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSobreIPCA = new javax.swing.JButton();
        btnConsultarPrevisaoVariacao = new javax.swing.JButton();
        btnConsultarVariacaoMensal = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Índice de Preços ao Consumidor Amplo");
        setResizable(false);
        getContentPane().setLayout(null);

        btnSobreIPCA.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnSobreIPCA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/sobre.png"))); // NOI18N
        btnSobreIPCA.setText("  Mais Informações sobre IPCA");
        btnSobreIPCA.setFocusable(false);
        btnSobreIPCA.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnSobreIPCA);
        btnSobreIPCA.setBounds(20, 340, 280, 50);

        btnConsultarPrevisaoVariacao.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnConsultarPrevisaoVariacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/previsao.png"))); // NOI18N
        btnConsultarPrevisaoVariacao.setText("Consultar Previsão de Variação");
        btnConsultarPrevisaoVariacao.setFocusable(false);
        btnConsultarPrevisaoVariacao.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnConsultarPrevisaoVariacao);
        btnConsultarPrevisaoVariacao.setBounds(20, 280, 280, 50);

        btnConsultarVariacaoMensal.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnConsultarVariacaoMensal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/variacao.png"))); // NOI18N
        btnConsultarVariacaoMensal.setText("   Consultar Históricos Mensais");
        btnConsultarVariacaoMensal.setFocusable(false);
        btnConsultarVariacaoMensal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnConsultarVariacaoMensal);
        btnConsultarVariacaoMensal.setBounds(20, 220, 280, 50);

        btnSair.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/sair_pequeno.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setFocusable(false);
        getContentPane().add(btnSair);
        btnSair.setBounds(510, 350, 100, 40);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setText("Índice de Preços ao Consumidor Amplo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 90, 320, 20);

        jLabel2.setFont(new java.awt.Font("Exotc350 DmBd BT", 0, 80)); // NOI18N
        jLabel2.setText("IPCA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 20, 320, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgs/financeiro.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 630, 410);

        setSize(new java.awt.Dimension(632, 437));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarPrevisaoVariacao;
    private javax.swing.JButton btnConsultarVariacaoMensal;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSobreIPCA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
