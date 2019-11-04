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
import com.dao.baseinfo.TourMapper;
import com.po.Tour;
import com.service.baseinfo.TourService;

@Transactional
@Service("TourService")
public class TourServiceImpl implements TourService {

	@Autowired
	private TourMapper TourMapper;
	
	@Override
	public List<Tour> findAll() {
		return TourMapper.findAll();
	}

	@Override
	public int add(Tour t) {
		return TourMapper.insert(t);
	}

	@Override
	public Tour findById(int id) {
		return TourMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Tour t) {
		return TourMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return TourMapper.delete(id);
	}

	@Override
	public List<Tour> vagueFind(String contant, int currentpage,
			int pagesize) {
		return TourMapper.vagueFind(contant, currentpage, pagesize);
	}
	public void importExcelInfo(InputStream in, MultipartFile file) throws Exception{
	    List<List<Object>> listobs = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
	    //遍历listob数据，把数据放到List中
	    for (int i = 0; i < listobs.size(); i++) {
	    	List<Object> listob = listobs.get(i);
	        Tour vo = new Tour();
	        Tour j= null;	        
	        try {
				j = TourMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(listob.get(0))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch blistobck
				System.out.println("没有新增");
			}
			    vo.setId(Integer.valueOf(String.valueOf(listob.get(0))));  
	            vo.setTourname(String.valueOf(listob.get(1)));  
	            vo.setTourage(Integer.valueOf(String.valueOf(listob.get(2))));
	            vo.setToursex(String.valueOf(listob.get(3)));	
	            vo.setTourphone(String.valueOf(listob.get(4)));            	            
	            vo.setTourcon(String.valueOf(listob.get(5)));
	            vo.setTourtempcon(String.valueOf(listob.get(6)));	            
	            vo.setIsvalid(Integer.valueOf(String.valueOf(listob.get(7))));
			if(j == null)
			{
		            TourMapper.insert(vo);
			}
			else
			{
		            TourMapper.updateByPrimaryKeySelective(vo);
			}
        }   

	}
	
	public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
	    //根据条件查询数据，把数据装载到一个list中
	    List<Tour> list = TourMapper.findAll();

	    List<ExcelBean> excel=new ArrayList<>();
	    Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
	    XSSFWorkbook xssfWorkbook=null;
	    //设置标题栏
	    excel.add(new ExcelBean("序号","id",0));
	    excel.add(new ExcelBean("导游名称","tourname",0));
	    excel.add(new ExcelBean("导游年龄","tourage",0));
	    excel.add(new ExcelBean("导游性别","toursex",0));
	    excel.add(new ExcelBean("导游电话","tourphone",0));
	    excel.add(new ExcelBean("导游租用情况","tourcon",0));
	    excel.add(new ExcelBean("导游情况","tourtempcon",0));
	    excel.add(new ExcelBean("导游是否有效","isvalid",0));
	    map.put(0, excel);
	    String sheetName = "Date";
	    //调用ExcelUtil的方法
	    xssfWorkbook = ExcelUtil.createExcelFile(Tour.class, list, map, sheetName);
	    return xssfWorkbook;
	}
	

}
