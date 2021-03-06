package octo.stage.octobereats;

import octo.stage.octobereats.domain.Livreur;
import octo.stage.octobereats.infra.controller.LivreurController;
import octo.stage.octobereats.infra.flux.CommandeFlux;
import octo.stage.octobereats.infra.repository.LivreurRepo;
import octo.stage.octobereats.infra.repository.LivreurRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = LivreurController.class)
@Import({LivreurRepo.class, CommandeFlux.class})
public class LivreurControllerTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    LivreurRepository livreurRepo;

    @Test
    public void testLivreurs(){
        List<Livreur> listLivreur = List.of(new Livreur("Martin","Kiki"),new Livreur("Richard","Tom"));

        Mockito.when(livreurRepo.getLivreurs()).thenReturn(listLivreur);

        webClient.get()
                .uri("/livreurs")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.[0].id").isEqualTo(1)
                .jsonPath("$.[0].nom").isEqualTo("Martin")
                .jsonPath("$.[0].prenom").isEqualTo("Kiki")
                .jsonPath("$.[1].id").isEqualTo(2)
                .jsonPath("$.[1].nom").isEqualTo("Richard")
                .jsonPath("$.[1].prenom").isEqualTo("Tom");

        Mockito.verify(livreurRepo, times(1)).getLivreurs();
    }

    @Test
    public void testNewLivreur() {
        Livreur livreur = new Livreur("Richard","Tony");

        Mockito.when(livreurRepo.addLivreur(livreur)).thenReturn(livreur);

        webClient.post()
                .uri("/livreurs")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(livreur)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(1)
                .jsonPath("$.nom").isEqualTo("Richard")
                .jsonPath("$.prenom").isEqualTo("Tony");


        Mockito.verify(livreurRepo, times(1)).addLivreur(livreur);
    }
}
