public class Usuario {
    private String nombre;
    private String password;
    private byte intentos;
    public Usuario(String nombre,String password){
        this.nombre = nombre;
        this.password = password;
        this.intentos = 3;
    }
    
   public boolean sonIguales(String nom,String contra){
        boolean bandera = (nombre.equals(nom) && password.equals(contra));

        if(!bandera)
           quitarIntentos();
       return bandera;
   }
    
   private void quitarIntentos(){
        this.intentos = (byte) ((byte) intentos - 1);
   }

   public boolean llegoCero(){
      return intentos == 0;
   }
}
