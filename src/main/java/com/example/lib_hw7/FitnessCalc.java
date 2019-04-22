package com.example.lib_hw7;

public class FitnessCalc {

    static char[] solution = new char[64]; // the answer

    public static void setSolution(char[] newSolution) {
        for (int i = 0; i < 64; i++) {
            if (i < newSolution.length) {
                solution[i] = newSolution[i];
            }
            else {
                solution[i] = ' ';
            }
        }
    }

    static void setSolution(String newSolution) {
        setSolution(newSolution.toCharArray());
    }

    // Calculate inidividuals fittness by comparing it to our candidate solution
    static int getFitness(Individual individual) {
        int fitness = 0;
        // Loop through our individuals genes and compare them to our candidates
        for (int i = 0; i < individual.size(); i++) {
            if (i > solution.length/2) {
                fitness -= Math.abs(individual.getGene(i) - solution[individual.size() - i - 1]); // difference in ascii number when 2 char are operated
            } else {
                fitness -= Math.abs(individual.getGene(i) - solution[i]);
            }
        }
        return fitness;
    }

    // Get optimum fitness
    static int getMaxFitness() {
        return 0;
    }
}
