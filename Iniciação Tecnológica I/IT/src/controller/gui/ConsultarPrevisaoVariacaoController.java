package controller.gui;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.List;
import javax.swing.ImageIcon;
import model.entity.IPCA;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.enums.CategoriaIPCA;
import view.gui.ConsultarPrevisaoVariacaoGUI;
import util.File;
import util.JSON;
import util.RegressaoLinear;

public class ConsultarPrevisaoVariacaoController {

    private ConsultarPrevisaoVariacaoGUI view = null;

    public ConsultarPrevisaoVariacaoController(ConsultarPrevisaoVariacaoGUI view) {
        this.view = view;
        this.addEvents();
        this.view.setIconImage(new ImageIcon(getClass().getResource(File.getDiretorioArquivoIconePadrao())).getImage());
        this.view.setVisible(true);
    }

    private void addEvents() {
        view.getBtnPesquisar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                calcularPrevisao();

                view.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }
        });

        view.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.sair();
            }
        });
    }

    private void calcularPrevisao() {
        if (!File.downloadArquivoIPCA()) {
            return;
        }

        List<IPCA> listIPCACompleta = JSON.carregarArquivoIPCA();
        List<IPCA> listIPCAFiltrada;

        Calendar dataAtual = Calendar.getInstance();
        Calendar dataLimiteFiltro = new GregorianCalendar(dataAtual.get(Calendar.YEAR), dataAtual.get(Calendar.MONTH) - 12, 1);

        listIPCAFiltrada = IPCA.filtrarListaIPCAByData(listIPCACompleta, dataLimiteFiltro.getTime(), dataAtual.getTime(), CategoriaIPCA.INDICE_GERAL);

        if (listIPCAFiltrada.isEmpty()) {
            return;
        }

        double[] y = new double[listIPCAFiltrada.size()];
        double[] x = new double[listIPCAFiltrada.size()];

        for (int i = listIPCAFiltrada.size(); i > 0; i--) {
            x[i - 1] = i;
            y[i - 1] = listIPCAFiltrada.get(listIPCAFiltrada.size() - i).getTaxaVariacaoMensal();
        }

        Double percentualPrevisto = RegressaoLinear.trend(y, x, 13);

        Format formatDecimal = new DecimalFormat("0.00");
        view.getLblPrevisaoMaxima().setText(formatDecimal.format(percentualPrevisto).replace(".", ",") + " %");
    }
}
