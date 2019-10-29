package web;

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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static web.HomeServlet.SearchLogic;

@WebServlet("/date")
public class BirthDateSortServlet extends HttpServlet {
    private final ModelMapper mapper;
    private final ClientsService clientsService;

    @Inject
    public BirthDateSortServlet(ModelMapper mapper, ClientsService clientsService) {
        this.mapper = mapper;
        this.clientsService = clientsService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ClientViewModel> clients = clientsService.getAll()
                .stream()
                .map(client -> mapper.map(client, ClientViewModel.class))
                .sorted(Comparator.comparing(last -> last.getDateBirth()))
                .collect(Collectors.toList());

        req.setAttribute("viewModel", clients);

        req.getRequestDispatcher("home.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SearchLogic(req, resp, clientsService, mapper);
    }
}
