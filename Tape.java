
import java.util.LinkedList;

public class Tape {
    private final LinkedList<String> tape = new LinkedList<>(); // La bande de l'automate.
    private int index = 0; // L'index de la position courante de la tete de lecture.

    public int getIndex() {
        return index;
    }

    public Tape(String entry) {
        // Creation de la bande à partir d'une chaine de caractères initiale.
        if (entry.length() == 0) {
            this.tape.add("#");
            return;
        }
        for (int i = 0; i < entry.length(); i++) {
            this.tape.add(String.valueOf(entry.charAt(i)));
        }
    }

    public String read() {
        // Retourne le caractère à la position courante de la tete de lecture.
        return tape.get(index);
    }

    public void write(String replace, String direction) {
        // Remplace le caractère à la position courante de la tete de lecture.
        tape.set(index, replace);

        // Déplace la tete de lecture dans la direction indiquée par la variable.
        if (direction.equals("L")) {
            --index;
            if (index < 0) {
                tape.addFirst("#");
                index = 0;
            }
        }
        if (direction.equals("R")) {
            ++index;
            if (index >= tape.size() - 1) {
                tape.addLast("#");
            }
        }
    }

    @Override
    public String toString() {
        // Retourne la bande sous forme de chaine de caractères.
        StringBuilder strBuffer = new StringBuilder();
        for (String str : tape) {
            strBuffer.append(str);
        }
        return strBuffer.toString();
    }
}
