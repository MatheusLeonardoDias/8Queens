package pkg8queens;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int size = 5;

        if (args.length > 1) {
            size = Integer.parseInt(args[0]);
        }

        SolutionNode solutionStart = new SolutionNode(size);
    }

}
