<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="../../common/quote.jsp" %>
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
								修改文件状态
							</small>
						</h1>
					</div><!--/.page-header-->

					<form id="validation-form" class="form-horizontal" action="${ctx}/pmfileController/edit.do" method="post">
						<div style="border-bottom:1px dotted #e2e2e2; padding-bottom:13px; margin-bottom:13px;">
							<button class="btn btn-small" type="button" onclick="javascript:location.href='${ctx}/pmfileController/list.do';">
								<i class="icon-undo"></i>
								返回
							</button>

							<input type="hidden" name="id" value="${pmfile.id}"/>
							<button class="btn btn-small btn-primary" type="submit">
								<i class="icon-save"></i>
								保存
							</button>
						</div>
							
						<div class="row-fluid">
							<div></div>
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">文件ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="id" readonly="readonly" value="${pmfile.id}"/>
									</div>
								</div>	
							</div><!--/span-->
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">文件种类</label>
	
									<div class="controls controls-m">
										<input type="text" name="category" readonly="readonly" value="${pmfile.category}"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
	
						<div class="row-fluid">
							<div></div>
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">上传ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="createid"  value="${pmfile.createrid}"/>
									</div>
								</div>		
							</div><!--/span-->
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">上传地址</label>
	
									<div class="controls controls-m">
										<input type="text" name="url"  readonly= "readonly" value="${pmfile.url}"/>
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
										<input type="text" name="projectid"   value="${pmfile.projectid}"/>
									</div>
								</div>		
							</div><!--/span-->

							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">审核状态</label>
	
									<div class="controls controls-m">
										<input type="text" name="filecheck"   value="${pmfile.filecheck}"/>
									</div>
								</div>		
							</div><!--/span-->
							</div><!--/.row-fluid-->
							<div class="row-fluid">
							<div></div>
							
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">上传日期</label>
	
									<div class="controls controls-m">
										<input type="text" name="date"   value="${pmfile.date}"/>
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
					}
			    });
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
