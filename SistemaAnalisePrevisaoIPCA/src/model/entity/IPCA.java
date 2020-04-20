package model.entity;

import model.enums.PeriodoConsultaIPCA;
import com.google.gson.internal.StringMap;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.enums.CategoriaIPCA;
import model.enums.TipoTaxaIPCA;

public class IPCA {

    private CategoriaIPCA categoria = null;
    private Date data = null;
    private Double taxaVariacaoMensal = 0D;
    private Double taxaAcumuladaAno = 0D;
    private Double taxaAcumulada12Meses = 0D;
    private Double pesoMensal = 0D;

    public IPCA(StringMap<Object> oStringMapIPCA) {
        Integer idCategoria;

        try {
            idCategoria = Integer.parseInt(oStringMapIPCA.get("D4N").toString().substring(0, 1));

        } catch (Exception ex) {
            idCategoria = 0;
        }

        CategoriaIPCA categoria = CategoriaIPCA.getById(idCategoria);
        int ano = Integer.parseInt(oStringMapIPCA.get("D3C").toString().substring(0, 4));
        int mes = Integer.parseInt(oStringMapIPCA.get("D3C").toString().substring(4, 6));
        Double taxa = Double.parseDouble(oStringMapIPCA.get("V").toString());

        String tipoTaxa;
        try {
            tipoTaxa = new String(oStringMapIPCA.get("D2N").toString().getBytes(), "UTF-8");
        } catch (Exception e) {
            tipoTaxa = "";
        }

        this.categoria = categoria;
        this.data = new GregorianCalendar(ano, mes - 1, 1).getTime();
        this.setTaxaByTipo(tipoTaxa, taxa);
    }

    public CategoriaIPCA getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaIPCA categoria) {
        this.categoria = categoria;
    }

    public Date getData() {
        return this.data;
    }

    public String getDataFormatada() {
        return new SimpleDateFormat("MM/yyyy").format(this.data);
    }

    public Double getTaxaVariacaoMensal() {
        return this.taxaVariacaoMensal;
    }

    public Double getTaxaAcumuladaAno() {
        return taxaAcumuladaAno;
    }

    public Double getTaxaAcumulada12Meses() {
        return taxaAcumulada12Meses;
    }

    public Double getPesoMensal() {
        return pesoMensal;
    }

    public String getTaxaFormatada(TipoTaxaIPCA tipoTaxa) {
        DecimalFormat format = new DecimalFormat("0.00");

        switch (tipoTaxa) {
            case VARIACAO_MENSAL:
                return format.format(taxaVariacaoMensal).replace(".", ",") + " %";
            case VARIACAO_ACUMULADA_NO_ANO:
                return format.format(taxaAcumuladaAno).replace(".", ",") + " %";
            case VARIACAO_ACUMULADA_EM_12_MESES:
                return format.format(taxaAcumulada12Meses).replace(".", ",") + " %";
            case PESO_MENSAL:
                return format.format(pesoMensal).replace(".", ",") + " %";
            default:
                return format.format(0);
        }
    }

    public static List<IPCA> filtrarListaIPCAByData(List<IPCA> listIPCA, Date dataInicio, Date dataTermino, CategoriaIPCA categoria) {
        List<IPCA> listIPCAFiltrada = new ArrayList<>();

        if (dataInicio == null || dataTermino == null) {

            for (IPCA oIPCA : listIPCA) {
                if ((!categoria.equals(CategoriaIPCA.TODAS) && !oIPCA.getCategoria().getId().equals(categoria.getId()))) {
                    continue;
                }

                listIPCAFiltrada.add(oIPCA);
            }

        } else {
            Calendar dataInicioFormatada = new GregorianCalendar();
            dataInicioFormatada.setTime(dataInicio);

            Calendar dataTerminoFormatada = new GregorianCalendar();
            dataTerminoFormatada.setTime(dataTermino);

            for (IPCA oIPCA : listIPCA) {
                Calendar dataIPCAFormatada = new GregorianCalendar();
                dataIPCAFormatada.setTime(oIPCA.data);

                if (dataIPCAFormatada.before(dataInicioFormatada) || dataIPCAFormatada.after(dataTerminoFormatada)
                        || (!categoria.equals(CategoriaIPCA.TODAS) && !oIPCA.getCategoria().getId().equals(categoria.getId()))) {

                    continue;
                }

                listIPCAFiltrada.add(oIPCA);
            }
        }

        return listIPCAFiltrada;
    }

    public static List<IPCA> filtrarPeriodoConsultaIPCA(List<IPCA> listIPCA, int tipoPeriodoConsulta) {
        return null;
    }

    public static Map<String, Date> filtrarPeriodoConsultaIPCA(List<IPCA> listIPCA, int tipoPeriodoConsulta, String mesInicio, String mesTermino, JLabel lblInformaPeriodo) {
        Map<String, Date> mapPeriodo = new HashMap<>();

        Date dataInicio;
        Date dataTermino;

        if (tipoPeriodoConsulta == PeriodoConsultaIPCA.MES_ANTERIOR.ordinal()) {
            Calendar calendar = Calendar.getInstance();

            GregorianCalendar dataInicioFormatada = null;
            GregorianCalendar dataTerminoFormatada = null;

            if (calendar.get(Calendar.MONTH) == 0) {
                dataInicioFormatada = new GregorianCalendar(calendar.get(Calendar.YEAR), 11, 1);
                dataTerminoFormatada = new GregorianCalendar(calendar.get(Calendar.YEAR), 11, 1);

            } else {
                dataInicioFormatada = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 1);
                dataTerminoFormatada = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 1);
            }

            dataInicio = dataInicioFormatada.getTime();
            dataTermino = dataTerminoFormatada.getTime();

        } else if (tipoPeriodoConsulta == PeriodoConsultaIPCA.ANO_ATUAL.ordinal()) {
            Calendar calendar = Calendar.getInstance();

            GregorianCalendar dataInicioFormatada = new GregorianCalendar(calendar.get(Calendar.YEAR), 0, 1);
            GregorianCalendar dataTerminoFormatada = new GregorianCalendar(calendar.get(Calendar.YEAR), 11, 1);

            dataInicio = dataInicioFormatada.getTime();
            dataTermino = dataTerminoFormatada.getTime();

        } else if (tipoPeriodoConsulta == PeriodoConsultaIPCA.ULTIMOS_5_ANOS.ordinal()) {
            Calendar calendar = Calendar.getInstance();

            GregorianCalendar dataInicioFormatada = new GregorianCalendar(calendar.get(Calendar.YEAR) - 4, 0, 1);
            GregorianCalendar dataTerminoFormatada = new GregorianCalendar(calendar.get(Calendar.YEAR), 11, 1);

            dataInicio = dataInicioFormatada.getTime();
            dataTermino = dataTerminoFormatada.getTime();

        } else if (tipoPeriodoConsulta == PeriodoConsultaIPCA.ULTIMOS_10_ANOS.ordinal()) {
            Calendar calendar = Calendar.getInstance();

            GregorianCalendar dataInicioFormatada = new GregorianCalendar(calendar.get(Calendar.YEAR) - 9, 0, 1);
            GregorianCalendar dataTerminoFormatada = new GregorianCalendar(calendar.get(Calendar.YEAR), 11, 1);

            dataInicio = dataInicioFormatada.getTime();
            dataTermino = dataTerminoFormatada.getTime();

        } else if (tipoPeriodoConsulta == PeriodoConsultaIPCA.INFORMAR_DATA.ordinal()) {
            if (mesInicio == null || mesTermino == null) {
                return null;
            }

            dataInicio = formatarData(mesInicio);
            dataTermino = formatarData(mesTermino);

        } else {
            dataInicio = null;
            dataTermino = null;
        }

        mapPeriodo.put("INICIO", dataInicio);
        mapPeriodo.put("TERMINO", dataTermino);

        return mapPeriodo;
    }

    public static Map<CategoriaIPCA, List<IPCA>> gerarMapAgrupamentoIPCABYCategorias(List<IPCA> listIPCA) {
        Map<CategoriaIPCA, List<IPCA>> mapIPCAByCategorias = new HashMap<>();

        List<IPCA> listIPCAAux = null;
        for (IPCA oIPCA : listIPCA) {
            if ((listIPCAAux = mapIPCAByCategorias.get(oIPCA.getCategoria())) == null) {
                listIPCAAux = new ArrayList<>();
                mapIPCAByCategorias.put(oIPCA.getCategoria(), listIPCAAux);
            }

            listIPCAAux.add(oIPCA);
        }

        return mapIPCAByCategorias;
    }

    private static Date formatarData(String data) {
        try {
            String[] dataSplit = data.split("/");

            GregorianCalendar dataFormatada = new GregorianCalendar(Integer.parseInt(dataSplit[1]),
                    Integer.parseInt(dataSplit[0]) - 1, 1);

            return dataFormatada.getTime();

        } catch (Exception ex) {
            ex.printStackTrace();

            JOptionPane.showMessageDialog(null, "Data(s) inválida(s)! Verifique as datas informadas",
                    "Erro de Formatação", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public void setTaxaByTipo(String tipoTaxa, Double taxa) {

        if (tipoTaxa.equals(TipoTaxaIPCA.VARIACAO_MENSAL.getDescricao())) {
            this.taxaVariacaoMensal = taxa;

        } else if (tipoTaxa.equals(TipoTaxaIPCA.VARIACAO_ACUMULADA_NO_ANO.getDescricao())) {
            this.taxaAcumuladaAno = taxa;

        } else if (tipoTaxa.equals(TipoTaxaIPCA.VARIACAO_ACUMULADA_EM_12_MESES.getDescricao())) {
            this.taxaAcumulada12Meses = taxa;

        } else if (tipoTaxa.equals(TipoTaxaIPCA.PESO_MENSAL.getDescricao())) {
            this.pesoMensal = taxa;
        }

    }

    public static void ordenarListaIPCAByData(List<IPCA> listIPCA) {
        Collections.sort(listIPCA, new IPCAComparatorCategoria());
        Collections.sort(listIPCA, new IPCAComparatorDateDecrescente());
    }

    public static class IPCAComparatorDateDecrescente implements Comparator<IPCA> {

        @Override
        public int compare(IPCA oIPCA1, IPCA oIPCA2) {
            return oIPCA2.getData().
                    compareTo(oIPCA1.getData());
        }
    }

    public static class IPCAComparatorCategoria implements Comparator<IPCA> {

        @Override
        public int compare(IPCA oIPCA1, IPCA oIPCA2) {
            return oIPCA1.getCategoria().getId().
                    compareTo(oIPCA2.getCategoria().getId());
        }
    }
}
