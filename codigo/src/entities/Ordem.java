package entities;

public class Ordem {
    private String tipoOrdem;
    private int qtdAcoes;
    private int qtdAcoesExecutadas = 0;
    private int qtdAcoesPendentes = qtdAcoes - qtdAcoesExecutadas;
    private int precoAcao;
    private boolean ordemTotalmenteExecutada = false;

    public Ordem(String tipoOrdem, int qtdAcoes, int precoAcao) {
        this.tipoOrdem = tipoOrdem;
        this.qtdAcoes = qtdAcoes;
        this.precoAcao = precoAcao;
    }

    public String getTipoOrdem() {
        return tipoOrdem;
    }

    public void setTipoOrdem(String tipoOrdem) {
        this.tipoOrdem = tipoOrdem;
    }

    public int getQtdAcoes() {
        return qtdAcoes;
    }

    public void setQtdAcoes(int qtdAcoes) {
        this.qtdAcoes = qtdAcoes;
    }

    public int getPrecoAcao() {
        return precoAcao;
    }

    public void setPrecoAcao(int precoAcao) {
        this.precoAcao = precoAcao;
    }

    @Override
    public String toString() {
        String txt = "ORDEM:\nTipo de ordem: " + tipoOrdem + "\nQuantidade de ações: " + qtdAcoes ;
        
        if(tipoOrdem.equals("V") || tipoOrdem.equals("v") ){
            txt = txt +"\nPreço mínimo aceitável: R$ " + precoAcao;
        }else if(tipoOrdem.equals("C") || tipoOrdem.equals("c") ){
            txt = txt +"\nPreço máximo aceitável: R$ " + precoAcao + "\n";
        }

        return txt;
    }
}
