package services;

import models.entities.Client;
import models.service.ClientServiceModel;

import java.util.List;

public interface ClientsService {
    void add(String firstName, String lastName, String dateBirth, String phoneNumber, String email)
            throws Exception;
    void update(Integer id, String firstName, String lastName, String dateBirth, String phoneNumber, String email)
            throws Exception;
    void delete(Integer id)
            throws Exception;

    ClientServiceModel getClient(Integer id);

    List<ClientServiceModel> getAll();

}
