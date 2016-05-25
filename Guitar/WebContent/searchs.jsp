<%@ page import="java.sql.*,javax.sql.*,web.DbUtil,java.text.*"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="searchs.jsp">
		<label for="serialNumber">编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;</label><input
			type="text" name="serialNumber" id="serialNumber"> <label
			for="build">制&nbsp;&nbsp;造&nbsp;&nbsp;商&nbsp;&nbsp;</label><input
			type="text" name="build" /> </br> <label for="type">类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型&nbsp;&nbsp;</label><input
			type="text" name="type" id="type" /> <label for="topWood">前面材质&nbsp;&nbsp;</label><input
			type="text" name="topWood" id="topWood" /></br> <label for="backWood">后面材质&nbsp;&nbsp;</label><input
			type="text" name="backWood" id="backWood" /> <input type="submit"
			value="查詢">
	</form>
	<table border=1px cellspacing=0px background=gray>
		<tr height=40px>
			<th width=80px>编号</th>
			<th width=80px>价格</th>
			<th width=80px>制造商</th>
			<th width=80px>类型</th>
			<th width=80px>背面材质</th>
			<th width=80px>表面材质</th>
			</tr>
					

			<%
			String serialNumber = request.getParameter("serialNumber");
			String build = request.getParameter("build");
			String backWood = request.getParameter("backWood");
			String topWood = request.getParameter("topWood");
				System.out.print(serialNumber);
				request.setCharacterEncoding("UTF-8");
				Connection conn = DbUtil.getConnection();
				//创建查询

				PreparedStatement stmt = conn.prepareStatement("select * from guitar where serialNumber = ?and build=?and backWood=? and topWood=?");

				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {

					String se = rs.getString("serialNumber");
					String pr = rs.getString("price");
					String bu = rs.getString("build");
					String ty = rs.getString("type");
					String ba = rs.getString("backWood");
					String to = rs.getString("topWood");

					out.println("<br/>");
					out.println("<br/>");
					
					out.println("<tr height=40px>");
					out.println("<td>" + se + "</td>");
					out.println("<td>" + pr + "</td>");
					out.println("<td>" + bu + "</td>");
					out.println("<td>" + ty + "</td>");
					out.println("<td>" + ba + "</td>");
					out.println("<td>" + to + "</td>");

					out.println("</tr>");

					
					out.println("</center>");

				}
				stmt.close();
				conn.close();
			%>
			</table>
		
</body>
</html>