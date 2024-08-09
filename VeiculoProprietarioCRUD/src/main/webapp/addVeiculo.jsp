<html>
<head>
    <title>Adicionar Veículo</title>
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
            background-color: #5cb85c;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #4cae4c;
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
        <h1>Adicionar Veículo</h1>
        <form action="veiculos" method="post">
            <input type="hidden" name="action" value="add">
            <label for="placa">Placa:</label>
            <input type="text" id="placa" name="placa" required>
            
            <label for="renavam">Renavam:</label>
            <input type="text" id="renavam" name="renavam" required>
            
            <label for="id_prop">ID Proprietário:</label>
            <input type="number" id="id_prop" name="id_prop" required>
            
            <input type="submit" value="Adicionar">
        </form>
        <a href="veiculos?action=list">Voltar</a>
    </div>
</body>
</html>
