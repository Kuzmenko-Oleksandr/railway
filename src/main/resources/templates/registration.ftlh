<#import "parts/common.ftlh" as c>

<@c.page>
    <h3>Регистрация</h3>
    ${message!""}
    <form action="/registration" method="post" xmlns="http://www.w3.org/1999/html">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Логин: </label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="login"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Пароль: </label>
            <div class="col-sm-6">
                <input class="form-control" type="password" name="password"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Имя: </label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="firstName"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Фамилия: </label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="lastName"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <button class="btn btn-primary" type="submit">Зарегистрироваться</button>
    </form>
</@c.page>
