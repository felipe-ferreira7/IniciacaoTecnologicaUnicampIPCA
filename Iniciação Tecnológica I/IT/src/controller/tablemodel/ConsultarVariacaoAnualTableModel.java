package controller.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.entity.IPCA;
import model.enums.TipoTaxaIPCA;

public class ConsultarVariacaoAnualTableModel extends AbstractTableModel {

    private String[] columnName = {"Mês Apurado", "Categoria", "Variação de IPCA do Mês",
        "Variação Acumulada no Ano", "Variação Acumulada em 12 Meses", "Peso Mensal"};
    private Class[] typeColumn = {java.lang.String.class, java.lang.String.class, java.lang.String.class,
        java.lang.String.class, java.lang.String.class, java.lang.String.class};
    private List<IPCA> listIPCA;

    public ConsultarVariacaoAnualTableModel(List<IPCA> listIPCA) {
        this.listIPCA = listIPCA;
    }

    @Override
    public int getRowCount() {
        return listIPCA.size();
    }

    @Override
    public int getColumnCount() {
        return typeColumn.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        IPCA obj = listIPCA.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return obj.getDataFormatada();

            case 1:
                return obj.getCategoria() != null ? obj.getCategoria().getDescricao() : "";

            case 2:
                return obj.getTaxaFormatada(TipoTaxaIPCA.VARIACAO_MENSAL);

            case 3:
                return obj.getTaxaFormatada(TipoTaxaIPCA.VARIACAO_ACUMULADA_NO_ANO);

            case 4:
                return obj.getTaxaFormatada(TipoTaxaIPCA.VARIACAO_ACUMULADA_EM_12_MESES);

            case 5:
                return obj.getTaxaFormatada(TipoTaxaIPCA.PESO_MENSAL);

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return typeColumn[column];
    }

}
