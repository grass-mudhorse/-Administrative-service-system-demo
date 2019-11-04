package com.service.personmanage.impl;

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
import com.dao.personmanage.ClientMapper;
import com.po.Client;
import com.service.personmanage.ClientService;

@Transactional
@Service("ClientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientMapper ClientMapper;
	
	@Override
	public List<Client> findAll() {
		return ClientMapper.findAll();
	}

	@Override
	public int add(Client t) {
		return ClientMapper.insert(t);
	}

	@Override
	public Client findById(int id) {
		return ClientMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Client t) {
		return ClientMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return ClientMapper.delete(id);
	}

	@Override
	public List<Client> vagueFind(String contant, int currentpage,
			int pagesize) {
		return ClientMapper.vagueFind(contant, currentpage, pagesize);
	}
	
	public void importExcelInfo(InputStream in, MultipartFile file) throws Exception{
	    List<List<Object>> listobs = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
	    //遍历listob数据，把数据放到List中
	    for (int i = 0; i < listobs.size(); i++) {
	    	List<Object> listob = listobs.get(i);
	        Client vo = new Client();
	        Client j= null;	        
	        try {
				j = ClientMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(listob.get(0))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch blistobck
				System.out.println("没有新增");
			}
			    vo.setId(Integer.valueOf(String.valueOf(listob.get(0))));
			    vo.setAccount(String.valueOf(listob.get(1)));
	            vo.setName(String.valueOf(listob.get(2)));  
	            vo.setGender(String.valueOf(listob.get(3)));
	            vo.setPassword(String.valueOf(listob.get(4)));
	            vo.setIdcard(String.valueOf(listob.get(5)));
	            vo.setEmail(String.valueOf(listob.get(6)));
	            vo.setPhonenumber1(String.valueOf(listob.get(7)));	   
	            vo.setPhonenumber2(String.valueOf(listob.get(8)));	   
	            vo.setCompany(String.valueOf(listob.get(9)));
	            vo.setPosition(String.valueOf(listob.get(10)));
	            vo.setIsvalid(Integer.valueOf(String.valueOf(listob.get(11))));
			if(j == null)
			{
		            ClientMapper.insert(vo);
			}
			else
			{
		            ClientMapper.updateByPrimaryKeySelective(vo);
			}
        }   

	}
	
	public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
	    //根据条件查询数据，把数据装载到一个list中
	    List<Client> list = ClientMapper.findAll();

	    List<ExcelBean> excel=new ArrayList<>();
	    Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
	    XSSFWorkbook xssfWorkbook=null;
	    //设置标题栏
	    excel.add(new ExcelBean("序号","id",0));
	    excel.add(new ExcelBean("用户账户","account",0));
	    excel.add(new ExcelBean("用户密码","name",0));
	    excel.add(new ExcelBean("用户性别","gender",0));
	    excel.add(new ExcelBean("用户密码","password",0));
	    excel.add(new ExcelBean("用户身份证号","idcard",0));
	    excel.add(new ExcelBean("用户邮箱","email",0));
	    excel.add(new ExcelBean("用户办公电话","phonenumber1",0));
	    excel.add(new ExcelBean("用户家庭电话","phonenumber2",0));
	    excel.add(new ExcelBean("用户所在公司","company",0));
	    excel.add(new ExcelBean("用户所属职务","position",0));
	    excel.add(new ExcelBean("是否有效","isvalid",0));	    
	    map.put(0, excel);
	    String sheetName = "Date";
	    //调用ExcelUtil的方法
	    xssfWorkbook = ExcelUtil.createExcelFile(Client.class, list, map, sheetName);
	    return xssfWorkbook;
	}
}
