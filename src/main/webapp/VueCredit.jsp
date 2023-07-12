<%@page import="web.CreditModel" %>
<%
CreditModel model=(CreditModel)request.getAttribute("creditmodel");
%>
<html>
<head>
    <title>Crédit bancaire</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
<div class="col-md-6 col-xm-12 col-sm-6 col-md-offset-3">
<div class="panel panel-primary">
<div class="panel-heading">Simulation de crédit</div>
<div class="panel-body">
<form  action="calculerMensualite.do" method="post">
<div class="form-group">
<label class="control-label">Montant:</label>
<input class="form-control" type="text" name="montant" value=<%=model.getMontant()  %>>
</div>
<div class="form-group">
<label class="control-label">Taux:</label>
<input class="form-control" type="text" name="taux" value=<%=model.getTaux()  %>>
</div>
<div class="form-group">
<label class="control-label">Durée:</label>
<input class="form-control" type="text" name="duree" value=<%=model.getDuree()  %>>
</div>
<button class="btn btn-danger" type="submit">Calculer</button>
</form>
<div>
<label>Mensualité:</label>
<label><% out.println(model.getMensualite()); %></label>
 
</div>
</div>
</div>
</div>
</div>




</body>
</html>
