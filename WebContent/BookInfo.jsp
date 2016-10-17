<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title>Books</title>
<style>
	.bookname
	{
		cursor:pointer;
		margin-bottom:10px;
		background-color:#ECECFF;
		color:#00000000;
		width:300px;
		padding:2px;
		border:1px solid #00000000;
	}
	.detail
	{
		display: none;
	}
</style>
</head>
<body>
	<script type="text/javascript">
	function ShowDetail(obj)
	{
		if(document.getElementById)
			{
				var el = document.getElementById(obj);
				if(el.style.display != "block")
				{
					el.style.display = "block";
				}
				else
				{
					el.style.display = "none";
				}
			}
	}
	</script>
	<div>
		<form action="search" method="post">
			Search by Author: <input type = "text" name = "authorname"><input type="submit" value="Search">
		</form>
	</div>
	
	<div>
	The Books are<br/>
	<ul>
		<s:iterator value="booklist">
		<li>
			<div class="bookname" onclick="ShowDetail('<s:property value="isbn"/>')">
				<s:property value="title"/>
			</div>
			
			<span class="detail" id="<s:property value="isbn"/>">
				Author: <s:property value="authorname"/><br/>
				ISBN: <s:property value="isbn"/><br/>
				Publisher: <s:property value="publisher"/><br/>
				PublisheDate: <s:property value="publishdate"/><br/>
				Price: <s:property value="price"/><br/>
				
				<form action="delete" method="post">
					<input type="hidden" 
						name ="isbn" value="<s:property value="isbn"/>" 
						readonly = "readonly">
					<input type="submit" value="Delete">
				</form>
			</span>
		</li>
		</s:iterator>
	</ul>
	</div>

	
</body>
</html>