import javafx.print.Printer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/servlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {

        try {
            String action = req.getParameter("action");

            if(action!=null && action.equals("C")) {
                if(req.getParameter("nume")==null){
                    PrintWriter out = resp.getWriter();
                    out.println("Please add your name and phone number.");
                } else {
                    System.out.println("creating new user");
                    String nume = req.getParameter("nume");
                    String telefon = req.getParameter("telefon");
                    ClasaDeDb.insert(nume, telefon);
                    PrintWriter out = resp.getWriter();
                    out.println("New contact added.");
                }
            } else if(action!=null && action.equals("D")){
                if(req.getParameter("nume")==null){
                    PrintWriter out = resp.getWriter();
                    out.println("Please enter a name you would like to delete");
                } else {
                    System.out.println("deleting from database");
                    String nume = req.getParameter("nume");
                    ClasaDeDb.delete(nume);
                    PrintWriter out = resp.getWriter();
                    out.println("Contact deleted.");
                }
            } else if(action!=null && action.equals("R")){
                System.out.println("reading from database");
                List<Item> lista = ClasaDeDb.read();
                PrintWriter out = resp.getWriter();
                boolean notNull = false;
                for(Item i : lista){
                    out.println(i.toString());
                    notNull=true;
                }
                if(!notNull)out.println("Agenda este goala.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
