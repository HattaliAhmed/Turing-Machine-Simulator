
public class Transition {
    private String read;
    private String replace;
    private String direction;
    private String nextState;

    public String getReplace() {
        // Retourne le caractère de remplacement.
        return replace;
    }

    public void setReplace(String replace) {
        // Défini le caractère de remplacement.
        this.replace = replace;
    }

    public void setRead(String read) {
        // Défini la condition de la transition.
        this.read = read;
    }

    public String getDirection() {
        // Retourne la direction de déplacement de la tete de lecture.
        return direction;
    }

    public void setDirection(String direction) {
        // Défini la direction de déplacement de la tete de lecture.
        this.direction = direction;
    }

    public String getNextState() {
        // Retourne le nom de l'état suivant.
        return nextState;
    }

    public void setNextState(String nextState) {
        // Défini le nom de l'état suivant.
        this.nextState = nextState;
    }

    public String getRead() {
        return read;
    }
}
