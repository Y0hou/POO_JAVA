import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Collections;

class MediaNotas{

    private ArrayList<Double> notas = new ArrayList<Double>();

    public void addNota(double nota){
        this.notas.add(nota);
    }

    public void removeNota(int index){
        this.notas.remove(index);
    }

    public void mudaNota(int index, double valor){
        this.notas.set(index, valor);
    }

    public double maiorNota(){
        if (this.notas.size() > 0) {
            return Collections.max(notas);
        }else{
            System.out.println("falha: quantidade de notas insuficiente");
        }
        return 0;
    }

    public double menorNota(){
        if (this.notas.size() > 0) {
            return Collections.min(notas);
        }else{
            System.out.println("falha: quantidade de notas insuficiente");
        }
        return 0;
    }

    double media(){
        double media = 0;
        for (int i = 0;i < this.notas.size() ; i++){
            media += this.notas.get(i);
        } 
        return media / this.notas.size();
    }

    void parametriza(){
        if (this.notas.size() > 0) {
            double maiorNota = this.maiorNota();
            for (int i = 0;i < this.notas.size() ;i++ ){
                double temp = this.notas.get(i);
                temp = (temp / maiorNota) * 10;
                mudaNota(i, temp);
            } 
        }else{
            System.out.println("falha: quantidade de notas insuficiente");
        }
    }

    public String toString(){
         String r = "[";
        for(int i = 0; i < this.notas.size(); i++){
            if(i == 0){
                r += String.format("%.2f", this.notas.get(i));    
            }
            else{
                r += String.format(", %.2f", this.notas.get(i));
            }
        }
        
        return r + "]";
    }

    
    
    
}


