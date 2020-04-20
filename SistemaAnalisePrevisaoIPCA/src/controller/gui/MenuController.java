package controller.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import view.gui.ConsultarPrevisaoVariacaoGUI;
import view.gui.ConsultarVariacaoMensalGUI;
import view.gui.MenuGUI;
import view.gui.SobreIPCAGUI;
import util.File;

public class MenuController {

    private MenuGUI view = null;
    private ConsultarVariacaoMensalGUI viewConsultarVariacao = null;
    private ConsultarPrevisaoVariacaoGUI viewConsultarPrevisao = null;
    private SobreIPCAGUI viewSobreIPCA = null;

    public MenuController(MenuGUI view) {
        this.view = view;
        this.addEvents();
        this.view.setIconImage(new ImageIcon(getClass().getResource(File.getDiretorioArquivoIconePadrao())).getImage());
        this.view.setVisible(true);
    }

    public MenuController(MenuGUI view, Boolean visible) {
        this.view = view;
        this.addEvents();
        this.view.setIconImage(new ImageIcon(getClass().getResource(File.getDiretorioArquivoIconePadrao())).getImage());
        this.view.setVisible(visible);
    }

    private void addEvents() {
        view.getBtnConsultarVariacaoMensal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (viewConsultarVariacao != null && viewConsultarVariacao.isShowing()) {
                    viewConsultarVariacao.dispose();
                }

                viewConsultarVariacao = new ConsultarVariacaoMensalGUI();
                new ConsultarVariacaoMensalController(viewConsultarVariacao);
            }
        });

        view.getBtnConsultarPrevisaoVariacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (viewConsultarPrevisao != null && viewConsultarPrevisao.isShowing()) {
                    viewConsultarPrevisao.dispose();
                }

                viewConsultarPrevisao = new ConsultarPrevisaoVariacaoGUI();
                new ConsultarPrevisaoVariacaoController(viewConsultarPrevisao);
            }
        });

        view.getBtnSobreIPCA().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (viewSobreIPCA != null && viewSobreIPCA.isShowing()) {
                    viewSobreIPCA.dispose();
                }

                viewSobreIPCA = new SobreIPCAGUI(view, true);
                new SobreIPCAController(viewSobreIPCA);
            }
        });

        view.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.sair();
            }
        });
    }
}
