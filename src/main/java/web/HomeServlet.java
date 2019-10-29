package web;

import models.service.ClientServiceModel;
import models.view.ClientViewModel;
import org.modelmapper.ModelMapper;
import services.ClientsService;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private final ModelMapper mapper;
    private final ClientsService clientsService;

    @Inject
    public HomeServlet(ModelMapper mapper, ClientsService clientsService) {
        this.mapper = mapper;
        this.clientsService = clientsService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ClientServiceModel> cl = new ArrayList<>(clientsService.getAll());

        List<ClientViewModel> clients = clientsService.getAll()
                .stream()
                .map(client -> mapper.map(client, ClientViewModel.class))
                .collect(Collectors.toList());

        req.setAttribute("viewModel", clients);

        req.getRequestDispatcher("home.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SearchLogic(req, resp, clientsService, mapper);
    }

    static void SearchLogic(HttpServletRequest req, HttpServletResponse resp, ClientsService clientsService, ModelMapper mapper) throws ServletException, IOException {
        String searchData = req.getParameter("searchData");

        List<ClientViewModel> clients = clientsService.getAll()
                .stream()
                .map(client -> mapper.map(client, ClientViewModel.class))
                .collect(Collectors.toList());

        List<ClientViewModel> viewModel = new ArrayList<ClientViewModel>();

        for (ClientViewModel client : clients)
        {
            if(client.getEmail().contains(searchData) || client.getLastName().contains(searchData) || client.getDateBirth().contains(searchData)
                    || client.getFirstName().contains(searchData) || client.getPhoneNumber().contains(searchData)){

                viewModel.add(client);
            }
        }

        req.setAttribute("viewModel", viewModel);

        req.getRequestDispatcher("home.jsp")
                .forward(req, resp);
    }
}
