package fr.esgi.verbes_irreguliers.business;

import java.util.ArrayList;

public class Partie {
    static Long compteur = 0L;
    private Long id;
    private int nbQuestionsSouhaitees;
    private int score;

    public ArrayList<Question> questions;

    public Partie (int nbQuestionsSouhaitees) {
        this.score = 0;
        this.nbQuestionsSouhaitees = nbQuestionsSouhaitees;
        this.id = ++compteur;
    }

    public int getNbQuestionsSouhaitees() {
        return nbQuestionsSouhaitees;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public void incrementScore(){
        ++this.score;
    }

    public int getScore(){
        return this.score;
    }
}
