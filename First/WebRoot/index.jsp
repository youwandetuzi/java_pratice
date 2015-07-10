<%@page import="com.theiron.tool.DataInit"%>
<%@page import="com.theiron.bean.Student"%>
<%@page import="com.theiron.database.DataMain"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");

	DataMain db = new DataMain();
	HashMap<String,Student> stus = new HashMap<String,Student>();
	DataInit.dataInit(db, stus);
	Student selectStudent;
	String searchId = request.getParameter("searchId");
	Student searchStu;
%>

<!DOCTYPE html>
<html lang="zh">
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	
  </head>
  
  <body>
    <div class="container">
		<div class="row"><h1>Student Manger</h1></div>
		<div class="row">
			<div class="col-md-4 my_nav">
				<div id="myCollapse">
					<a data-toggle="collapse" data-parent="#myCollapse" href="#collapseOne">查询</a>
					<div id="collapseOne" class="collapse">
						<div class="input-group">
							<input type="text" class="form-control input-lg" placeholder="学生学号" id="ssId" name="ssId">
							<span class="input-group-btn">
								<button class="btn btn-lg" type="button" id="search">search</button>
							</span>
						</div>
						
					</div>
					<div><a href="#" id="myShow">展示</a></div>
					<div><a href="#" id="myAdd">添加</a></div>
				</div>
				
			</div>
			<div class="col-md-8">
				<div class="my_content">
					<div class="show_data">
						<ul>
							<%
								Set keySet = stus.keySet();
								Iterator<String> iterator = keySet.iterator();
								Student student;
								while(iterator.hasNext()){
									student = stus.get(iterator.next());
									System.out.println(student);
									%>
									<li>
										<span>学号:</span><span><%= student.getId()%></span>
										<span>姓名:</span><span><%= student.getName()%></span>
										<span>性别:</span><span><%= student.getSex()%></span>
										<span>年龄:</span><span><%= student.getAge()%></span>
										<a href="#" title="<%= student.getId()%>" class="myEdit">编辑</a><a href="./servlet/Delete?stuid=<%=student.getId()%>">删除</a>
									</li>
									<%
								}
							 %>
						</ul>
					</div>
					<div class="search_data hide">
						<ul>
							<li>
										<span>学号:</span><span class="searchId"></span>
										<span>姓名:</span><span class="searchName"></span>
										<span>性别:</span><span class="searchSex"></span>
										<span>年龄:</span><span class="searchAge"></span>
							</li>
						</ul>
					</div>
					<div class="show_add hide">
						<form role="form"  method="post" action="./servlet/Add">
							<div class="form-group">
								<label for="stuId">学号</label>
								<input type="text" class="form-control" id="stuId" placeholder="请输入学号" name="stuId">
							</div>
							<div class="form-group">
								<label for="name">姓名</label>
								<input type="text" class="form-control" id="name" placeholder="请输入学号" name="name">
							</div>
							<div class="form-group">
								<label for="sex">性别</label>
								<input type="text" class="form-control" id="sex" placeholder="请输入学号" name="sex">
							</div>
							<div class="form-group">
								<label for="age">年龄</label>
								<input type="text" class="form-control" id="age" placeholder="请输入学号" name="age">
							</div>
							<button type="submit" class="btn btn-default">提交</button>
						</form>
					</div>
					<div  class="show_edit hide" >
						<form role="form" action="./servlet/Edit" method="post">
							<div>编辑页面</div>
							<div class="form-group">
								<label for="stuId1">学号</label>
								<input type="text" class="form-control disable" id="stuId1" placeholder="请输入学号" name="stuId">
							</div>
							<div class="form-group">
								<label for="name1">姓名</label>
								<input type="text" class="form-control" id="name1" placeholder="请输入学号" name="name">
							</div>
							<div class="form-group">
								<label for="sex1">性别</label>
								<input type="text" class="form-control" id="sex1" placeholder="请输入学号" name="sex">
							</div>
							<div class="form-group">
								<label for="age1">年龄</label>
								<input type="text" class="form-control" id="age1" placeholder="请输入学号" name="age">
							</div>
							<button type="submit" class="btn btn-default">提交</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#myShow").unbind("click").bind('click',function(){
				$(".show_add").addClass("hide");
				$(".show_data").removeClass("hide");
				$(".show_edit").addClass("hide");
				$(".search_data").addClass("hide");
			});
			$("#myAdd").unbind('click').bind('click',function(){
				$(".show_add").removeClass("hide");
				$(".show_data").addClass("hide");
				$(".show_edit").addClass("hide");
				$(".search_data").addClass("hide");
			});
			
			$(".myEdit").unbind('click').bind('click',function(e){
				var $ss = $(this);
				$(".show_add").addClass("hide");
				$(".show_data").addClass("hide");
				$(".show_edit").removeClass("hide");
				$(".search_data").addClass("hide");
				var id = $ss.attr("title");
				console.log("test:"+id);
				$("#stuId1").attr("value",id);
			});
			
			$("#search").unbind('click').bind('click',function(e){
				var id = $("#ssId").val();
				window.location.href="index.jsp?searchId="+id; 
			});
			
			<%if(searchId!=null){
				%>
				$(".show_add").addClass("hide");
				$(".show_data").addClass("hide");
				$(".show_edit").addClass("hide");
				$(".search_data").removeClass("hide");
				<%
				searchStu = stus.get(searchId);
				if(searchStu!=null){
				%>
					$(".searchId").html("<%= searchStu.getId()%>");
					$(".searchName").html("<%= searchStu.getName()%>");
					$(".searchSex").html("<%= searchStu.getSex()%>");
					$(".searchAge").html("<%= searchStu.getAge()%>");
					<%
				}else{
				%>
					$(".searchId").html("为找到相关内容");
					$(".searchName").html("");
					$(".searchSex").html("");
					$(".searchAge").html("");
					<%
				}
			}
			%>
		});
	</script>
  </body>
</html>
