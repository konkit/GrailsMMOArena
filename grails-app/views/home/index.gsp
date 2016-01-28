<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    %{--<meta name="layout" content="main" />--}%
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Enter the game</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>

    <asset:stylesheet src="templatestyle.css" />
</head>
<body>
<!--start header-->
<div class="header">
    <div class="header-top">
        <div class="container">
            <div class="logo">
                <a href="${createLink(controller: 'home', action: 'index')}"><asset:image class="logo" src="mmoarenalogo.png"/></a>
            </div>
            <div class="menu">
                <a class="toggleMenu" href="#"><img src="assets/nav_icon.png" alt="" /></a>
                <ul class="nav" id="nav">
                    <li><a href="${createLink(controller: 'register')}">Register</a></li>
                    <li><a href="${createLink(controller: 'login', action: 'auth')}">Login</a></li>
                    <div class="clear"></div>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="header-bottom" id="home">
        <h1>Some placeholder text ...</h1>
        <h1 style="width: 73%;">... to encourage players to play this game :D</h1>
        <h1><a href="${createLink(controller: 'register')}" style="color: #FFF;">Register Now!</a></h1>
    </div>
</div>
<!--end header-->
<!--start services-->
<div class="services" id="services">
    <div class="container">
        <div class="row">
            <h3 class="m_3">MMOArena - new MMO Game</h3>
            <div class="m_4"><span class="bottom_line"> </span></div>
            <div class="col-md-4 top_grid">
                <h3 class="m_1">Duels</h3>
                <p class="m_2">Fight with your enemies 1 vs. 1 in a duel. <br/>Use your skills to achive ultimate victory!</p>
            </div>
            <div class="col-md-4 top_grid">
                <h3 class="m_1">Items and Spells</h3>
                <p class="m_2">Collect new equipment and spells to make your character even stronger</p>
            </div>
            <div class="col-md-4 top_grid">
                <h3 class="m_1">Free!</h3>
                <p class="m_2">As for now, all of those pleasures are for free! Join now!</p>
            </div>
        </div>
    </div>
</div>
<!--end services-->

<g:render template="/layouts/footer" />

<!--end contact-->
<script type="text/javascript">
    $(document).ready(function() {

        var defaults = {
            containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
        };


        $().UItoTop({ easingType: 'easeOutQuart' });

    });
</script>
<a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>



</body>
</html>