<%@ page import="java.util.Base64" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Compressed Image</title>
</head>
<body>
    <h2>Compressed Image</h2>
    <img src="data:image/jpeg;base64,${encodedImage}" alt="Compressed Image">
    <br>
    <a href="downloadCompressedImage">Download Compressed Image</a>
</body>
</html>
