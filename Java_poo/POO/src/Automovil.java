public class Automovil implements Comparable<Automovil>{

    private int id;
    private static int contadorId;
    private String fabricante;
    private String modelo;
    private Color color;
    private Motor motor;
    private Estanque estanque;
    private Persona conductor;
    private Rueda[] ruedas;
    private int indiceRuedas;

    private TipoAutomovil tipo;
    private static Color colorPatente = Color.NARANJA;
    private static int capacidadEstanqueEstatico = 40;
    public static final Integer VELOCIDAD_MAX_CARRETERA = 120;
    public static final int VELOCIDAD_MAX_CIUDAD = 60;
    public static final Color COLOR_ROJO = Color.ROJO;
    public static final String COLOR_AMARILLO = "Aamarillo";
    public static final String COLOR_AZUL = "Azul";
    public static final String COLOR_BLANCO = "Blanco";
    public static final String COLOR_GRIS = "Gris";

    public Automovil(){
        this.id = ++contadorId;
        this.ruedas = new Rueda[indiceRuedas + 2];
    }
    public Automovil(String fabricante, String modelo){
        this();
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, Color color){
        this();
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.color = color;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor) {
        this();
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.color = color;
        this.motor = motor;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Estanque estanque) {
        this();
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.color = color;
        this.motor = motor;
        this.estanque = estanque;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Estanque estanque, Persona conductor, Rueda[] ruedas) {
        this();
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.color = color;
        this.motor = motor;
        this.estanque = estanque;
        this.conductor = conductor;
        this.ruedas = ruedas;
    }

    public String getFabricante(){
        return this.fabricante;
    }

    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Motor getMotor(){
        return this.motor;
    }

    public void setMotor(Motor motor){
        this.motor = motor;
    }

    public Estanque getEstanque(){
        if(estanque == null){
            this.estanque = new Estanque();
        }
        return this.estanque;
    }

    public void setEstanque(Estanque estanque){
        this.estanque = estanque;
    }

    public static Color getColorPatente(){
        return colorPatente;
    }

    public static void setColorPatente(Color colorPatente){
        Automovil.colorPatente = colorPatente;
    }

    public static int getCapacidadEstanqueEstatico() {
        return capacidadEstanqueEstatico;
    }

    public static void setCapacidadEstanqueEstatico(int capacidadEstanqueEstatico) {
        Automovil.capacidadEstanqueEstatico = capacidadEstanqueEstatico;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    public Automovil addRueda(Rueda rueda){
        if(indiceRuedas < this.ruedas.length){
            this.ruedas[indiceRuedas++] = rueda;
        }
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoAutomovil getTipo() {
        return tipo;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    public Persona getConductor() {
        return conductor;
    }

    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }

    public String verDetalle(){
        String detalle =  "fabricante = " + this.fabricante +
                "\nmodelo = " + this.modelo +
                "\ncolor = " + this.color +
                "\nmotor = " + this.motor.getTipo() +
                "\npatenteColor = " + colorPatente +
                "\nid = " + getId();
                if(this.getTipo() != null){
                    detalle += "\ntipo = " + getTipo().getNombre();
                }
        if (conductor != null) {
            detalle += "Conductor del autoMovil: " + this.getConductor();
        }

        if(this.getRuedas() != null){
            detalle += "\nLas ruedas del automovil son: ";
            for(Rueda r : this.getRuedas()){
                if (r != null){
                    detalle += "\n" + r.getFabricante() + ", aro: " + r.getAro() + ", ancho: " + r.getAncho();
                }
            }
        }

            return detalle;
    }

    public String acelerar(int rpm){
        return "El auto " + this.fabricante + " acelerando a " + rpm + " rpm";
    }

    public String frenar(){
        return this.fabricante + " " + this.modelo + " frenando!";
    }

    public String acelerarFrenar(int rpm){
        String acelerar = this.acelerar(rpm);
        String frenar = this.frenar();
        return acelerar + "\n" + frenar;
    }

    public float calcularConsumo(int km, float porcentajeBencina){
        return (float) (km / (motor.getCilindrada() * porcentajeBencina));
    }

//    public float calcularConsumo(int km, int porcentajeBencina){
//        return km / (capacidadEstanque * (porcentajeBencina / 100f));
//    }

    public static float calcularConsumo(int km, int porcentajeBencina){
        return km / (capacidadEstanqueEstatico * (porcentajeBencina / 100f));
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Automovil))
            return false;

        Automovil a = (Automovil) obj;
        return (this.fabricante != null && this.modelo != null
        && this.fabricante.equals(a.getFabricante())
        && this.modelo.equals(a.getModelo()));
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", fabricante: " + fabricante +
                ", modelo: " + modelo;
    }

    @Override
    public int compareTo(Automovil o) {
        return this.modelo.compareTo(o.modelo);
    }

}
