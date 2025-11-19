package it.unibo.mvc;

/**
 * This is an interface that defines a basic controller.
 */
public interface Controller {

    /**
     * Prints in standard output the selected string.
     */
    void print();

    /**
     * Returns the current string.
     * 
     * @return the string.
     */
    String getString();

    /**
     * Sets the string passed in the parameter as the current one.
     * 
     * @param string the new string to be selected.
     */
    void setString(String string);
}
