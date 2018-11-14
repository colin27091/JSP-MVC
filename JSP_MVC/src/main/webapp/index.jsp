<%-- 
    Document   : JSP
    Created on : 13 nov. 2018, 16:12:07
    Author     : pedago
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Hashtable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Saisie d'un taux de remise</title>
	</head>
	<body>
            
		<!-- On montre le formulaire de saisie -->
		<h1>Edition des taux de remise</h1>
		<form action="Control" method="GET">
                    Code : <input name="code" size="1" maxlength="1" pattern="[A-Z]{1}+" title="Une lettre en MAJUSCULES"><br>
		    Taux : <input name="taux" step="0.01" min="0.0" max="99.99" size="5" type="number"><br>
			<input name="action" value="ADD" type="hidden">
			<input value="Ajouter" type="submit">
                    
		</form>
		
                
                <%String mes = (String) request.getAttribute("mes");%>
                
                <%if(mes == null){
                    mes = " ";
                }%>
                <div><h4><%=mes%></h4></div>
		<div>
			<table border="1">
				<tbody><tr><th>Code</th><th>Taux</th><th>Action</th></tr>
                                    
                                
                                <%Hashtable<String, String> HT = (Hashtable<String, String>) request.getAttribute("HT");
                                    
                                    if(HT != null){
                                    Set keys = HT.keySet();
                                    
                                    Iterator itr = keys.iterator();
                                    String key = null;
                                    
                                    while(itr.hasNext()){
                                        key = (String) itr.next();%>
                                        
                                        
                                        <tr>
                                            <td><%=key%></td>
                                            <td><%=HT.get(key)%> %</td>
                                            <td><a href="Control?action=DELETE&amp;code=<%=key%>">delete</a></td>
                                        </tr>
                                        
                                    
                                    <%}
                                    }%>
                                    
				
					<tr>
						<td>H</td>
						<td>16,00 %</td>
						<td><a href="Control?action=DELETE&amp;code=H">delete</a></td>
					</tr>	  		    
				
					<tr>
						<td>L</td>
						<td>07,00 %</td>
						<td><a href="Control?action=DELETE&amp;code=L">delete</a></td>
					</tr>	  		    
				
					<tr>
						<td>M</td>
						<td>11,00 %</td>
						<td><a href="Control?action=DELETE&amp;code=M">delete</a></td>
					</tr>	  		    
				
					<tr>
						<td>N</td>
						<td>00,00 %</td>
						<td><a href="Control?action=DELETE&amp;code=N">delete</a></td>
					</tr>	    
				  
			</tbody></table>
		</div>                     
                </body>
                

