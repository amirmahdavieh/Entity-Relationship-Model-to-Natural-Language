class ER {

    public static void main(String[] args) {

        Entity EMPLOYEE = new Entity("EMPLOYEE");
        Entity DEPARTMENT = new Entity("DEPARTMENT");
        Entity PROJECT = new Entity("PROJECT");

        Relationship WORKS_FOR = new Relationship("WORKS_FOR", EMPLOYEE, DEPARTMENT, new int[]{1, 1, 4, -1});
        WORKS_FOR.printResult();

        System.out.println("---------------------------------------------");

        Relationship MANAGES = new Relationship("MANAGES", EMPLOYEE, DEPARTMENT, new int[]{0, 1, 1, 1});
        MANAGES.printResult();

        System.out.println("---------------------------------------------");

        Relationship WORKS_ON = new Relationship("WORKS_ON", EMPLOYEE, PROJECT, new int[]{1, -1, 1, -1});
        WORKS_ON.printResult();

        System.out.println("---------------------------------------------");

        Relationship CONTROLS = new Relationship("CONTROLS", DEPARTMENT, PROJECT, new int[]{0, -1, 1, 1});
        CONTROLS.printResult();

    }
}

class Entity {
    private String name;
    public Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Relationship {

    private String name;
    private Entity left;
    private Entity right;
    private int[] notations;  // min max notation -> (1, 1) , (0, N) : [1, 1, 0, N] //  N=-1 use -1 for N

    public Relationship(String name, Entity left, Entity right, int[] notations) {
        this.name = name;
        this.left = left;
        this.right = right;

        this.notations = new int[4];
        for (int i = 0; i < notations.length; i++) {
            this.notations[i] = notations[i];
        }

    }

    public String[] toText() {

        String[] array = new String[4];

        String verb = name;
        verb = verb.replaceAll("_", " ").toLowerCase();
        int indexOfS = verb.indexOf('s');

        if (indexOfS + 1 == verb.length())
            verb = removeCharAtIndex(verb, indexOfS);
        else
        if (verb.charAt(indexOfS + 1) == ' ')
            verb = removeCharAtIndex(verb, indexOfS);

        String number;

        if (notations[1] == -1) {
            number = "N";
        } else {
            number = Integer.toString(notations[1]);
        }

        String firstSentence = left.getName() + " must " + verb + " maximum " + number + " " + right.getName();
        array[0] = firstSentence;


        String existence;
        String necessity;
        String additionalS = "";

        if (notations[0] == 1) {
            existence = "Every ";
            necessity = " must ";
        } else {
            existence = "Not all ";
            necessity = " have to ";
            additionalS = "s";
        }

        String secondSentence = existence + left.getName() + additionalS + necessity + verb +
                " a " + right.getName();
        array[1] = secondSentence;


        // In department maximum n employee must work.
        String[] verbSplit = verb.split(" ");
        verb = verbSplit[0];

        if (notations[3] == -1) {
            number = "N";
        } else {
            number = Integer.toString(notations[3]);
        }

        String thirdSentence = "In " + right.getName() + " maximum " + number + " " +
                left.getName() + " must " + verb;
        array[2] = thirdSentence;


        // In department minimum 1 employee must work.
        String fourthSentence = "In " + right.getName() + " minimum " + notations[2] + " " +
                left.getName() + " must " + verb;
        array[3] = fourthSentence;

        return array;
    }

    public void printResult() {

        String[] sentences = toText();
        for (int i = 0; i < sentences.length; i++) {
            System.out.println(sentences[i]);
        }

    }

    public static String removeCharAtIndex(String str, int indexToRemove) {
        if (indexToRemove < 0 || indexToRemove >= str.length()) {
            // Invalid index, return the original string
            return str;
        }

        return str.substring(0, indexToRemove) + str.substring(indexToRemove + 1);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}