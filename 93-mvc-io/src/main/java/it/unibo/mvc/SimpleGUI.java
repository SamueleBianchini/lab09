package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();

    /**
     * The constructor for this class, creates the whole graphic interface.
     */
    public SimpleGUI() {

        final SimpleController controller = new SimpleController();

        final JPanel panel = new JPanel(new BorderLayout());
        final JTextField field = new JTextField();
        panel.add(field, BorderLayout.NORTH);
        final JTextArea area = new JTextArea();
        panel.add(area, BorderLayout.CENTER);
        final JPanel inner = new JPanel();
        inner.setLayout(new BoxLayout(inner, BoxLayout.X_AXIS));
        final JButton print = new JButton("print");
        inner.add(print);
        final JButton history = new JButton("Show history");
        inner.add(history);
        panel.add(inner, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignore) {
                controller.setString(field.getText());
                controller.print();
            }
        });

        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignore) {
                area.setText(controller.getHistory().toString());
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
        new SimpleGUI().display();

    }
}
