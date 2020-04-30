package br.com.fiap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.ProdutoTO;

/**
 * Servlet implementation class ProdutoController
 */
@WebServlet({ "/listar", "/editar", "/inserir", "/excluir" })
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProdutoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getRequestURI().equals("/LojaAppClient/listar")){
			restGet(req, resp);
			
		}
		
	}

	public void restGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/LojaApp/rest/produto");

		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (response.getStatus() == 200) {
			ProdutoTO[] produtos = response.getEntity(ProdutoTO[].class);
			req.setAttribute("listaProduto", produtos);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
//			for (ProdutoTO produtoTO : produtos) {
//				System.out.println(produtoTO.getTitulo());
//			}
		} else {
			System.out.println("Erro - HTTP Status: " + response.getStatus());
		}
	}

}
