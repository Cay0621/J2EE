package org.com.cay.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.cay.dao.BaseDao;
import org.com.cay.entity.City;
import org.com.cay.entity.District;
import org.com.cay.entity.Province;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ProvinceServlet
 */
@WebServlet("/chinaServlet")
public class ChinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChinaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String methodName = request.getParameter("method");

		try {
			//使用反射机制
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private BaseDao baseDao = new BaseDao();
	protected void provinceList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String sql = "select * from province";
		List<Province> provinces = baseDao.getForList(sql, Province.class);
		
		request.setAttribute("provinces", provinces);
		
		request.getRequestDispatcher("/WEB-INF/pages/china.jsp").forward(request, response);
	}
	
	protected void cityList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int provinceId = Integer.parseInt(request.getParameter("province_id"));
		
		String sql = "select * from city c where c.province_id = ?";
		
		List<City> cities = baseDao.getForList(sql, City.class, provinceId);
		
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(cities);
		//System.out.println(result);
		
		response.setContentType("text/javascipt;charset=utf-8");
		response.getWriter().print(result);
	}
	
	protected void districtList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int cityId = Integer.parseInt(request.getParameter("city_id"));
		//System.out.println(cityId);
		
		String sql = "select * from district d where d.city_id = ?";
		List<District> districts = baseDao.getForList(sql, District.class, cityId);
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(districts);
		//System.out.println(result);
		
		response.setContentType("text/javascript;charset=utf-8");
		response.getWriter().print(result);
	}
	
	protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int provinceId = Integer.parseInt(request.getParameter("province_id"));
		int cityId = Integer.parseInt(request.getParameter("city_id"));
		int districtId = Integer.parseInt(request.getParameter("district_id"));
		
		//System.out.println(provinceId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		String sql1 = "select * from province p where p.id = ?";
		String sql2 = "select * from city c where c.id = ?";
		String sql3 = "select * from district d where d.id = ?";
		
		Province province = baseDao.get(sql1, Province.class, provinceId);
		//System.out.println("provinceName:" + province);
		
		City city = baseDao.get(sql2, City.class, cityId);
		//System.out.println("cityName:" + city);
		
		District district = baseDao.get(sql3, District.class, districtId);
		//System.out.println("district:" + district);
		
		map.put("id", district.getId());
		map.put("province", province.getName());
		map.put("city", city.getName());
		map.put("district", district.getName());
		map.put("post", district.getPost());
		
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(map);
		//System.out.println(result);
		
		response.setContentType("text/javascript;charset=utf-8");
		response.getWriter().print(result);
	}

}
