package fr.esgi.verbes_irreguliers;

import fr.esgi.verbes_irreguliers.business.Partie;
import fr.esgi.verbes_irreguliers.business.Question;
import fr.esgi.verbes_irreguliers.business.Verbe;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class App
{
    public static void main( String[] args )  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue sur verbes irréguliers ! \r");

        ArrayList<Verbe> verbes = new ArrayList<Verbe>();
        ArrayList<Partie> parties = new ArrayList<Partie>();
        ArrayList<Question> questions = new ArrayList<Question>();
        verbes.add(new Verbe("begin","begun","began","commencer"));
        verbes.add(new Verbe("drink", "drunk", "drank", "boire"));
        verbes.add(new Verbe("swim", "swum", "swam", "nager"));
        verbes.add(new Verbe("find","found","found","trouver"));
        verbes.add(new Verbe("drive","driven","drove","conduire"));

        System.out.print("Nombre de verbes irréguliers disponibles : " + verbes.size() + "\n");

        System.out.println("Nouvelle partie !\r");

        System.out.println("Combien de verbes pour cette partie ?\r");

        int nombreVerbes = scanner.nextInt();
        Partie partie = new Partie(nombreVerbes);

        for (int i = 0; i < nombreVerbes; i++) {
            Random random = new Random();
            Verbe verbe = verbes.get(random.nextInt(verbes.size()));
            Question question = new Question(verbe);
            questions.add(question);
        }
        partie.setQuestions(questions);

        System.out.println("Merci de séparer le prétérit et le participe passé avec une virgule \r");

        for( int i = 0; i < partie.getNbQuestionsSouhaitees(); i++) {
            partie.getQuestions().get(i).setDateHeureEnvoi(LocalDateTime.now());
            System.out.println("Question " + i+1 +" : donnez le prétérit et le participe passé du verbe " + partie.getQuestions().get(i).getVerbe().getBaseVerbale() + " (" + partie.getQuestions().get(i).getVerbe().getTraduction() + ") : ");
            String response = scanner.nextLine();
            String[] responses = response.split(",");
            partie.questions.get(i).setReponsePreterit(responses[0].trim());
            partie.questions.get(i).setReponseParticipePasse(responses[1].trim());
            partie.questions.get(i).setDateHeureReponse(LocalDateTime.now());
            if(partie.getQuestions().get(i).isResponseRight()) {
                partie.incrementScore();
                System.out.println("Bravo ! Score : " + partie.getScore() + "/" + i+1);
            } else {
                System.out.println("Ce n’est pas la bonne réponse.");
                System.out.println("Dommage ! Score : " + partie.getScore() + "/" + i+1);
            }



        }



    }
}