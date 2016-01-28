<!--start header-->
<div class="header">
    <div class="header-top">
        <div class="container">
            <div class="logo">
                <a href="${createLink(controller: 'home', action: 'index')}"><asset:image class="logo" src="mmoarenalogo.png"/></a>
            </div>
            <div class="menu">
                <a class="toggleMenu" href="#"><img src="nav_icon.png" alt="" /></a>
                <ul class="nav" id="nav">
                    <li><a href="${createLink(controller: 'adminItem')}">Item management</a></li>
                    <li><a href="${createLink(controller: 'adminSpell')}">Spell management</a></li>
                    <li><a href="${createLink(controller: 'logout')}">Logout</a></li>
                </ul>
            </div>
            <div class="clear"></div>
            <script type="text/javascript" src="js/responsive-nav.js"></script>
        </div>
    </div>
</div>
<!--end header-->