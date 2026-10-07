import lombok.Getter;
import lombok.ToString;

@Getter 
@ToString 
public class Inimigo{
    private String nome;
    private int vida;
    private int dano;

    public Inimigo(String nome, int vida, int dano){
        this.nome = nome;

        if(vida > 20 || vida < 1) vida = 10;
        if(dano > 2 || dano < 1) dano = 1; 

        this.vida = vida;
        this.dano = dano;
    }

    public Inimigo(String nome){
        this(nome, 22, 3);
    }

    public void receberGolpe(){
        vida--;
        if(vida < 0) vida = 0;

        System.out.println(nome + " recebeu 1 de dano.");
    }

    public boolean estaDerrotado(){
        if(vida == 0) return true;
        else return false;
    }
}