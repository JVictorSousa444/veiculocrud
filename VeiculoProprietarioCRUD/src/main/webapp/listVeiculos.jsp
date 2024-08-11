<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            max-width: 1000px;
            margin: auto;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        .filter {
            margin-bottom: 20px;
            display: flex;
            justify-content: space-between;
            gap: 20px;
        }
        .filter form {
            display: flex;
            align-items: center;
            gap: 10px;
            flex: 1;
        }
        .filter label {
            font-weight: bold;
        }
        .filter select, .filter input[type="text"] {
            padding: 6px;
            font-size: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 120px; /* Largura fixa reduzida */
        }
        .filter input[type="submit"] {
            padding: 6px 12px;
            font-size: 12px;
            background-color: #5cb85c;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .filter input[type="submit"]:hover {
            background-color: #4cae4c;
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
        tr:nth-child(even) {
            background-color: #f9f9f9;
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
        
        <!-- Formulário para Filtrar por Status e Placa/Renavam -->
        <div class="filter">
            <!-- Filtro por Status -->
            <form action="veiculos" method="get">
                <label for="status">Filtrar por Status:</label>
                <select id="status" name="status">
                    <option value="">Todos</option>
                    <option value="1" ${param.status == '1' ? 'selected' : ''}>Em Circulação</option>
                    <option value="2" ${param.status == '2' ? 'selected' : ''}>Baixado</option>
                    <option value="3" ${param.status == '3' ? 'selected' : ''}>Em Processo de Transferência</option>
                    <option value="4" ${param.status == '4' ? 'selected' : ''}>Veículo de outra UF</option>
                    <option value="5" ${param.status == '5' ? 'selected' : ''}>Dados de Pré-Cadastro</option>
                </select>
                <input type="submit" value="Filtrar por Status">
            </form>

            <!-- Filtro por Placa e Renavam -->
            <form action="veiculos" method="get">
                <label for="placa">Placa:</label>
                <input type="text" id="placa" name="placa" value="${param.placa}">
                <label for="renavam">Renavam:</label>
                <input type="text" id="renavam" name="renavam" value="${param.renavam}">
                <input type="submit" value="Filtrar por Placa/Renavam">
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
