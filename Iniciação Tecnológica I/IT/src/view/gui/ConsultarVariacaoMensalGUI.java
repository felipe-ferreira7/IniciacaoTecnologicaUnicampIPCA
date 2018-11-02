package view.gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ConsultarVariacaoMensalGUI extends javax.swing.JFrame {

    public ConsultarVariacaoMensalGUI() {
        initComponents();
    }

    public JButton getBtnSair() {
        return btnSair;
    }

    public JButton getBtnPesquisar() {
        return btnPesquisar;
    }

    public JButton getBtnGerarGrafico() {
        return btnGerarGrafico;
    }

    public JTable getTblConsulta() {
        return tblConsulta;
    }

    public JComboBox getCboPeriodoConsulta() {
        return cboPeriodoConsulta;
    }

    public JTextField getTxtMesInicio() {
        return txtMesInicio;
    }

    public JTextField getTxtMesTermino() {
        return txtMesTermino;
    }

    public JLabel getLblPeriodoConsultado() {
        return lblPeriodoConsultado;
    }

    public JComboBox<String> getCboCategoriaConsulta() {
        return cboCategoriaConsulta;
    }

    public JRadioButton getRdbBarras() {
        return rdbBarras;
    }

    public JRadioButton getRdbLinhas() {
        return rdbLinhas;
    }

    public void sair() {
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupGrafico = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnGerarGrafico = new javax.swing.JButton();
        rdbBarras = new javax.swing.JRadioButton();
        rdbLinhas = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        cboCategoriaConsulta = new javax.swing.JComboBox<>();
        btnSair = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        lblPeriodoConsultado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMesTermino = new javax.swing.JFormattedTextField();
        txtMesInicio = new javax.swing.JFormattedTextField();
        cboPeriodoConsulta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Histórico de Variação do IPCA");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GRÁFICO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12))); // NOI18N
        jPanel2.setLayout(null);

        btnGerarGrafico.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnGerarGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/grafico.png"))); // NOI18N
        btnGerarGrafico.setText("Gerar");
        btnGerarGrafico.setFocusable(false);
        jPanel2.add(btnGerarGrafico);
        btnGerarGrafico.setBounds(180, 20, 110, 40);

        groupGrafico.add(rdbBarras);
        rdbBarras.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rdbBarras.setText("Barras");
        jPanel2.add(rdbBarras);
        rdbBarras.setBounds(100, 27, 80, 27);

        groupGrafico.add(rdbLinhas);
        rdbLinhas.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rdbLinhas.setSelected(true);
        rdbLinhas.setText("Linhas");
        jPanel2.add(rdbLinhas);
        rdbLinhas.setBounds(20, 27, 80, 27);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(40, 420, 300, 70);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Categoria");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(470, 80, 150, 30);

        cboCategoriaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriaConsultaActionPerformed(evt);
            }
        });
        jPanel1.add(cboCategoriaConsulta);
        cboCategoriaConsulta.setBounds(470, 110, 220, 30);

        btnSair.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/sair_pequeno.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setFocusable(false);
        jPanel1.add(btnSair);
        btnSair.setBounds(890, 450, 90, 40);

        btnPesquisar.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/pesquisar_pequeno.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setFocusable(false);
        jPanel1.add(btnPesquisar);
        btnPesquisar.setBounds(860, 100, 120, 40);

        lblPeriodoConsultado.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        lblPeriodoConsultado.setForeground(new java.awt.Color(255, 255, 255));
        lblPeriodoConsultado.setText("Período Consultado:");
        jPanel1.add(lblPeriodoConsultado);
        lblPeriodoConsultado.setBounds(360, 420, 430, 30);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mês Término");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(340, 80, 110, 30);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mês Início");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(220, 80, 110, 30);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Período");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 80, 150, 30);

        try {
            txtMesTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMesTermino.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jPanel1.add(txtMesTermino);
        txtMesTermino.setBounds(340, 110, 110, 30);

        try {
            txtMesInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMesInicio.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jPanel1.add(txtMesInicio);
        txtMesInicio.setBounds(220, 110, 110, 30);

        cboPeriodoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPeriodoConsultaActionPerformed(evt);
            }
        });
        jPanel1.add(cboPeriodoConsulta);
        cboPeriodoConsulta.setBounds(40, 110, 170, 30);

        jLabel2.setFont(new java.awt.Font("Exotc350 DmBd BT", 0, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Histórico de Variação do IPCA");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 10, 580, 80);

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblConsulta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblConsulta);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 150, 940, 260);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgs/investimento.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-240, -30, 1530, 710);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, 0, 1070, 540);

        setSize(new java.awt.Dimension(1006, 540));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cboPeriodoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPeriodoConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPeriodoConsultaActionPerformed

    private void cboCategoriaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCategoriaConsultaActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarVariacaoMensalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarVariacaoMensalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarVariacaoMensalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarVariacaoMensalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarVariacaoMensalGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarGrafico;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cboCategoriaConsulta;
    private javax.swing.JComboBox<String> cboPeriodoConsulta;
    private javax.swing.ButtonGroup groupGrafico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPeriodoConsultado;
    private javax.swing.JRadioButton rdbBarras;
    private javax.swing.JRadioButton rdbLinhas;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JFormattedTextField txtMesInicio;
    private javax.swing.JFormattedTextField txtMesTermino;
    // End of variables declaration//GEN-END:variables
}
