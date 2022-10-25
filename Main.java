
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Lecture du programme de la machine de turing à partir du fichier JSON.
        TuringMachine turingMachine = new TuringMachine("./examples/comparaison_nb_x_y.json");

        // Execution du programme.
        System.out.println("État final  : " + turingMachine.execute());
        System.out.println("fin");
    }
}
