<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listagem de Veículos</title>
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
        .filter {
            margin-bottom: 20px;
        }
        .filter label {
            margin-right: 10px;
        }
        .filter select {
            padding: 5px;
            font-size: 14px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Veículos</h1>
        
        <div class="filter">
            <form action="veiculos" method="get">
                <label for="status">Filtrar por Status:</label>
                <select id="status" name="status">
                    <option value="">Todos</option>
                    <option value="1" <c:if test="${selectedStatus == '1'}">selected</c:if>>Em Circulação</option>
                    <option value="2" <c:if test="${selectedStatus == '2'}">selected</c:if>>Baixado</option>
                    <option value="3" <c:if test="${selectedStatus == '3'}">selected</c:if>>Em Processo de Transferência</option>
                    <option value="4" <c:if test="${selectedStatus == '4'}">selected</c:if>>Veículo de outra UF</option>
                    <option value="5" <c:if test="${selectedStatus == '5'}">selected</c:if>>Dados de Pré-Cadastro</option>
                </select>
                <input type="submit" value="Filtrar">
            </form>
        </div>
        
        <a href="addVeiculo.jsp" class="add-btn">Adicionar Veículo</a>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Placa</th>
                    <th>Renavam</th>
                    <th>ID Proprietário</th>
                    <th>Nome Proprietário</th>
                    <th>Status do Veículo</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="veiculo" items="${veiculos}">
                    <tr>
                        <td>${veiculo.id}</td>
                        <td>${veiculo.placa}</td>
                        <td>${veiculo.renavam}</td>
                        <td>${veiculo.idProp}</td>
                        <td>${veiculo.nomeProprietario}</td>
                        <td>${veiculo.nomeStatus}</td>
                        <td class="actions">
                            <a href="veiculos?action=edit&id=${veiculo.id}">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
