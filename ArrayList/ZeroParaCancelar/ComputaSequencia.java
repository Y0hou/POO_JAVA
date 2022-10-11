import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;
class ComputaSequencia{
    private ArrayList<Integer> sequencia = new ArrayList<Integer>();
    
    public void cadastra(int valor){
        if(valor == 0){
            this.sequencia.remove(this.sequencia.get(this.sequencia.size() -1));
        }else{
            this.sequencia.add(valor);
        }
    }

    public int computa(){
        int soma = 0;
        for (int i = 0;i < this.sequencia.size() ; i++){
            soma += this.sequencia.get(i);
        } 
        return soma;
    }

    public String toString(){
        return "valores = "+ this.sequencia;
    }

}


