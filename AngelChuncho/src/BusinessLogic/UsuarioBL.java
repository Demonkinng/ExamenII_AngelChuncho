package BusinessLogic;

import java.sql.ResultSet;

import BusinessLogic.Entities.Usuario;
import DataAccess.UsuarioDAC;
import Framework.APP;
import Framework.AppException;

public class UsuarioBL {

    /**
     * Permite verificar si el usuario que desea ingresar al sistema se encuentra registrado
     * en la Base de Datos.
     * @param acEmail Recibe el email del usuario
     * @param acConstrasena Recibe la contraseña del usuario
     * @return Encuentra al usuario en la BD y retorna el mismo si es valido
     * @throws Exception
     */
    public Usuario acGetUserLogin(String acEmail, String acConstrasena) throws Exception {
        try {
            UsuarioDAC userDAC = new UsuarioDAC();
            ResultSet rs = userDAC.getUsuario();
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString(APP.GLOBAL.ACCORREO)
                                        , rs.getString(APP.GLOBAL.ACCONTRASENA));

                if (u.acGetEmail().equalsIgnoreCase(acEmail) && u.acGetContrasena().equals(acConstrasena)){
                    return u;
                }
            }
        } catch (Exception e) {
            throw new AppException(e, getClass(),
                    "Error en getUserLogin(String acEmail, String acContrasena): " + e.getMessage());
        }
        return null;
    }
}
