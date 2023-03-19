package packA;

import java.util.ArrayList;

public class game24 {
    // static String solution = "";
    // static boolean checkPossible = false;

    static public String checkPossibleAndAns(ArrayList<Integer> num) {
        ArrayList<Double> list = new ArrayList<>();
        ArrayList<String> listSolution = new ArrayList<>();
        String solution = "";
        boolean checkPossible = false;
        for (int i = 0; i < num.size(); i++) {
            list.add((double) num.get(i));
            listSolution.add(String.valueOf(num.get(i)));
        }
        solution = solver(list, listSolution, checkPossible, solution);
        return solution;
    }

    static private String solver(ArrayList<Double> list, ArrayList<String> listSolution, boolean checkPossible,
            String solution) {
        if (checkPossible) {
            return solution;
        }
        if (list.size() == 1) {
            if (list.get(0) == 24) {
                checkPossible = true;
                solution = listSolution.get(0);
                return solution;
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < i; j++) {
                    ArrayList<Double> posNum = new ArrayList<>();
                    ArrayList<String> posSol = new ArrayList<>();
                    double a = list.get(i);
                    double b = list.get(j);
                    String SA = listSolution.get(i);
                    String SB = listSolution.get(j);
                    posNum = makeOperater(a, b, SA, SB, posSol);
                    list.remove(i);
                    list.remove(j);
                    listSolution.remove(i);
                    listSolution.remove(j);
                    for (int k = 0; k < posNum.size(); k++) {
                        list.add(posNum.get(k));
                        listSolution.add(posSol.get(k));

                        solution = solver(list, listSolution, checkPossible, solution);

                        list.remove(list.size() - 1);
                        listSolution.remove(listSolution.size() - 1);
                    }
                    list.add(j, b);
                    list.add(i, a);

                    listSolution.add(j, SB);
                    listSolution.add(i, SA);
                }
            }
        }
        return solution;
    }

    static private ArrayList<Double> makeOperater(double a, double b, String SA, String SB, ArrayList<String> posSol) {
        ArrayList<Double> posNumInMake = new ArrayList<>();
        posNumInMake.add(a + b);
        posSol.add(String.format("(%s+%s)", SA, SB));
        posNumInMake.add(a - b);
        posSol.add(String.format("(%s-%s)", SA, SB));
        posNumInMake.add(b - a);
        posSol.add(String.format("(%s-%s)", SB, SA));
        posNumInMake.add(a * b);
        posSol.add(String.format("(%s*%s)", SA, SB));
        if (a != 0) {
            if (b % a == 0) {
                posNumInMake.add(b / a);
                posSol.add(String.format("(%s/%s)", SB, SA));
            }
        }
        if (b != 0) {
            if (a % b == 0) {
                posNumInMake.add(a / b);
                posSol.add(String.format("(%s/%s)", SA, SB));
            }
        }
        return posNumInMake;
    }
}