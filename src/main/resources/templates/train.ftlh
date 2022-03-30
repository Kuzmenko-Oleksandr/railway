<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <h1>${train.name}</h1>
    <div class="row">
        <div class="col-8">
            <p>${train.description}</p>
            <h3>Отправление</h3>
            <form action="/train/${train.id}" method="get" xmlns="http://www.w3.org/1999/html">
                <div class="form-group row">
                    <label for="example-date-input" class="col-2 col-form-label">Дата</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="date" value="${date?ifExists}" name="date">
                    </div>

                    <button class="btn btn-primary" type="submit">Показать</button>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>

            <div class="row">
                <#if sessions??>
                    <#list sessions as session>

                        <div class="col-4">
                            <div class="card mb-4" style="width: 13rem;">
                                <div class="card-body">
                                    <h5 class="card-title">${session.getTime()}</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">Свободных
                                        мест ${20 - session.countOfBuyTicket()}</h6>
                                    <#if session.isEnd()>
                                        <button disabled class="btn btn-secondary mb-2">Купить</button>
                                    <#else>
                                        <a href="/sessions/${session.getId()}" class="btn btn-primary mb-2">Купить</a>
                                    </#if>


                                    <#if isAdmin>
                                        <form action="/sessions/delete/${session.getId()}" method="post"
                                              xmlns="http://www.w3.org/1999/html">
                                            <button class="btn btn-danger" type="submit">удалить</button>
                                            <input type="hidden" name="date" value="${session.getDate()}"/>
                                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                        </form>
                                    </#if>
                                </div>
                            </div>
                        </div>
                    </#list>
                <#else >
                    <h4>Поездов нет</h4>
                </#if>
            </div>
        </div>
    </div>


</@c.page>