package vostore.orcamentoragonezi.Database;

public class ServicosValores {
    private  static ServicosValores instance = new ServicosValores();

    public float getRemocaoRevestimentoParede() {
        return remocaoRevestimentoParede;
    }

    public void setRemocaoRevestimentoParede(float remocaoRevestimentoParede) {
        this.remocaoRevestimentoParede = remocaoRevestimentoParede;
    }

    float remocaoRevestimentoParede = (float) 24.50;

    private ServicosValores(){

    }

    public static ServicosValores getInstance() {
        return instance;
    }
}
