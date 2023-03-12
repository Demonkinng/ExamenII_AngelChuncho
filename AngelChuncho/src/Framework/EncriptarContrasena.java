/**
*   Examen II
*   @author Angel David Chuncho Jiménez
*   @version 1.0 - Base de datos
*   Recopilado de ChatGPT
*/
package Framework;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Clase que se encarga de encriptar las contraseñas de los usuarios 
 */
public class EncriptarContrasena {

    private static final String ACALGORITMO = "AES"; // Algoritmo de encriptación simétrico
    private static final String ACCLAVE_SECRETA = "esta_es_una_clave_secreta_de_32_bytes".substring(0, 32);

    /**
     * Permite encriptar las palabras deseadas, en este caso util para encriptar contraseñas
     * @param acPalabras Recibe las palabras que se desea encriptar
     * @return Retorna las mismas palabras ingresadas pero de forma encriptada
     */
    public String acEncriptar(String acPalabras) throws Exception {
        SecretKeySpec acClave = new SecretKeySpec(ACCLAVE_SECRETA.getBytes(), ACALGORITMO);
        Cipher acCifrador = Cipher.getInstance(ACALGORITMO);
        acCifrador.init(Cipher.ENCRYPT_MODE, acClave);
        byte[] acCadenaEncriptada = acCifrador.doFinal(acPalabras.getBytes());
        return Base64.getEncoder().encodeToString(acCadenaEncriptada);
    }

    /**
     * Permite obtener el mensaje original una vez que fue encriptado
     * @param acPalabrasEncriptadas Recibe las palabras encriptadas anteriormente
     * @return Retorna el mensaje original, es decir, ya desencriptado
     */
    public String acDesencriptar(String acPalabrasEncriptadas) throws Exception {
        SecretKeySpec acClave = new SecretKeySpec(ACCLAVE_SECRETA.getBytes(), ACALGORITMO);
        Cipher acCifrador = Cipher.getInstance(ACALGORITMO);
        acCifrador.init(Cipher.DECRYPT_MODE, acClave);
        byte[] acTextoDesencriptado = acCifrador.doFinal(Base64.getDecoder().decode(acPalabrasEncriptadas));
        return new String(acTextoDesencriptado);
    }
}
