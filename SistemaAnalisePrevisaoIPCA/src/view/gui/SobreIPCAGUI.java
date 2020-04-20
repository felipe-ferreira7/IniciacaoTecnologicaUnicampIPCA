package view.gui;

import javax.swing.JButton;

public class SobreIPCAGUI extends javax.swing.JDialog {

    public SobreIPCAGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JButton getBtnSair() {
        return btnSair;
    }

    public void sair() {
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgs/backgroun_white.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mais Informações sobre o IPCA");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel8.setText("<html><center>FONTE: https://www.btgpactualdigital.com/blog/financas/ipca-o-que-e</center></html>");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 370, 520, 30);

        btnSair.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/sair_pequeno.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setFocusable(false);
        getContentPane().add(btnSair);
        btnSair.setBounds(510, 410, 100, 40);

        jLabel2.setFont(new java.awt.Font("Exotc350 DmBd BT", 0, 40)); // NOI18N
        jLabel2.setText("O que é IPCA?");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 10, 340, 60);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 3, 16)); // NOI18N
        jLabel3.setText("<html><center>O IPCA é um índice que mede a variação de preços de mercado para o consumidor final. Estabelecido pelo Instituto Brasileiro de Geografia e Estatística (IBGE) mensalmente, ele representa o índice oficial da inflação no Brasil. É um bom termômetro para avaliar perdas no poder de compra.  Calculado desde 1979, então, o IPCA identifica uma variação nos preços do comércio. Ele é utilizado pelo Banco Central para monitorar a inflação.  Como consumidor, você pode notar que, quando os preços nas prateleiras do supermercado aumentam, o índice sobe. Realizado em estabelecimentos comerciais, domicílios, com prestadores de serviços e concessionárias de serviços públicos. Mas quais são os produtos e serviços que o índice leva em consideração?  Bem, o IPCA considera as seguintes categorias: alimentação e bebidas, artigos de residência, comunicação, despesas pessoais, educação, habitação, saúde e cuidados pessoais, transportes e vestuário.</center></html>");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 80, 560, 300);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgs/backgroun_white.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 70, 590, 340);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgs/backgroun_white.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 70, 590, 340);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgs/imagem empresarial 2.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, -20, 760, 500);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 410, 630, 50);

        setSize(new java.awt.Dimension(643, 491));
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
            java.util.logging.Logger.getLogger(SobreIPCAGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SobreIPCAGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SobreIPCAGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SobreIPCAGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SobreIPCAGUI dialog = new SobreIPCAGUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
