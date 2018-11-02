package model.enums;

public enum PeriodoConsultaIPCA {

    MES_ANTERIOR("MÊS ANTERIOR"),
    ANO_ATUAL("ANO ATUAL"),
    ULTIMOS_5_ANOS("ULTIMOS 5 ANOS"),
    ULTIMOS_10_ANOS("ÚLTIMOS 10 ANOS"),
    INFORMAR_DATA("INFORMAR DATA"),
    HISTORICO_COMPLETO("HISTÓRICO COMPLETO");

    private String descricao = "";

    private PeriodoConsultaIPCA(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
