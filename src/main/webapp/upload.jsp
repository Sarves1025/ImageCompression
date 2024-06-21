<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Compression</title>
    <link rel="stylesheet" type="text/css" href="uploadstyles.css">
    <script>
        function showFileSize() {
            const fileInput = document.getElementById('file1');
            const fileSizeOutput = document.getElementById('fileSize');
            const imagePreview = document.getElementById('imagePreview');

            if (fileInput.files.length > 0) {
                const fileSizeInBytes = fileInput.files[0].size;
                const fileSizeInKB = fileSizeInBytes / 1024;
                console.log(fileSizeInKB);
                fileSizeOutput.textContent = 'File Size: ' + fileSizeInKB.toFixed(2) + ' KB';

                const reader = new FileReader();
                reader.onload = function (e) {
                    imagePreview.src = e.target.result;
                };
                reader.readAsDataURL(fileInput.files[0]);
            } else {
                fileSizeOutput.textContent = 'File Size: N/A';
                imagePreview.src = ''; 
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>COMPRESS IMAGE</h2>
        <form action="compressImage" method="post" enctype="multipart/form-data">
            Select image to compress:
            <input type="file" name="file1" id="file1" onchange="showFileSize()">
            <div id="fileSize">File Size: N/A</div>
       
            <div id="imagePreviewContainer">
                <img id="imagePreview" alt="" style="max-width: 100%; max-height: 200px;">
            </div>
            <input type="submit" value="Compress Image" name="submit">
        </form>
    </div>
</body>
</html>
