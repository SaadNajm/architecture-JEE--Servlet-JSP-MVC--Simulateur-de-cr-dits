package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICreditMetier;

@WebServlet(name = "cs",urlPatterns = {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
 private ICreditMetier metier;

    @Override
    public void init() throws ServletException {
       metier=new CreditMetierImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setAttribute("creditmodel", new CreditModel());
        req.getRequestDispatcher("VueCredit.jsp").forward(req,resp);
    }
    

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double montant=Double.parseDouble(req.getParameter("montant"));
		double taux=Double.parseDouble(req.getParameter("taux"));
		int duree=Integer.parseInt(req.getParameter("duree"));
		
		CreditModel model=new CreditModel();
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		double resultat=metier.calculerMensualiteCredit(montant, taux, duree);
		model.setMensualite(resultat);
		req.setAttribute("creditmodel", model);
		req.getRequestDispatcher("VueCredit.jsp").forward(req, resp);
	}

	@Override
    public void destroy() {
        super.destroy();
    }
}
