<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Editar Veículo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }
        label {
            display: block;
            margin-bottom: 6px;
            color: #555;
        }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #f0ad4e;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #ec971f;
        }
        a {
            display: inline-block;
            margin-top: 10px;
            color: #337ab7;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Editar Veículo</h1>
        <form action="veiculos" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${veiculo.id}">
            
            <label for="placa">Placa:</label>
            <input type="text" id="placa" name="placa" value="${veiculo.placa}" required>
            
            <label for="renavam">Renavam:</label>
            <input type="text" id="renavam" name="renavam" value="${veiculo.renavam}" required>
            
            <label for="id_prop">ID Proprietário:</label>
            <input type="number" id="id_prop" name="id_prop" value="${veiculo.idProp}" required>
            
            <input type="submit" value="Atualizar">
        </form>
        <a href="veiculos?action=list">Voltar</a>
    </div>
</body>
</html>
