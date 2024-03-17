package fr.esgi.verbes_irreguliers.business;

public class Verbe {
    static Long compteur = 0L;
    private Long id;
    private String baseVerbale;
    private String preterit;
    private String participePasse;
    private String traduction;

    public Verbe(String baseVerbale, String preterit, String participePasse, String traduction) {
        this.baseVerbale = baseVerbale;
        this.preterit = preterit;
        this.participePasse = participePasse;
        this.traduction = traduction;
        this.id = ++compteur;
    }


    public String getBaseVerbale() {
        return this.baseVerbale;
    }

    public String getTraduction()
    {
        return this.traduction;
    }

    public String getPreterit(){
        return this.preterit;
    }

    public String getParticipePasse() {
        return this.participePasse;
    }
}
