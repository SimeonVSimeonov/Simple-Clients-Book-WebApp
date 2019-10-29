package web;

import services.ClientsService;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/delete/*")
public class DeleteServlet extends HttpServlet {

    private final ClientsService clientsService;

    @Inject
    public DeleteServlet(ClientsService clientsService){
        this.clientsService = clientsService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = parseInt(req.getPathInfo().substring(1));

        try{
            clientsService.delete(id);
            resp.sendRedirect("/home");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
