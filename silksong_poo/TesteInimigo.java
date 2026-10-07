public class TesteInimigo {
    public static void main(String[] args) {
        Inimigo mossMother = new Inimigo("Moss Mother", 12, 1);
        Inimigo peregrino = new Inimigo("Besouro Peregrino");
        Inimigo bugado = new Inimigo("Inimigo Bugado", 50, 7);

        System.out.println(mossMother);
        System.out.println(peregrino);
        System.out.println(bugado);

        while(peregrino.getVida() != 0){
            peregrino.receberGolpe();
        }
        System.out.println(peregrino);
        System.out.println("Derrotado? " + peregrino.estaDerrotado());
    }
}
