package UI;

import Model.Garn;
import javafx.application.Application;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Application.launch(GUI.class);
    }

    public static void konsolRun(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast løbelængde på originalt garn:");
        double løbelængde = scanner.nextInt();
        System.out.println("Indtast gram per nøgle på originalt garn:");
        double gram = scanner.nextInt();
        Garn garn1 = new Garn(løbelængde, gram);

        System.out.println("Indtast løbelængde på alternativt garn:");
        løbelængde = scanner.nextInt();
        System.out.println("Indtast gram per nøgle på alternativt garn:");
        gram = scanner.nextInt();
        Garn garn2 = new Garn(løbelængde, gram);

        System.out.println("Hvor mange gram siger opskriften du skal bruge i alt?");
        double samletAntalGram = scanner.nextInt();

        double alternativGram = udregnGram(garn1,garn2,samletAntalGram);
        double alternativNøgle = udregnNøgle(garn1,garn2,samletAntalGram);
        System.out.printf("Du skal bruge %.2f gram (%.2f nøgler) af det alternative garn \n", alternativGram, alternativNøgle);
    }

    public static double udregnGram(Garn garn1, Garn garn2, double gram){
        return udregnNøgle(garn1,garn2,gram) * garn2.getGram();
    }

    public static double udregnNøgle(Garn garn1, Garn garn2, double gram){
        double nøgler = gram/garn1.getGram(); //antal nøgler
        double samledeLøbelængde = nøgler * garn1.getLøbelængde(); //udregner den totale løbelængde

        return samledeLøbelængde / garn2.getLøbelængde();// udregner antal nøgler;
    }
}
