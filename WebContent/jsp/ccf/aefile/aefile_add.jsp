<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="../../common/quote.jsp" %>

		<style>
			.controls-radio{width:74.34%;display:inline-block;min-width:200px;}
			.date-picker{display:block !important;}
			.add-on{position: relative; top:-30px; left:14%; z-index:3000;z-index:1;}
		</style>
	</head>

	<body>
		<div class="main-container container-fluid">
			<div class="main-content">
				<div class="page-content">
					<div class="page-header position-relative">
						<h1>
							文件管理
							<small>
								<i class="icon-double-angle-right"></i>
								新增文件信息
							</small>
						</h1>
					</div><!--/.page-header-->

					<form id="validation-form" class="form-horizontal" action="${ctx}/aefileController/add.do" method="post"enctype="multipart/form-data">
						<div style="border-bottom:1px dotted #e2e2e2; padding-bottom:13px; margin-bottom:13px;">
							<button class="btn btn-small" type="button" onclick="javascript:location.href='${ctx}/aefileController/list.do';">
								<i class="icon-undo"></i>
								返回
							</button>

							<button class="btn btn-small btn-primary" type="submit">
								<i class="icon-save"></i>
								保存
							</button>
						</div>
							
						<div class="row-fluid">
							<div></div>


	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">创建者id</label>
	
									<div class="controls controls-m">
										<input type="text" name="createrid"/>
									</div>
								</div>		
							</div><!--/span-->
						</div><!--/.row-fluid-->
	
						<div class="row-fluid">
							<div></div>
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">项目ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="projectid"/>
									</div>
								</div>		
							</div><!--/span-->
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">创建日期</label>
	
									<div class="controls controls-m">
										<span class="text-m" >
											<div class="row-fluid input-append">
												<input class="span10 date-picker" name="date" style="width:193px;" type="text" data-date-format="yyyy-mm-dd" />
												<span class="add-on" style="float:right;">
													<i class="icon-calendar"></i>
												</span>
											</div>
										</span>
									</div>
								</div>	
							</div><!--/span-->

							<div class="span4">
								<div class="control-group control-group-m">
									<div class="controls controls-m">
										<input type="file" name="file" id="btn_file" style="btn btn-small btn-primary">
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->

					
					</form><!-- /.form -->
				</div><!--/.page-content-->
			</div><!--/.main-content-->
		</div><!--/.main-container-->

		<script type="text/javascript">
			$(function(){
				//开启表单验证
				formValidate();				
			});
			
			//表单验证
			function formValidate(){
				$("#validation-form").validate({
					errorElement: 'label',
					errorClass: 'help-inline',
					focusInvalid: false,
				    rules: {
				   	  
				   	  	category:{
				   	  		required:true,
				   	  		maxlength:20
				   	  		},
				   	  	
				   	    createrid:{
				   	    	required:true,
				   	    	maxlength:9
				   	    },
				   	 	url:{
				   	 	    required:true,
			   	  		    maxsize:50
				   	 	},
				   	    projectid:{
				   	  		required:true,
				   	  		maxsize:9
				   	  	},
				   	  	filecheck:{
				   	  	    required:true,
				   	 	    maxsize:1
				   	  	},
				   	    date:{
				   	  	    required:true,
				   	  	},
				   	    
				   	  	
				    },
				    
				    highlight: function (e) {
						$(e).closest('.control-group').removeClass('info').addClass('error');
					},
			
					success: function (e) {
						$(e).closest('.control-group').removeClass('error').addClass('info');
						$(e).remove();
					},
					//重写提交方式
					submitHandler:function(){
						formSubmit();
					}
			    });
			}

						//点击选择图片
			function F_Open_dialog() 
			{ 
				$("#btn_file").click(); 
			}
		
			//表单提交
			function formSubmit(){
				swal({
				  	title: "是否保存?",
				  	text: "",
				  	type: "warning",
				  	showCancelButton: true,
				  	cancelButtonText: "否",
				  	confirmButtonClass: "btn-danger",
				  	confirmButtonText: "是",
				  	closeOnConfirm: true
				},
				function(){
					document.forms[0].submit();
				});
			}
		</script>
	</body>
</html>
