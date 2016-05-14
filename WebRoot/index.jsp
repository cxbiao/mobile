<%@ page language="java" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
<meta charset="utf-8" />
</head>

<body>

	 <p>
	      User模型: <br/>
          Integer id;<br/>
	      String username;<br/>
	      String sex;<br/>
	      Date birthday;<br/>
	      String address;<br/>
	 
	 </p>
	     
	  
	  <hr/>
      
      <p>
       1. /rest/findUserForGet   输入User,输出User(json) 
      </p>
      
      <p>
       2. /rest/findUserForPost   输入User,输出User(json) 
      </p>
      
      <p>
       3. /rest/findUserList   输出User列表(json数组) 
      </p>
      
       <p>
       4. /rest/postBodyJson   输入Body体(json)   输出User(json) 
      </p>
      
      
      <p>
       5. /rest/postBodyString   输入Body体(string)   输出User(json) 
      </p>
      
       <p>
       6. /rest/upload   多文件上传   输出上传后地址(json)
      </p>
</body>
</html>
