package BusinessLogic.Entities;

public class Usuario {
    private String acEmail;
    private String acContrasena;
    
    public Usuario(String acEmail, String acContrasena){
        this.acEmail = acEmail;
        this.acContrasena = acContrasena;
    }

    public String acGetEmail() {
        return acEmail;
    }

    public String acGetContrasena() {
        return acContrasena;
    }

}
