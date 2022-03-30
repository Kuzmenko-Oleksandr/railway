<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <h1 class="mb-1">Вход</h1>
    <@l.login "/login"/>

    <a href="/registration">Регистрация</a>
</@c.page>
