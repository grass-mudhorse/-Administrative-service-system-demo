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
							项目管理
						</h1>
					</div><!--/.page-header-->

					<form id="validation-form" class="form-horizontal" action="${ctx}/clientprojectController/edit.do" method="post">
						<div style="border-bottom:1px dotted #e2e2e2; padding-bottom:13px; margin-bottom:13px;">
							<button class="btn btn-small" type="button" onclick="javascript:location.href='${ctx}/clientprojectController/list.do';">
								<i class="icon-undo"></i>
								返回
							</button>

							<input type="hidden" name="id" value="${clientproject.id}"/>
							<button class="btn btn-small btn-primary" type="submit">
								<i class="icon-save"></i>
								保存
							</button>
						</div>
							
						<div class="row-fluid">
							<div></div>
	
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">项目ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="id" readonly= "readonly" value="${clientproject.id}"/>
									</div>
								</div>	
							</div><!--/span-->

							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">用户名</label>
	
									<div class="controls controls-m">
										<input type="text" name="account"  value="${clientproject.account}"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
	
						<div class="row-fluid">
						<div></div>
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">项目需求ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="projectrequireid" value="${clientproject.projectrequireid}"/>
									</div>
								</div>	
							</div><!--/span-->

							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">项目意向书ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="projectloiid" readonly= "readonly" value="${clientproject.projectloiid}"/>
									</div>
								</div>		
							</div><!--/span-->
						</div><!--/.row-fluid-->
	
						<div class="row-fluid">
							<div></div>
	
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">可行性方案ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="feasibilityreportid" readonly= "readonly" value="${clientproject.feasibilityreportid}"/>
									</div>
								</div>	
							</div><!--/span-->

						<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">报价表ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="offerlistid" readonly= "readonly" value="${clientproject.offerlistid}"/>
									</div>
								</div>		
							</div><!--/span-->							
						</div><!--/.row-fluid-->

						<div class="row-fluid">
							<div></div>
	

							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">服务合同ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="contractid"  readonly= "readonly" value="${clientproject.contractid}"/>
									</div>
								</div>		
							</div><!--/span-->

							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">项目总结</label>
	
									<div class="controls controls-m">
										<input type="text" name="project" readonly= "readonly" value="${clientproject.project}"/>
									</div>
								</div>		
							</div><!--/span-->

				</div><!--/.row-fluid-->

				<div class="row-fluid">
				<div></div>
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">创建日期</label>
	
									<div class="controls controls-m">
										<span class="text-m" >
											<div class="row-fluid input-append">
												<input class="span10 date-picker" name="createdate" style="width:193px;" type="text" value="${clientproject.createdate}"  data-date-format="yyyy-mm-dd" />
												<span class="add-on" style="float:right;">
													<i class="icon-calendar"></i>
												</span>
											</div>
										</span>
									</div>
								</div>	
							</div><!--/span-->



					<div class="span5">		
						<div class="control-group control-group-m">
									<label class="control-label control-label-l">项目状态</label>
	
									<div class="controls controls-m">
										<select class="chzn-select" data-placeholder="-请选择-" name="flag" readonly= "readonly" value="${clientproject.flag}"  
										>											
											<option value="已提交项目需求" />已提交项目需求
											<option value="未提交项目需求" />未提交项目需求
										</select>
									</div>
						</div>
					</div>



				</div><!--/.row-fluid-->						
				<div class="row-fluid">
					<div></div>
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">总经理ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="headmanagerid" readonly= "readonly" value="${clientproject.headmanagerid}"/>
									</div>
								</div>		
							</div><!--/span-->

							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">总经理账户</label>
	
									<div class="controls controls-m">
										<input type="text" name="headmanageraccount" readonly= "readonly" value="${clientproject.headmanageraccount}"/>
									</div>
								</div>		
							</div><!--/span-->

				</div><!--/.row-fluid-->
				<div class="row-fluid">
				<div></div>
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">总经理电话</label>
	
									<div class="controls controls-m">
										<input type="text" name="phonenumber" readonly= "readonly" value="${clientproject.headmanagerphone}"/>
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
				    	account:{
				   	  		required:true,
				   	  		maxlength:20,
				   	  		minlength:3
				   	  		},
				   	  	
				   	  	projectrequireid:{
				   	    	required:true,
							number:true,
				   	    	minlength:3,
				   	    	maxlength:20
				   	    },
				   	 	createdate:"required",
				   		flag:"required",
				   	  	
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

