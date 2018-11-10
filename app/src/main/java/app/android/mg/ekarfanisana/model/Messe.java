package app.android.mg.ekarfanisana.model;

import java.util.Date;

public class Messe {
    private Date dateMesse;
    private int nombreAdulte;
    private int nombreJeune;
    private int nombreEnfant;
    private int nombreNourrisson;
    private int nombreTotal;

    public int getNombreAdulte(){
        return nombreAdulte;
    }
    public int getNombreJeune(){
        return nombreJeune;
    }
    public int getNombreEnfant(){
        return nombreEnfant;
    }
    public int getNombreNourrisson(){
        return nombreNourrisson;
    }
    public int getNombreTotal(){
        return nombreTotal;
    }
    public void setNombreAdulte(int nombreAdulte){
        this.nombreAdulte=nombreAdulte;
    }
    public void setNombreJeune(int nombreJeune){
        this.nombreJeune=nombreJeune;
    }
    public void setNombreEnfant(int nombreEnfant1){
        this.nombreEnfant=nombreEnfant1;
    }
    public void setNombreNourrisson(int nombreNourrisson1){
        this.nombreNourrisson=nombreNourrisson1;
    }

    private void calculerTotal(){
        nombreTotal = nombreAdulte + nombreJeune + nombreEnfant + nombreNourrisson;
    }
    public Messe(){}
    public Messe(int nbrAdulte, int nbrJeune, int nbrEnfant, int nbrNourrisson){
        this.setNombreAdulte(nbrAdulte);
        this.setNombreJeune(nbrJeune);
        this.setNombreEnfant(nbrEnfant);
        this.setNombreNourrisson(nbrNourrisson);
        this.calculerTotal();
    }

}
