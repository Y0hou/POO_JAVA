import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

class Conta {
    private String titular;
    private int numero;
    private double saldo;
    private static int totalContas = 0;
    
    public Conta(String titular){
        numero = totalContas;
        totalContas++;
        saldo = 0;
        this.titular = titular;
    }



    void deposita(double valor){
        saldo += valor;
    }

    static void deposita(Conta c, double valor){
        c.deposita(valor);
    }

    boolean saca(double valor){
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }else { 
            System.out.printf("Conta ficou zerada após o saque %.2f reais\n", saldo);
            saldo = 0;
            return false;
        }
        
    }

    static void saca(Conta c, double valor){
        c.saca(valor);
    }

    boolean transfere(Conta c, double valor){
        double tempSaldo = saldo;
        if(saca(valor)){
            c.deposita(valor);
            return true;
        }else {
            c.deposita(tempSaldo);
            return false;
        }
    }

    static boolean transfere(Conta origem, Conta destino, double valor){
        return origem.transfere(destino, valor); 
    }
    


    public String toString(){
        return String.format("Nro da conta: %d, Titular: %s, Saldo: %.2f", numero, titular, saldo);
    }

    double getSaldo(){
        return saldo;
    }
}



