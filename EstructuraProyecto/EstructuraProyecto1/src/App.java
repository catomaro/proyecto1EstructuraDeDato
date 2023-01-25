import java.util.Scanner;
public class App {
   static Gestor gestor = new Gestor();//permite gestionar los usuarios
   static Scanner entrada = new Scanner(System.in);
   static Scanner num = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        Usuario user = new Usuario("user1","Pasa");
        boolean ingreso = false;//Esto es para si o no se podra ingresar al menu principal
        String nombre = "";
        String contra = "";
        //Parte de ingresar usuario y contraseña
        int opcionM = 0;//variable para opcion del menu
        do{
           
        System.out.println("ingrese los datos para ingresar al sistema");
        System.out.println("ingrese el nombre de usuario");
        nombre = entrada.nextLine();
        System.out.println("ingrese la contraseña");
        contra = entrada.nextLine();
        ingreso = user.sonIguales(nombre,contra);
        }while(!user.llegoCero() && !ingreso);
        //termina el loggeo

        //inicio de todo el sistema
        if(ingreso){
         do{
           System.out.println("____________________________________");
           System.out.println("                  Menu");
           System.out.println("____________________________________");
           System.out.println("1)Añadir alumno");
           System.out.println("2)Datos de alumno por matricula\n3)Modificar calificaciones de alumno");
           opcionM = num.nextInt();
           switch(opcionM){
             case 1:
               registarAlumno();
             break;
             case 2:
               buscarAlumno();
               break;
             case 3:
                
             break;
           }
         }while(opcionM != 4);
        }else{
            System.out.println("Excediste el numero de intentos disponible intente mas tarde");
        }
    }

    public static void registarAlumno(){
      
      
      String nombre = "";
      String apellidoP = "";
      String apellidoM = "";
      String matricula ="";
      boolean bandera = false;
      int opcion = 0;
      System.out.println("ingrese el nombre del alumno");
      nombre = entrada.nextLine();
      System.out.println("ingrese el apellido paterno del alumno");
      apellidoP = entrada.nextLine();
      System.out.println("ingrese el apellido materno");
      apellidoM = entrada.nextLine();
      do{
      System.out.println("ingrese la matricula");
      matricula = entrada.nextLine();
      bandera = gestor.comprobarMatricula(matricula);
      if(bandera){
        System.out.println("esta matricula ya existe");
        System.out.println("______________________________");
        System.out.println("     Desea continuar");
        System.out.println("______________________________");
        System.out.println("1)Si  seleccione otro numero)No");
        System.out.println("______________________________");
        opcion = num.nextInt();
        entrada.next();

      }
      }while(opcion == 1 &&  bandera);

      if(!bandera){
        
      
        Alumno a = new Alumno(nombre, apellidoP, apellidoM, matricula,llenarCalificaciones());
        System.out.println("registro exitoso");
      }
   
      
    }

    public static void buscarAlumno(){
        System.out.println("ingrese la matricula a mostrar");
      
        Alumno alumno = gestor.buscarAlumno(entrada.nextLine());

        if(alumno != null){
            alumno.imprimirDatos();
        }else{
            System.out.println("alumno no encontrado");
        }
 
    }

    public static float[] llenarCalificaciones(){
        String materias[] = {"POO", "Estructura de Datos","ISAC","Calculo Diferencial","Procesos de Software","Desarrollo Humano"};
        float calificaciones[] = new float[6];
        for (int i=0; i<calificaciones.length; i++){
            System.out.println("Ingrese calificaciones \n"+materias[i]+": ");
            calificaciones[i] = num.nextFloat();
        }
        return calificaciones;
    }

    public static void modificarCalificaciones(){
        String matricula;
        System.out.println("Ingrese matricula: ");
        matricula = entrada.next();
        if(gestor.comprobarMatricula(matricula)){
            Alumno alumno = gestor.buscarAlumno(matricula);
            alumno.setCalificaiones();
        }
        
    }
}
