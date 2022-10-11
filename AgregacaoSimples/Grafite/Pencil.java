class Pencil {
    private float thickness;
    private Lead tip;

    public Pencil(float thickness) {
        this.thickness = thickness;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float value) {
        thickness = value;
    }

    public boolean hasGrafite() { 
        return tip != null;
    }

    public boolean insert(Lead grafite) {
        if(hasGrafite()){
            System.out.println("fail: ja existe grafite");
            return false;
        } 
        else if(getThickness() != grafite.getThickness()){
            System.out.println("fail: calibre incompatível");
            return false;
        }
        else{
            tip = grafite;
            return true;
        }
    }

    public Lead remove() {
        if(hasGrafite()){
            Lead temp = tip;
            tip = null;
            return temp;
        }
        
        return tip;
    }

    public void writePage() {
        if(!hasGrafite()){
            System.out.println("fail: nao existe grafite");
        }
        else if(tip.getSize() <= 10){
            System.out.println("warning: grafite com tamanho insuficiente para escrever");
        }
        else{
            int tam = tip.getSize() - tip.usagePerSheet();
            if(tam < 10){
                System.out.println("fail: folha incompleta");
                tip.setSize(10);
            }
            
            else{
                tip.setSize(tam);
            }
        }
    }
    
    public String toString() {
        String saida = "calibre: " + thickness + ", grafite: ";
        if (tip != null)
            saida += "[" + tip + "]";
        else
            saida += "null";
        return saida;
    }
}