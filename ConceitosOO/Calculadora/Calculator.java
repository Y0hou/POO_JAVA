import java.util.Scanner;
import java.text.*;
class Calculator {
    public int batteryMax;
    public int battery;
    public float display;

    public Calculator(int batteryMax) {
        this.batteryMax = batteryMax;
        this.battery = 0;
        this.display = 0;
    }

    public void chargeBattery(int value) {

        this.battery = battery + value;
            if(battery > batteryMax){
                this.battery = batteryMax;
            }
    }

    public boolean useBattery(int battery) {
        if (battery > 0){
            this.battery--;
            return true;
        }else {
            return false;
        }
    }

    public void sum(int a, int b) {
        if(useBattery(battery)){
            this.display = a + b;
        }else {
            System.out.println("fail: bateria insuficiente");
        }
    }

    public void division(float num, float den) {
        if(useBattery(battery)) {
            if (den == 0) {
                System.out.println("fail: divisao por zero");
            } else {
                this.display = num / den;
            }
        }else {
            System.out.println("fail: bateria insuficiente");
        }
    }





    public String toString() {
        DecimalFormat form = new DecimalFormat("0.00");
        return "display = " + form.format(this.display).replace(",",".") + ", battery = " + this.battery;
    }
}

