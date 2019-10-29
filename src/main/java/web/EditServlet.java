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
import static java.lang.Integer.parseInt;

@WebServlet("/edit/*")
public class EditServlet extends HttpServlet {
    private final ClientsService clientsService;
    private final ModelMapper mapper;

    @Inject
    public EditServlet(ClientsService clientsService, ModelMapper mapper) {
        this.clientsService = clientsService;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = parseInt(req.getPathInfo().substring(1));

        ClientViewModel clientViewModel = mapper.map(clientsService.getClient(id), ClientViewModel.class);
        req.setAttribute("viewModel", clientViewModel);
        req.getRequestDispatcher("/edit.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = parseInt(req.getPathInfo().substring(1));

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dateBirth = req.getParameter("dateBirth");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");

        try {
            clientsService.update(id, firstName, lastName, dateBirth, phoneNumber, email);
            resp.sendRedirect("/home");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
