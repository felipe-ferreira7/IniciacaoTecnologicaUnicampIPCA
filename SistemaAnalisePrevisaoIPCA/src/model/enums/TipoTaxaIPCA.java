package model.enums;

public enum TipoTaxaIPCA {

    VARIACAO_MENSAL(0, "IPCA - Variação mensal"),
    VARIACAO_ACUMULADA_NO_ANO(1, "IPCA - Variação acumulada no ano"),
    VARIACAO_ACUMULADA_EM_12_MESES(2, "IPCA - Variação acumulada em 12 meses"),
    PESO_MENSAL(3, "IPCA - Peso mensal");

    private Integer id = null;
    private String descricao = "";

    private TipoTaxaIPCA(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoTaxaIPCA getById(Integer id) {
        for (TipoTaxaIPCA oCategoriaIPCA : TipoTaxaIPCA.values()) {
            if (oCategoriaIPCA.getId().equals(id)) {
                return oCategoriaIPCA;
            }
        }

        return null;
    }
}
