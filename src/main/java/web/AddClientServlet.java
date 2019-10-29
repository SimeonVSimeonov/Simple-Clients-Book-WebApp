package web;

import services.ClientsService;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddClientServlet extends HttpServlet {

    private final ClientsService clientsService;

    @Inject
    public AddClientServlet(ClientsService clientsService){
        this.clientsService = clientsService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dateBirth = req.getParameter("dateBirth");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");

        try {
            clientsService.add(firstName, lastName, dateBirth, phoneNumber, email);
            resp.sendRedirect("/index");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
