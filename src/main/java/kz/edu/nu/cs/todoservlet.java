package kz.edu.nu.cs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(urlPatterns = { "/todo" })
public class todoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String> list = new ArrayList<String>();


	public todoservlet() {
		super();
		list.add("Welcome, start adding items!!!");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("doGet");
		response.setContentType("text/plain");
		Gson gson = new Gson();
		out.append(gson.toJson(list));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String myText = request.getParameter("texttosend");
		System.out.println("doPost");
		list.add(myText);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		list.remove(id);
		System.out.println(list);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPut");

		int id = Integer.parseInt(request.getParameter("textid"));

		String to = request.getParameter("textto");
		System.out.println(id + " " + to);
		list.set(id,to);

	}

}
