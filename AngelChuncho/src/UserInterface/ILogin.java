package UserInterface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import BusinessLogic.UsuarioBL;
import BusinessLogic.Entities.Usuario;
import Framework.EncriptarContrasena;

public class ILogin extends JFrame {
    private JPanel acPanelPrincipal = new JPanel();
    private static JTextField acTxtUsuario;
    private static  JPasswordField acTxtContrasena;
    int acIntentosLogin = 0;


    public static void main(String[] args) throws Exception {
        ILogin acFrameInicio = new ILogin();
        acFrameInicio.setVisible(true);
    }
    
    public ILogin(){
        /*
         * Se crean los paneles necesarios para organizar los componentes del formulario
         * de registro de productos
         */

        setTitle("LOGIN");
        setBounds(0, 0, 800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(acPanelPrincipal);

        acPanelPrincipal.setLayout(new BorderLayout(0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel acPanelSuperior = new JPanel();
        acPanelSuperior.setOpaque(false);
        acPanelPrincipal.add(acPanelSuperior, BorderLayout.NORTH);

        JPanel acPanelIzquierdo = new JPanel();
        acPanelPrincipal.add(acPanelIzquierdo, BorderLayout.WEST);
        
        JPanel acPanelCentral = new JPanel();
        acPanelPrincipal.add(acPanelCentral, BorderLayout.CENTER);
        acPanelCentral.setLayout(new BorderLayout(5, 5));

        JPanel acPanelCentralSuperior = new JPanel();
        acPanelCentral.add(acPanelCentralSuperior, BorderLayout.NORTH);

        JPanel acPanelCentralCentro = new JPanel();
        acPanelCentral.add(acPanelCentralCentro, BorderLayout.CENTER);
        acPanelCentralCentro.setLayout(new GridLayout(7, 2, 10, 0));

        /**
         * Creacion del resto de componentes que conforman el formulario Login
         */
        JLabel acLblTitulo = new JLabel("FUERZAS ESPECIALES RUSAS");
        acLblTitulo.setFont(new Font("Berlin Sans FB", Font.BOLD | Font.ITALIC, 25));
        acLblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        acPanelSuperior.add(acLblTitulo);

        JLabel acLblFondoLogin = new JLabel();
        acLblFondoLogin.setIcon(new ImageIcon("images/img_soldado.jpg"));
        acLblFondoLogin.setBounds(0, 0, 0, 0);
        acPanelIzquierdo.add(acLblFondoLogin);

        JLabel acLblIngreseDatos = new JLabel("INGRESE SUS DATOS");
        acLblIngreseDatos.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
        acPanelCentralSuperior.add(acLblIngreseDatos);

        JLabel acLblAyudante1 = new JLabel("            ");
        acPanelCentralCentro.add(acLblAyudante1);

        JLabel acLblAyudante2 = new JLabel("            ");
        acPanelCentralCentro.add(acLblAyudante2);

        JLabel acLblUsuario = new JLabel("Usuario :");
        acLblUsuario.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
        acPanelCentralCentro.add(acLblUsuario);

        //TODO txtusuario
        acTxtUsuario = new JTextField();
        acTxtUsuario.setColumns(10);
        acPanelCentralCentro.add(acTxtUsuario);

        JLabel acLblAyudante3 = new JLabel("            ");
        acPanelCentralCentro.add(acLblAyudante3);
        
        JLabel acLblAyudante4 = new JLabel("            ");
        acPanelCentralCentro.add(acLblAyudante4);

        JLabel acLblContrasena = new JLabel("Contraseña :");
        acLblContrasena.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
        acPanelCentralCentro.add(acLblContrasena);

        acTxtContrasena = new JPasswordField();
        acTxtContrasena.setColumns(10);
        acPanelCentralCentro.add(acTxtContrasena);

        JLabel acLblAyudante5 = new JLabel("            ");
        acPanelCentralCentro.add(acLblAyudante5);
        
        JLabel acLblAyudante6 = new JLabel("            ");
        acPanelCentralCentro.add(acLblAyudante6);

        JButton acBtnLimpiar = new JButton("Limpiar");
        acBtnLimpiar.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        acBtnLimpiar.setHorizontalAlignment(SwingConstants.CENTER);
        acPanelCentralCentro.add(acBtnLimpiar);
        acBtnLimpiar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                acTxtUsuario.setText("");
                acTxtContrasena.setText("");
            }
        });

        JButton acBtnLogin = new JButton("Iniciar Sesión");
        acBtnLogin.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
        acBtnLogin.setHorizontalAlignment(SwingConstants.CENTER);
        acPanelCentralCentro.add(acBtnLogin);
        acBtnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    acIntentosLogin++;
                    if (acIntentosLogin > 2) {
                        JOptionPane.showMessageDialog(null, "Se alcanzó el límite de intentos permitidos. El programa se cerrará.");
                        System.exit(0);
                    }

                    UsuarioBL acUser = new UsuarioBL();
                    EncriptarContrasena acEncriptar = new EncriptarContrasena();
                    String acTexto = new String(acTxtContrasena.getPassword());
                    String acTextoEncriptado = acEncriptar.acEncriptar(acTexto);
                    Usuario acNuevoUsuario = acUser.acGetUsuarioLogin(acTxtUsuario.getText().trim(), acTextoEncriptado);
                    if (acNuevoUsuario != null) {
                            Ventana iAdmin = new Ventana();
                            iAdmin.setVisible(true);
                            dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario " + acTxtUsuario.getText()+ " no se encuentra en la base de datos.");
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Error al loguearse");
                }
            }
        });

        JLabel acLblAyudante7 = new JLabel("            ");
        acPanelCentralCentro.add(acLblAyudante7);
        
        JLabel acLblAyudante8 = new JLabel("            ");
        acPanelCentralCentro.add(acLblAyudante8);
        
    }
}
