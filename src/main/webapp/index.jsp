<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Image Compression</title>
   
    <link rel="stylesheet" type="text/css" href="indexstyles.css">
    <style>
        
        body {
            font-family: Arial, sans-serif;
            background-color: #add8e6; 
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        
        .container {
            background-color: light blue;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            width:50%;
            height:20vh;
        }
.container:hover{
	box-shadow:0px 0px 20px ;
}
       
        h1 {
            margin-bottom: 20px;
            color:green;
           // animation: blink 5s infinite;
        }

       
        h1:hover {
            color: red;
        }

        
       /*  @keyframes blink {
            0%, 25%, 50% {
                color: yellow;
                opacity: 1;
            }
            30%, 55%, 80% {
                color: red;
                opacity: 1;
            }
            60%, 85%, 100% {
                color: green;
                opacity: 1;
            }
        } */
        a {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s; 
        }

        a:hover {
            text-decoration: underline;
            color: #0056b3;
        }
    </style>
</head>

<body>
    
    <div class="container">
      
        <h1>Welcome to Image Compression Project</h1>
       <br>
        <a href="upload.jsp">Click here to upload an image for compression</a>
    </div>
</body>

</html>
