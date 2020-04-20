package util;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.entity.IPCA;

public class JSON {

    public static List<IPCA> carregarArquivoIPCA() {

        List<IPCA> listIPCA = new ArrayList<>();
        Reader reader = null;

        String arquivoIPCABaixado = util.File.getDiretorioArquivoIPCABaixado();

        try {
            if (!new java.io.File(arquivoIPCABaixado).exists()) {
                JOptionPane.showMessageDialog(null, "Não foi possível baixar o arquivo de IPCA atualizado!",
                        "Arquivo não encontrado", JOptionPane.ERROR_MESSAGE);

                return null;
            }

            reader = new FileReader(arquivoIPCABaixado);

            Gson gson = new Gson();
            List<StringMap<Object>> listIPCAVO = gson.fromJson(reader, ArrayList.class);

            Map<String, IPCA> mapIPCA = new HashMap<>();

            IPCA oIPCA = null;
            int ano, mes;
            String categoria;
            Date data;

            for (StringMap<Object> oStringMapIPCA : listIPCAVO) {
                try {
                    ano = Integer.parseInt(oStringMapIPCA.get("D3C").toString().substring(0, 4));
                    mes = Integer.parseInt(oStringMapIPCA.get("D3C").toString().substring(4, 6));
                    categoria = new String(oStringMapIPCA.get("D4N").toString().getBytes(), "UTF-8");

                    data = new GregorianCalendar(ano, mes - 1, 1).getTime();

                    if ((oIPCA = mapIPCA.get(data.toString() + categoria)) != null) {
                        oIPCA.setTaxaByTipo(new String(oStringMapIPCA.get("D2N").toString().getBytes(), "UTF-8"), Double.parseDouble(oStringMapIPCA.get("V").toString()));
                        continue;

                    } else {
                        oIPCA = new IPCA(oStringMapIPCA);
                    }

                } catch (Exception e) {
                    continue;
                }

                mapIPCA.put(data.toString() + categoria, oIPCA);
            }

            listIPCA = new ArrayList<>(mapIPCA.values());

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        IPCA.ordenarListaIPCAByData(listIPCA);

        JOptionPane.showMessageDialog(null, "Consulta ao Portal dados.gov.br concluída! Arquivo de IPCA atualizado.",
                "Operação concluída", JOptionPane.INFORMATION_MESSAGE);

        return listIPCA;
    }

}
