import java.util.Vector;

public class Gestor {
    Vector<Alumno> v = new Vector<>();

    public void addEstudiante(Alumno a){//metodo para Añadir estudiante
        v.addElement(a);
    }

    public boolean comprobarMatricula(String matricula){
        boolean existe = false;
        int i = 0;
        if(matricula.length() == 6){
            while(i < v.size() && !existe){
             if(v.get(i).getMatricula().equals(matricula)){
                existe = true;
             }
            i++;
            }
        } else {
            System.out.println("la matricula debe ser de 6 digitos");
    
        }
        
        return existe;
    }

    public Alumno buscarAlumno(String matricula){
        Alumno alumno = null;
        boolean existe = false;
        int i = 0;
        while(i < v.size()  && !existe){
             if(v.get(i).compararMatricula(matricula)){
                existe = true;
                alumno = v.get(i);
             }
            i++;
        }
        return alumno;
    }
}
