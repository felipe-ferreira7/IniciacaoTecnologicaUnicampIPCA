package controller.gui;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.entity.IPCA;
import controller.tablemodel.ConsultarVariacaoAnualTableModel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.enums.CategoriaIPCA;
import model.enums.PeriodoConsultaIPCA;
import util.File;
import view.gui.ConsultarVariacaoMensalGUI;
import util.JSON;

public class ConsultarVariacaoMensalController {

    private ConsultarVariacaoMensalGUI view = null;
    private JFrame viewGrafico = null;
    private List<IPCA> listIPCA = null;
    private List<Integer> listLinhasIndiceGeral = null;

    public ConsultarVariacaoMensalController(ConsultarVariacaoMensalGUI view) {
        this.view = view;
        this.addEvents();
        this.view.setIconImage(new ImageIcon(getClass().getResource(File.getDiretorioArquivoIconePadrao())).getImage());
        this.listLinhasIndiceGeral = new ArrayList<>();
        this.listIPCA = new ArrayList<>();
        this.carregarFiltros();
        this.view.setVisible(true);
    }

    public JFrame getViewGrafico() {
        return viewGrafico;
    }

    private void carregarFiltros() {
        view.getCboPeriodoConsulta().addItem(PeriodoConsultaIPCA.MES_ANTERIOR.getDescricao());
        view.getCboPeriodoConsulta().addItem(PeriodoConsultaIPCA.ANO_ATUAL.getDescricao());
        view.getCboPeriodoConsulta().addItem(PeriodoConsultaIPCA.ULTIMOS_5_ANOS.getDescricao());
        view.getCboPeriodoConsulta().addItem(PeriodoConsultaIPCA.ULTIMOS_10_ANOS.getDescricao());
        view.getCboPeriodoConsulta().addItem(PeriodoConsultaIPCA.INFORMAR_DATA.getDescricao());
        view.getCboPeriodoConsulta().addItem(PeriodoConsultaIPCA.HISTORICO_COMPLETO.getDescricao());

        view.getCboCategoriaConsulta().addItem(CategoriaIPCA.INDICE_GERAL.getDescricao());
        view.getCboCategoriaConsulta().addItem(CategoriaIPCA.ALIMENTACAO_E_BEBIDAS.getDescricao());
        view.getCboCategoriaConsulta().addItem(CategoriaIPCA.HABITACAO.getDescricao());
        view.getCboCategoriaConsulta().addItem(CategoriaIPCA.ARTIGOS_DERESIDENCIA.getDescricao());
        view.getCboCategoriaConsulta().addItem(CategoriaIPCA.VESTUARIO.getDescricao());
        view.getCboCategoriaConsulta().addItem(CategoriaIPCA.TRANSPORTES.getDescricao());
        view.getCboCategoriaConsulta().addItem(CategoriaIPCA.SAUDE_E_CUIDADOS_PESSOAIS.getDescricao());
        view.getCboCategoriaConsulta().addItem(CategoriaIPCA.DESPESAS_PESSOAIS.getDescricao());
        view.getCboCategoriaConsulta().addItem(CategoriaIPCA.EDUCACAO.getDescricao());
        view.getCboCategoriaConsulta().addItem(CategoriaIPCA.COMUNICACAO.getDescricao());
        view.getCboCategoriaConsulta().addItem("TODAS");

        view.getCboCategoriaConsulta().setSelectedIndex(10);
    }

    private void addEvents() {
        view.getBtnPesquisar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (!validarCamposBusca()) {
                    return;
                }

                view.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                pesquisarIPCA();
                filtrarConsulta();
                verificarLinhasIndiceGeral();

                view.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                popularTabelaConsulta();

            }
        });

        view.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.sair();
            }
        });

        view.getCboPeriodoConsulta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                habilitarCamposData();
            }
        });

        view.getBtnGerarGrafico().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarGrafico();

            }
        });
    }

    private void habilitarCamposData() {
        if (view.getCboPeriodoConsulta().getSelectedIndex() == PeriodoConsultaIPCA.INFORMAR_DATA.ordinal()) {
            view.getTxtMesInicio().setEnabled(true);
            view.getTxtMesTermino().setEnabled(true);

        } else {
            view.getTxtMesInicio().setEnabled(false);
            view.getTxtMesTermino().setEnabled(false);

            view.getTxtMesInicio().setText("");
            view.getTxtMesTermino().setText("");
        }
    }

    private void filtrarConsulta() {
        Map<String, Date> mapPeriodo = IPCA.filtrarPeriodoConsultaIPCA(listIPCA, view.getCboPeriodoConsulta().getSelectedIndex(),
                view.getTxtMesInicio().getText(), view.getTxtMesTermino().getText(), view.getLblPeriodoConsultado());

        Date dataInicio = mapPeriodo.get("INICIO");
        Date dataTermino = mapPeriodo.get("TERMINO");

        CategoriaIPCA categoria = CategoriaIPCA.getById(view.getCboCategoriaConsulta().getSelectedIndex());

        atualizarLabelPeriodoConsulta(dataInicio, dataTermino);

        listIPCA = IPCA.filtrarListaIPCAByData(listIPCA, dataInicio, dataTermino, categoria);
    }

    private boolean validarCamposBusca() {
        if (view.getCboPeriodoConsulta().getSelectedIndex() == PeriodoConsultaIPCA.INFORMAR_DATA.ordinal()
                && (view.getTxtMesInicio().getText().replace("/", "").trim().isEmpty() || view.getTxtMesTermino().getText().replace("/", "").trim().isEmpty())) {

            JOptionPane.showMessageDialog(null, "Informe o mês de início de término da consulta!",
                    "Campos não informados", JOptionPane.WARNING_MESSAGE);

            return false;
        }

        return true;
    }

    private void pesquisarIPCA() {
        if (!File.downloadArquivoIPCA()) {
            return;
        }

        listIPCA = JSON.carregarArquivoIPCA();
    }

    private void verificarLinhasIndiceGeral() {
        listLinhasIndiceGeral.clear();

        if (view.getCboCategoriaConsulta().getSelectedIndex() != CategoriaIPCA.TODAS.getId()) {
            return;
        }

        for (int i = 0; i < listIPCA.size(); i++) {
            if (listIPCA.get(i).getCategoria().equals(CategoriaIPCA.INDICE_GERAL)) {
                listLinhasIndiceGeral.add(i);
            }
        }
    }

    private void atualizarLabelPeriodoConsulta(Date dataInicio, Date dataTermino) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");

        if (dataInicio == null || dataTermino == null) {
            view.getLblPeriodoConsultado().setText("Período Consultado: PERÍODO COMPLETO DO ARQUIVO");
        } else {
            view.getLblPeriodoConsultado().setText("Período Consultado: " + dateFormat.format(dataInicio) + " a " + dateFormat.format(dataTermino));

        }
    }

    private void popularTabelaConsulta() {
        view.getTblConsulta().setModel(new ConsultarVariacaoAnualTableModel(listIPCA));
        columnWidht();
    }

    private void columnWidht() {
        int qtdColumns = 6;
        int v[] = new int[qtdColumns];
        v[0] = 100;
        v[1] = 200;
        v[2] = 150;
        v[3] = 170;
        v[4] = 210;
        v[5] = 100;

        for (int i = 0; i < qtdColumns; i++) {
            javax.swing.table.TableColumn column = view.getTblConsulta().getColumnModel().getColumn(i);
            column.setMinWidth(v[i]);
            column.setPreferredWidth(v[i]);
            view.getTblConsulta().getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());
        }
    }

    public class CellRenderer extends DefaultTableCellRenderer {

        public CellRenderer() {
            super();
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            if (listLinhasIndiceGeral.contains(row) && !isSelected) {
                JLabel label = new JLabel(value.toString());

                label.setHorizontalAlignment(CENTER);
                label.setFont(new Font(this.getFont().getName(), Font.BOLD, this.getFont().getSize()));
                label.setBackground(new Color(31, 171, 248));
                label.setOpaque(true);

                return label;
            } else {
                this.setHorizontalAlignment(CENTER);

                return super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
            }
        }
    }

    private void gerarGrafico() {
        if (viewGrafico != null && viewGrafico.isShowing()) {
            viewGrafico.dispose();
        }

        viewGrafico = new JFrame();
        viewGrafico.setSize(800, 600);
        viewGrafico.setLocationRelativeTo(null);
        viewGrafico.setTitle("Gráfico");
        viewGrafico.setIconImage(new ImageIcon(getClass().getResource(File.getDiretorioArquivoIconePadrao())).getImage());
        viewGrafico.setVisible(true);

        JFXPanel fxPanel = new JFXPanel();
        viewGrafico.add(fxPanel);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {              
                initFX(fxPanel);
                
            }
        });
    }

    private void initFX(JFXPanel panel) {
        List<IPCA> listIPCAAux = new ArrayList<>();
        listIPCAAux.addAll(listIPCA);

        Collections.reverse(listIPCAAux);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        XYChart<String, Number> chart = null;

        if (view.getRdbLinhas().isSelected()) {
            chart = new LineChart<>(xAxis, yAxis);
        } else {
            chart = new BarChart<>(xAxis, yAxis);
        }

        xAxis.setLabel("Mês/Ano");
        yAxis.setLabel("Percentual de Variação IPCA");
        chart.setTitle("Histórico de Variação do IPCA");

        if (view.getCboCategoriaConsulta().getSelectedIndex() != CategoriaIPCA.TODAS.getId()) {
            XYChart.Series seriesTaxaVariacaoMensal = new XYChart.Series();
            seriesTaxaVariacaoMensal.setName("Variação de IPCA do Mês");

            XYChart.Series seriesTaxaAcumuladaAno = new XYChart.Series();
            seriesTaxaAcumuladaAno.setName("Variação Acumulada no Ano");

            XYChart.Series seriesTaxaAcumulada12Meses = new XYChart.Series();
            seriesTaxaAcumulada12Meses.setName("Variação Acumulada em 12 Meses");

            for (IPCA oIPCA : listIPCAAux) {
                seriesTaxaVariacaoMensal.getData().add(new XYChart.Data(oIPCA.getDataFormatada(), oIPCA.getTaxaVariacaoMensal()));
                seriesTaxaAcumuladaAno.getData().add(new XYChart.Data(oIPCA.getDataFormatada(), oIPCA.getTaxaAcumuladaAno()));
                seriesTaxaAcumulada12Meses.getData().add(new XYChart.Data(oIPCA.getDataFormatada(), oIPCA.getTaxaAcumulada12Meses()));
            }

            chart.getData().addAll(seriesTaxaVariacaoMensal);
            chart.getData().addAll(seriesTaxaAcumuladaAno);
            chart.getData().addAll(seriesTaxaAcumulada12Meses);

        } else {
            Map<CategoriaIPCA, List<IPCA>> mapIPCAByCategorias = IPCA.gerarMapAgrupamentoIPCABYCategorias(listIPCAAux);

            for (List<IPCA> listIPCAByMap : mapIPCAByCategorias.values()) {
                XYChart.Series seriesTaxaVariacaoMensal = new XYChart.Series();
                seriesTaxaVariacaoMensal.setName(listIPCAByMap.get(0).getCategoria().getDescricao());

                for (IPCA oIPCA : listIPCAByMap) {
                    seriesTaxaVariacaoMensal.getData().add(new XYChart.Data(oIPCA.getDataFormatada(), oIPCA.getTaxaVariacaoMensal()));
                }

                chart.getData().addAll(seriesTaxaVariacaoMensal);
            }

        }

        Scene scene = new Scene(chart, 800, 600);
        
        panel.setScene(scene);
    }
}
