<#include "security.ftlh">
<#import "logout.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Train</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Купить билет на поезд</a>
            </li>
            <#if known>
                <li class="nav-item">
                    <a class="nav-link" href="/tickets">Мои билеты</a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/addTrain">Добавить новый поезд</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/addSession">Добавить новое отправлвение</a>
                </li>
            </#if>
        </ul>

        <#if known>
            <div class="navbar-text mr-3">${name}</div>
            <@l.logout/>
        <#else>
            <a href="/login">Войти</a>
        </#if>

    </div>
</nav>