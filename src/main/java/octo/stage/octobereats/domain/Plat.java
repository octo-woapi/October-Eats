package octo.stage.octobereats.domain;

import java.util.Objects;

public class Plat {

    private static long count = 0;
    private long id;
    private String nom;
    private float prix;

    public Plat(String nom, float prix) {
        this.id = ++count;
        this.nom = nom;
        this.prix = prix;
    }

    public long getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public float getPrix() {
        return this.prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plat plat = (Plat) o;
        return id == plat.id && Float.compare(plat.prix, prix) == 0 && Objects.equals(nom, plat.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prix);
    }

    @Override
    public String toString() {
        return "Plat{" + "id=" + this.id + ", nom='" + this.nom + '\'' +
                ", prix='" + this.prix + '}';
    }
}