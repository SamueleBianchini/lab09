package it.unibo.mvc;

import java.util.List;
import java.util.ArrayList;

/**
 * This class implements the interface Controller.
 *
 */
public final class SimpleController implements Controller {

    private String string;
    private final List<String> history;

    /**
     * Constructor for the class.
     */
    public SimpleController() {
        history = new ArrayList<>();
    }

    /**
     * Returns all the strings printed until now.
     * 
     * @return a {@link List} of strings.
     */
    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    @Override
    public void print() {
        System.out.println(string); //NOPMD required by the exercise
        history.add(string);
    }

    @Override
    public String getString() {
        return this.string;
    }

    @Override
    public void setString(final String string) {
        if (string == null || string.isEmpty() || string.isBlank()) {
            throw new IllegalStateException("The string parameter is null or empty");
        } else {
            this.string = string;
        }
    }
}
