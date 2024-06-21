<%@ page import="java.util.Base64" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Decompressed Image</title>
</head>
<body>
    <h2>Decompressed Image</h2>
    <img src="data:image/jpeg;base64,${encodedImage}" alt="Decompressed Image">
    <br>
    <a href="downloadDecompressedImage">Download Decompressed Image</a>
</body>
</html>
