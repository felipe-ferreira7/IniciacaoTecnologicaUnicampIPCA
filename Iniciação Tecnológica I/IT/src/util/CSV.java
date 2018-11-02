package util;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.entity.IPCA;

public class CSV {

    public static List<IPCA> carregarArquivoIPCA() {

        List<IPCA> listIPCA = new ArrayList<>();
        BufferedReader br = null;

        String arquivoIPCABaixado = util.File.getDiretorioArquivoIPCABaixado();
        String linha = "";
        String csvDivisor = ";";

        try {
            if (!new java.io.File(arquivoIPCABaixado).exists()) {
                JOptionPane.showMessageDialog(null, "Não foi possível baixar o arquivo de IPCA atualizado!",
                        "Arquivo não encontrado", JOptionPane.ERROR_MESSAGE);

                return null;
            }

            br = new BufferedReader(new FileReader(arquivoIPCABaixado));
            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(csvDivisor);

                IPCA oIPCA = null;

                try {
                    String[] data = dados[0].split("/");

                    /*oIPCA = new IPCA(null, Integer.parseInt(data[0].replace("\"", "")), Integer.parseInt(data[1].replace("\"", "")),
                            Integer.parseInt(data[2].replace("\"", "")), new Double(dados[1].replace(",", ".").replace("\"", "")));*/
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }

                listIPCA.add(oIPCA);

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        IPCA.ordenarListaIPCAByData(listIPCA);

        JOptionPane.showMessageDialog(null, "Consulta concluída! Arquivo de IPCA atualizado.",
                "Concluído", JOptionPane.INFORMATION_MESSAGE);

        return listIPCA;
    }

}
