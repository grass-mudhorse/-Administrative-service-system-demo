package com.service.baseinfo;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.expression.ParseException;
import org.springframework.web.multipart.MultipartFile;

import com.core.common.BaseService;
import com.po.Meet;

public interface MeetService extends BaseService<Meet, Integer>{
	/**
	 * 分页查询收费类别
	 * @param contant
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<Meet> vagueFind(String contant,int currentpage,int pagesize);
	public void importExcelInfo(InputStream in, MultipartFile file) throws Exception;
	public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;	
	
}
