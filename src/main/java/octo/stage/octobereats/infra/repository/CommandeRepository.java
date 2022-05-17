package octo.stage.octobereats.infra.repository;

import octo.stage.octobereats.domain.Commande;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CommandeRepository {
    public List<Commande> getCommandes();
    public Commande addCommande(Commande commande);
    public List<Commande> findById(long id);
}
