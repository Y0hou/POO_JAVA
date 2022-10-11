class Solver{
    static Shell sh = new Shell();
    static Motorcycle motoca  = new Motorcycle(1);
    public static void main(String[] args) {
    
        sh.setfn("init",   () -> motoca = new Motorcycle(toInt(sh.par(1))));
        sh.setfn("buy",    () -> motoca.buy(toInt(sh.par(1))));
        sh.setfn("enter",  () -> motoca.enter(new Person(sh.par(1), toInt(sh.par(2)))));
        sh.setfn("drive",  () -> motoca.drive(toInt(sh.par(1))));
        sh.setfn("leave",  () ->  {
            Person person = motoca.leave();
            if(person != null) {
                System.out.println(person.toString());
            }
        });
        sh.setfn("honk",   () -> motoca.honk());
        sh.setfn("show",   () -> System.out.println(motoca));
    
        sh.execute();
    }
    static int toInt(String s){
        return Integer.parseInt(s);
    }
}