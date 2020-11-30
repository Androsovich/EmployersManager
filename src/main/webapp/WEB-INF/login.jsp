<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form>
        <input type="text" id="userName"/>
        <input type="text" id="password"/>
        <input type="button" name="sub" onclick="sendData()"/>
    </form>
    <script>
        function sendData() {
            let userName = document.getElementById("userName").value;
            let password = document.getElementById("password").value;
            let param =`{
                "userName" : "` + userName + `",
                "password" : "` + password + `"
            }`

            const request = new XMLHttpRequest();
            const url = "api/v1/auth/login";
            request.open("POST", url, true);
            request.setRequestHeader("Content-type", "application/json");
            request.setRequestHeader("Authorization", "Bearer_");
            request.send(param);
        }

    </script>
</div>
</body>
</html>
