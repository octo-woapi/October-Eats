package octo.stage.octobereats.infra.controller.output;

import octo.stage.octobereats.domain.Restaurant;

public class RestaurantOutput {
    private final long id;
    private final String nom;
    private final String type;

    public RestaurantOutput(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.nom = restaurant.getNom();
        this.type = restaurant.getType();
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }
}
