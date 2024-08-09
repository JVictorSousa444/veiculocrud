<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Listagem de Proprietários</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        a {
            color: #337ab7;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .actions a {
            margin-right: 10px;
        }
        .add-btn {
            display: inline-block;
            margin-bottom: 15px;
            padding: 10px 15px;
            background-color: #5cb85c;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        .add-btn:hover {
            background-color: #4cae4c;
        }
        .filter {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Proprietários</h1>
        <a href="addProprietario.jsp" class="add-btn">Adicionar Proprietário</a>
        
        <!-- Filtro de status -->
        <div class="filter">
            <form method="get" action="proprietarios">
                <label for="status">Filtrar por status:</label>
                <select id="status" name="status" onchange="this.form.submit()">
                    <option value="ativos" ${statusFiltro == 'ativos' ? 'selected' : ''}>Ativos</option>
                    <option value="inativos" ${statusFiltro == 'inativos' ? 'selected' : ''}>Inativos</option>
                </select>
                <input type="hidden" name="action" value="list">
            </form>
        </div>
        
        <table>
            <tr>
                <th>ID</th>
                <th>CPF/CNPJ</th>
                <th>Nome</th>
                <th>Endereço</th>
                <th>Status</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="proprietario" items="${proprietarios}">
                <tr>
                    <td>${proprietario.id}</td>
                    <td>${proprietario.cpfCnpj}</td>
                    <td>${proprietario.nome}</td>
                    <td>${proprietario.endereco}</td>
                    <td><c:if test="${proprietario.ativo}">Ativo</c:if><c:if test="${!proprietario.ativo}">Inativo</c:if></td>
                    <td class="actions">
                        <a href="proprietarios?action=edit&id=${proprietario.id}">Editar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
