
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class State {
    private final String name;
    private final String print; // Message à afficher à l'utilisateur. (états puits uniquement)
    private HashMap<String, Transition> transitions = new HashMap<>();

    public State(JSONObject jsonState) {
        // Creation de l'état à partir d'un objet JSON.
        this.name = (String) (jsonState).get("state");
        this.print = (String) (jsonState).get("print");
        // Creation des transitions de cet état à partir d'un objet JSON.
        JSONArray jsonTransitions = (JSONArray) jsonState.get("transitions");
        if (jsonTransitions == null) {

            transitions = null;
            return;
        }

        for (Object jsonTransition : jsonTransitions) {
            JSONArray conditions = (JSONArray) (((JSONObject) jsonTransition).get("read"));
            for (Object condition : conditions) {
                Transition transition = new Transition();
                String replace = ((String) ((JSONObject) jsonTransition).get("replace"));
                if (replace.equals("")) {
                    transition.setReplace((String) condition);
                } else {
                    transition.setReplace(replace);
                }
                transition.setDirection((String) ((JSONObject) jsonTransition).get("direction"));
                transition.setNextState((String) ((JSONObject) jsonTransition).get("nextState"));
                transition.setRead((String) condition);
                this.transitions.put((String) condition, transition);
            }
        }
    }

    public Transition getNextTransition(String condition) {
        // Retourne la transition correspondante à la condition.
        // Si aucune transition n'est trouvée, retourne null.
        if (transitions == null)
            return null;
        return transitions.get(condition);
    }

    public String getName() {
        return name;
    }

    public String getPrint() {
        return print;
    }
}
