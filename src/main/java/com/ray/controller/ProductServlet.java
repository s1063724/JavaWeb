package com.ray.controller;

import com.ray.model.Product;
import com.ray.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 調用測試資料庫連接的方法
        DBUtil.testConnection();

        // 其他處理產品列表的邏輯
        List<Product> products = fetchProductsFromDatabase();
        request.setAttribute("products", products);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

	private List<Product> fetchProductsFromDatabase() {
	    List<Product> products = new ArrayList<>();
	    String sql = "SELECT * FROM store.products";
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement statement = conn.prepareStatement(sql);
	         ResultSet resultSet = statement.executeQuery()) {
	        
	        while (resultSet.next()) {
	            Product product = new Product();
	            product.setId(resultSet.getInt("id"));
	            product.setName(resultSet.getString("name"));
	            product.setPrice(resultSet.getDouble("price"));
	            product.setDescription(resultSet.getString("description"));
	            product.setImageUrl(resultSet.getString("image_url")); // 設置圖片路徑
	            products.add(product);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return products;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
