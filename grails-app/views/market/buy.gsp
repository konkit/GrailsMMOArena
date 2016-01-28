
<%@ page import="pl.tenerowicz.mmoarena.Message" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Auctions</title>
	</head>
	<body>
		<div class="content scaffold-list" role="main">
			<h1>Market - buy items</h1>
			
			<div>
				<p>Buy</p>
				<a href="${createLink(action: 'sell') }">Sell</a>
			</div>
			
			<div>
				<p>Coins : ${ coins }</p>
			</div>
			
			<table>
				<thead>
						<tr>					
							<th style="width: 100px;">Item</th>	
							<th style="width: 100px;">Cost</th>	
							<th style="width: 100px;"></th>
						</tr>
					</thead>
				<tbody>
					<g:each in="${allItems}" status="i" var="itemInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">					
							<td>${itemInstance.name}</td>	
							<td>${itemInstance.coinCost}</td>	
							<td>
								<a href="${createLink(action: 'buyItem', id: itemInstance.id)}">Buy</a>
							</td>
						</tr>
					</g:each>
				</tbody>
			</table>
			
		</div>
	</body>
</html>
