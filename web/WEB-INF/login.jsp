<!DOCTYPE HTML>
<!--
Fractal by HTML5 UP
html5up.net | @ajlkn
Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
    <title>Fractal by HTML5 UP</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css" />
</head>
<body id="top">

<!-- Header -->
<header id="header">
    <div class="content">
        <h1><a href="#">Login</a></h1>
        <p>Login to access<br />
            to the users list</p>


        <form method="post" action="${pageContext.request.contextPath}/login">
            <input type="text" placeholder="username" name="userName"><br>
            <input type="password" placeholder="password" name="password"><br>
            <input type="submit" value="Login">
        </form>
    </div>
</header>

<!-- Footer -->
<footer id="footer">
    <ul class="icons">
        <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
        <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
        <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
    </ul>
    <p class="copyright">&copy; Untitled. Credits: <a href="http://html5up.net">HTML5 UP</a></p>
</footer>

<!-- Scripts -->
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.scrolly.min.js"></script>
<script src="${pageContext.request.contextPath}/statis/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/util.js"></script>
<script src="${pageContext.request.contextPath}/static/js/main.js"></script>

</body>
</html>

