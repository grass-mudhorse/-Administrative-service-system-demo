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
							评价管理
							<small>
								<i class="icon-double-angle-right"></i>
								修改评价信息
							</small>
						</h1>
					</div><!--/.page-header-->

					<form id="validation-form" class="form-horizontal" action="${ctx}/clientcommentController/edit.do" method="post">
						<div style="border-bottom:1px dotted #e2e2e2; padding-bottom:13px; margin-bottom:13px;">
							<button class="btn btn-small" type="button" onclick="javascript:location.href='${ctx}/clientcommentController/list.do';">
								<i class="icon-undo"></i>
								返回
							</button>

							<input type="hidden" name="id" value="${clientcomment.id}"/>
							<button class="btn btn-small btn-primary" type="submit">
								<i class="icon-save"></i>
								保存
							</button>
						</div>
							
						<div class="row-fluid">
							<div></div>
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">项目ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="projectid" readonly= "readonly" value="${clientcomment.projectid}"/>
									</div>
								</div>	
							</div><!--/span-->
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">项目名称</label>
	
									<div class="controls controls-m">
										<input type="text" name="projectname" readonly= "readonly" value="${clientcomment.projectname}"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
	
						<div class="row-fluid">
							<div></div>
							
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">用户账号</label>
	
									<div class="controls controls-m">
										<input type="text" name="clientaccount"  value="${clientcomment.clientaccount}"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->

						<div class="row-fluid">
							<div></div>
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">用户评价</label>
	
									<div class="controls controls-m">
										<input type="text" name="commentinfo"  value="${clientcomment.commentinfo}"/>
									</div>
								</div>		
							</div><!--/span-->
						<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">评价日期</label>
	
									<div class="controls controls-m">
										<span class="text-m" >
											<div class="row-fluid input-append">
												<input class="span10 date-picker"  name="commentdate"  value="${clientcomment.commentdate}" style="width:193px;" type="text" data-date-format="yyyy-mm-dd" />
												<span class="add-on" style="float:right;">
													<i class="icon-calendar"></i>
												</span>
											</div>
										</span>
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
				  	  	clientcommentname:{
				   	  		required:true,
				   	  		maxlength:20
				   	  		},
				   	  	
				   	    clientcommentcol:{
				   	    	required:true,
				   	    	maxlength:20
				   	    },
				   	 	clientcommenttime:{
				   	 	required:true,
			   	  		number:true
				   	 	},
				   	    clientcommentpri:{
				   	  		required:true,
				   	  		number:true
				   	  	},
				   	  	clientcommentcon:{
				   	  	required:true,
				   	 	maxlength:100
				   	  	},
				   	  	clientcommenttempcon:"required",
				   	  	
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
