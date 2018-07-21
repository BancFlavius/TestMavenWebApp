import javafx.print.Printer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {

        try {
            String action = req.getParameter("action");

            if(action!=null && action.equals("C")) {
                System.out.println("creating new user");
                String nume = req.getParameter("nume");
                String telefon  = req.getParameter("telefon");
                ClasaDeDb.insert(nume, telefon);
                PrintWriter out = resp.getWriter();
                out.println("New contact added.");
            } else if(action!=null && action.equals("D")){
                System.out.println("deleting from database");
                String nume = req.getParameter("nume");
                ClasaDeDb.delete(nume);
                PrintWriter out = resp.getWriter();
                out.println("Contact deleted.");
            } else if(action!=null && action.equals("R")){
                System.out.println("reading from database");
                String[] sa = ClasaDeDb.read();
                PrintWriter out = resp.getWriter();
                boolean notNull = false;
                for(int i=0;i<sa.length;i++){
                    if(sa[i]!=null) {
                        notNull = true;
                        out.print("Nume: " + sa[i]);
                        i++;
                        out.println("   Telefon: " + sa[i]);
                    }
                }
                if(!notNull)out.println("Agenda este goala.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
