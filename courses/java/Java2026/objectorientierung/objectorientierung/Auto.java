public class Auto {

    // Attribute
    private String name;
    private String farbe;
    private int ps;
    private double hubraum;

    // Methoden
    // regeln den Zugriff auf die Attribute
    // Methoden um das Attribute name zu setzen
    public void setName(String name) {
        this.name = name;   
    }

    public void setFarbe(String farbe){
        this.farbe = farbe;
    }

    public void setPs(int ps){
        this.ps = ps;
    }

    public void setHubraum(double hubraum){
        this.hubraum = hubraum;
    }
    // Methoden um das Attribute name auszulesen
    public String getName(){
        return name;
    }

    public String getFarbe(){
        return farbe;
    }

    public int getPs(){
        return ps;
    }

    public double getHubraum(){
        return hubraum;
    }
}
