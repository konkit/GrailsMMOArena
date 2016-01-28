
<%@ page import="pl.tenerowicz.mmoarena.Item" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}" />
		<title>List of items</title>
	</head>
	<body>
		<div class="nav" role="navigation">
            <button class="btn" >
                <g:link class="create" action="create">Create new Item</g:link>
            </button>
		</div>
		<div id="list-item" class="content scaffold-list" role="main">
			<h1>List of items</h1>

			<table class="table">
			    <thead>
					<tr>
                        <g:sortableColumn property="name" title="${message(code: 'item.name.label', default: 'Name')}" />
						<g:sortableColumn property="coinCost" title="${message(code: 'item.coinCost.label', default: 'Coin Cost')}" />
                        <td></td>
                        <td></td>
					</tr>
				</thead>
				<tbody>
                    <g:each in="${itemInstanceList}" status="i" var="itemInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td>
                                ${fieldValue(bean: itemInstance, field: "name")}
                            </td>
                            <td>
                                ${fieldValue(bean: itemInstance, field: "coinCost")}
                            </td>
                            <td>
                                <g:link action="edit" id="${itemInstance.id}">
                                    <button class="btn">Edit</button>
                                </g:link>
                            </td>
                            <td>
                                <button class="btn btn-danger">Remove</button>
                            </td>
                        </tr>
                    </g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${itemInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
