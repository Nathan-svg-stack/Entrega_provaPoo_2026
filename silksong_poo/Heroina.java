public class Heroina {
    private String nome;
    private int mascaras;
    private int seda;


    public Heroina(String nome){
        this.nome = nome;
        this.mascaras = 5;
        this.seda = 0;
    }

    public String getNome(){
        return nome;
    }

    public int getMascaras(){
        return mascaras;
    }
    
    public int getSeda(){
        return seda;
    }

    public void atacar(){
        System.out.println(nome + " ataca com a agulha!");

        if(seda < 9) seda ++;
    }

    public void atacar(int vezes){
        for(int i = 0; i < vezes; i++){
            atacar();
        }
    }

    public void receberDano(int dano){
        mascaras = mascaras - dano;

        if(mascaras <0) mascaras = 0;

        System.out.println(nome + " recebeu " + dano + " de dano.");
    }
// parte da cura
    public void curar(){
        if(seda == 9){
            mascaras = mascaras + 3;

            if(mascaras > 5) mascaras = 5;

            seda = 0;

            System.out.println(nome + " se amarrou com seda e recuperou mascaras.");
        }else{
            System.out.println(nome + " nao tem seda suficiente para se curar.");
        }
    }

    public boolean estaDerrotada(){
        if(mascaras == 0) return true;
        else return false;
    }

    @Override
    public String toString(){
    return nome + " | Mascaras: " + mascaras + "/5 | Seda: " + seda + "/9";
    }
}
