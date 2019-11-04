package com.service.baseinfo.impl;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.core.util.ExcelBean;
import com.core.util.ExcelUtil;
import com.dao.baseinfo.CarMapper;
import com.po.Car;
import com.service.baseinfo.CarService;



@Transactional
@Service("carService")
public class CarServiceImpl implements CarService {

	@Autowired
	private CarMapper carMapper;
	
	@Override
	public List<Car> findAll() {
		return carMapper.findAll();
	}

	@Override
	public int add(Car t) {
		return carMapper.insert(t);
	}

	@Override
	public Car findById(int id) {
		return carMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Car t) {
		return carMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return carMapper.delete(id);
	}

	@Override
	public List<Car> vagueFind(String contant, int currentpage,
			int pagesize) {
		return carMapper.vagueFind(contant, currentpage, pagesize);
	}
	
	public void importExcelInfo(InputStream in, MultipartFile file) throws Exception{
	    List<List<Object>> listobs = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
	    //遍历listob数据，把数据放到List中
	    for (int i = 0; i < listobs.size(); i++) {
	    	List<Object> listob = listobs.get(i);
	        Car vo = new Car();
	        Car j= null;	        
	        try {
				j = carMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(listob.get(0))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch blistobck
				System.out.println("没有新增");
			}
			    vo.setId(Integer.valueOf(String.valueOf(listob.get(0))));  
	            vo.setCarname(String.valueOf(listob.get(1)));  
	            vo.setCarcol(String.valueOf(listob.get(2)));
	            vo.setCartime(Integer.valueOf(String.valueOf(listob.get(3))));
	            vo.setCarpri(Integer.valueOf(String.valueOf(listob.get(4))));
	            vo.setCarcon(String.valueOf(listob.get(5)));
	            vo.setCartempcon(String.valueOf(listob.get(6)));	            
	            vo.setIsvalid(Integer.valueOf(String.valueOf(listob.get(7))));
			if(j == null)
			{
		            carMapper.insert(vo);
			}
			else
			{
		            carMapper.updateByPrimaryKeySelective(vo);
			}
        }   

	}
	
	public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
	    //根据条件查询数据，把数据装载到一个list中
	    List<Car> list = carMapper.findAll();

	    List<ExcelBean> excel=new ArrayList<>();
	    Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
	    XSSFWorkbook xssfWorkbook=null;
	    //设置标题栏
	    excel.add(new ExcelBean("序号","id",0));
	    excel.add(new ExcelBean("车辆品牌名称","carname",0));
	    excel.add(new ExcelBean("车辆颜色","carcol",0));
	    excel.add(new ExcelBean("车辆租赁时间","cartime",0));
	    excel.add(new ExcelBean("车辆价格/h","carpri",0));
	    excel.add(new ExcelBean("车辆租用情况","carcon",0));
	    excel.add(new ExcelBean("车辆当前情况","cartempcon",0));
	    excel.add(new ExcelBean("车辆是否有效","isvalid",0));
	    map.put(0, excel);
	    String sheetName = "Date";
	    //调用ExcelUtil的方法
	    xssfWorkbook = ExcelUtil.createExcelFile(Car.class, list, map, sheetName);
	    return xssfWorkbook;
	}
}
