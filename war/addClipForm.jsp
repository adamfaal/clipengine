<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add clip</title>
	<link rel="stylesheet" type="text/css" href="/stylesheets/skeleton.css" />
</head>
<body>

	<div class="doc-section clearfix" id="forms">
	
		<div class="four columns alpha">
			<form action="/addClip" method="POST">
		
				<input type="hidden" name="_method" value="PUT" />
				
				<label for="description">Description</label>
				<input type="text" name="description" placeholder="">
				
				<label for="mimeType">MIME-Type</label>
				<input type="text" name="mimeType" value="text/plain">
		
				<label for="clip">Clip:</label>
				<textarea name="clip" placeholder="Paste your clip here..."></textarea>
		
				<button type="submit">Add clip</button>
				
			</form>
			
		</div>
	
	</div>

</body>
</html>