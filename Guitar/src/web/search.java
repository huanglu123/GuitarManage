package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String keyword = request.getParameter("keyword");
		System.out.print(keyword);
		PrintWriter pw = response.getWriter();
		Connection conn = DbUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn
					.prepareStatement("select * from guitar where serialNumber like '%" + keyword + "%'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 遍历查询
		try {
			while (rs.next()) {
				String serialNumber = rs.getString("serialNumber");
				String price = rs.getString("price");
				String build = rs.getString("build");
				String type = rs.getString("type");
				String backWood = rs.getString("backWood");
				String topWood = rs.getString("topWood");

				pw.println("<br/>");
				pw.println("<br/>");
				pw.println("<br/>");
				pw.println("<center>");
				pw.println("<table  border=1px  cellspacing=0px  >");
				pw.println("<tr height=40px >");
				pw.println("<td width=80px>" + "编号" + "</td>");
				pw.println("<td width=80px>" + "价格" + "</td>");
				pw.println("<td width=80px>" + "制造商" + "</td>");
				pw.println("<td width=80px>" + "类型" + "</td>");
				pw.println("<td width=80px>" + "背面材质" + "</td>");
				pw.println("<td width=80px>" + "表面材质" + "</td>");

				pw.println("</tr>");
				pw.println("<tr height=40px>");
				pw.println("<td>" + serialNumber + "</td>");
				pw.println("<td>" + price + "</td>");
				pw.println("<td>" + build + "</td>");
				pw.println("<td>" + type + "</td>");
				pw.println("<td>" + backWood + "</td>");
				pw.println("<td>" + topWood + "</td>");

				pw.println("</tr>");

				pw.println("</table>");
				pw.println("</center>");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
