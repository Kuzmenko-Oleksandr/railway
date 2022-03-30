<#import "parts/common.ftlh" as c>

<@c.page>
    <h1>Добавление нового сеанса</h1>
    <form action="/addSession" method="post" xmlns="http://www.w3.org/1999/html">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Название поезда: </label>
            <div class="col-sm-6">
                <select class="form-control" id="exampleSelect1" name="trainName">
                    <#list trains as train>
                        <option>${train.name}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Номер поезда: </label>
            <div class="col-sm-6">
                <select class="form-control" id="exampleSelect1" name="hallNumber">
                    <#list halls as hall>
                        <option>${hall.number}</option>
                    </#list>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label for="example-date-input" class="col-2 col-form-label">Дата</label>
            <div class="col-sm-6">
                <input class="form-control" type="date" name="date">
            </div>
        </div>

        <div class="form-group row">
            <label for="example-time-input" class="col-2 col-form-label">Время</label>
            <div class="col-6">
                <input class="form-control" type="time" id="example-time-input" name="time">
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <button class="btn btn-primary" type="submit">Добавить</button>
    </form>
</@c.page>