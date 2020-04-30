package br.com.fiap.application;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.ProdutoTO;

public class Listagem {

	public static void main(String[] args) {
		
		Client client = Client.create();
		
		WebResource resource = client.resource("http://localhost:8080/LojaApp/rest/produto");
		
		ClientResponse clientResponse = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(clientResponse.getStatus() == 200) {
			
			ProdutoTO[] produtos = clientResponse.getEntity(ProdutoTO[].class);
			
			for (ProdutoTO produtoTO : produtos) {
				System.out.println("Nome Produto : " + produtoTO.getTitulo());				
			}
			
		}else {
			System.out.println("Erro = HTTP Status  " + clientResponse.getStatus());
		}

	}

}
