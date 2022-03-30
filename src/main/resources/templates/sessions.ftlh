<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">



<@c.page>
    <h1 xmlns="http://www.w3.org/1999/html">${train.name}</h1>
    <h4>Свободных мест: ${20 - countOfBuyTickets}</h4>
    <h5>Выберите место</h5>
    ${message!""}

    <form action="/sessions/${session.getId()}/buy" method="post" xmlns="http://www.w3.org/1999/html">
        <div class="input-group mb-3">
            <#list tickets as ticket>
            <#if ticket?counter % 20 -1 == 0></div>
        <div class="input-group mb-3"></#if>

            <#if ticket.getId()??>
                <div class="input-group-prepend">
                    <div class="input-group-text">
                        <input type="checkbox" checked disabled>
                    </div>
                </div>
            <#else >
                <div class="input-group-prepend">
                    <div class="input-group-text">
                        <input type="checkbox" disabled>
                    </div>
                </div>
            </#if>
            </#list>
        </div>
    </form>

    <form action="/sessions/${session.getId()}/buy" method="post" xmlns="http://www.w3.org/1999/html">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">ряд: </label>
            <div class="col-sm-6">
                <select class="form-control" id="exampleSelect1" name="row">
                    <#list 1..1 as train>
                        <option>${train}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">место: </label>
            <div class="col-sm-6">
                <select class="form-control" name="seat">
                    <#list 1..20 as train>
                        <option>${train}</option>
                    </#list>
                </select>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <button class="btn btn-primary" type="submit">купить</button>
    </form>


</@c.page>