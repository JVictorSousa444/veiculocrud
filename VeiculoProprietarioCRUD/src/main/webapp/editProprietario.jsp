<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Editar Proprietário</title>
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
        input[type="text"], input[type="checkbox"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="checkbox"] {
            width: auto;
            margin-top: 0;
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
        <h1>Editar Proprietário</h1>
        <form action="proprietarios" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${proprietario.id}">
            
            <label for="cpf_cnpj">CPF/CNPJ:</label>
            <input type="text" id="cpf_cnpj" name="cpf_cnpj" value="${proprietario.cpfCnpj}" required>
            
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="${proprietario.nome}" required>
            
            <label for="endereco">Endereço:</label>
            <input type="text" id="endereco" name="endereco" value="${proprietario.endereco}" required>

            <label for="ativo">Ativo:</label>
            <input type="checkbox" id="ativo" name="ativo" ${proprietario.ativo ? "checked" : ""}>
            
            <input type="submit" value="Atualizar">
        </form>
        <a href="proprietarios?action=list">Voltar</a>
    </div>
</body>
</html>
