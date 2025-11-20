package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {

    private File element;

    /**
     * This constructor sets the current file as output.txt.
     */
    public Controller() {
        this.element = new File(System.getProperty("user.home"), "output.txt");
    }

    /**
     * Sets the file to the one passed as a parameter.
     * 
     * @param input is the new file.
     */
    public void setFile(final File input) {
        this.element = input;
    }

    /**
     * Is used to get the current file used by the class.
     * 
     * @return the current file.
     */
    public File getFile() {
        return this.element;
    }

    /**
     * Is used to get the path for the current file.
     * 
     * @return a string rapresentation of the file path.
     */
    public String getPath() {
        return this.element.getPath();
    }

    /**
     * Writes the string passed as a parameter into the current file.
     * 
     * @param insert is the String you want to insert into the file.
     * 
     * @throws IOException if the string cannot be written.
     */
    public void insertString(final String insert) throws IOException {
        try (final PrintStream ps = new PrintStream(this.getPath(), StandardCharsets.UTF_8)) {
            ps.println(insert);
        }
    }
}
