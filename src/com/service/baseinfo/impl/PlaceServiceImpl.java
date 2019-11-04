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
import com.dao.baseinfo.PlaceMapper;
import com.po.Place;
import com.service.baseinfo.PlaceService;

@Transactional
@Service("PlaceService")
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	private PlaceMapper PlaceMapper;
	
	@Override
	public List<Place> findAll() {
		return PlaceMapper.findAll();
	}

	@Override
	public int add(Place t) {
		return PlaceMapper.insert(t);
	}

	@Override
	public Place findById(int id) {
		return PlaceMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Place t) {
		return PlaceMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return PlaceMapper.delete(id);
	}

	@Override
	public List<Place> vagueFind(String contant, int currentpage,
			int pagesize) {
		return PlaceMapper.vagueFind(contant, currentpage, pagesize);
	}
	
	public void importExcelInfo(InputStream in, MultipartFile file) throws Exception{
	    List<List<Object>> listobs = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
	    //遍历listob数据，把数据放到List中
	    for (int i = 0; i < listobs.size(); i++) {
	    	List<Object> listob = listobs.get(i);
	        Place vo = new Place();
	        Place j= null;	        
	        try {
				j = PlaceMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(listob.get(0))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch blistobck
				System.out.println("没有新增");
			}
			    vo.setId(Integer.valueOf(String.valueOf(listob.get(0))));  
	            vo.setPlacename(String.valueOf(listob.get(1)));  
	            vo.setPlacesize(String.valueOf(listob.get(2)));
	            vo.setPlaceloc(String.valueOf(listob.get(3)));
	            vo.setPlacepri(Integer.valueOf(String.valueOf(listob.get(4))));
	            vo.setPlacecon(String.valueOf(listob.get(5)));
	            vo.setPlacetempcon(String.valueOf(listob.get(6)));	            
	            vo.setIsvalid(Integer.valueOf(String.valueOf(listob.get(7))));
			if(j == null)
			{
		            PlaceMapper.insert(vo);
			}
			else
			{
		            PlaceMapper.updateByPrimaryKeySelective(vo);
			}
        }   

	}
	
	public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
	    //根据条件查询数据，把数据装载到一个list中
	    List<Place> list = PlaceMapper.findAll();

	    List<ExcelBean> excel=new ArrayList<>();
	    Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
	    XSSFWorkbook xssfWorkbook=null;
	    //设置标题栏
	    excel.add(new ExcelBean("序号","id",0));
	    excel.add(new ExcelBean("会场名称","placename",0));
	    excel.add(new ExcelBean("会场可选规模种类","placesize",0));
	    excel.add(new ExcelBean("会场位置","placeloc",0));
	    excel.add(new ExcelBean("会场价格","placepri",0));
	    excel.add(new ExcelBean("会场租用情况","placecon",0));
	    excel.add(new ExcelBean("会场情况","placetempcon",0));
	    excel.add(new ExcelBean("会场是否有效","isvalid",0));
	    map.put(0, excel);
	    String sheetName = "Date";
	    //调用ExcelUtil的方法
	    xssfWorkbook = ExcelUtil.createExcelFile(Place.class, list, map, sheetName);
	    return xssfWorkbook;
	}

}
