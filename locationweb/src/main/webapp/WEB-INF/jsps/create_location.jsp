<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location | Create</title>
</head>
<body>
<h2> Location | Add New Location</h2>
<form action="saveLocation" method="post">
	<pre>
		Id <input type="text" name="id">
		Name <input type="text" name="name">
		Code <input type="text" name="codes">
		Type:
		Urban <input type="radio" value="Urban" name="type">
		Rural <input type="radio" value="Rural" name="type">
		<input type="submit" value="Save">
	</pre>
</form>
${msg}

</body>
</html>