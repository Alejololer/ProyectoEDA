import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Menu {
    private final JFrame window;
    private JLabel modo;
    private JLabel titulo;
    private JLabel menuBackgroundLabel;
    private JLabel nombreLabel;
    private JLabel contrasenaLabel;
    private JLabel honorificosLabel;
    private JPanel roundedPanel;
    private JPanel fotoPerfilPanel;
    private JLayeredPane layeredPane;
    private Font fuente;
    private Font fuente2;
    private Font fuente3;
    private ImageIcon menuBackgroundImage;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField edad;
    private JTextField cedula;
    private JTextField usuario;
    private JPasswordField contrasena;
    private JPasswordField confirmarContrasena;
    private JComboBox<String> comboBox;
    private JButton login;
    private JButton register;
    private JButton registrase;



    public Menu(String nombre, int width, int height){
        window = new JFrame(nombre);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);
        window.setLayout(null);
        initPrincipalComponent();
        initPrincipalActionListener();
    }

    private void initPrincipalComponent(){
        menuBackgroundImage = new ImageIcon("src/main/Imagenes/BackgroundMenu.jpg");
        menuBackgroundLabel = new JLabel(menuBackgroundImage);
        menuBackgroundLabel.setBounds(0,0,menuBackgroundImage.getIconWidth(), menuBackgroundImage.getIconHeight());

        fuente = new Font("Arial",Font.PLAIN, 50);
        fuente2 = new Font("Arial", Font.PLAIN,20);
        fuente3 = new Font("Arial", Font.PLAIN, 14);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1000,790); // Establecer el tamaño del JLayeredPane
        window.add(layeredPane);

        titulo = new JLabel("PoliHospital");
        titulo.setFont(fuente);
        titulo.setBounds(600,80,300,100);
        titulo.setForeground(Color.WHITE);

        roundedPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                int borderRadius = 50;
                g.fillRoundRect(0, 0, 400, 600, borderRadius, borderRadius);
            }
        };
        roundedPanel.setBounds(60, 60, 400, 650);
        roundedPanel.setOpaque(false);

        fotoPerfilPanel = getjPanel();

        modo = new JLabel("Modo: Usuario");
        modo.setFont(fuente2);
        modo.setBounds(250,80,170,120);

        comboBox = new JComboBox<>();
        comboBox.addItem("Usuario");
        comboBox.addItem("Doctor");
        comboBox.addItem("Administrador");
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.BLACK);
        comboBox.setFont(fuente3);

        comboBox.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                button.setContentAreaFilled(false);
                return button;
            }
        });

        comboBox.setBounds(130,250,250,40);

        nombreLabel = new JLabel("Nombre:");
        nombreLabel.setFont(fuente3);
        nombreLabel.setBounds(80,350, 250,40);

        setName();
        nombre.setBounds(170,350,250,40);


        contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setFont(fuente3);
        contrasenaLabel.setBounds(80,400,250,40);

        contrasena = new JPasswordField(20);
        contrasena.setEchoChar('*');
        contrasena.setBackground(Color.gray);
        contrasena.setForeground(Color.BLACK);
        contrasena.setBorder(BorderFactory.createLineBorder(Color.black,1));
        contrasena.setBounds(170,400,250,40);

        login = new JButton("Login");
        login.setContentAreaFilled(false);
        login.setBorderPainted(false);
        login.setFocusPainted(false);
        login.setForeground(Color.BLACK);
        login.setBackground(Color.green);
        login.setFont(fuente3);
        login.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int width = c.getWidth();
                int height = c.getHeight();
                g2d.setColor(Color.green);
                g2d.fillRoundRect(0, 0, width, height, 40, 40);
                super.paint(g, c);
            }
        });
        login.setBounds(270,500,170,40);

        register = new JButton("Register");
        register.setContentAreaFilled(false);
        register.setBorderPainted(false);
        register.setFocusPainted(false);
        register.setForeground(Color.BLACK);
        register.setBackground(Color.green);
        register.setFont(fuente3);
        register.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int width = c.getWidth();
                int height = c.getHeight();
                g2d.setColor(Color.green);
                g2d.fillRoundRect(0, 0, width, height, 40, 40);
                super.paint(g, c);
            }
        });
        register.setBounds(80,500,170,40);

        honorificosLabel = new JLabel("By Carlos A. Alejandro A. Ariel A. Emilio A");
        honorificosLabel.setFont(fuente3);
        honorificosLabel.setBounds(600,600,400,100);
        honorificosLabel.setForeground(Color.WHITE);


        layeredPane.add(menuBackgroundLabel, new Integer(0));
        layeredPane.add(roundedPanel, new Integer(1));
        layeredPane.add(titulo, new Integer(2));
        layeredPane.add(honorificosLabel, new Integer(3));
        layeredPane.add(fotoPerfilPanel, new Integer(4));
        layeredPane.add(modo, new Integer(5));
        layeredPane.add(comboBox, new Integer(6));
        layeredPane.add(nombre, new Integer(7));
        layeredPane.add(nombreLabel, new Integer(8));
        layeredPane.add(contrasena, new Integer(9));
        layeredPane.add(contrasenaLabel, new Integer(10));
        layeredPane.add(login, new Integer(11));
        layeredPane.add(register, new Integer(12));

    }

    private void eliminarMenuPrincipalRegistro(){
        layeredPane.remove(fotoPerfilPanel);
        layeredPane.remove(modo);
        layeredPane.remove(comboBox);
        layeredPane.remove(nombre);
        layeredPane.remove(nombreLabel);
        layeredPane.remove(contrasena);
        layeredPane.remove(contrasenaLabel);
        layeredPane.remove(register);
        layeredPane.remove(login);
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    private JPanel getjPanel() {
        JPanel fotoPerfilPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Ellipse2D.Double clip = new Ellipse2D.Double(0, 0, getWidth(), getHeight());

                Graphics2D g2d = (Graphics2D) g;
                g2d.setClip(clip);

                ImageIcon imagenPerfil = new ImageIcon("src/main/Imagenes/224fe2ab3b0bab7ba2a7ef5827d6fcd7.jpg");
                Image img = imagenPerfil.getImage();
                g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        fotoPerfilPanel.setBounds(100,80,120,120);
        fotoPerfilPanel.setOpaque(false);
        return fotoPerfilPanel;
    }
    private void initRegistroComponent(){
        setName();
        nombre.setBounds(170,150,250,40);

        apellido = new JTextField();
        apellido.setPreferredSize(new Dimension(150,30));
        apellido.setBorder(BorderFactory.createLineBorder(Color.black,1));
        apellido.setBackground(Color.gray);
        apellido.setForeground(Color.BLACK);
        apellido.setFont(fuente3);
        apellido.setBounds(170,200,250,40);

        edad = new JTextField();
        edad.setPreferredSize(new Dimension(150,30));
        edad.setBorder(BorderFactory.createLineBorder(Color.black,1));
        edad.setBackground(Color.gray);
        edad.setForeground(Color.BLACK);
        edad.setFont(fuente3);
        edad.setBounds(170,250,250,40);

        cedula = new JTextField();
        cedula.setPreferredSize(new Dimension(150,30));
        cedula.setBorder(BorderFactory.createLineBorder(Color.black,1));
        cedula.setBackground(Color.gray);
        cedula.setForeground(Color.BLACK);
        cedula.setFont(fuente3);
        cedula.setBounds(170,300,250,40);

        usuario = new JTextField();
        usuario.setPreferredSize(new Dimension(150,30));
        usuario.setBorder(BorderFactory.createLineBorder(Color.black,1));
        usuario.setBackground(Color.gray);
        usuario.setForeground(Color.BLACK);
        usuario.setFont(fuente3);
        usuario.setBounds(170,100,250,40);


        contrasena = new JPasswordField(20);
        contrasena.setEchoChar('*');
        contrasena.setBackground(Color.gray);
        contrasena.setForeground(Color.BLACK);
        contrasena.setBorder(BorderFactory.createLineBorder(Color.black,1));
        contrasena.setBounds(170,350,250,40);

        confirmarContrasena = new JPasswordField(20);
        confirmarContrasena.setEchoChar('*');
        confirmarContrasena.setBackground(Color.gray);
        confirmarContrasena.setForeground(Color.BLACK);
        confirmarContrasena.setBorder(BorderFactory.createLineBorder(Color.black,1));
        confirmarContrasena.setBounds(170,400,250,40);

        registrase = new JButton("Registrarse");
        registrase.setContentAreaFilled(false);
        registrase.setBorderPainted(false);
        registrase.setFocusPainted(false);
        registrase.setForeground(Color.BLACK);
        registrase.setBackground(Color.green);
        registrase.setFont(fuente3);
        registrase.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int width = c.getWidth();
                int height = c.getHeight();
                g2d.setColor(Color.green);
                g2d.fillRoundRect(0, 0, width, height, 40, 40);
                super.paint(g, c);
            }
        });
        registrase.setBounds(150,500,170,40);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setFont(fuente3);
        usuarioLabel.setBounds(80,100, 250,40);
        JLabel nombreslabel = new JLabel("Nombres:");
        nombreslabel.setFont(fuente3);
        nombreslabel.setBounds(80,150,250,40);
        JLabel apellidoslabel = new JLabel("Apellidos:");
        apellidoslabel.setFont(fuente3);
        apellidoslabel.setBounds(80,200,250,40);
        JLabel edadeslabel = new JLabel("Edad:");
        edadeslabel.setFont(fuente3);
        edadeslabel.setBounds(80,250,250,40);
        JLabel cedulaLabel = new JLabel("Cedula:");
        cedulaLabel.setFont(fuente3);
        cedulaLabel.setBounds(80,300,250,40);
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setFont(fuente3);
        contrasenaLabel.setBounds(80,350,250,40);
        JLabel cContrasena = new JLabel("Confirmar C:");
        cContrasena.setFont(fuente3);
        cContrasena.setBounds(80,400,250,40);


        layeredPane.add(nombre,new Integer(4));
        layeredPane.add(apellido, new Integer(5));
        layeredPane.add(edad, new Integer(6));
        layeredPane.add(cedula, new Integer(7));
        layeredPane.add(registrase, new Integer(8));
        layeredPane.add(contrasena, new Integer(9));
        layeredPane.add(confirmarContrasena, new Integer(10));
        layeredPane.add(usuario, new Integer(11));
        layeredPane.add(usuarioLabel, new Integer(12));
        layeredPane.add(nombreslabel, new Integer(13));
        layeredPane.add(apellidoslabel, new Integer(14));
        layeredPane.add(edadeslabel, new Integer(15));
        layeredPane.add(cedulaLabel, new Integer(16));
        layeredPane.add(contrasenaLabel, new Integer(17));
        layeredPane.add(cContrasena, new Integer(18));
    }

    private void eliminarVentana(){
        window.remove(layeredPane);
        window.revalidate();
        window.repaint();
    }
    private void initRegisterActionLister(){

    }
    private void setName() {
        nombre = new JTextField();
        nombre.setPreferredSize(new Dimension(150,30));
        nombre.setBorder(BorderFactory.createLineBorder(Color.black,1));
        nombre.setBackground(Color.gray);
        nombre.setForeground(Color.BLACK);
        nombre.setFont(fuente3);
    }

    private void initPrincipalActionListener(){
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarMenuPrincipalRegistro();
                initRegistroComponent();
            }
        });
    }

    public void showWindow(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {window.setVisible(true);}
        });
    }

}
