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
import com.dao.baseinfo.WorkMapper;
import com.po.Work;
import com.service.baseinfo.WorkService;

@Transactional
@Service("WorkService")
public class WorkServiceImpl implements WorkService {

	@Autowired
	private WorkMapper workMapper;
	
	@Override
	public List<Work> findAll() {
		return workMapper.findAll();
	}

	@Override
	public int add(Work t) {
		return workMapper.insert(t);
	}

	@Override
	public Work findById(int id) {
		return workMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Work t) {
		return workMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return workMapper.delete(id);
	}

	@Override
	public List<Work> vagueFind(String contant, int currentpage,
			int pagesize) {
		return workMapper.vagueFind(contant, currentpage, pagesize);
	}
	public void importExcelInfo(InputStream in, MultipartFile file) throws Exception{
	    List<List<Object>> listobs = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
	    //遍历listob数据，把数据放到List中
	    for (int i = 0; i < listobs.size(); i++) {
	    	List<Object> listob = listobs.get(i);
	        Work vo = new Work();
	        Work j= null;	        
	        try {
				j = workMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(listob.get(0))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch blistobck
				System.out.println("没有新增");
			}
			    vo.setId(Integer.valueOf(String.valueOf(listob.get(0))));  
	            vo.setWorkname(String.valueOf(listob.get(1)));
	            vo.setWorkkind(String.valueOf(listob.get(2)));
	            vo.setWorkcost(String.valueOf(listob.get(3)));	
	            vo.setWorksize(String.valueOf(listob.get(4)));
	            vo.setWorknum(Integer.valueOf(String.valueOf(listob.get(5))));
	            vo.setWorkpri(Integer.valueOf(String.valueOf(listob.get(6))));
	            vo.setWorkcon(String.valueOf(listob.get(7)));
	            vo.setWorktempcon(String.valueOf(listob.get(8)));	            
	            vo.setIsvalid(Integer.valueOf(String.valueOf(listob.get(9))));     	            
			if(j == null)
			{
		            workMapper.insert(vo);
			}
			else
			{
		            workMapper.updateByPrimaryKeySelective(vo);
			}
        }   

	}
	
	public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
	    //根据条件查询数据，把数据装载到一个list中
	    List<Work> list = workMapper.findAll();

	    List<ExcelBean> excel=new ArrayList<>();
	    Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
	    XSSFWorkbook xssfWorkbook=null;
	    //设置标题栏
	    excel.add(new ExcelBean("序号","id",0));
	    excel.add(new ExcelBean("建材名称","workname",0));
	    excel.add(new ExcelBean("建材种类","workkind",0));
	    excel.add(new ExcelBean("建材耗材","workcost",0));
	    excel.add(new ExcelBean("建材规格","worksize",0));
	    excel.add(new ExcelBean("建材数量","worknum",0));
	    excel.add(new ExcelBean("建材价格","workpri",0));
	    excel.add(new ExcelBean("建材情况","workcon",0));
	    excel.add(new ExcelBean("建材当前情况","worktempcon",0));	    
	    excel.add(new ExcelBean("建材是否有效","isvalid",0));
	    map.put(0, excel);
	    String sheetName = "Date";
	    //调用ExcelUtil的方法
	    xssfWorkbook = ExcelUtil.createExcelFile(Work.class, list, map, sheetName);
	    return xssfWorkbook;
	}
	

}
