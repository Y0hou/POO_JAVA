import java.util.ArrayList;

public class Mercantil {
    private int qtdCaixas;
    private Pessoa[] caixas;
    private ArrayList<Pessoa> esperando;
    


Mercantil(int qtdCaixas){
        this.qtdCaixas = qtdCaixas;
        this.caixas = new Pessoa[qtdCaixas];
        this.esperando = new ArrayList<Pessoa>();
    }

public void chegar(Pessoa p){
        this.esperando.add(p);
    }

public boolean chamarNoCaixa(int indice){
        if(this.esperando.size() > 0){
            this.caixas[indice] = this.esperando.get(0);
            this.esperando.remove(0);
            return true;
        }
    
        System.out.println("fail: fila vazia");
        return false;
    }

public Pessoa finalizarAtendimento(int indice){
        Pessoa temp = this.caixas[indice];
        this.caixas[indice] = null;
        return temp;
    }

public String toString(){
        StringBuilder s = new StringBuilder("|");
        for (int i = 0; i < qtdCaixas; i++) {
            if(this.caixas[i] == null){
                s.append(String.format("%d:-----|", i));
            }
            else {
                s.append(String.format("%d:%s|", i, this.caixas[i]));
            }
        }
        s.append("\nEspera: " + this.esperando );

        return s.toString();
    }
}
