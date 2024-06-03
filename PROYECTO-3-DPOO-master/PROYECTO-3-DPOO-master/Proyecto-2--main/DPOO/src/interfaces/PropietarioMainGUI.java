package interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropietarioMainGUI {
    private JFrame frame;
    private JPanel panel;
    private JButton verPiezasButton;
    private JButton verCompradoresButton;
    private JButton buscarPiezaButton;
    private JButton buscarCompradorButton;
    private JButton consignarPiezaButton;
    private JButton verSubastasButton;
    private JButton verHistorialPiezasButton;
    private JButton salirButton;

    public PropietarioMainGUI() {
        frame = new JFrame("Propietario Main");
        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        verPiezasButton = new JButton("Ver piezas");
        verPiezasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría el código para ver piezas
                System.out.println("Ver piezas");
            }
        });

        verCompradoresButton = new JButton("Ver compradores");
        verCompradoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría el código para ver compradores
                System.out.println("Ver compradores");
            }
        });

        buscarPiezaButton = new JButton("Buscar pieza y autor");
        buscarPiezaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría el código para buscar pieza y autor
                System.out.println("Buscar pieza y autor");
            }
        });

        buscarCompradorButton = new JButton("Buscar comprador");
        buscarCompradorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría el código para buscar comprador
                System.out.println("Buscar comprador");
            }
        });

        consignarPiezaButton = new JButton("Consignar pieza");
        consignarPiezaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría el código para consignar pieza
                System.out.println("Consignar pieza");
            }
        });

        verSubastasButton = new JButton("Ver subastas");
        verSubastasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría el código para ver subastas
                System.out.println("Ver subastas");
            }
        });

        verHistorialPiezasButton = new JButton("Ver historial de piezas");
        verHistorialPiezasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría el código para ver historial de piezas
                System.out.println("Ver historial de piezas");
            }
        });

        salirButton = new JButton("Salir");
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría el código para salir
                System.out.println("Salir");
                System.exit(0);
            }
        });

        // Añadir los botones al panel
        panel.add(verPiezasButton);
        panel.add(verCompradoresButton);
        panel.add(buscarPiezaButton);
        panel.add(buscarCompradorButton);
        panel.add(consignarPiezaButton);
        panel.add(verSubastasButton);
        panel.add(verHistorialPiezasButton);
        panel.add(salirButton);

        // Configurar el frame
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PropietarioMainGUI();
            }
        });
    }
}

