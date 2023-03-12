package UserInterface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Framework.EncriptarContrasena;

public class Login extends JFrame {
    private JPanel acPanelPrincipal = new JPanel();
    //private JPanel acPanelFondo = new JPanel();
    private static JTextField acTxtUsuario;
    private static  JPasswordField acTpfContrasena;
    //JComboBox cbxRol;

    public static void main(String[] args) throws Exception {
        Login acFrameInicio = new Login();
        acFrameInicio.setVisible(true);
        EncriptarContrasena encriptar = new EncriptarContrasena();
        //String texto = acTpfContrasena.getText;
        //String texto = "0705977823";
        String textoEncriptado = encriptar.acEncriptar(texto);
        String textoDesencriptado = encriptar.acDesencriptar(textoEncriptado);
        System.out.println("Texto desencriptado: " + textoDesencriptado);
        System.out.println("Texto encriptado: " + textoEncriptado);
        System.out.println("Texto original: " + texto);
    }
    
    public Login(){
        /*
         * Se crean los paneles necesarios para organizar los componentes del formulario
         * de registro de productos
         */

        //setLayout(new BorderLayout(0, 0));
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

        //TODO AQUI YA NO HAY PANELES

        JLabel acLblTitulo = new JLabel("FUERZAS ESPECIALES RUSAS");
        acLblTitulo.setFont(new Font("Berlin Sans FB", Font.BOLD | Font.ITALIC, 25));
        acLblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        acPanelSuperior.add(acLblTitulo);

        //ImageIcon acFondoLogin = new ImageIcon("images/img_fondoMilitar.jpg");
        JLabel acLblFondoLogin = new JLabel();
        acLblFondoLogin.setIcon(new ImageIcon("images/img_soldado.jpg"));
        acLblFondoLogin.setBounds(0, 0, 0, 0);
        acPanelIzquierdo.add(acLblFondoLogin);

        // JLabel acLblImagenSoldado = new JLabel("New label");
        // acPanelIzquierdo.add(acLblImagenSoldado);

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

        JTextField acTxtContrasena = new JTextField();
        acTxtUsuario.setColumns(10);
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

        JLabel acLblAyudante7 = new JLabel("            ");
        acPanelCentralCentro.add(acLblAyudante7);
        
        JLabel acLblAyudante8 = new JLabel("            ");
        acPanelCentralCentro.add(acLblAyudante8);
        //panelSuperior.add(lbTittle);


        // JLabel lblAcEslogan = new JLabel("Te ayudamos en todo");
        // lbEslogan.setForeground(new Color(255, 255, 255));
        // lbEslogan.setHorizontalAlignment(SwingConstants.CENTER);
        // lbEslogan.setHorizontalTextPosition(SwingConstants.CENTER);
        // lbEslogan.setFont(new Font("Amaranth", Font.PLAIN, 25));
        // lbEslogan.setBounds(0, 25, 740, 51);
        // panelPrincipal.add(lbEslogan);

        //TODO
        // JLabel lbLeyenda = new JLabel("Registre sus datos");
        // lbLeyenda.setHorizontalAlignment(SwingConstants.CENTER);
        // lbLeyenda.setFont(new Font("Lato", Font.BOLD, 18));
        // lbLeyenda.setBounds(462, 90, 255, 17);
        // panelPrincipal.add(lbLeyenda);

        // JLabel lbUsuarioIcon = new JLabel();
        // lbUsuarioIcon.setBounds(415, 141, 30, 30);
        // ImageIcon imgUsuario = new ImageIcon("images/iconos/user.png");
        // Icon iconUsuario = new ImageIcon(
        //         imgUsuario.getImage().getScaledInstance(lbUsuarioIcon.getWidth(), lbUsuarioIcon.getHeight(),
        //                 Image.SCALE_SMOOTH));
        // lbUsuarioIcon.setIcon(iconUsuario);
        // panelPrincipal.add(lbUsuarioIcon);

        // JLabel lbContrasenaIcon = new JLabel();
        // lbContrasenaIcon.setBounds(415, 261, 30, 30);
        // ImageIcon imgContrasena = new ImageIcon("images/iconos/password.png");
        // Icon iconContrasena = new ImageIcon(
        //         imgContrasena.getImage().getScaledInstance(lbContrasenaIcon.getWidth(),
        //                 lbContrasenaIcon.getHeight(),
        //                 Image.SCALE_SMOOTH));
        // lbContrasenaIcon.setIcon(iconContrasena);
        // panelPrincipal.add(lbContrasenaIcon);

        // txtUsuario = new JTextField();
        // txtUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        // txtUsuario.setFont(new Font("Dialog", Font.PLAIN, 13));
        // txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        // txtUsuario.setOpaque(false);
        // txtUsuario.setBounds(462, 141, 255, 30);
        // panelPrincipal.add(txtUsuario);
        // txtUsuario.setColumns(10);

        // txtContrasena = new JPasswordField();
        // txtContrasena.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        // txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
        // txtContrasena.setOpaque(false);
        // txtContrasena.setBounds(463, 261, 253, 30);
        // panelPrincipal.add(txtContrasena);

        // String[] roles = { "Administrador", "Trabajador" };
        // //cbxRol = new JComboBox<>(roles);

        // //cbxRol.setForeground(Color.DARK_GRAY);
        // //cbxRol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        // //cbxRol.setBackground(new Color(255, 140, 0));
        // //cbxRol.setBounds(478, 206, 223, 24);
        // //panelPrincipal.add(cbxRol);

        // JButton btnIngresar = new JButton("Ingresar");
        // btnIngresar.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {

        //         try {
        //             iniciarSesion();
        //         } catch (Exception e1) {
        //         }
        //     }
        // });
        // btnIngresar.setBackground(new Color(255, 140, 0));
        // btnIngresar.setBorderPainted(false);
        // btnIngresar.setBorder(new LineBorder(new Color(73, 168, 53), 10, true));
        // btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        // setLocationRelativeTo(null);
        // btnIngresar.setBounds(531, 329, 117, 25);
        // panelPrincipal.add(btnIngresar);

        // JLabel lbImgLogo = new JLabel();
        // lbImgLogo.setBounds(0, 142, 385, 264);
        // ImageIcon imgLogo = new ImageIcon("images/img_fondoLogin.png");
        // Icon iconLogo = new ImageIcon(
        //         imgLogo.getImage().getScaledInstance(lbImgLogo.getWidth(), lbImgLogo.getHeight(),
        //                 Image.SCALE_SMOOTH));
        // lbImgLogo.setIcon(iconLogo);
        // panelPrincipal.add(lbImgLogo);
    }
}
