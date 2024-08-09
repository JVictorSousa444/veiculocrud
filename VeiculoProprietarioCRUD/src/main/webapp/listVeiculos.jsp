<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Veículos</h1>
        <a href="addVeiculo.jsp" class="add-btn">Adicionar Veículo</a>
        <table>
            <tr>
                <th>ID</th>
                <th>Placa</th>
                <th>Renavam</th>
                <th>ID Proprietário</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="veiculo" items="${veiculos}">
                <tr>
                    <td>${veiculo.id}</td>
                    <td>${veiculo.placa}</td>
                    <td>${veiculo.renavam}</td>
                    <td>${veiculo.idProp}</td>
                    <td class="actions">
                        <a href="veiculos?action=edit&id=${veiculo.id}">Editar</a>
                        <a href="veiculos?action=delete&id=${veiculo.id}" onclick="return confirm('Tem certeza que deseja excluir?')">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
