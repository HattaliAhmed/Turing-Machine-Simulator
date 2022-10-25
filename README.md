## Exécution du programme.
#### 1. Compilation.
`javac -cp ".:./json-simple-1.1.jar" *.java`
#### 2. Exécution.
`java -cp ".:./json-simple-1.1.jar" Main.java`

La compilation et l'exécution du programme necessite la librairie JSON. d'où `-cp ".:./json-simple-1.1.jar"`

## Description des fichiers.
1. `json-simple-1.1.jar` : bibliothèque pour la manipulation de fichiers JSON.
2. `Main.java` : fichier principal qui crée une instance de la machine de turing.
3. `TuringMachine.java` : Classe qui représente la machine de turing déterministe.
4. `Tape.java` : Classe qui représente un ruban 'infini' de la machine de turing déterministe.
5. `State.java` : Classe qui représente un état dans une machine de turing déterministe.
6. `Transition.java` : Classe qui représente une transition possible d'un sommet a un autre dans une machine de turing déterministe.

## Exemples de programmes.
Vous trouverez dans le dossier `examples` des exemples de programmes pour la machine de turing déterministe.
1. `soustraction.json` : soustraction de deux nombres unaires.
2. `comparaison_nb_x_y` : Compare le nombre de x et y dans une chaine de caractères de type `x^n.y^m` (Exercice du TD 4).
## Codage d'une MT à partir d’un fichier JSON.

```
{
  "input": "1011",                 // Représente le mot d’entée.
  "startState": "start",           // Nom de l’état de début.
  "states": [                      // Liste des états, chaque état est un Objet JSON { … }.
    {                                     
      "state": "start",            // Nom de l’état.
      "transitions": [             // Liste des transitions possibles à partir de cet état chaque
                                   // si aucune transition n’existe alors c’est un état puit.
        {                          // transition est aussi un objet JSON { … }.
          "read": ["1", "0"],      // Traduit par : Si la tête de lecture lit la valeur 1 ou 0.
          "replace": "1",          // La valeur qui sera écrite en à la position actuelle
          "direction": "R",        // Prochaine direction de la tête de lecture ("R" pour droite         
                                   // et "L" pour gauche )
          "nextState": "right"     // Nom du prochain état a partir de cette transition.
        },
    {
    . . .
    },
    {                                     
      "state": "qoui",            
      "transitions": []           Pas de transition = état puit.
      "print" : "MOT VALIDE"      // Affichage du message si l’état est atteint.
        
    }
}
```