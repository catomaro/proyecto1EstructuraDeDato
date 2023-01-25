import java.util.Scanner;

public class Alumno{
    Scanner entrada = new Scanner (System.in);
    private String nombre, apellidoP, apellidoM, matricula;
    float[] calificaciones;
    String materias[] = {"POO", "Estructura de Datos","ISAC","Calculo Diferencial","Procesos de Software","Desarrollo Humano"};
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setApellidoP(String apellidoP){this.apellidoP= apellidoP;}
    public void setApellidoM(String apellidoM){this.apellidoM= apellidoM;}
    public void setMatricula(String matricula){this.matricula= matricula;}
    public void setCalificaiones (){
       
        for (int i=0; i<calificaciones.length; i++){
            System.out.println("Ingrese calificaciones \n"+materias[i]+": ");
            calificaciones[i] = entrada.nextFloat();
        }
    }
    public String getMatricula(){return matricula;}
    public String getNombre(){return nombre;}
    public String getApellidoP(){return apellidoP;}
    public String getApellidoM(){return apellidoM;}
    
    /**
     * 
     */
    public void imprimirDatos(){
        System.out.println("Nombre: "+nombre+" "+apellidoP+" "+apellidoM+"\nMatricula: "+matricula);
        for (int i=0; i<materias.length;i++){
            System.out.println(materias[i]+": "+calificaciones[i]);
        }
    }

    public Alumno(String nombre, String apellidoP, String apellidoM, String matricula, float[] calificaciones){
        this.nombre = nombre;
        this.apellidoP= apellidoP;
        this.apellidoM= apellidoM;
        this.matricula= matricula;
        this.calificaciones = calificaciones;
    }

    public boolean compararMatricula(String m){
       return matricula.equals(m);
    }
}