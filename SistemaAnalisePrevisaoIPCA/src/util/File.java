package util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

public class File {

    private static final String DIRETORIO_ARQUIVO_ICONE_PADRAO = "/view/icons/icon_principal_pequeno.png";
    private static final String DIRETORIO_PADRAO_JAVA = System.getProperties().getProperty("java.io.tmpdir");

    private static final String NOME_ARQUIVO_IPCA = "\\arquivo_ipca.json";
    private static final String NOME_ARQUIVO_ULTIMA_ATUALIZACAO = "\\data_ultima_atualizacao_arquivo_ipca.txt";

    private static final String URL_ARQUIVO_IPCA_DOWNLOAD = "http://api.sidra.ibge.gov.br/values/t/1419/n1/all/v/all/p/all/c315/7169,7170,7445,7486,7558,7625,7660,7712,7766,7786/d/v63%202,v66%204,v69%202,v2265%202?formato=json";
    private static final String URL_HTML_DADOS_GOV_IPCA = "http://dados.gov.br/dataset/ia-indice-nacional-de-precos-ao-consumidor-amplo-ipca/resource/b9af193c-f8b2-41e0-8d3a-08210eb0962e";

    public static void saveFileFromUrlWithJavaIO(String fileName, String fileUrl)
            throws MalformedURLException, IOException {

        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            in = new BufferedInputStream(new URL(fileUrl).openStream());
            fout = new FileOutputStream(fileName);
            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
        }
    }

    public static void saveFileFromUrlWithCommonsIO(String fileName,
            String fileUrl) throws MalformedURLException, IOException {

        FileUtils.copyURLToFile(new URL(fileUrl), new java.io.File(fileName));
    }

    public static boolean downloadArquivoIPCA() {
        FileReader fileReader = null;
        BufferedReader bufferredReader = null;

        InputStreamReader inputStreamReader = null;

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            String dataUltimaAtualizacaoArquivoURL = "";
            String dataUltimaAtualizacaoArquivoLocal = "";

            // Carrega arquivo de data de Ãºltima atualizaÃ§Ã£o local
            if (new java.io.File(getDiretorioArquivoUltimaAtualizacao()).exists()) {
                fileReader = new FileReader(getDiretorioArquivoUltimaAtualizacao());
                bufferredReader = new BufferedReader(fileReader);

                try {
                    dataUltimaAtualizacaoArquivoLocal = bufferredReader.readLine().trim();

                } catch (NullPointerException ex) {
                    dataUltimaAtualizacaoArquivoLocal = "";
                }

                bufferredReader.close();
                fileReader.close();
            }

            // Consulta data de Última atualização do Arquivo na Web
            inputStreamReader = new InputStreamReader(new URL(File.getUrlHtmlDadosGovIPCA()).openStream(), "UTF-8");
            bufferredReader = new BufferedReader(inputStreamReader);

            String inputLine;
            boolean isLinhaDataUltimaAtualizacao = false;

            while ((inputLine = bufferredReader.readLine()) != null) {

                if (inputLine.trim().contains("<th scope=\"row\">Ultima atualização</th>")) {
                    isLinhaDataUltimaAtualizacao = true;
                    continue;
                }

                if (isLinhaDataUltimaAtualizacao) {
                    dataUltimaAtualizacaoArquivoURL = inputLine.replace("<td>", "").replace("</td>", "").trim();
                    break;
                }
            }

            bufferredReader.close();
            inputStreamReader.close();

            // Baixa arquivo se não existir ou atualiza arquivo se a versão for mais recente
            if (!new java.io.File(getDiretorioArquivoIPCABaixado()).exists()
                    || isDataURLNovaVersaoArquivo(dataUltimaAtualizacaoArquivoLocal, dataUltimaAtualizacaoArquivoURL)) {
                saveFileFromUrlWithCommonsIO(getDiretorioArquivoIPCABaixado(), getURLArquivoIPCADownload());

                // Atualiza data do arquivo
                fileWriter = new FileWriter(getDiretorioArquivoUltimaAtualizacao());
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.append(dataUltimaAtualizacaoArquivoURL);

                bufferedWriter.flush();
                bufferedWriter.close();
                fileWriter.close();
            }

            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve algum problema de conexão com o site dados.gov.br!\nVerifique sua conexão com a Internet."
                    + "\nCaso esteja operante, aguarde um momento e tente novamente.", "Falha de Conexão", JOptionPane.ERROR_MESSAGE);

            return false;

        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferredReader != null) {
                    bufferredReader.close();
                }

                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }

                if (fileWriter != null) {
                    fileWriter.close();
                }

                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static boolean isDataURLNovaVersaoArquivo(String dataLocal, String dataURL) {
        if (dataLocal.trim().isEmpty() || dataURL.trim().isEmpty()) {
            return true;
        }

        Calendar calendarDataLocal = converterDataCalendar(dataLocal);
        Calendar calendarDataURL = converterDataCalendar(dataURL);

        if (calendarDataLocal == null || calendarDataURL == null) {
            return true;
        }

        return calendarDataURL.after(calendarDataLocal);
    }

    private static Calendar converterDataCalendar(String dataExtenso) {
        String[] data = dataExtenso.split("/");

        String mesNumerico = null;

        switch (data[1]) {
            case "Janeiro":
                mesNumerico = "00";
                break;
            case "Fevereiro:":
                mesNumerico = "01";
                break;
            case "Março":
                mesNumerico = "02";
                break;
            case "Abril":
                mesNumerico = "03";
                break;
            case "Maio":
                mesNumerico = "04";
                break;
            case "Junho":
                mesNumerico = "05";
                break;
            case "Julho":
                mesNumerico = "06";
                break;
            case "Agosto":
                mesNumerico = "07";
                break;
            case "Setembro":
                mesNumerico = "08";
                break;
            case "Outubro":
                mesNumerico = "09";
                break;
            case "Novembro":
                mesNumerico = "10";
                break;
            case "Dezembro":
                mesNumerico = "11";
                break;
            default:
                return null;
        }

        Calendar dataCalendar = new GregorianCalendar(Integer.parseInt(data[2]), Integer.parseInt(mesNumerico), Integer.parseInt(data[0]));

        return dataCalendar;
    }

    public static String getDiretorioArquivoIconePadrao() {
        return DIRETORIO_ARQUIVO_ICONE_PADRAO;
    }

    public static String getDiretorioArquivoIPCABaixado() {
        return DIRETORIO_PADRAO_JAVA + NOME_ARQUIVO_IPCA;
    }

    public static String getDiretorioArquivoUltimaAtualizacao() {
        return DIRETORIO_PADRAO_JAVA + NOME_ARQUIVO_ULTIMA_ATUALIZACAO;
    }

    public static String getURLArquivoIPCADownload() {
        return URL_ARQUIVO_IPCA_DOWNLOAD;
    }

    public static String getUrlHtmlDadosGovIPCA() {
        return URL_HTML_DADOS_GOV_IPCA;
    }
}
