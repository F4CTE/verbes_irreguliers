package fr.esgi.verbes_irreguliers.business;

import java.time.LocalDateTime;

public class Question {

    static Long compteur = 0L;
    private Long id;
    private String reponsePreterit;
    private String reponseParticipePasse;
    private LocalDateTime dateHeureEnvoi;
    private LocalDateTime dateHeureReponse;

    private Verbe verbe;


    public Question(Verbe verbe) {
        this.verbe = verbe;
        this.id = ++compteur;
    }

    public Verbe getVerbe() {
        return verbe;
    }


    public void setReponsePreterit(String reponsePreterit) {
        this.reponsePreterit = reponsePreterit;
    }

    public void setReponseParticipePasse(String reponseParticipePasse) {
        this.reponseParticipePasse = reponseParticipePasse;
    }

    public void setDateHeureEnvoi(LocalDateTime dateHeureEnvoi) {
        this.dateHeureEnvoi = dateHeureEnvoi;
    }

    public void setDateHeureReponse(LocalDateTime dateHeureReponse) {
        this.dateHeureReponse = dateHeureReponse;
    }

    public Boolean isResponsePreteritRight() {
        return this.reponsePreterit.equals(verbe.getPreterit());
    }

    public Boolean isResponseParticipePasseRight() {
        return this.reponseParticipePasse.equals(verbe.getParticipePasse());
    }

    public Boolean isResponseRight(){
        return this.isResponseParticipePasseRight() && this.isResponsePreteritRight();
    }

}
