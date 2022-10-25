
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;

public class TuringMachine {
    private Tape tape;
    private final HashMap<String, State> States = new HashMap<>();
    private String initialState;

    public TuringMachine(String fileName) {
        // Creation de l'automate à partir d'un fichier JSON.
        try {
            // Lecture du fichier JSON.
            // check if the file exists
            FileReader program = new FileReader(fileName);

            // Creation d'un objet JSON à partir du fichier.
            JSONParser parser = new JSONParser();
            JSONObject jsonProgram = (JSONObject) parser.parse(program);

            // Creation de la bande initiale à partir d'un objet JSON.
            this.tape = new Tape((String) jsonProgram.get("input"));

            // Définition de l'état initial de l'automate.
            this.initialState = (String) jsonProgram.get("startState");

            // Creation des états de l'automate à partir d'un objet JSON.
            JSONArray jsonStates = (JSONArray) jsonProgram.get("states");
            for (Object jsonState : jsonStates) {
                String stateName = (String) ((JSONObject) jsonState).get("state");
                State state = new State((JSONObject) jsonState);
                this.States.put(stateName, state);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String execute() throws InterruptedException {
        // Execute l'automate sur la bande.
        int i = 0;
        // Affichage de la bande initiale.
        System.out.println("État initial : " + tape.toString());
        // Définition de l'état initial.
        State currentState = States.get(initialState);
        Transition nextTransition;
        // Tant qu'il y a des transitions à effectuer.
        do {
            // to slow down the print .
            Thread.sleep(100);

            // Affichage de l'état courant.
            System.out.println("Transition " + i + ": " + tape.toString());
            i++;
            // Récupération de la transition à effectuer.
            nextTransition = currentState.getNextTransition(tape.read());
            // Si aucune transition n'est trouvée, on arrête l'exécution.
            if (nextTransition != null) {
                tape.write(nextTransition.getReplace(), nextTransition.getDirection());
                currentState = States.get(nextTransition.getNextState());
            }
        } while (nextTransition != null);
        if (currentState.getPrint() != null) {
            // Affichage du message de l'état puit.
            System.out.println(currentState.getPrint());
        }
        // Affichage de la bande finale.
        return tape.toString();
    }

}
