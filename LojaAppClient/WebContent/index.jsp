<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/style.css" type="text/css">
<title>PRODUTOS</title>
</head>
<body>
	<div class="case-frm">
		<form class="frm-1" action="cadastrar" method="get">
			<fieldset>
				<legend>Cadastro de produtos</legend>
				<div>
					<label for="idNmProd">Nome do produto</label> <input type="text"
						id="idNmProd" name="txtNmProd" required="required"
						placeholder="Digite o nome do produto">
				</div>
				<div>
					<label for="idVlProd">Preço do produto</label> <input type="text"
						id="idVlProd" name="txtVlProd" required="required"
						placeholder="Digite o valor do produto">
				</div>
				<div>
					<label for="idQtdProd">Quantidade do produto</label> <input
						type="number" id="idQtdProd" name="txtQtdProd" required="required"
						placeholder="Digite a quantidade do produto">
				</div>
				<div>
					<input type="submit" value="Cadastrar">
				</div>
			</fieldset>
		</form>
	</div>
	<hr>
	<table>
		<tr>
			<th>id</th>
			<th>Produto</th>
			<th>R$</th>
			<th>Estoque</th>
		</tr>
		<c:forEach var="p" items="${listaProduto}" varStatus="id">
			<tr bgcolor="${id.count % 2 == 0 ? '#90EE90':'#F5DEB3'}">
				<td>${id.count}</td>
				<td>${p.titulo}</td>
				<td>${p.preco}</td>
				<td>${p.quantidade}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>