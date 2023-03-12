package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import Framework.APP;
import Framework.AppException;

/**
 * Clase DAC que permite realziar consultas con la base de datos sobre los usuarios
 */
public class UsuarioDAC extends DataHelper{

    /**
     * Constructor 
     * @throws AppException
     */
    public UsuarioDAC() throws AppException{
        super(APP.getProperty(APP.GLOBAL.KEY_DB_FULLPATH));
    }

    /**
     * Permite obtener el resultado de la consulta sql
     * @return Retorna el resultado de la consulta sql
     * @throws AppException
     */
    public ResultSet acGetUsuario() throws AppException{
        try {
            String sql = "SELECT " + APP.GLOBAL.ACCORREO + ", "
                                   + APP.GLOBAL.ACCONTRASENA
                                   + " FROM " + APP.GLOBAL.ACTABLA_USUARIO;
            return getResultSet(sql);
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getAllUsuario()" + e.getMessage());
        }
    }
}
