<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="s_supplier.s_quote"%>
<%@page import="s_supplier.s_DBConfig"%>
<%@ page
    import="s_supplier.s_quote, s_supplier.s_supplierDBModel, java.util.List, java.util.ArrayList, java.util.Date"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
        crossorigin="anonymous">
    <title>Quotation update</title>
</head>

    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        .header {
            text-align: center;
            margin-bottom: 20px;
        }
        .table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .table, .table th, .table td {
            border: 1px solid #000;
        }
        .table th, .table td {
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
 <%
    String qid = request.getParameter("qid");
    s_supplierDBModel supModel = new s_supplierDBModel();
    List<s_quote> s_quoteList = supModel.viewEditform(qid);

    int i = 1;
    s_quote qobj1 = new s_quote();
    s_quote qobj2 = new s_quote();
    s_quote qobj3 = new s_quote();
    for (s_quote quote : s_quoteList) {

        if (i == 1) {
        	qobj1.setQuoteId(quote.getQuoteId());
            qobj1.setItemName(quote.getItemName());
            qobj1.setQuantity(quote.getQuantity());
            qobj1.setUnitPrice(quote.getUnitPrice());
            qobj1.setItemPrice(quote.getItemPrice());
        } else if (i == 2) {
            qobj2.setItemName(quote.getItemName());
            qobj2.setQuantity(quote.getQuantity());
            qobj2.setUnitPrice(quote.getUnitPrice());
            qobj2.setItemPrice(quote.getItemPrice());
        } else if (i == 3) {
            qobj3.setItemName(quote.getItemName());
            qobj3.setQuantity(quote.getQuantity());
            qobj3.setUnitPrice(quote.getUnitPrice());
            qobj3.setItemPrice(quote.getItemPrice());
        }
        i++;
    }
    %>

    <div class="container">
        <div class="header">
        <h1>Exquisite Planners</h1>
        <img src="s_images/logo5.jpg" alt="s& s Suppliers Logo" width="100">
        
            <p>S & S Suppliers</p>
            <h2>Quotation ${quote.quoteId}</h2>
            Quote ID: <%=qobj1.getQuoteId()%><br>
            created by: S & S Suppliers Exquisite Events.
            <br><br><br>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th>Item Name</th>
                    <th>Quantity</th>
                    <th>Unit Price</th>
                    <th>Item Price</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%=qobj1.getItemName()%></td>
                    <td><%=qobj1.getQuantity()%></td>
                    <td><%=qobj1.getUnitPrice()%></td>
                    <td><%=qobj1.getItemPrice()%></td>
                    
                </tr>
                <tr>
                    <td><%=qobj2.getItemName()%></td>
                    <td><%=qobj2.getQuantity()%></td>
                    <td><%=qobj2.getUnitPrice()%></td>
                    <td><%=qobj2.getItemPrice()%></td>
                </tr>
                <tr>
                    <td><%=qobj3.getItemName()%></td>
                    <td><%=qobj3.getQuantity()%></td>
                    <td><%=qobj3.getUnitPrice()%></td>
                    <td><%=qobj3.getItemPrice()%></td>
                </tr>
            </tbody>
        </table>
<br><br><br><br><br>
        <div class="footer">
            &copy; <%= new java.util.Date().getYear() + 1900 %> S & S Suppliers. All rights reserved.
        </div>
        
        <a href="download.jsp" download>Download as PDF</a>
    </div>
</body>
</html>
