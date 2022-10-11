class Motorcycle { //todo
    private Person person; //agregacao
    private int power;
    private int time;
    
    //Inicia o atributo power, time com zero e person com null
    public Motorcycle(int power){
        this.power = power;
    }
    public int getPower() {
        return power;
    }
    public int getTime() {
        return time;
    }
    public Person getPerson() {
        return person;
    }
    //Comprar mais tempo
    public void buy(int time){
        this.time += time;
    }
    
    //Se estiver vazio, coloca a pessoa na moto e retorna true
    public boolean enter(Person person) {
        if(this.person == null){
            this.person = person;
            return true;
        }
        
        System.out.println("fail: busy motorcycle");
        return false;
    }
    public Person leave() {
        if(this.person != null){
            Person p = this.person;
            this.person = null;
            return p;
        }
        
        System.out.println("fail: empty motorcycle");
        return this.person;
    }
    public void drive(int time){
        if(this.person.getAge() > 10){
            System.out.println("fail: too old to drive");
            return;
        }
        else if(this.time > 0){
            if(this.time >= time){
                this.time -= time;
            } else {
                System.out.printf("fail: time finished after %d minutes\n", this.time);
                this.time = 0;
            }
        } else{
            System.out.println("fail: buy time first");
        }
    }
    //buzinar
    public void honk(){
        StringBuilder s = new StringBuilder("P");
        for (int i = 0; i < this.power; i++) {
            s.append("e");
        }
        s.append("m");
        
        System.out.println(s);
        
    }
    
    public String toString(){
        if(this.person == null)
            return String.format("power:%d, time:%d, person:(empty)", this.power, this.time);
        
        return String.format("power:%d, time:%d, person:(%s)", this.power, this.time, this.person);
    }
}