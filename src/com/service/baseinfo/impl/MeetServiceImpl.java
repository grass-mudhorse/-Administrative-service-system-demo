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
import com.dao.baseinfo.MeetMapper;
import com.po.Meet;
import com.service.baseinfo.MeetService;

@Transactional
@Service("MeetService")
public class MeetServiceImpl implements MeetService {

	@Autowired
	private MeetMapper meetMapper;
	
	@Override
	public List<Meet> findAll() {
		return meetMapper.findAll();
	}

	@Override
	public int add(Meet t) {
		return meetMapper.insert(t);
	}

	@Override
	public Meet findById(int id) {
		return meetMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Meet t) {
		return meetMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return meetMapper.delete(id);
	}

	@Override
	public List<Meet> vagueFind(String contant, int currentpage,
			int pagesize) {
		return meetMapper.vagueFind(contant, currentpage, pagesize);
	}
	
	public void importExcelInfo(InputStream in, MultipartFile file) throws Exception{
	    List<List<Object>> listobs = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
	    //遍历listob数据，把数据放到List中
	    for (int i = 0; i < listobs.size(); i++) {
	    	List<Object> listob = listobs.get(i);
	        Meet vo = new Meet();
	        Meet j= null;	        
	        try {
				j = meetMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(listob.get(0))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch blistobck
				System.out.println("没有新增");
			}
			    vo.setId(Integer.valueOf(String.valueOf(listob.get(0))));  
	            vo.setMeetname(String.valueOf(listob.get(1)));  
	            vo.setMeetsize(String.valueOf(listob.get(2)));
	            vo.setMeetloc(String.valueOf(listob.get(3)));	            
	            vo.setMeetpri(Integer.valueOf(String.valueOf(listob.get(4))));
	            vo.setMeetcon(String.valueOf(listob.get(5)));
	            vo.setMeettempcon(String.valueOf(listob.get(6)));	            
	            vo.setIsvalid(Integer.valueOf(String.valueOf(listob.get(7))));
			if(j == null)
			{
		            meetMapper.insert(vo);
			}
			else
			{
		            meetMapper.updateByPrimaryKeySelective(vo);
			}
        }   

	}
	
	public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
	    //根据条件查询数据，把数据装载到一个list中
	    List<Meet> list = meetMapper.findAll();

	    List<ExcelBean> excel=new ArrayList<>();
	    Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
	    XSSFWorkbook xssfWorkbook=null;
	    //设置标题栏
	    excel.add(new ExcelBean("序号","id",0));
	    excel.add(new ExcelBean("会议室名称","meetname",0));
	    excel.add(new ExcelBean("会议室可选规模种类","meetsize",0));
	    excel.add(new ExcelBean("会议室位置","meetloc",0));
	    excel.add(new ExcelBean("会议室价格","meetpri",0));
	    excel.add(new ExcelBean("会议室租用情况","meetcon",0));
	    excel.add(new ExcelBean("会议室情况","meettempcon",0));
	    excel.add(new ExcelBean("会议室是否有效","isvalid",0));
	    map.put(0, excel);
	    String sheetName = "Date";
	    //调用ExcelUtil的方法
	    xssfWorkbook = ExcelUtil.createExcelFile(Meet.class, list, map, sheetName);
	    return xssfWorkbook;
	}
	
}
