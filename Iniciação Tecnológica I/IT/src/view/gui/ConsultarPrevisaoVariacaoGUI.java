package view.gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ConsultarPrevisaoVariacaoGUI extends javax.swing.JFrame {

    public ConsultarPrevisaoVariacaoGUI() {
        initComponents();
    }

    public JButton getBtnSair() {
        return btnSair;
    }

    public JButton getBtnPesquisar() {
        return btnPesquisar;
    }

    public JLabel getLblPrevisaoMaxima() {
        return lblPrevisaoMaxima;
    }

    public void sair() {
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPrevisaoMaxima = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Previsão de Variação do IPCA");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        lblPrevisaoMaxima.setFont(new java.awt.Font("Trebuchet MS", 3, 50)); // NOI18N
        lblPrevisaoMaxima.setForeground(new java.awt.Color(0, 0, 153));
        lblPrevisaoMaxima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrevisaoMaxima.setText("-");
        jPanel1.add(lblPrevisaoMaxima);
        lblPrevisaoMaxima.setBounds(180, 140, 330, 170);

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel15.setText("Previsão para o Próximo Mês:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(110, 110, 320, 30);

        btnPesquisar.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/pesquisar_pequeno.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setFocusable(false);
        jPanel1.add(btnPesquisar);
        btnPesquisar.setBounds(490, 100, 120, 40);

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel7.setText("<html><center>A taxa de variação prevista é calculada com base no conceito de Regressão Linear / Tendência, levando em conta as taxas de variação de IPCA dos últimos doze meses</center></html>");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(90, 310, 510, 80);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgs/backgroun_white.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(40, 80, 600, 330);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgs/backgroun_white.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 80, 600, 330);

        jLabel2.setFont(new java.awt.Font("Exotc350 DmBd BT", 0, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Previsão de Variação do IPCA");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 10, 560, 80);

        btnSair.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/sair_pequeno.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setFocusable(false);
        jPanel1.add(btnSair);
        btnSair.setBounds(540, 420, 90, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgs/taxas.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -70, 1070, 590);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, 0, 1070, 540);

        setSize(new java.awt.Dimension(667, 507));
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
            java.util.logging.Logger.getLogger(ConsultarPrevisaoVariacaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarPrevisaoVariacaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarPrevisaoVariacaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarPrevisaoVariacaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarPrevisaoVariacaoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPrevisaoMaxima;
    // End of variables declaration//GEN-END:variables
}
