<#macro logout>
    <form action="/logout" method="post">
        <button class="btn btn-primary" type="submit">Выйти</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</#macro>