package UserInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
    private JPanel acPanelPrincipal = new JPanel();
    public Ventana(){
        setTitle("GUERRA");
        setBounds(0, 0, 800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(acPanelPrincipal);
    }
}
