
<%@ page import="pl.tenerowicz.mmoarena.Message" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Market</title>
	</head>
	<body>
		<div class="content scaffold-list" role="main">
			<h1>Market - sell items</h1>
			
			<div>
				<a href="${createLink(action: 'buy') }">Buy</a>
				<p>Sell</p>
			</div>
			
			<div>
				<p>Coins : ${ coins }</p>
			</div>
			
			<table>
				<thead>
					<tr>					
						<th style="width: 100px;">Item</th>					
						<th style="width: 100px;">Amount</th>
						<th style="width: 100px;">Selling cost</th>
						<th style="width: 100px;"></th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${playerItems}" status="i" var="itemInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">					
							<td>${itemInstance.item.name}</td>					
							<td>${itemInstance.amount}</td>
							<td>${itemInstance.item.coinCost}</td>
							<td>
								<a href="${createLink(action: 'sellItem', id: itemInstance.id)}">Sell</a>
							</td>
						</tr>
					</g:each>
				</tbody>
			</table>
			
		</div>
	</body>
</html>
