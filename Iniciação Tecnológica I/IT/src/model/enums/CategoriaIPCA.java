package model.enums;

public enum CategoriaIPCA {

    INDICE_GERAL(0, "ÍNDICE GERAL"),
    ALIMENTACAO_E_BEBIDAS(1, "ALIMENTAÇÃO E BEBIDAS"),
    HABITACAO(2, "HABITAÇÃO"),
    ARTIGOS_DERESIDENCIA(3, "ARTIGOS DE RESIDÊNCIA"),
    VESTUARIO(4, "VESTUÁRIO"),
    TRANSPORTES(5, "TRANSPORTES"),
    SAUDE_E_CUIDADOS_PESSOAIS(6, "SAÚDE E CUIDADOS PESSOAIS"),
    DESPESAS_PESSOAIS(7, "DESPESAS PESSOAIS"),
    EDUCACAO(8, "EDUCAÇÃO"),
    COMUNICACAO(9, "COMUNICAÇÃO"),
    TODAS(10, "TODAS");

    private Integer id = null;
    private String descricao = "";

    private CategoriaIPCA(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CategoriaIPCA getById(Integer id) {
        for (CategoriaIPCA oCategoriaIPCA : CategoriaIPCA.values()) {
            if (oCategoriaIPCA.getId().equals(id)) {
                return oCategoriaIPCA;
            }
        }

        return null;
    }
}
