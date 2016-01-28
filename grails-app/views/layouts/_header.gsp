<sec:ifAllGranted roles="ROLE_USER">
    <g:render template="/layouts/navigation/userNavigation"></g:render>
</sec:ifAllGranted>
<sec:ifAllGranted roles="ROLE_ADMIN">
    <g:render template="/layouts/navigation/adminNavigation"></g:render>
</sec:ifAllGranted>
<sec:ifNotLoggedIn>
    <g:render template="/layouts/navigation/homeNavigation"></g:render>
</sec:ifNotLoggedIn>

%{--<g:render template="/layouts/navigation/userNavigation"></g:render>--}%