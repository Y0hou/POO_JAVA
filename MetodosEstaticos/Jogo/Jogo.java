import java.util.Scanner;
import java.util.Locale;


class Jogo{
    
    private int numJogadores;
    private int [] armadilha;
    private int [] posicao;
    private boolean [] podeJogar;
    private int numArmadilha = 0;
    private int numCasas;
    private int prox;
    private boolean fimDoJogo = false;
    
    public Jogo(int numJogadores, int numCasas){
        this.numJogadores = numJogadores;
        this.numCasas = numCasas;
        this.prox = 0;
        this.armadilha = new int[3];
        this.posicao = new int[2];
        this.posicao[0] = 0;
        this.posicao[1] = 0;
        this.podeJogar = new boolean[2];
        this.podeJogar[0] = true;
        this.podeJogar[1] = true;
    }
    
    public void addArmadilha(int t){
        this.armadilha[this.numArmadilha] = t;
        this.numArmadilha++;
    }
    
    public void addMove(int d1, int d2){
        int total = d1 + d2;
        if(!this.fimDoJogo){
            if(this.podeJogar[this.prox]){
                this.posicao[this.prox] += total;
                System.out.println("O jogador " + (this.prox + 1) + " vai para a casa " + this.posicao[this.prox]);
                
                if(this.posicao[this.prox] >= (this.numCasas + 1)){
                    System.out.println("O jogador " + (this.prox + 1) + " venceu o jogo");
                    this.fimDoJogo = true;
                }
                
                for (int i = 0; i < 3; i++){
                    if(this.armadilha[i] == this.posicao[this.prox]){
                        System.out.println("O jogador " + (this.prox + 1) + " caiu em um armadilha");
                        this.podeJogar[this.prox] = false;
                    }
                } 
                
                if(this.prox == 0){
                    this.prox = 1;
                }else{
                    this.prox = 0;
                }
            }else{
                System.out.println("O jogador " + (this.prox + 1) + " passa a vez");
                this.podeJogar[this.prox] = true;
                if(this.prox == 0){
                    this.prox = 1;
                }else{
                    this.prox = 0;
                }
                this.addMove(d1,d2);
            }
        }else{
            System.out.println("O jogo acabou");
        }
        
        
    }
    public String toString(){
        for (int i = 1;i <= this.numJogadores ; i++) {
            System.out.printf("PosJogador[%d] = %d\n", i, this.posicao[i-1]);
        }
        return "";
    }
    
}


