package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame("My second java graphical interface");

    /**
     * Creates the graphic interface for the file.
     */
    public SimpleGUIWithFileChooser() {

        final Controller controller = new Controller();

        final JPanel panel = new JPanel(new BorderLayout());
        final JTextArea text = new JTextArea();
        panel.add(text, BorderLayout.CENTER);
        final JButton save = new JButton("save");
        panel.add(save, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel inner = new JPanel(new BorderLayout());
        final JTextField field = new JTextField();
        field.setEditable(false);
        field.setText(controller.getPath());
        inner.add(field, BorderLayout.CENTER);
        final JButton browse = new JButton("Browse");
        inner.add(browse, BorderLayout.LINE_END);
        panel.add(inner, BorderLayout.NORTH);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                try {
                    controller.insertString(text.getText());
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(frame, "An error occured while saving the file");
                }
            }
        });

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                final JFileChooser chooser = new JFileChooser();
                final int result = chooser.showSaveDialog(frame);
                switch (result) {
                    case JFileChooser.APPROVE_OPTION: controller.setFile(chooser.getSelectedFile()); 
                        field.setText(controller.getPath()); 
                        break;
                    case JFileChooser.CANCEL_OPTION: break;
                    case JFileChooser.ERROR_OPTION: JOptionPane.showMessageDialog(frame, "An error has occured");
                    default: JOptionPane.showMessageDialog(frame, "Well i don't know how we got here");
                }
            }
        });
    }

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }

    /**
     * Starts the compilation by calling the constructor of the file and the display to make it visible.
     * 
     * @param args not necessary.
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser().display();

    }
}
