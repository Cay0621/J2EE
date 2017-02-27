package org.com.cay.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.com.cay.entity.City;

public interface CityMapper {

	//使用外部
	@Select("select * from city c where length(c.id) = 2")
	@ResultMap(value="ResultToCity")
	public List<City> getAllProvince();
	
	@Select("select * from city c where c.id like '${id}%'")
	@Results({
		@Result(id=true, column="id", property="cityId"),
		@Result(column="name", property="cityName")
	})
	public List<City> getCitiesByProvinceId(@Param("id") String id);
}
