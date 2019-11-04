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

					<form id="validation-form" class="form-horizontal" action="${ctx}/aeprojectController/edit.do" method="post">
						<div style="border-bottom:1px dotted #e2e2e2; padding-bottom:13px; margin-bottom:13px;">
							<button class="btn btn-small" type="button" onclick="javascript:location.href='${ctx}/aeprojectController/list.do';">
								<i class="icon-undo"></i>
								返回
							</button>

							<input type="hidden" name="id" value="${aeproject.id}"/>
							<button class="btn btn-small btn-primary" type="submit">
								<i class="icon-save"></i>
								保存
							</button>
						</div>
							
						<div class="row-fluid">
							<div></div>
	
							<div class="span5">
								<div class="control-group control-group-l">
									<label class="control-label control-label-l">项目ID</label>
	
									<div class="controls controls-l">
										<input type="text" name="id" readonly= "readonly" value="${aeproject.id}"/>
									</div>
								</div>	
							</div><!--/span-->

							<div class="span5">
								<div class="control-group control-group-l">
									<label class="control-label control-label-l">用户名</label>
	
									<div class="controls controls-l">
										<input type="text" name="account" readonly= "readonly"  value="${aeproject.account}"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
	
						<div class="row-fluid">
						<div></div>
							<div class="span5">
								<div class="control-group control-group-l">
									<label class="control-label control-label-l">项目需求ID</label>
	
									<div class="controls controls-l">
										<input type="text" name="projectrequireid" readonly= "readonly" value="${aeproject.projectrequireid}"/>
									</div>
								</div>	
							</div><!--/span-->

							<div class="span5">
								<div class="control-group control-group-l">
									<label class="control-label control-label-l">项目意向书ID</label>
	
									<div class="controls controls-l">
										<input type="text" name="projectloiid"  value="${aeproject.projectloiid}"/>
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
										<input type="text" name="feasibilityreportid" readonly= "readonly" value="${aeproject.feasibilityreportid}"/>
									</div>
								</div>	
							</div><!--/span-->

						<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">报价表ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="offerlistid" readonly= "readonly" value="${aeproject.offerlistid}"/>
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
										<input type="text" name="contractid"  readonly= "readonly" value="${aeproject.contractid}"/>
									</div>
								</div>		
							</div><!--/span-->

							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">项目总结</label>
	
									<div class="controls controls-m">
										<input type="text" name="project" readonly= "readonly" value="${aeproject.project}"/>
									</div>
								</div>		
							</div><!--/span-->

				</div><!--/.row-fluid-->

				<div class="row-fluid">
					<div></div>



					<div class="span5">		
						<div class="control-group control-group-m">
									<label class="control-label control-label-l">项目状态</label>
	
									<div class="controls controls-m">
										<select class="chzn-select" data-placeholder="-请选择-" name="flag" readonly= "readonly" value="${aeproject.flag}"  
										>											
											<option value="项目需求已通过" />项目需求已通过
											<option value="项目需求未通过" />项目需求未通过
											<option value="项目意向书已提交" />项目意向书已提交	
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
										<input type="text" name="headmanagerid" readonly= "readonly" value="${aeproject.headmanagerid}"/>
									</div>
								</div>		
							</div><!--/span-->

							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">总经理账户</label>
	
									<div class="controls controls-m">
										<input type="text" name="headmanageraccount" readonly= "readonly" value="${aeproject.headmanageraccount}"/>
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
										<input type="text" name="phonenumber" readonly= "readonly" value="${aeproject.headmanagerphone}"/>
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
				    	projectloiid:{
				   	  		required:true,
				   	  		number:true,
				   	  		maxlength:20,
				   	  		minlenght:3
				   	  		},
				   	  	
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

