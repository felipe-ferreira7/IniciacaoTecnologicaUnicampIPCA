package controller.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import view.gui.SobreIPCAGUI;
import util.File;

public class SobreIPCAController {

    private SobreIPCAGUI view = null;

    public SobreIPCAController(SobreIPCAGUI view) {
        this.view = view;
        this.addEvents();
        this.view.setIconImage(new ImageIcon(getClass().getResource(File.getDiretorioArquivoIconePadrao())).getImage());
        this.view.setVisible(true);
    }

    private void addEvents() {
        view.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.sair();
            }
        });
    }

}
