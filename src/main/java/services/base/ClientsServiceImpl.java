package services.base;

import models.entities.Client;
import models.service.ClientServiceModel;
import org.modelmapper.ModelMapper;
import services.ClientsService;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class ClientsServiceImpl implements ClientsService {
    private final ModelMapper mapper;
    private final EntityManager entityManager;

    @Inject
    public ClientsServiceImpl(EntityManager entityManager, ModelMapper mapper){
        this.entityManager = entityManager;
        this.mapper = mapper;
    }

    @Override
    public void add(String firstName, String lastName, String dateBirth, String phoneNumber, String email) {

        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setDateBirth(dateBirth);
        client.setPhoneNumber(phoneNumber);
        client.setEmail(email);

        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Integer id, String firstName, String lastName, String dateBirth, String phoneNumber, String email)
            throws Exception {

        entityManager.getTransaction().begin();
        Client client = entityManager.find(Client.class, id);
        entityManager.detach(client);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setDateBirth(dateBirth);
        client.setPhoneNumber(phoneNumber);
        client.setEmail(email);
        entityManager.merge(client);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<ClientServiceModel> getAll() {
        var clientsFromDb = entityManager.createQuery("select c from Client c", Client.class).getResultList();
        entityManager.clear();

        var clientServiceModels = clientsFromDb.stream().map(client -> mapper.map(client, ClientServiceModel.class))
                .collect(Collectors.toList());
        return clientServiceModels;

    }

    @Override
    public void delete(Integer id) throws Exception {
        Client client = entityManager.find(Client.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(client);
        entityManager.getTransaction().commit();
    }

    @Override
    public ClientServiceModel getClient(Integer id) {
        ClientServiceModel clientServiceModel = new ClientServiceModel();
        Client client = entityManager.find(Client.class, id);
        mapper.map(client, clientServiceModel);
        return clientServiceModel;
    }
}
