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
import com.dao.baseinfo.HotelMapper;
import com.po.Hotel;
import com.service.baseinfo.HotelService;

@Transactional
@Service("HotelService")
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelMapper hotelMapper;
	
	@Override
	public List<Hotel> findAll() {
		return hotelMapper.findAll();
	}

	@Override
	public int add(Hotel t) {
		return hotelMapper.insert(t);
	}

	@Override
	public Hotel findById(int id) {
		return hotelMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Hotel t) {
		return hotelMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return hotelMapper.delete(id);
	}

	@Override
	public List<Hotel> vagueFind(String contant, int currentpage,
			int pagesize) {
		return hotelMapper.vagueFind(contant, currentpage, pagesize);
	}
	
	public void importExcelInfo(InputStream in, MultipartFile file) throws Exception{
	    List<List<Object>> listobs = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
	    //遍历listob数据，把数据放到List中
	    for (int i = 0; i < listobs.size(); i++) {
	    	List<Object> listob = listobs.get(i);
	        Hotel vo = new Hotel();
	        Hotel j= null;	        
	        try {
				j = hotelMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(listob.get(0))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch blistobck
				System.out.println("没有新增");
			}
			    vo.setId(Integer.valueOf(String.valueOf(listob.get(0))));  
	            vo.setHotelname(String.valueOf(listob.get(1)));  
	            vo.setHotelsize(Integer.valueOf(String.valueOf(listob.get(2))));
	            vo.setHotelnum(Integer.valueOf(String.valueOf(listob.get(3))));
	            vo.setHotelloc(String.valueOf(listob.get(4)));	            
	            vo.setHotelpri(Integer.valueOf(String.valueOf(listob.get(5))));
	            vo.setHotelcon(String.valueOf(listob.get(6)));
	            vo.setHoteltempcon(String.valueOf(listob.get(7)));	            
	            vo.setIsvalid(Integer.valueOf(String.valueOf(listob.get(8))));
			if(j == null)
			{
		            hotelMapper.insert(vo);
			}
			else
			{
		            hotelMapper.updateByPrimaryKeySelective(vo);
			}
        }   

	}
	
	public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
	    //根据条件查询数据，把数据装载到一个list中
	    List<Hotel> list = hotelMapper.findAll();

	    List<ExcelBean> excel=new ArrayList<>();
	    Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
	    XSSFWorkbook xssfWorkbook=null;
	    //设置标题栏
	    excel.add(new ExcelBean("序号","id",0));
	    excel.add(new ExcelBean("酒店名称","hotelname",0));
	    excel.add(new ExcelBean("酒店可选规模种类","hotelsize",0));
	    excel.add(new ExcelBean("酒店可选规模个数","hotelnum",0));
	    excel.add(new ExcelBean("酒店位置","hotelloc",0));
	    excel.add(new ExcelBean("酒店价格","hotelpri",0));
	    excel.add(new ExcelBean("酒店租用情况","hotelcon",0));
	    excel.add(new ExcelBean("酒店情况","hoteltempcon",0));
	    excel.add(new ExcelBean("酒店是否有效","isvalid",0));
	    map.put(0, excel);
	    String sheetName = "Date";
	    //调用ExcelUtil的方法
	    xssfWorkbook = ExcelUtil.createExcelFile(Hotel.class, list, map, sheetName);
	    return xssfWorkbook;
	}
	
	

}
